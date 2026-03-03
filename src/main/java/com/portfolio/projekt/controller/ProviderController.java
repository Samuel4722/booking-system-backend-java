package com.portfolio.projekt.controller;

import com.portfolio.projekt.entity.Availability;
import com.portfolio.projekt.entity.ServiceEntity;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping
    public List<User> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PostMapping("/{providerId}/services")
    public ServiceEntity createService(@PathVariable Long providerId,
            @RequestBody ServiceEntity service) {
        return providerService.createService(providerId, service);
    }

    @PostMapping("/{providerId}/availability")
    public Availability addAvailability(@PathVariable Long providerId,
            @RequestBody Availability availability) {
        return providerService.addAvailability(providerId, availability);
    }

    // PROVIDER – jego rezerwacje
    @GetMapping("/{providerId}/appointments")
    public List<Appointment> getProviderAppointments(@PathVariable Long providerId) {
        return providerService.getProviderAppointments(providerId);
    }
}
