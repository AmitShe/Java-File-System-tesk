import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class directory {
    private String name;
    private Date createDate;
    private Map<String, directory> subDir;
    private Map<String, file> files;

    public directory(String name){
        this.name = name.substring(0,32);
        this.createDate = new Date();
        this.subDir = new HashMap<>();
        this.files= new HashMap<>();
    }

    public void addFileToDir(String parentDirName, String fileName, int fileSize) {
        directory dirToInsertFile;
        if (subDir.containsKey(parentDirName)){
            dirToInsertFile = subDir.get(parentDirName);
            dirToInsertFile.files.put(fileName, new file(fileName, fileSize));
        }else{
            for (String key : subDir.keySet()){
                dirToInsertFile = subDir.get(key);
                dirToInsertFile.addFileToDir(parentDirName, fileName, fileSize);
            }
        }
    }

    public void addDirToDir(String parentDirName, String dirName) {
        directory dirToInsertFile;
        if (subDir.containsKey(parentDirName)){
            dirToInsertFile = subDir.get(parentDirName);
            dirToInsertFile.subDir.put(dirName, new directory(dirName));
        }else{
            for (String key : subDir.keySet()){
                dirToInsertFile = subDir.get(key);
                dirToInsertFile.addDirToDir(parentDirName, dirName);
            }
        }
    }

    public void deleteFile(String name) {
        directory dirToLookIn;
        if(files.containsKey(name)){
            files.remove(name);
        }else{
            for (String key : subDir.keySet()) {
                dirToLookIn = subDir.get(key);
                dirToLookIn.deleteFile(name);
            }
        }
    }

    // startOfRow is for display
    public void printAll(String startOfRow) {
        System.out.println("Name: " + this.name + " | Create Date: " + this.createDate);
        for (String key : subDir.keySet()){
            directory nextDir = this.subDir.get(key);
            nextDir.printAll(startOfRow + "-");
        }
        for (String key : files.keySet()){
            file FileToPrint = files.get(key);
            FileToPrint.printFile(startOfRow);
        }
    }
}


