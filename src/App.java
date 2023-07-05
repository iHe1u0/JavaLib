public class App {
    public static void main(String[] args) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        System.load(currentDirectory + "/build/Debug/javaLib.dll");
        sayHello();
    }

    private native static void sayHello();
}
