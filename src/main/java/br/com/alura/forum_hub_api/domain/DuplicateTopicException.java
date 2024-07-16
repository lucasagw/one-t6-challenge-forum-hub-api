package br.com.alura.forum_hub_api.domain;

public class DuplicateTopicException extends RuntimeException {
    public DuplicateTopicException(String message) {
        super(message);
    }
}
