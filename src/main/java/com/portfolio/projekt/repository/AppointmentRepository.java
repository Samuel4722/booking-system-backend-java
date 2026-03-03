package com.portfolio.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.projekt.entity.Appointment;
import com.portfolio.projekt.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByProviderId(Long providerId);

    List<Appointment> findByUserId(Long userId);

    @Query("""
                SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
                FROM Appointment a
                WHERE a.provider = :provider
                AND (a.startTime < :end AND a.endTime > :start)
            """)
    boolean existsByProviderAndTimeRange(User provider, LocalDateTime start, LocalDateTime end);

    @Query("""
                SELECT a FROM Appointment a
                WHERE DATE(a.startTime) = DATE(:date)
            """)
    List<Appointment> findByDate(LocalDateTime date);

    @Query("""
                SELECT a FROM Appointment a
                WHERE a.startTime >= :start AND a.endTime <= :end
            """)
    List<Appointment> findByDateRange(LocalDateTime start, LocalDateTime end);

    @Query("""
                SELECT a FROM Appointment a
                WHERE a.user.id = :userId
                AND DATE(a.startTime) = DATE(:date)
            """)
    List<Appointment> findByUserAndDate(Long userId, LocalDateTime date);

    @Query("""
                SELECT a FROM Appointment a
                WHERE a.provider.id = :providerId
                AND a.startTime >= :start
                AND a.endTime <= :end
            """)
    List<Appointment> findByProviderAndDateRange(Long providerId, LocalDateTime start,
            LocalDateTime end);


}
