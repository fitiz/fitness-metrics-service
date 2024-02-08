
package com.fitiz.fitnessmetrics.listeners;

import com.fitiz.fitnessmetrics.events.FitnessMetricsUpdatedEvent;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;
import com.fitiz.fitnessmetrics.model.UserFitnessMetricsHistory;
import com.fitiz.fitnessmetrics.repositories.FitnessMetricsHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class FitnessMetricsUpdateListener implements ApplicationListener<FitnessMetricsUpdatedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FitnessMetricsUpdateListener.class);
    private final FitnessMetricsHistoryRepository fitnessMetricsHistoryRepository;


    public FitnessMetricsUpdateListener(FitnessMetricsHistoryRepository fitnessMetricsHistoryRepository) {
        this.fitnessMetricsHistoryRepository = fitnessMetricsHistoryRepository;
    }


    @Override
    public void onApplicationEvent(FitnessMetricsUpdatedEvent fitnessMetricsUpdatedEvent) {

        //old metrics saved in history database
        UserFitnessMetrics userFitnessMetrics = fitnessMetricsUpdatedEvent.getUserFitnessMetrics();
        LOGGER.info("Received fitness metrics update event for user: {}", userFitnessMetrics.getUserId());

        //convert to history entity
        UserFitnessMetricsHistory userFitnessMetricsHistory = convertToHistoryEntity(userFitnessMetrics);

        //save to history database
        fitnessMetricsHistoryRepository.save(userFitnessMetricsHistory);

    }

    private UserFitnessMetricsHistory convertToHistoryEntity(UserFitnessMetrics userFitnessMetrics) {
        UserFitnessMetricsHistory userFitnessMetricsHistory = new UserFitnessMetricsHistory();
        userFitnessMetricsHistory.setUserId(userFitnessMetrics.getUserId());
        userFitnessMetricsHistory.setStartTime(userFitnessMetrics.getStartTime());
        userFitnessMetricsHistory.setEndTime(userFitnessMetrics.getEndTime());
        userFitnessMetricsHistory.setHeight(userFitnessMetrics.getHeight());
        userFitnessMetricsHistory.setWeight(userFitnessMetrics.getWeight());
        userFitnessMetricsHistory.setStepCount(userFitnessMetrics.getStepCount());
        userFitnessMetricsHistory.setDistanceTotal(userFitnessMetrics.getDistanceTotal());
        userFitnessMetricsHistory.setCaloriesBurned(userFitnessMetrics.getCaloriesBurned());
        userFitnessMetricsHistory.setAveragePace(userFitnessMetrics.getAveragePace());
        userFitnessMetricsHistory.setSpeed(userFitnessMetrics.getSpeed());
        userFitnessMetricsHistory.setSpeedKmH(userFitnessMetrics.getSpeedKmH());
        userFitnessMetricsHistory.setStride(userFitnessMetrics.getStride());
        return userFitnessMetricsHistory;
    }

}
