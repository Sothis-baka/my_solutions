package logger_rate_limiter_359;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
    Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
    It is possible that several messages arrive roughly at the same time.
 */
public class Logger {
    TreeMap<String, Integer> cache;
    int limit;

    Logger(int limit) {
        this.cache = new TreeMap<>();
        this.limit = limit;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // Discard no longer used entries
        while (cache.firstEntry().getValue() + 10 < timestamp){
            cache.remove(cache.firstKey());
        }

        if (timestamp - cache.getOrDefault(message, 0) >= 10) {
            cache.put(message, timestamp);
            return true;
        }

        cache.put(message, timestamp);
        return false;
    }
}