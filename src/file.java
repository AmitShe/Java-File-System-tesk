import java.util.Date;

public class file {
    private String name;
    private int size;
    private Date createDate;


    public file(String name, int size){
        this.name = name.substring(0,32);
        this.size = size;
        this.createDate = new Date();
    }

    public void printFile(String startOfRow) {
        System.out.println(startOfRow + " Name: " + this.name + " | Create Date: " + this.createDate + " | Size: " + this.size);
    }
}
