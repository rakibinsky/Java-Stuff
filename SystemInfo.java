public class SystemInfo {
    public static void main(String[] args) {
        // Get specific properties
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");

        System.out.println("Operating System: " + osName);
        System.out.println("OS Version: " + osVersion);
        System.out.println("Java Version: " + javaVersion);
        System.out.println();

        // Get all system properties
        //Properties properties = System.getProperties();
        //properties.list(System.out);
    }
}