import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        loadLib("javaLib.dll");
        sayHello();
    }

    private static void loadLib(String libName) {
        String buildType[] = { "Release", "MinSizeRel", "Debug", "RelWithDebInfo" };
        String currentDirectory = System.getProperty("user.dir");
        for (String type : buildType) {
            try {
                System.load(currentDirectory + "/lib/" + type + File.separator + libName);
                break;
            } catch (UnsatisfiedLinkError e) {
                System.err.println(e.getLocalizedMessage());
            }
        }
    }

    private native static void sayHello();
}
