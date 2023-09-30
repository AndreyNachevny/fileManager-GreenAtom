package manageFile;

import util.FileValidate;
import util.TextValidate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageFile {

    private FileValidate fileValidate;

    private TextValidate textValidate;

    public ManageFile(FileValidate fileValidate, TextValidate textValidate) {
        this.fileValidate = fileValidate;
        this.textValidate = textValidate;
    }

    public List<Character> readFile(String path) throws FileNotFoundException {

        if (fileValidate.isFileExists(path)) {

            if (fileValidate.isFileNotEmpty(path)){

                List<Character> textFromFile = new ArrayList<>();
                try (FileReader fileReader = new FileReader(path)) {
                    int bt;

                    while ((bt = fileReader.read()) != -1) {
                        textFromFile.add((char) bt);
                    }
                    return textFromFile;

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            throw new FileNotFoundException("file is empty");
        }
        throw new FileNotFoundException("file not exists");
    }

    public void writeToFile(String path, List<String> text) throws FileNotFoundException {
        if(fileValidate.isFileExists(path)){
            try (FileWriter fileWriter = new FileWriter(path,false)) {
                text = textValidate.validate(text);
                for(String word:text){
                    for (int i =0; i < word.length(); i++){
                        fileWriter.write(word.charAt(i));
                    }
                }

            } catch (IOException e){
                System.err.println(e.getMessage());
            }
        } else {
            throw new FileNotFoundException("File not exists");
        }
    }

    public boolean createFile(String path){
        if (!fileValidate.isFileExists(path)){
            File fileToCreate = new File(path);
            try {
                return fileToCreate.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean removeFile(String path){
        if (fileValidate.isFileExists(path)){
            File fileToRemove = new File(path);
            return fileToRemove.delete();
        }
        return false;
    }
}
