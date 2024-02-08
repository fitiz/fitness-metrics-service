
package com.fitiz.fitnessmetrics.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.fitiz.fitnessmetrics.services.FitnessMetricsService;
import com.fitiz.fitnessmetrics.model.UserFitnessMetrics;
import com.fitiz.fitnessmetrics.model.UserFitnessMetricsRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Handles requests to "/api" endpoints.
 * @see com.auth0.example.security.SecurityConfig to see how these endpoints are protected.
 */
@RestController
public class APIController {
    
    @Autowired
    private FitnessMetricsService fitnessMetricsService;

    private static final Logger logger = LoggerFactory.getLogger(APIController.class);

    @GetMapping(value = "/")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping(value = "/private/updateMetrics", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateMetricsEndpoint(@RequestBody UserFitnessMetricsRequest userFitnessMetricsRequest) {
        logger.info("Received fitness metrics update request for user: {}", userFitnessMetricsRequest.getUserId());
        
        UserFitnessMetrics userFitnessMetrics = userFitnessMetricsRequest.toUserFitnessMetrics();
        fitnessMetricsService.updateUserMetrics(userFitnessMetrics, userFitnessMetrics.getUserId());
        return ResponseEntity.ok().build();

    }
}
