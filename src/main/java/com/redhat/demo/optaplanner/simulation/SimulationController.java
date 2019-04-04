package com.redhat.demo.optaplanner.simulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/simulation")
public class SimulationController {

    private static final Logger log = LoggerFactory.getLogger(SimulationController.class);

    @Autowired
    private SimulationService simulationService;

    public SimulationController() {
    }

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public void startSimulation() {
        log.info("Starting simulation");
        simulationService.startSimulation();
    }

    @PostMapping("/stop")
    @ResponseStatus(HttpStatus.OK)
    public void stopSimulation() {
        log.info("Stopping simulation");
        simulationService.stopSimulation();
    }

    @PostMapping (value = "/damage")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void damageMachine(@RequestBody DamageOrHealMachine machine) {
        log.info("Damaging a machine " + machine.getMachineIndex());
        simulationService.damageMachine(machine.getMachineIndex());
    }

    @PostMapping (value = "/heal")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void healMachine(@RequestBody DamageOrHealMachine machine) {
        log.info("Healing a machine " + machine.getMachineIndex());
        simulationService.healMachine(machine.getMachineIndex());
    }
}
