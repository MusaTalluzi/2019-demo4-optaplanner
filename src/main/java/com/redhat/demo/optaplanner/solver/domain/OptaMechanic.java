/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redhat.demo.optaplanner.solver.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

public class OptaMechanic extends OptaVisitOrMechanic {

    @PlanningId
    private int mechanicIndex;

    // The machine component that the mechanic is currently working on, on-route to or has just finished working on
    private OptaMachine focusMachine;
    // When the OptaMechanic will finish with working on focusMachine
    private long focusDepartureTimeMillis;

    private OptaMechanic() {
    }

    public OptaMechanic(int mechanicIndex, OptaMachine focusMachine, long focusDepartureTimeMillis) {
        this.mechanicIndex = mechanicIndex;
        this.focusMachine = focusMachine;
        this.focusDepartureTimeMillis = focusDepartureTimeMillis;
    }

    @Override
    public OptaMachine getMachine() {
        return focusMachine;
    }

    @Override
    public Long getDepartureTimeMillis() {
        return focusDepartureTimeMillis;
    }

    @Override
    public String toString() {
        return "OptaMechanic-" + mechanicIndex;
    }

    // ************************************************************************
    // Getter and setters boilerplate
    // ************************************************************************

    public int getMechanicIndex() {
        return mechanicIndex;
    }

    public OptaMachine getFocusMachine() {
        return focusMachine;
    }

    public void setFocusMachine(OptaMachine focusMachine) {
        this.focusMachine = focusMachine;
    }

    public long getFocusDepartureTimeMillis() {
        return focusDepartureTimeMillis;
    }

    public void setFocusDepartureTimeMillis(long focusDepartureTimeMillis) {
        this.focusDepartureTimeMillis = focusDepartureTimeMillis;
    }

}