import com.sun.deploy.util.ArrayUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by SteveQ on 2016-08-03.
 */
public class Generator implements ActionListener {
    public static String inputWord = null;
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(GUI.outputAcronyms.getText().isEmpty()) {
            String selectedWord;
            try {
                selectedWord = GUI.inputWords.getSelectedText();
                if (selectedWord != null) {
                    inputWord = selectedWord;
                    try {
                        ArrayList<String> generatedAcronyms = generateAcronyms(selectedWord);
                        for (String el : generatedAcronyms) {
                            GUI.outputAcronyms.append(el + "\n");
                        }
                    } catch(IllegalArgumentException iae) {
                        JOptionPane.showMessageDialog(GUI.frame,
                                "Word length cannot be larger than 8",
                                "WARNING",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
            }
        }
    }

    public class CompleteGenerator implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            if(GUI.outputAcronyms.getText().isEmpty()) {
                String[] selectedWords = GUI.inputWords.getText().split("\\n");
                inputWord = "allAcros";
                for (String el : selectedWords) {
                    if (el != null) {
                        ArrayList<String> generatedAcronyms = generateAcronyms(el);
                        for (String el2 : generatedAcronyms) {
                            GUI.outputAcronyms.append(el2 + "\n");
                        }
                    }
                }
            }
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

    public int permutationWithRepetition(int number, int[] repetitions) {
        int result = 0;
        int numenator = strongOperation(number);
        int denumenator = 1;
        for (int val : repetitions) {
            denumenator = strongOperation(val) * denumenator;
        }
        result = numenator / denumenator;
        return result;
    }

    public int[] getRepetitions(char[] charList){
        int[] repetitions = new int[charList.length];
        ArrayList<Character> repeatedChar = new ArrayList<Character>();
        for(int i=0; i < charList.length; i++) {
            repetitions[i]=1;
            for(int j=0; j < charList.length; j++) {
                if(j != i){
                    if(charList[j] == charList[i] && repeatedChar.indexOf(charList[i]) == -1) {
                        repetitions[i]++;
                        repeatedChar.add(charList[i]);
                    }
                }
            }
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

    public String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public ArrayList<String> generateAcronyms(String word) throws IllegalArgumentException {

        if(word.length() > 8) {
            throw new IllegalArgumentException();
        }

        char[] charsOrigin = word.toCharArray();
        ArrayList<String> acronymsList = new ArrayList<String>();
        String acronymAsString = null;

        ArrayList<Character> charsToModify = new ArrayList<Character>();
        for (int i=0; i < charsOrigin.length; i++) {
            charsToModify.add(charsOrigin[i]);
        }

        if (charsOrigin.length == 2) {
            charsToModify = swapIndexes(charsToModify, 0, 1);
            acronymAsString = getStringRepresentation(charsToModify);
            acronymsList.add(String.valueOf(charsOrigin));
            acronymsList.add(acronymAsString);
        }
        if (charsOrigin.length > 2) {
            Character tempRemovedChar = null;
            for(int i = 0; i < charsOrigin.length; i++) {
                if (i > 0) {
                    charsToModify = swapIndexes(charsToModify, 0, i);
                }
                Character temporaryRemovedLetter = charsToModify.get(0);
                tempRemovedChar = charsToModify.get(0);
                charsToModify.remove(0);
                ArrayList<String> partAcronymsList = new ArrayList<String>(generateAcronyms(getStringRepresentation(charsToModify)));
                String singleWord = null;
                for (int j = 0; j < partAcronymsList.size(); j++) {
                    singleWord = Character.toString(temporaryRemovedLetter) + partAcronymsList.get(j);
                    partAcronymsList.set(j, singleWord);
                }
                for (String el : partAcronymsList) {
                    if (acronymsList.indexOf(el) < 0 ) {
                        acronymsList.add(el);
                    }
                }
                charsToModify.add(0, tempRemovedChar);
                charsToModify = swapIndexes(charsToModify, i, 0);
            }
        }

        acronymsList.remove(inputWord);
        System.out.println(acronymsList.size());
        return acronymsList;
    }
}
