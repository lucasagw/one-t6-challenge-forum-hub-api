package br.com.alura.forum_hub_api.domain.user;

import br.com.alura.forum_hub_api.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
