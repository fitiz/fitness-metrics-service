package com.fitiz.fitnessmetrics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitiz.fitnessmetrics.model.UserFitnessMetricsHistory;
import java.util.List;

public interface FitnessMetricsHistoryRepository extends JpaRepository<UserFitnessMetricsHistory, Long> {
    List<UserFitnessMetricsHistory> findByUserId(Long userId);
}
