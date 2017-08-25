package com.host.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by sarkarri on 11/24/16.
 */
public class MyComputerHostName {
    public static void main(String[] args) throws IOException {
        //        System.out.println("Linux computer name through exec: " + execReadToString("hostname"));
//        System.out.println("Linux computer name through /etc/hostname: " + execReadToString("cat /etc/hostname"));
//
//        String envName = System.getenv("HOSTNAME");
//        System.out.println("envName "+envName);
        for (int i = 0; i < 10000; i++) {
            try {
                String os = System.getProperty("os.name").toLowerCase();
                System.out.println("OS " + os);

                if (os.indexOf("win") >= 0) {
                    System.out.println("Windows computer name throguh env:\"" + System.getenv("COMPUTERNAME") + "\"");
                    System.out.println("Windows computer name through exec:\"" + execReadToString("hostname") + "\"");
                } else {
                    if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
                        System.out.println("Linux computer name throguh env:\"" + System.getenv("HOSTNAME") + "\"");
                        System.out.println("Linux computer name through exec:\"" + execReadToString("hostname") + "\"");
                        System.out.println("Linux computer name through /etc/hostname:\"" + execReadToString("cat /etc/hostname") + "\"");
                    }
                }


//        try {
//           /* String hostName = System.getenv("HOSTNAME");
//            if(hostName == null){
//                String commandName = "hostname";
//                execReadToString(commandName);
//            }*/
//            StringBuilder sb = new StringBuilder();
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            sb.append(inetAddress.getHostName()).append("/").append(inetAddress.getHostAddress());
//            System.out.println("inet address "+sb.toString());
//        } catch (UnknownHostException e) {
//            System.out.println("UnknownHostException while retrieving hostname {} "+e.getMessage());
//        }catch (Exception e){
//            System.out.println("Exception while retrieving hostname {} "+e.getMessage());
//        }


                InetAddress address = InetAddress.getByName(System.getenv("HOSTNAME"));
                System.out.println("address " + address.getHostAddress());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

            System.out.println("i ========= "+i);
        }

    }


    public static String execReadToString(String execCommand) throws IOException, IOException {
        Process proc = Runtime.getRuntime().exec(execCommand);
        try (InputStream stream = proc.getInputStream()) {
            try (Scanner s = new Scanner(stream).useDelimiter("\\A")) {
                return s.hasNext() ? s.next() : "";
            }
        }
    }

}
