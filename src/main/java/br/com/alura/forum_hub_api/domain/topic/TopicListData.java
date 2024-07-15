package br.com.alura.forum_hub_api.domain.topic;

public record TopicListData(
        Long id,
        String title,
        String message,
        Status status
) {
}
