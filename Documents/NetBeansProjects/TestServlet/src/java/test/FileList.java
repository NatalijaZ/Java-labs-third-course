package test;

//import java.io.FileNotFoundException;

//import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
//import javax.servlet.http.Part;
//import javax.servlet.ServletContext;
//import javax.faces.context.*;

public class FileList {
    //private static FileList ourInstance=new FileList();
    private static ArrayList<File> listWithFileNames = new ArrayList<>();
    private static ArrayList<File> listWithDirectoryNames = new ArrayList<>();
    
    public static ArrayList<File> getListDirectory(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isDirectory()) {
                listWithDirectoryNames.add(s);
            } 
        }
        return listWithDirectoryNames;
    }
    
    public static ArrayList<File> getListFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } 
        }
        return listWithFileNames;
    }
 
}