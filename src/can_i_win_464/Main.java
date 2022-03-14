package can_i_win_464;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        boolean[] status = new boolean[maxChoosableInteger + 1];
        return canWin(desiredTotal, status, new HashMap<>());
    }

    private static boolean canWin(int remain, boolean[] status, Map<Integer, Boolean> cache){
        int asInt = format(status);
        if(!cache.containsKey(asInt)){
            for(int i=1; i<status.length; i++){
                if(!status[i]){
                    status[i] = true;
                    if(remain - i <= 0 || !canWin(remain - i, status, cache)){
                        status[i] = false;
                        cache.put(asInt, true);
                        return true;
                    }
                    status[i] = false;
                }
            }

            cache.put(asInt, false);
        }

        return cache.get(asInt);
    }

    public static int format(boolean[] used){
        int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }

    public static void main(String[] args){
        System.out.println(canIWin(20, 152));
    }
}
