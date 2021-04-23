package org.mm.assess.input;

import java.util.Arrays;
import java.util.Scanner;

import org.mm.assess.common.Constants;
import org.mm.assess.model.ParkingLotStructure;
import org.mm.assess.service.impl.ProcessorImpl;

public class InteractiveIp {

    public void interactiveIpMethod() {
        Scanner in = new Scanner(System.in);
        try{
            ProcessorImpl p = new ProcessorImpl();
            System.out.println("Input:");
            String input = in.nextLine();
            ParkingLotStructure[] pL = null;
            String[] value;
            String result;
            while (!input.equalsIgnoreCase("exit")) {
                value = input.split(" ");
                if (Constants.parkingLot.equalsIgnoreCase(value[0]) && pL == null) {
                    pL = new ParkingLotStructure[Integer.parseInt(value[1])];
                    Arrays.fill(pL, new ParkingLotStructure());
                    System.out.print("Output:\n" + "Created a parking lot with " + value[1] + " slots.\n");
                } else {
                    result = p.process(value, pL);
                    System.out.print("Output:\n" + result);
                }
                System.out.println("Input:");
                input = in.nextLine();
            }
            System.out.println("Output:\n" + "Exiting the application :/");
        }
        catch(Exception e){
            System.out.println("Error in interactiveIpMethod:"+e);
        }
        finally{
            in.close();
        } 
    }

}
