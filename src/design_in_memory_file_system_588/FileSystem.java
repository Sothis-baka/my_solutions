package design_in_memory_file_system_588;

import java.util.*;

/*
    Design and implement a file system with following
 */
public class FileSystem {
    /*
        The functional requirements include:
        1. Create Dir / File
        2. Find Dir / File
        3. Get children of dir (in order)
        4. Set, get File content

        Basically we need method to create/find Dir, and use that dir to create/find file
        Find & create are the same operation.
        Use a map to save all sub dirs
        Use another map to save all files with their content
     */

    static class Dir{
        Map<String, Dir> children;
        Map<String, String> files;

        Dir(){
            this.children = new HashMap<>();
            this.files = new HashMap<>();
        }

        Dir findDir(String[] names, int fromIndex, int toIndex){
            if(fromIndex >= toIndex) return this;

            String name = names[fromIndex];
            // Create dir if it's absent, recursively create/find dir until end
            return children
                    .computeIfAbsent(name, k -> new Dir())
                    .findDir(names, fromIndex + 1, toIndex);
        }

        void setFile(String name, String content){
            this.files.put(name, this.files.getOrDefault(name, "") + content);
        }

        String getFile(String name){
            return this.files.computeIfAbsent(name, k->"");
        }
    }

    Dir root;

    public FileSystem() {
        this.root = new Dir();
    }

    public List<String> ls(String path) {
        String[] names = path.split("/");
        Dir dir = root.findDir(names, 1, names.length - 1);

        if(names.length != 0){
            String name = names[names.length - 1];
            // It's a file, not a dir
            if(!dir.children.containsKey(name)){
                List<String> result = new ArrayList<>(){};
                result.add(name);
                return result;
            }

            // It's a dir
            dir = dir.children.get(name);
        }

        List<String> children = new ArrayList<>(dir.children.keySet());
        children.addAll(dir.files.keySet());

        children.sort(String::compareTo);
        return children;
    }

    public void mkdir(String path) {
        String[] names = path.split("/");
        root.findDir(names, 1, names.length);
    }

    public void addContentToFile(String filePath, String content) {
        String[] names = filePath.split("/");
        Dir dir = root.findDir(names, 1, names.length - 1);
        dir.setFile(names[names.length - 1], content);
    }

    public String readContentFromFile(String filePath) {
        String[] names = filePath.split("/");
        Dir dir = root.findDir(names, 1, names.length - 1);
        return dir.getFile(names[names.length - 1]);
    }

    public static void main(String[] args){
        FileSystem fs = new FileSystem();
        fs.ls("/");
        System.out.println(fs.root.children.keySet());
        fs.mkdir("/a/b/c");
        System.out.println(fs.root.children.keySet());
        fs.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fs.root.children.keySet());
        fs.ls("/");
    }
}
