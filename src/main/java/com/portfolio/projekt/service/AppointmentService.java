package com.portfolio.projekt.service;

import com.portfolio.projekt.dto.AppointmentRequest;
import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.entity.ServiceEntity;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.repository.AppointmentRepository;
import com.portfolio.projekt.repository.ServiceRepository;
import com.portfolio.projekt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;

    public Appointment createAppointment(AppointmentRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User provider = userRepository.findById(request.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        LocalDateTime start = LocalDateTime.parse(request.getStartTime());
        LocalDateTime end = LocalDateTime.parse(request.getEndTime());

        if (!end.isAfter(start)) {
            throw new RuntimeException("End time must be after start time");
        }

        boolean overlaps = appointmentRepository.existsByProviderAndTimeRange(provider, start, end);
        if (overlaps) {
            throw new RuntimeException("Provider is not available at this time");
        }

        Appointment appointment = Appointment.builder().user(user).provider(provider)
                .service(service).startTime(start).endTime(end).build();

        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    public List<Appointment> getAppointmentsByProvider(Long providerId) {
        return appointmentRepository.findByProviderId(providerId);
    }
}
