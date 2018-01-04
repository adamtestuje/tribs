package tribs.utils;


import tribs.page_objects.LoginPage;
import tribs.page_objects.MainPage;
import tribs.page_objects.Pages;

import java.util.List;

public class Tribs {
    public static String gameRoot(String world) {
        return String.format("https://www.tribalwars.net/page/play/en%s", world);
    }

    public static boolean login(String login, String password) {
        LoginPage loginPage = Pages.loginPage();
        loginPage.loginAs(login, password);
        // TODO: Proper wait should be written for below
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loginPage.isLogged();
    }

    private static void openGame(String world) {
        Drivers.chrome().get(gameRoot(world));
    }

    public static List getWorlds() {
        // TODO: Proper wait should be written for below
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginPage loginPage = new LoginPage();
        return loginPage.getWorldsList();
    }

    public static List getVillages() {
        // TODO: Proper wait should be written for below
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage();
        return mainPage.getVillagesList();
    }
}
