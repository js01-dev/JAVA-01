import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestClassLoader extends ClassLoader {
    public String getCurrentPath() {
        String dirPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        return dirPath;
    }

    private static byte[] decode(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }

    @Override
    public Class<?> findClass(String name) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(this.getCurrentPath() + "/" + name + ".xlass"));
            bytes = decode(bytes);
            return defineClass(name,bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException("Read file error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = new TestClassLoader().findClass("Hello");
            Method declaredMethod = clazz.getDeclaredMethod("hello");
            declaredMethod.invoke(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}