package longest_absolute_file_path_388;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");

        // Save the length of last dir of depth index;
        List<Integer> cache = new ArrayList<>();

        int maxLength = 0;
        for(String path: paths){
            int start = 0;
            int depth = 0;

            while (path.charAt(start) == '\t'){
                depth++;
                start++;
            }

            int length = depth == 0 ? path.length() : getDirLength(path.substring(start), cache.get(depth-1));

            if(cache.size() == depth){
                cache.add(length);
            }else{
                cache.set(depth, length);
            }

            if(path.contains("."))
                maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    private int getDirLength(String name, int parentL){
        return parentL + 1 + name.length();
    }
}
