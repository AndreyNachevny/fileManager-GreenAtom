package core;

import console.ConsoleReader;
import manageFile.ManageFile;
import util.FileValidate;
import util.TextValidate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileValidate fileValidate = new FileValidate();
        TextValidate textValidate = new TextValidate();
        ManageFile manageFile = new ManageFile(fileValidate, textValidate);
        ConsoleReader consoleReader = new ConsoleReader(new Scanner(System.in));
        FileControl fileControl = new FileControl(consoleReader,manageFile);
        while (true){
            if(!fileControl.control()) break;
        }
    }
}
