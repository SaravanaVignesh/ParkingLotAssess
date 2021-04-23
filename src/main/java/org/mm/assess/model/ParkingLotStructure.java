package org.mm.assess.model;

public class ParkingLotStructure {
    private String regNum;
    private String carColour;
    private boolean isFree = true;

    public ParkingLotStructure(String regNum, String carColour, boolean isFree) {
        this.regNum = regNum;
        this.carColour = carColour;
        this.isFree = isFree;
    }

    public ParkingLotStructure() {
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "ParkingLotStructure [carColour=" + carColour + ", isFree=" + isFree + ", regNum=" + regNum + "]";
    }

}
