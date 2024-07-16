package br.com.alura.forum_hub_api.domain.topic;

public record TopicDetailData(
        Long id,
        String author,
        String course,
        String title,
        String message,
        Status status) {

    public TopicDetailData(Topic topic) {
        this(topic.getId(), topic.getUser().getName(),
                topic.getCourse().getName(), topic.getTitle(),
                topic.getMessage(), topic.getStatus());
    }
}
