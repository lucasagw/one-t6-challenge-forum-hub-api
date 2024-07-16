package br.com.alura.forum_hub_api.domain.topic;

import br.com.alura.forum_hub_api.domain.course.Course;
import br.com.alura.forum_hub_api.domain.course.CourseRepository;
import br.com.alura.forum_hub_api.domain.topic.validations.create.TopicCreateValidator;
import br.com.alura.forum_hub_api.domain.topic.validations.update.TopicUpdateValidator;
import br.com.alura.forum_hub_api.domain.user.User;
import br.com.alura.forum_hub_api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private List<TopicCreateValidator> createValidators;

    @Autowired
    private List<TopicUpdateValidator> updateValidators;


    public TopicDetailData createTopic(TopicCreateData data) {

        if (!userRepository.existsById(data.authorId())) {
            throw new NoSuchElementException(String.format("User with id %d not found", data.authorId()));
        }

        if (!courseRepository.existsById(data.courseId())) {
            throw new NoSuchElementException(String.format("Course with id %d not found", data.courseId()));
        }

        createValidators.forEach(validator -> validator.validate(data));

        User user = userRepository.getReferenceById(data.authorId());

        Course course = courseRepository.getReferenceById(data.courseId());

        var topic = new Topic(user, course, data);

        var save = topicRepository.save(topic);

        return new TopicDetailData(save);
    }

    public TopicDetailData updateTopic(Long id, TopicUpdateData data) {

        var topic = topicRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Topic with id %d not found", id)));

        if (data.title() != null && data.message() != null) {

            updateValidators.forEach(validator -> validator.validate(data));
            topic.setTitle(data.title());
            topic.setMessage(data.message());
        }
        topic.updateData(data);

        return new TopicDetailData(topic);
    }

    public void deleteTopic(Long id) {

        var topic = topicRepository.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Topic with id %d not found", id)));

        topicRepository.deleteById(topic.getId());
    }
}
