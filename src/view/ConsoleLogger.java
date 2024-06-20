package view;

import java.time.LocalDateTime;

public class ConsoleLogger implements Loggable{
    @Override
    public void log(String message) {
        System.err.println(LocalDateTime.now() + " <--- : ---> " + message);

    }
}
