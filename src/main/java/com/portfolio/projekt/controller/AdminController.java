package com.portfolio.projekt.controller;

import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.entity.User;
import com.portfolio.projekt.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/providers")
    public List<User> getProviders() {
        return adminService.getProviders();
    }

    @DeleteMapping("/providers/{id}")
    public void deleteProvider(@PathVariable Long id) {
        adminService.deleteProvider(id);
    }

    @PostMapping("/providers/{id}/block")
    public User blockProvider(@PathVariable Long id) {
        return adminService.blockProvider(id);
    }

    @PostMapping("/providers/{id}/unblock")
    public User unblockProvider(@PathVariable Long id) {
        return adminService.unblockProvider(id);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return adminService.getAllAppointments();
    }

    @GetMapping("/appointments/provider/{providerId}")
    public List<Appointment> getAppointmentsByProvider(@PathVariable Long providerId) {
        return adminService.getAppointmentsByProvider(providerId);
    }

    @GetMapping("/appointments/user/{userId}")
    public List<Appointment> getAppointmentsByUser(@PathVariable Long userId) {
        return adminService.getAppointmentsByUser(userId);
    }

    @GetMapping("/appointments/date/{date}")
    public List<Appointment> getAppointmentsByDate(@PathVariable String date) {
        return adminService.getAppointmentsByDate(LocalDateTime.parse(date));
    }

    @GetMapping("/appointments/range")
    public List<Appointment> getAppointmentsByDateRange(@RequestParam String start,
            @RequestParam String end) {

        return adminService.getAppointmentsByDateRange(LocalDateTime.parse(start),
                LocalDateTime.parse(end));
    }

    @DeleteMapping("/appointments/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {
        adminService.deleteAppointment(appointmentId);
    }

    @GetMapping("/appointments/user/{userId}/date/{date}")
    public List<Appointment> getAppointmentsByUserAndDate(@PathVariable Long userId,
            @PathVariable String date) {

        return adminService.getAppointmentsByUserAndDate(userId, LocalDateTime.parse(date));
    }

    @GetMapping("/appointments/provider/{providerId}/range")
    public List<Appointment> getAppointmentsByProviderAndRange(@PathVariable Long providerId,
            @RequestParam String start, @RequestParam String end) {

        return adminService.getAppointmentsByProviderAndRange(providerId,
                LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

}

