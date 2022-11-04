package reorder_data_in_log_files_937;

import java.util.*;

public class Main {
    public String[] reorderLogFiles(String[] logs) {
        /*
            Iterate all logs.
            Use a PQ to save letter logs, sorted by lex order
            Use a list to save digits logs, don't change order
         */
        PriorityQueue<String> letters = new PriorityQueue<>(
                (a, b) -> {
                    int spaceA = a.indexOf(' '), spaceB = b.indexOf(' ');
                    int l = spaceA + 1, r = spaceB + 1;
                    while (l < a.length() && r < b.length()){
                        if(a.charAt(l) < b.charAt(r)){
                            return -1;
                        }else if(a.charAt(l) > b.charAt(r)){
                            return 1;
                        }else {
                            l++;
                            r++;
                        }
                    }

                    if(l == a.length() && r == b.length()) {
                        /*
                            Compare Id
                         */
                        return a.compareTo(b);
                    }else if(l == a.length()) return -1;
                    else return 1;
                }
        );
        List<String> digits = new ArrayList<>();

        for(String log: logs){
            if(log.charAt(log.length() - 1) >= 'a') letters.offer(log);
            else digits.add(log);
        }

        String[] result = new String[logs.length];
        int index = 0;
        while(!letters.isEmpty()) result[index++] = letters.poll();
        for(String log: digits) result[index++] = log;
        return result;
    }
}
