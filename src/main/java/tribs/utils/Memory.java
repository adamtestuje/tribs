package tribs.utils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Memory {
    private static String login;
    private static String password;
    private static String world;

    public static void rememberUserData(String login, String password) {
        Memory.login = login;
        Memory.password = password;
    }

    public static void rememberWorld(String world) {
        Memory.world = world;
    }

    public static void saveUserData() {
        try (
            FileOutputStream fos = new FileOutputStream("userdata.dat");
            PrintStream writer = new PrintStream(fos)
        ) {
            writer.printf("%s|%s|%s", login, password, world);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map readUserData() {
        Map<String, String> userData = new HashMap<>();
        try (
            FileInputStream fis = new FileInputStream("userdata.dat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        ) {
            List<String> parsed = Arrays.asList(reader.readLine().split("\\|"));
            userData.put("login", parsed.get(0));
            userData.put("password", parsed.get(1));
            userData.put("world", parsed.get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }
}