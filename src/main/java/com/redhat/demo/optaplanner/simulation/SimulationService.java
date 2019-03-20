package com.redhat.demo.optaplanner.simulation;

import com.redhat.demo.optaplanner.AppConstants;
import com.redhat.demo.optaplanner.upstream.UpstreamConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    @Autowired
    private UpstreamConnector upstreamConnector;

    @Scheduled(fixedDelay = AppConstants.TIME_TICK_MILLIS)
    public void damageMachines() {
        for (int i = 0; i < AppConstants.MACHINES_LENGTH; i++) {
            upstreamConnector.damageMachine(i, Math.random() / 1000);
        }
    }
}