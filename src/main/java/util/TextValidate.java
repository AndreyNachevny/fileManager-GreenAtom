package util;

import java.util.List;

public class TextValidate {

    public List<String> validate(List<String> text){
        text.remove(0);
        text.remove(0);
        StringBuilder firstWord = new StringBuilder();
        StringBuilder lastWord = new StringBuilder();
        for (int i =0; i < text.get(0).length(); i++ ){
            if (text.get(0).charAt(i) == 34){
                continue;
            }
            firstWord.append(text.get(0).charAt(i));
        }
        text.set(0,firstWord.toString());
        for (int i =0; i < text.get(text.size()-1).length(); i++ ){
            if (text.get(text.size()-1).charAt(i) == 34){
                continue;
            }
            lastWord.append(text.get(text.size()-1).charAt(i));
        }
        text.set(text.size()-1, lastWord.toString());
        return text;
    }
}
