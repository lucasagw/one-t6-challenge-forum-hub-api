package br.com.alura.forum_hub_api.domain.course;

public record CourseListData(
        Long id,
        String name,
        Category category) {
}
