package common;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNGAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent event) {
        Reporter.log(getLayout().format(event));
    }

    public void close() {
        Reporter.log("Logging appender is closed");
    }

    public boolean requiresLayout() {
        return true;
    }

    /**
     * Insert log message into reportNG
     *
     * @param logMessage
     */
    public void info(String logMessage) {
        Reporter.log(logMessage);
    }

}
