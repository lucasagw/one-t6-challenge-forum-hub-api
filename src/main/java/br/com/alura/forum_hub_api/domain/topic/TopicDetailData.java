package br.com.alura.forum_hub_api.domain.topic;

public record TopicDetailData(
        Long id,
        String userName,
        String courseName,
        String title,
        String message,
        Status status) {
}
