package me.homework.server.helpers;

import java.util.Calendar;

/**
 * Created by Mihail on 10/25/2015.
 */
public class Logger {

    public static void info(String tag, String content) {
        System.out.println("["
                + Calendar.getInstance().getTime().toString()
                + "] "
                + tag
                + " - "
                + content
        );
    }

    public static void error(String tag, String content) {
        System.err.println("["
                        + Calendar.getInstance().getTime().toString()
                        + "] "
                        + tag
                        + " ERROR - "
                        + content
        );
    }

}
