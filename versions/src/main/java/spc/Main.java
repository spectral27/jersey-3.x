package spc;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        printInfo();

        if (System.getProperty("origin") != null && System.getProperty("origin").length() > 0) {
            System.out.println("Origin set to " + System.getProperty("origin"));
            VersionService.origin = System.getProperty("origin");
        } else {
            System.out.println("Origin not set");
            System.exit(1);
        }

        String url = "http://0.0.0.0:8080";

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(Main.class.getPackageName());

        GrizzlyHttpServerFactory.createHttpServer(URI.create(url), resourceConfig);
    }

    public static void printInfo() {
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String osVersion = System.getProperty("os.version");

        String javaVendor = System.getProperty("java.vendor");
        String javaVersion = System.getProperty("java.version");

        System.out.printf("%s %s %s%n", osName, osArch, osVersion);
        System.out.printf("%s JDK %s%n", javaVendor, javaVersion);
    }

}
