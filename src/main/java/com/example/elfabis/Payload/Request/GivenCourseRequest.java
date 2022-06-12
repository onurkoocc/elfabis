package com.example.elfabis.Payload.Request;

import lombok.Data;

@Data
public class GivenCourseRequest {
    private Integer id;
    private Integer lecturerId;
    private Integer courseId;
    private Integer year;
    private Integer semester;
    private Integer courseGroup;
}
