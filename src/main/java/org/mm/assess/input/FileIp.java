package org.mm.assess.input;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.mm.assess.common.Constants;
import org.mm.assess.model.ParkingLotStructure;
import org.mm.assess.service.impl.ProcessorImpl;

public class FileIp {

    public void processFile(Scanner reader) {
        String input;
        String[] value;
        //StringBuilder result = new StringBuilder();
        ProcessorImpl p = new ProcessorImpl();
        ParkingLotStructure[] pL = null;
        try {
            /*File file = createFile();
            FileOutputStream fos = new FileOutputStream(file, true);*/
            while(reader.hasNextLine()) {
                input = reader.nextLine();
                value = input.split(" ");
                if (Constants.parkingLot.equalsIgnoreCase(value[0]) && pL == null) {
                    pL = new ParkingLotStructure[Integer.parseInt(value[1])];
                    Arrays.fill(pL, new ParkingLotStructure());
                    System.out.print("Created a parking lot with " + value[1] + " slots.\n");
                } else {
                    System.out.print(p.process(value, pL));
                }
            }
            /*byte[] b = result.toString().getBytes();
            fos.write(b);
            fos.close();
            System.out.println("Output file saved.");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    private File createFile() throws IOException {
        File file = new File("/output.txt");
        boolean result = true;
        int i = 1;
        while (result) {
            result = file.createNewFile();
            if (!result) {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
                file = new File("/output" + i + ".txt");
            } else {
                System.out.println("File created successfully at location: " + file.getCanonicalPath());
            }
        }
        return file;
    }*/

}
