package com.tekcapsule.course.domain.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.tekcapsule.course.domain.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class CourseRepositoryImpl implements CourseDynamoRepository {

    private DynamoDBMapper dynamo;

    @Autowired
    public CourseRepositoryImpl(DynamoDBMapper dynamo) {
        this.dynamo = dynamo;
    }

    @Override
    public List<Course> findAll() {

        return dynamo.scan(Course.class,new DynamoDBScanExpression());
    }

    @Override
    public Course findBy(String code) {
        return dynamo.load(Course.class, code);
    }

    @Override
    public Course save(Course course) {
        dynamo.save(course);
        return course;
    }
}
