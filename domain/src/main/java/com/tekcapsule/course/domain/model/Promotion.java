package com.tekcapsule.course.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Promotion {
    private Boolean promoted;
    private String endsOnUtc;
    private String imageUrl;
    private String campaignUrl;
}
