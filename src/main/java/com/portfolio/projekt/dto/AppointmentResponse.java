package com.portfolio.projekt.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class AppointmentResponse {
    private Long id;
    private String startTime;
    private String endTime;
    private Long userId;
    private Long providerId;
}
