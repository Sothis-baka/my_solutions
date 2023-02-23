package simplify_path_71;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 */
public class Main {
    public static String simplifyPath(String path) {
        List<String> li = new ArrayList<>();
        int length = path.length();
        StringBuilder strBd = new StringBuilder();

        int i=0;
        while(i < length){
            if(path.charAt(i) == '/'){
                if(strBd.length() > 0){
                    li.add(strBd.toString());
                }
                strBd = new StringBuilder();
            }else{
                strBd.append(path.charAt(i));
            }

            i++;
        }

        if(strBd.length() > 0){
            li.add(strBd.toString());
        }

        List<String> realLi = new ArrayList<>();
        for(String temp: li){
            if(!temp.equals(".")){
                if(temp.equals("..")){
                    if(!realLi.isEmpty()){
                        realLi.remove(realLi.size() - 1);
                    }
                }else{
                    realLi.add(temp);
                }
            }
        }

        if(realLi.isEmpty()){
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for(String temp: realLi){
            result.append("/");
            result.append(temp);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
