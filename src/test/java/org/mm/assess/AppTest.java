package org.mm.assess;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
import java.net.*;
import org.junit.*;
import org.mm.assess.input.InteractiveIp;
/**
 * Unit test for simple App.
 */
public class AppTest extends App
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void testMainWthFileIp() throws IOException {
        System.out.println("Entering AppTest : testMainWthFileIp at "+System.currentTimeMillis());
        String path = System.getProperty("user.dir")+"\\input.txt";
        System.out.println(path);
        String[] args = {path};
        main(args);
        System.out.println("Exiting AppTest : testMainWthFileIp at "+System.currentTimeMillis());
    }
}
