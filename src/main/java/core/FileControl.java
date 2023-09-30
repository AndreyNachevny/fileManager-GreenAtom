package core;

import console.ConsoleReader;
import manageFile.ManageFile;

import java.io.FileNotFoundException;
import java.util.List;

public class FileControl {

    private ConsoleReader consoleReader;

    private ManageFile manageFile;


    public FileControl(ConsoleReader consoleReader, ManageFile manageFile) {
        this.consoleReader = consoleReader;
        this.manageFile = manageFile;
    }

    public boolean control() {
        List<String> paramsAndActions = consoleReader.consoleRead();
        if (!paramsAndActions.isEmpty() && paramsAndActions.get(0).equals("exit")){
            return false;
        }
        if(paramsAndActions.size() >= 2){
            switch (paramsAndActions.get(1)) {
                case "-create" -> {
                    if (manageFile.createFile(paramsAndActions.get(0))) {
                        System.out.println("File was created!");
                    } else {
                        System.out.println("File already exists!");
                    }
                }
                case "-write" -> {
                    if(paramsAndActions.size() > 2){
                        try {
                            manageFile.writeToFile(paramsAndActions.get(0), paramsAndActions);
                            System.out.println("Text saved");
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("You have not entered text");
                    }
                }
                case "-read" -> {
                    try {
                        System.out.println(manageFile.readFile(paramsAndActions.get(0)));
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "-remove" -> {
                    if (manageFile.removeFile(paramsAndActions.get(0))) {
                        System.out.println("file successful was removed");
                    } else {
                        System.out.println("Something went wrong");
                    }
                }
            }
            return true;
        }
        System.out.println("you entered something incorrect");
        return true;
    }
}
