package br.com.alura.forum_hub_api.domain.topic;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {


    Optional<Topic> findByTitleAndMessage(String title, String message);

    Optional<Topic> findByCourseName(Pageable pageable);
}
