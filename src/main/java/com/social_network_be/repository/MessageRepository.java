package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> getAllByFromUser(Account fromUser);
    List<Message> getAllByToUser(Account toUser);

    @Query(value = "" +
            "SELECT m FROM Message AS m " +
            "WHERE ((m.fromUser.id = :firstUserId AND m.toUser.id = :secondUserId) " +
            "OR  (m.fromUser.id = :secondUserId AND m.toUser.id = :firstUserId)) " +
            "ORDER BY m.time")
    List<Message> findAllMessagesBetweenTwoUsers(@Param("firstUserId") int firstUserId, @Param("secondUserId") int secondUserId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Message as m " +
            "SET m.status = 1 " +
            "WHERE m.toUser.id =:toUserId AND m.fromUser.id =:fromUserId " +
            "    AND m.status = 0")
    void updateStatusFromReadMessages(@Param("toUserId") int toUserId, @Param("fromUserId") int fromUserId);

    @Query(value = "select * from messages AS m INNER JOIN\n" +
            "            (select m.from_user_id as from_user_m1, max(m.time) as time_m1, count(*)\n" +
            "             as count\n" +
            "             from messages AS m where m.to_user_id =:userId\n" +
            "            GROUP BY m.from_user_id) as m1 ON m.from_user_id = m1.from_user_m1\n" +
            "            and m.time = m1.time_m1 where m.to_user_id =:userId ORDER BY m.time DESC;", nativeQuery = true)
    List<Message> getAllUnreadMessages(@Param("userId") int loggedInUserId);
//@Query(value = "select m from Message AS m where m.toUser.id = :userId group by m.fromUser.id " )
//List<Message> getAllUnreadMessages(@Param("userId") int loggedInUserId);
//    @Query(value = "select m from Message AS m where m.fromUser.id = :userId group by m.fromUser.id")
//    List<Message> getAllUnreadMessages1(@Param("userId") int loggedInUserId);
    @Query(value = "select m.from_user_id, count(*)as count " +
            "from messages AS m " +
            "where m.status = 0 " +
            "  and m.to_user_id =:userId " +
            "GROUP BY m.from_user_id " +
            "ORDER BY m.time DESC;", nativeQuery = true)
    List<Object[]> getCountOfUnreadMessagesByFromUser(@Param("userId") int loggedInUserId);
}
