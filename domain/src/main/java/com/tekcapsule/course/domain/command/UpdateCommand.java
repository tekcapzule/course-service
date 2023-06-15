package com.tekcapsule.course.domain.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapsule.core.domain.Command;
import com.tekcapsule.course.domain.model.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UpdateCommand extends Command {
    private String courseId;
    private String topicCode;
    private String title;
    private String author;
    private String publisher;
    private String duration;
    private String courseUrl;
}
