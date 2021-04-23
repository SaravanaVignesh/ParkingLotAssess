package org.mm.assess.service.impl;

import org.mm.assess.common.Constants;
import org.mm.assess.model.ParkingLotStructure;
import org.mm.assess.service.Processor;

public class ProcessorImpl implements Processor {

    @Override
    public String process(String[] ip, ParkingLotStructure[] pL) {
        if (pL != null) {
            switch (ip[0]) {
            case Constants.park:
                return checkParkingSpace(ip[1], ip[2], pL);
            case Constants.leave:
                return leaveParkingSpace(Integer.parseInt(ip[1]), pL);
            case Constants.slotNumRegNum:
                return getParkingDetails(ip[1], pL, "snwr") + "\n";
            case Constants.slotNumCarColor:
                return getParkingDetails(ip[1], pL, "snwc") + "\n";
            case Constants.regNum:
                return getParkingDetails(ip[1], pL, "rnwc") + "\n";
            case Constants.status:
                return status(pL);
            default:
                return "Please provide correct input";
            }
        }
        return "Parking Lot is not created.";
    }

    private String checkParkingSpace(String regNum, String carColour, ParkingLotStructure[] pL) {

        for (int i = 0; i < pL.length; i++) {
            if (pL[i].isFree()) {
                pL[i] = new ParkingLotStructure(regNum, carColour, false);
                return "Allocated slot number: " + (i + 1) + ".\n";
            }
        }
        return "Sorry, parking lot is full.\n";

    }

    private String leaveParkingSpace(int lotNum, ParkingLotStructure[] pL) {
        if (pL[lotNum - 1].isFree()) {
            return "Slot number " + lotNum + " is already free.\n";
        } else {
            pL[lotNum - 1] = new ParkingLotStructure(null, null, true);
            return "Slot number " + lotNum + " is free.\n";
        }
    }

    private String status(ParkingLotStructure[] pL) {
        StringBuilder sb = new StringBuilder();
        sb.append("Slot No. Registration No. Colour \n");
        for (int i = 0; i < pL.length; i++) {
            if (!pL[i].isFree()) {
                sb.append(i + 1 + " \t " + pL[i].getRegNum() + " \t  " + pL[i].getCarColour() + "\n");
            }
        }
        return sb.toString();
    }

    private String getParkingDetails(String value, ParkingLotStructure[] pL, String type) {
        String result = "";
        for (int i = 0; i < pL.length; i++) {
            if (type.equalsIgnoreCase("rnwc") && !pL[i].isFree() && pL[i].getCarColour().equalsIgnoreCase(value)) {
                result = result + pL[i].getRegNum() + ", ";
            } else if (type.equalsIgnoreCase("snwc") && !pL[i].isFree()
                    && pL[i].getCarColour().equalsIgnoreCase(value)) {
                result = result + (i + 1) + ", ";
            } else if (type.equalsIgnoreCase("snwr") && !pL[i].isFree() && pL[i].getRegNum().equalsIgnoreCase(value)) {
                result = result + (i + 1) + ", ";
            }
        }

        return (result.length() > 2) ? result.substring(0, result.length() - 2) : "Not Found";
    }

}
