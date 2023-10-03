package com.social_network_be.config;

import com.social_network_be.controller.LoginController;
import com.social_network_be.service.iService.IAccountService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class FilterAuthToken extends OncePerRequestFilter {
    @Autowired
    private IAccountService accountService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Lấy token trong request
            String token = getTokenFromRequest(request);

            if (token != null) {
                // lấy username trong token
                String username = getUserNameFromJwtToken(token);

                // lấy ra UserDetails thông qua username
                UserDetails userDetails = accountService.loadUserByUsername(username);

                // thực hiện xác thực
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    // lấy token từ request
    private String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }
        return null;
    }

    // lấy username từ token
    public String getUserNameFromJwtToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(LoginController.PRIVATE_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return username;
    }
}
