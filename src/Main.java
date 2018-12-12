public class Main {

    public static void main(String[] args) {
        // link to ROOT folder
        directory rootFolder = new directory("root");
        fileSystem root =  new fileSystem(rootFolder);
    }

    public static class fileSystem{
        directory rootFolder;

        public fileSystem(directory root){
            this.rootFolder = root;
        }

//Adds new File under the Directory branch
        public void addFile (String parentDirName, String fileName, int fileSize){
            this.rootFolder.addFileToDir(parentDirName, fileName, fileSize);
        }


        //Adds new Directory under the parent Directory
        public void addDir (String parentDirName, String dirName){
            this.rootFolder.addDirToDir(parentDirName, dirName);
        }

        //Deletes the Directory or the File with this name
        public void delete (String name){
            this.rootFolder.deleteFile(name);
        }


        //Displays all files & directories with their hierarchical structure (for file display all file properties and for Directory all its properties)
        public void showFileSystem (){
            this.rootFolder.printAll("");
        }
    }
}

