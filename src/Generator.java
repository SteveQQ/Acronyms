import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SteveQ on 2016-08-03.
 */
public class Generator implements ActionListener {
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

    public int permutationWithRepetition(int number, int... repetitions) {
        int result = 0;
        int numenator = strongOperation(number);
        int denumenator = 1;
        for (int val : repetitions) {
            denumenator = strongOperation(val) * denumenator;
        }
        result = numenator / denumenator;
        return result;
    }
}
