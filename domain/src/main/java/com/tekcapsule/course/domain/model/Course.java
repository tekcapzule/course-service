package com.tekcapsule.course.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapsule.core.domain.AggregateRoot;
import com.tekcapsule.core.domain.BaseDomainEntity;
import lombok.*;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@DynamoDBTable(tableName = "Course")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseDomainEntity implements AggregateRoot {

    @DynamoDBHashKey(attributeName = "topicCode")
    private String topicCode;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName = "author")
    private String author;
    @DynamoDBAttribute(attributeName = "publisher")
    private String publisher;
    @DynamoDBAttribute(attributeName = "duration")
    private String duration;
    @DynamoDBAttribute(attributeName = "courseUrl")
    private String courseUrl;
}