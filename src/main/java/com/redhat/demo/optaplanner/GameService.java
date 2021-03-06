package com.redhat.demo.optaplanner;

public interface GameService {
     void pauseGame();

     void resumeGame();

     void addMechanic();

     void removeMechanic();

     void initializeDownstream();

     boolean isDispatchPaused();

     void reset(boolean healAllMachines);

     void setupForStage();
}
