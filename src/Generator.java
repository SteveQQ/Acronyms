import com.sun.deploy.util.ArrayUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by SteveQ on 2016-08-03.
 */
public class Generator implements ActionListener {
    public String inputWord = null;
    public void actionPerformed(ActionEvent ev) {
        String selectedWord;
        try {
            selectedWord = GUI.inputWords.getSelectedText();
            if (selectedWord != null) {
                GUI.outputAcronyms.append(selectedWord + "\n");
            }
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }
    public int strongOperation(int number) {
        int result = 0;
        if(number == 0) {
            result = 1;
        }
        if(number > 0) {
            result = number * strongOperation(number - 1);
        }
        return result;
    }

    public int permutationWithRepetition(int number, List<Integer> repetitions) {
        int result = 0;
        int numenator = strongOperation(number);
        int denumenator = 1;
        for (int val : repetitions) {
            denumenator = strongOperation(val) * denumenator;
        }
        result = numenator / denumenator;
        return result;
    }

    public List<Integer> getRepetitions(ArrayList<Character> charList){
        Set<Character> charSet = new HashSet<Character>(charList);
        List<Integer> repetitions = new ArrayList<Integer>();
        for (Character elS : charSet) {
            int i = 0;
            for(Character el : charList) {
                if (elS.equals(el)){
                    i++;
                }
            }
            repetitions.add(i);
        }
        return repetitions;
    }

    public ArrayList<Character> swapIndexes(ArrayList<Character> charList, int index1, int index2) {
        Character tmp1 = charList.get(index1);
        Character tmp2 = charList.get(index2);
        charList.remove(index1);
        charList.add(index1,tmp2);
        System.out.println(charList);
        charList.remove(index2);
        charList.add(index2,tmp1);
        System.out.println(charList);

        return charList;
    }

    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public ArrayList<String> generateAcronyms(String word){
        char[] charsArray = word.toCharArray();
        ArrayList<Character> charsOrigin = new ArrayList<Character>();
        ArrayList<String> acronymsList = new ArrayList<String>();
        String acronymAsString = null;
        for (char ch : charsArray) {
            charsOrigin.add(new Character(ch));
        }
        ArrayList<Character> charsToModify = new ArrayList<Character>();
        for (Character el : charsOrigin) {
            charsToModify.add(el);
        }
        if (charsOrigin.size() == 2) {
            charsToModify = swapIndexes(charsToModify, 0, 1);
            acronymAsString = getStringRepresentation(charsToModify);
            acronymsList.add(acronymAsString);
        }
        if (charsOrigin.size() == 3) {
            do {
                for (int i = 0; i < charsOrigin.size(); i++) {
                    if (i + 1 < charsOrigin.size()) {
                        charsToModify = swapIndexes(charsToModify, i, i + 1);
                    } else {
                        charsToModify = swapIndexes(charsToModify, i, 0);
                    }
                    acronymAsString = getStringRepresentation(charsToModify);
                    if ((acronymsList.indexOf(acronymAsString) < 0)) {
                        acronymsList.add(acronymAsString);
                    }
                }
            } while(acronymsList.size() != (permutationWithRepetition(charsOrigin.size(), getRepetitions(charsOrigin))));
        }
        if (charsOrigin.size() > 3) {
            Character tempRemovedChar = null;
            for(int i = 0; i < charsOrigin.size(); i++) {
                if (i > 0) {
                    charsToModify = swapIndexes(charsToModify, 0, i);
                }
                Character temporaryRemovedLetter = charsToModify.get(0);
                tempRemovedChar = charsToModify.get(0);
                charsToModify.remove(0);
                ArrayList<String> partAcronymsList = new ArrayList<String>(generateAcronyms(getStringRepresentation(charsToModify)));
                String singleWord = null;
                for(int j = 0; j < partAcronymsList.size(); j++){
                    singleWord = Character.toString(temporaryRemovedLetter) + partAcronymsList.get(j);
                    partAcronymsList.set(j, singleWord);
                }
                for(String el : partAcronymsList) {
                    if (acronymsList.indexOf(el) < 0) {
                        acronymsList.add(el);
                    }
                }
                charsToModify.add(0, tempRemovedChar);
            }
        }
        acronymsList.remove(inputWord);
        System.out.println(acronymsList.size());
        return acronymsList;
        /*
        do{

            //for (int i = 0; i < charsOrigin.size(); i++) {
                for (int j = 0; j < charsOrigin.size(); j++) {
                    //if(i != j) {
                        charsToModify = swapIndexes(charsToModify, 0, j);
                        acronymAsString = getStringRepresentation(charsToModify);
                        if((acronymsList.indexOf(acronymAsString) < 0) && (!acronymAsString.equals(getStringRepresentation(charsOrigin)))) {
                            acronymsList.add(acronymAsString);
                        }
                    //}
                }
            //}
            System.out.println(acronymsList.size());
        } while (acronymsList.size() != (permutationWithRepetition(charsOrigin.size(), getRepetitions(charsOrigin))-1));

        return acronymsList;*/
    }


}
