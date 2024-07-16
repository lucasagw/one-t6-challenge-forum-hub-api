package br.com.alura.forum_hub_api.domain.topic;

import br.com.alura.forum_hub_api.domain.course.Course;
import br.com.alura.forum_hub_api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "title")
    @Setter
    private String title;

    @Column(name = "message")
    @Setter
    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


    public Topic(User user, Course course, TopicCreateData data) {
        this.user = user;
        this.course = course;
        this.title = data.title();
        this.message = data.message();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateData(TopicUpdateData data) {

        if (data.title() != null) {
            this.title = data.title();
        }

        if (data.message() != null) {
            this.message = data.message();
        }

        if (data.status() != null) {
            this.status = data.status();
        }

        this.updatedAt = LocalDateTime.now();
    }
}
