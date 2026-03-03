package com.portfolio.projekt.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.entity.Role;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.repository.AppointmentRepository;
import com.portfolio.projekt.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;

    public List<User> getProviders() {
        return userRepository.findByRole(Role.PROVIDER);
    }

    public void deleteProvider(Long providerId) {
        userRepository.deleteById(providerId);
    }

    public User blockProvider(Long providerId) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        provider.setRole(Role.BLOCKED);
        return userRepository.save(provider);
    }

    public User unblockProvider(Long providerId) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        provider.setRole(Role.PROVIDER);
        return userRepository.save(provider);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByProvider(Long providerId) {
        return appointmentRepository.findByProviderId(providerId);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    public List<Appointment> getAppointmentsByUser(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    public List<Appointment> getAppointmentsByDate(LocalDateTime date) {
        return appointmentRepository.findByDate(date);
    }

    public List<Appointment> getAppointmentsByDateRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDateRange(start, end);
    }

    public List<Appointment> getAppointmentsByUserAndDate(Long userId, LocalDateTime date) {
        return appointmentRepository.findByUserAndDate(userId, date);
    }

    public List<Appointment> getAppointmentsByProviderAndRange(Long providerId, LocalDateTime start,
            LocalDateTime end) {
        return appointmentRepository.findByProviderAndDateRange(providerId, start, end);
    }


}
