package by.it.kishkar.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private final File logFile;

    private static volatile Logger logger;

    private Logger() {
        logFile = Util.getFile(Logger.class, "log.txt");
    }


    public static Logger getLogger() {
        Logger local = logger;

        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    local = logger = new Logger();
                }

            }
        }
        return local;
    }

    synchronized void log(String message) {
        try (
                PrintWriter logWriter = new PrintWriter(
                        new FileWriter(logFile, true)
                )
        ) {
            logWriter.println(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
