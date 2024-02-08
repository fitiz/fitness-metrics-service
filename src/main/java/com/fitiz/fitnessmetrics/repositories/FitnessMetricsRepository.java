package com.fitiz.fitnessmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;


public interface FitnessMetricsRepository extends JpaRepository<UserFitnessMetrics, Long> {
    Optional<UserFitnessMetrics> findByUserId(Long userId);

    @Query("SELECT count(ufm) FROM UserFitnessMetrics ufm WHERE ufm.userId = :userId AND ufm.startTime >= :startTime AND ufm.endTime <= :endTime")
    Long countByUserIdAndDay(Long userId, LocalDateTime startTime, LocalDateTime endTime);
}
