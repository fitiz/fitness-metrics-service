package com.fitiz.fitnessmetrics.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.Instant;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;



public class UserFitnessMetricsRequest {

    
    private Long userId;
    private Long startTime;
    private Long endTime;
    private Float height; // in cm
    private Float weight; // in kg
    private Long stepCount;
    private Long distanceTotal;
    private Double caloriesBurned;
    private Double averagePace; // in km/h
    private Float speed; // in m/s
    private Float speedKmH; // in km/h
    private Float stride; // in cm

    public UserFitnessMetricsRequest() {
    }
    public UserFitnessMetricsRequest(
            Long userId, 
            Long startTime, 
            Long endTime, 
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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

        
    public void setEndTime(Long endTime) {
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


    public UserFitnessMetrics toUserFitnessMetrics() {
        LocalDateTime startTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(this.getStartTime()), ZoneOffset.UTC);
        LocalDateTime endTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(this.getEndTime()), ZoneOffset.UTC);
        return new UserFitnessMetrics(
            this.getUserId(),
            startTime,
            endTime,
            this.getHeight(),
            this.getWeight(),
            this.getStepCount(),
            this.getDistanceTotal(),
            this.getCaloriesBurned(),
            this.getAveragePace(),
            this.getSpeed(),
            this.getSpeedKmH(),
            this.getStride()
        );
    }
}


