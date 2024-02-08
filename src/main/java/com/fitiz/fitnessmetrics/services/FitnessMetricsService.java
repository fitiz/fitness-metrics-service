package com.fitiz.fitnessmetrics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;
import com.fitiz.fitnessmetrics.repositories.FitnessMetricsHistoryRepository;
import com.fitiz.fitnessmetrics.repositories.FitnessMetricsRepository;
import org.springframework.context.ApplicationEventPublisher;
import com.fitiz.fitnessmetrics.events.FitnessMetricsUpdatedEvent;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Optional;



@Service
public class FitnessMetricsService {
    
    @Autowired
    private FitnessMetricsRepository fitnessMetricsRepository;

    @Autowired
    private FitnessMetricsHistoryRepository fitnessMetricsHistoryRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Transactional
    public void updateUserMetrics(UserFitnessMetrics userFitnessMetrics, Long userId) {
        userFitnessMetrics.setUserId(userId);

        Long countMetricsForCurrentDay = fitnessMetricsRepository.countByUserIdAndDay(userId, userFitnessMetrics.getStartTime(), userFitnessMetrics.getEndTime());
        if (countMetricsForCurrentDay < 1L) { //save to history once a day
            applicationEventPublisher.publishEvent(new FitnessMetricsUpdatedEvent(this, userFitnessMetrics));
        }
        fitnessMetricsRepository.save(userFitnessMetrics);

    }

}
