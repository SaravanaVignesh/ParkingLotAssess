package org.mm.assess;

import java.io.*;
import java.util.Scanner;

import org.mm.assess.input.FileIp;
import org.mm.assess.input.InteractiveIp;

public class App {
    public static void main(String[] args) {
        if (args.length == 1) {
            try (Scanner reader = new Scanner(new FileInputStream(args[0]));) {
                FileIp readIp = new FileIp();
                readIp.processFile(reader);
            } catch (Exception e) {
                System.err.println("Error in Main:" + e);
            }
        } else {
            InteractiveIp interIp = new InteractiveIp();
            interIp.interactiveIpMethod();
        }
    }
}
