package com.prahlad;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import com.sun.management.UnixOperatingSystemMXBean;
public class OpenFileCount{
    public static void main(String[] args){
        OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(os);
        if(os instanceof UnixOperatingSystemMXBean){
            System.out.println("Number of open fd: " + ((UnixOperatingSystemMXBean) os).getOpenFileDescriptorCount());
        }
    }
}
