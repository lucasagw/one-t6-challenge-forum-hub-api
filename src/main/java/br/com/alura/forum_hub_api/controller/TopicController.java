package br.com.alura.forum_hub_api.controller;

import br.com.alura.forum_hub_api.domain.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    private TopicService service;

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createTopic(@RequestBody @Valid TopicCreateData data, UriComponentsBuilder uriBuilder) {

        var topic = service.createTopic(data);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();

        return ResponseEntity.created(uri).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicListData>> listTopics(@PageableDefault(sort = {"createdAt"}) Pageable pageable) {

        var page = repository.findAll(pageable).
                map(TopicListData::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailedTopic(@PathVariable @Positive Long id) {

        var topic = repository.getReferenceById(id);

        return ResponseEntity.ok(new TopicDetailData(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateTopic(@PathVariable @Positive Long id, @RequestBody @Valid TopicUpdateData data) {

        var topic = service.updateTopic(id, data);

        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTopic(@PathVariable @Positive Long id) {

        service.deleteTopic(id);

        return ResponseEntity.noContent().build();
    }

}
