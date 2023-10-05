package com.social_network_be.model;

<<<<<<< HEAD
=======
import com.social_network_be.model.Post;
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
<<<<<<< HEAD
@Data
@Entity
@Table(name = "comments")
=======

@Data
@Entity
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD
    @ManyToOne
    private Post post;
    @ManyToOne
    private Account creator;
    private String content;
    private LocalDateTime time;

    public Comment() {
    }
}
=======
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime create_at;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Account account;
}
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
