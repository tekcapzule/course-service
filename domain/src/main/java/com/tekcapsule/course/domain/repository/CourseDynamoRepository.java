package com.tekcapsule.course.domain.repository;

import com.tekcapsule.core.domain.CrudRepository;
import com.tekcapsule.course.domain.model.Course;

public interface CourseDynamoRepository extends CrudRepository<Course, String> {
}
