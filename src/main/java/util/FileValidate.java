package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileValidate {
    public boolean isFileExists(String path){
        File fileToCheck = new File(path);
        return fileToCheck.exists();
    }

    public boolean isFileNotEmpty(String path) {
        File fileToCheck = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToCheck));
            return !(br.readLine() == null);
        } catch (IOException e) {
            return false;
        }
    }
}
