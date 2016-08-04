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
}
