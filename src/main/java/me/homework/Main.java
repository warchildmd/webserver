package me.homework;

import me.homework.server.WebServer;
import me.homework.server.apps.FileServingApp;

/**
 * Created by Mihail on 10/24/2015.
 */
public class Main {

    public static void main(String [] args) {
        new Thread(
                new WebServer(3000, 10, new FileServingApp("web/"))
        ).start();
    }

}
