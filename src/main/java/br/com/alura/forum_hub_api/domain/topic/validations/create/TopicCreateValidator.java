package br.com.alura.forum_hub_api.domain.topic.validations.create;

import br.com.alura.forum_hub_api.domain.topic.TopicCreateData;

public interface TopicCreateValidator {

    void validate(TopicCreateData data);
}
