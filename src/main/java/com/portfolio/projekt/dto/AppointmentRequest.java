package com.portfolio.projekt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentRequest {
    private Long serviceId;
    private Long providerId;
    private Long userId;
    private String startTime;
    private String endTime;
}
