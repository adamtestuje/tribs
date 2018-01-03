package tribs.utils;


import tribs.page_objects.LoginPage;
import tribs.page_objects.Pages;

import java.util.ArrayList;
import java.util.List;

public class Tribs {
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
}
