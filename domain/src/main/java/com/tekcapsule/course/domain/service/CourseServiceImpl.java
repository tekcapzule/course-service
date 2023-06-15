package com.tekcapsule.course.domain.service;

import com.tekcapsule.course.domain.command.CreateCommand;
import com.tekcapsule.course.domain.command.UpdateCommand;
import com.tekcapsule.course.domain.model.Course;
import com.tekcapsule.course.domain.repository.CourseDynamoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    private CourseDynamoRepository courseDynamoRepository;

    @Autowired
    public CourseServiceImpl(CourseDynamoRepository courseDynamoRepository) {
        this.courseDynamoRepository = courseDynamoRepository;
    }

    @Override
    public void create(CreateCommand createCommand) {

        log.info(String.format("Entering create course service - Topic Code :%s", createCommand.getTopicCode()));

        Course course = Course.builder()
                .title(createCommand.getTitle())
                .topicCode(createCommand.getTopicCode())
                .author(createCommand.getAuthor())
                .publisher(createCommand.getPublisher())
                .duration(createCommand.getDuration())
                .courseUrl(createCommand.getCourseUrl())
                .build();

        course.setAddedOn(createCommand.getExecOn());
        course.setUpdatedOn(createCommand.getExecOn());
        course.setAddedBy(createCommand.getExecBy().getUserId());

        courseDynamoRepository.save(course);
    }

    @Override
    public void update(UpdateCommand updateCommand) {

        log.info(String.format("Entering update course service - Topic Code:%s", updateCommand.getTopicCode()));

        Course course = courseDynamoRepository.findBy(updateCommand.getTopicCode());
        if (course != null) {
            course.setTitle(updateCommand.getTitle());
            course.setTopicCode(updateCommand.getTopicCode());
            course.setAuthor(updateCommand.getAuthor());
            course.setPublisher(updateCommand.getPublisher());
            course.setDuration(updateCommand.getDuration());
            course.setCourseUrl(updateCommand.getCourseUrl());
            course.setUpdatedBy(updateCommand.getExecBy().getUserId());
            courseDynamoRepository.save(course);
        }
    }

   /* @Override
    public void disable(DisableCommand disableCommand) {

        log.info(String.format("Entering disable topic service - Topic Code:%s", disableCommand.getCode()));

        courseDynamoRepository.findBy(disableCommand.getCode());
        Topic topic = courseDynamoRepository.findBy(disableCommand.getCode());
        if (topic != null) {
            topic.setStatus("INACTIVE");
            topic.setUpdatedOn(disableCommand.getExecOn());
            topic.setUpdatedBy(disableCommand.getExecBy().getUserId());
            courseDynamoRepository.save(topic);
        }
    }*/

    @Override
    public List<Course> findAll() {

        log.info("Entering findAll Course service");

        return courseDynamoRepository.findAll();
    }

    @Override
    public Course findBy(String topicCode) {

        log.info(String.format("Entering findBy Course service - Topic code:%s", topicCode));

        return courseDynamoRepository.findBy(topicCode);
    }


}
