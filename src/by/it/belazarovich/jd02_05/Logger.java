package by.it.belazarovich.jd02_05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private final File logFile;

    private static volatile Logger instanceLogger;

    private Logger() {
        logFile = Util.getFile(Logger.class, "log.txt");
    }

    public static Logger getInstanceLogger() {
        Logger localLogger = instanceLogger;
        if (localLogger == null) {
            synchronized (Logger.class) {
                localLogger = instanceLogger;
                if (localLogger == null) {
                    localLogger = new Logger();
                    instanceLogger = localLogger;
                }
            }
        }
        return localLogger;
    }


    synchronized void log(String logText) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(logFile, true)
                )
        ) {
            logWriter.println(logText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

