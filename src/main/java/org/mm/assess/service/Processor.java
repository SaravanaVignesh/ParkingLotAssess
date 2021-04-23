package org.mm.assess.service;

import org.mm.assess.model.ParkingLotStructure;

public interface Processor {
    public String process(String[] ip, ParkingLotStructure[] pL);
}
