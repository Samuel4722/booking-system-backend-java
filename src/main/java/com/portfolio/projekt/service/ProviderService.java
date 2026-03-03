package com.portfolio.projekt.service;

import com.portfolio.projekt.entity.*;
import com.portfolio.projekt.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final UserRepository userRepository;
    private final ServiceRepository serviceRepository;
    private final AvailabilityRepository availabilityRepository;
    private final AppointmentRepository appointmentRepository;

    public List<User> getAllProviders() {
        return userRepository.findByRole(Role.PROVIDER);
    }

    public ServiceEntity createService(Long providerId, ServiceEntity service) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        service.setProvider(provider);
        return serviceRepository.save(service);
    }

    public Availability addAvailability(Long providerId, Availability availability) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        availability.setProvider(provider);
        return availabilityRepository.save(availability);
    }

    public List<Appointment> getProviderAppointments(Long providerId) {
        return appointmentRepository.findByProviderId(providerId);
    }
}
