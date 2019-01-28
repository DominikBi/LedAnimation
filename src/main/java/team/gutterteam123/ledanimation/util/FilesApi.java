package team.gutterteam123.ledanimation.util;

import io.github.splotycode.mosaik.util.info.SystemProperties;
import team.gutterteam123.ledanimation.elemets.Animation;

import java.io.*;

public class FilesApi {

    String userName = SystemProperties.getUserName();
    String filesep = System.getProperty("file.separator");
    String linesep = System.getProperty("line.separator");

    public boolean fileExists(String filename, String path){
        return new File(path, filename).exists();
    }

    public void createFile(String filename, String Content) throws IOException {
        String path = "C:" + filesep +"Users" + filesep + userName  + filesep +"LedAnimation" + filesep +"src" + filesep +"main" + filesep +"resources" + filename + ".txt";
        FileOutputStream fos = new FileOutputStream(filename + ".txt");
        fos.write(Content.getBytes());
    }
    public void addContent(String filename, String... Content) throws IOException {
        String path = "C:" + filesep +"Users" + filesep + userName  + filesep +"LedAnimation" + filesep +"src" + filesep +"main" + filesep +"resources" + filename + ".txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        for(int i=0; i<Content.length; i++)
        fileOutputStream.write(Content[i].getBytes());
        fileOutputStream.write(linesep.getBytes());
    }
    public void readFile(String filename) throws IOException {
        String path = "C:" + filesep +"Users" + filesep + userName  + filesep +"LedAnimation" + filesep +"src" + filesep +"main" + filesep +"resources" + filename + ".txt";
        FileInputStream fis = new FileInputStream(path);
        String text = "";
        int ios = 0;
        char c;
        while(fis.available() > 0){
            c = (char) fis.read();
                if(c == linesep.charAt(0)){
                    ios++;
                    String aniname = "animation" + String.valueOf(ios);
                    Animation animation = new Animation();



                }
            text = text + c;


        }

    }
}