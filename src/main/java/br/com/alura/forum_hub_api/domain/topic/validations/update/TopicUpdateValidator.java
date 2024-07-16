package br.com.alura.forum_hub_api.domain.topic.validations.update;

import br.com.alura.forum_hub_api.domain.topic.TopicUpdateData;

public interface TopicUpdateValidator {

    void validate(TopicUpdateData data);
}
