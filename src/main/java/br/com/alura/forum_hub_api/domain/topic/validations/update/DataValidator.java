package br.com.alura.forum_hub_api.domain.topic.validations.update;

import br.com.alura.forum_hub_api.domain.DuplicateTopicException;
import br.com.alura.forum_hub_api.domain.topic.TopicRepository;
import br.com.alura.forum_hub_api.domain.topic.TopicUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataValidator implements TopicUpdateValidator{

    @Autowired
    private TopicRepository topicRepository;


    @Override
    public void validate(TopicUpdateData data) {

        if (topicRepository.findByTitleAndMessage(data.title(), data.message()).isPresent()) {
            throw new DuplicateTopicException("A topic with the same title and message already exists");
        }
    }
}
