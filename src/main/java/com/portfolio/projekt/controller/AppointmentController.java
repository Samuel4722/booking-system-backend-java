package com.portfolio.projekt.controller;

import com.portfolio.projekt.dto.AppointmentRequest;
import com.portfolio.projekt.dto.AppointmentResponse;
import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

        private final AppointmentService appointmentService;

        @PostMapping
        public AppointmentResponse create(@RequestBody AppointmentRequest request) {
                Appointment appointment = appointmentService.createAppointment(request);

                return AppointmentResponse.builder().id(appointment.getId())
                                .startTime(appointment.getStartTime().toString())
                                .endTime(appointment.getEndTime().toString())
                                .userId(appointment.getUser().getId())
                                .providerId(appointment.getProvider().getId()).build();
        }

        @GetMapping("/user/{userId}")
        public List<Appointment> getUserAppointments(@PathVariable Long userId) {
                return appointmentService.getAppointmentsByUser(userId);
        }

        @GetMapping("/provider/{providerId}")
        public List<Appointment> getProviderAppointments(@PathVariable Long providerId) {
                return appointmentService.getAppointmentsByProvider(providerId);
        }
}
