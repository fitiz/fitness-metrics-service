package com.fitiz.fitnessmetrics.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "fitness_metrics")
public class UserFitnessMetrics {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fitnessMetricId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "height")
    private Float height; // in cm

    @Column(name = "weight")
    private Float weight; // in kg

    @Column(name = "stepCount")
    private Long stepCount;

    @Column(name = "distanceTotal")
    private Long distanceTotal;

    @Column(name = "caloriesBurned")
    private Double caloriesBurned;

    @Column(name = "average_pace")
    private Double averagePace; // in km/h
    

    @Column(name = "speed")
    private Float speed; // in m/s
    
    @Column(name = "speedKmH")
    private Float speedKmH; // in km/h

    @Column(name = "stride")
    private Float stride; // in cm
    

    public UserFitnessMetrics() {
    }

    public UserFitnessMetrics(
            Long userId, 
            LocalDateTime startTime, 
            LocalDateTime endTime, 
            Float height, 
            Float weight, 
            Long stepCount, 
            Long distanceTotal, 
            Double caloriesBurned, 
            Double averagePace, 
            Float speed, 
            Float speedKmH, 
            Float stride
        ) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.height = height;
        this.weight = weight;
        this.stepCount = stepCount;
        this.distanceTotal = distanceTotal;
        this.caloriesBurned = caloriesBurned;
        this.averagePace = averagePace;
        this.speed = speed;
        this.speedKmH = speedKmH;
        this.stride = stride;
    }




    public Long getFitnessMetricId() {
        return fitnessMetricId;
    }

    public void setFitnessMetricId(Long fitnessMetricId) {
        this.fitnessMetricId = fitnessMetricId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Long getStepCount() {
        return stepCount;
    }

    public void setStepCount(Long stepCount) {
        this.stepCount = stepCount;
    }

    public Long getDistanceTotal() {
        return distanceTotal;
    }

    public void setDistanceTotal(Long distanceTotal) {
        this.distanceTotal = distanceTotal;
    }

    public Double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Double getAveragePace() {
        return averagePace;
    }

    public void setAveragePace(Double averagePace) {
        this.averagePace = averagePace;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

        
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

        
    public Float getSpeedKmH() {
        return speedKmH;
    }

    public void setSpeedKmH(Float speedKmH) {
        this.speedKmH = speedKmH;
    }

    public Float getStride() {
        return stride;
    }

    public void setStride(Float stride) {
        this.stride = stride;
    }




}


