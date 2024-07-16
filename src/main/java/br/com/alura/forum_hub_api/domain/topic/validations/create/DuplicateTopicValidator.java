package br.com.alura.forum_hub_api.domain.topic.validations.create;

import br.com.alura.forum_hub_api.domain.DuplicateTopicException;
import br.com.alura.forum_hub_api.domain.topic.TopicCreateData;
import br.com.alura.forum_hub_api.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateTopicValidator implements TopicCreateValidator {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(TopicCreateData data) {

        if (topicRepository.findByTitleAndMessage(data.title(), data.message()).isPresent()) {
            throw new DuplicateTopicException("A topic with the same title and message already exists");
        }
    }
}
