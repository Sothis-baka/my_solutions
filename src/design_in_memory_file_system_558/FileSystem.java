package design_in_memory_file_system_558;

import java.util.ArrayList;
import java.util.List;

/*
    Design and implement a file system with following
 */
public class FileSystem {
    // Use a class to represent file
    static class File{
        String name;
        boolean isDir;

        // Dir contains a list of file
        List<File> files;
        // Non-dir contains some content
        String content;

        File(String name, boolean isDir){
            this.name = name;
            this.isDir = isDir;

            if(isDir){
                files = new ArrayList<>();
            }else{
                content = "";
            }
        }
    }

    File root;

    FileSystem(){
        root = new File("", true);
    }

    private String[] analysisPath(String path){
        return path.split("/");
    }

    public List<String> ls(String path) {
        return null;
    }

    public void mkdir(String path) {
        String[] pathList = analysisPath(path);
        int length = pathList.length;

        File cur = root;
        for(int i=0; i<length - 1; i++){

        }
    }

    public void addContentToFile(String filePath, String content) {

    }

    public String readContentFromFile(String filePath) {
        return "";
    }
}
