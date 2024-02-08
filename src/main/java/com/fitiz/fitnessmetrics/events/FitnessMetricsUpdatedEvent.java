package com.fitiz.fitnessmetrics.events;

import org.springframework.context.ApplicationEvent;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;


public class FitnessMetricsUpdatedEvent extends ApplicationEvent {
    //the old (current) fitness metrics to be updated with the new ones (save before discarding) 
    private final UserFitnessMetrics userFitnessMetrics;

    public FitnessMetricsUpdatedEvent(Object source, UserFitnessMetrics userFitnessMetrics) {
        super(source);
        this.userFitnessMetrics = userFitnessMetrics;
    }

    public UserFitnessMetrics getUserFitnessMetrics() {
        return userFitnessMetrics;
    }

}
