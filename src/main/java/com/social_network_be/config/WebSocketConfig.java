package com.social_network_be.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/chat", "/topic", "/queue","/apiLike");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // with sockjs
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").setAllowedOrigins("http://localhost:3000")
                .withSockJS();
        // without sockjs
        //registry.addEndpoint("/ws-message").setAllowedOriginPatterns("*");
    }
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        // Cấu hình các thông số thời gian chờ và kích thước cho WebSocket
        registration.setMessageSizeLimit(200000); // Giới hạn kích thước tin nhắn đến
        registration.setSendTimeLimit(20 * 10000); // Thời gian tối đa để gửi tin nhắn
        registration.setSendBufferSizeLimit(3 * 512 * 1024); // Kích thước bộ đệm cho việc gửi tin nhắn
    }
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // Cấu hình thời gian chờ không hoạt động (inactivity) cho kết nối WebSocket
        registration.taskExecutor().keepAliveSeconds(20000); // Cấu hình thời gian không hoạt động (milliseconds)
        registration.taskExecutor().keepAliveSeconds(20000); // Cấu hình thời gian không hoạt động (milliseconds)
    }
}