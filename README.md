# Fitiz - Fitness Metrics Service (unfinished)
### (currently just a storage for the metrics collected from the user)



## Files: 
1. controller/APIController - exposes endpoint where client sends his metrics data to be stored 
2. eventListeners/FitnessMetricsUpdateListener - listens for fitness metrics updates
3. events/FitnessMetricsUpdatedEvent - custom event for fitness metrics update
4. model/* - dto classes
5. repositories/* - one repository for the actual fitness metrics and one for history data
6. services/* - one service for storing the data in the corresponding repository
