import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SteveQ on 2016-08-08.
 */
public class Cleaner implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ev){
        GUI.outputAnagrams.setText("");
    }
    public static class InputCleaner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            GUI.inputWords.setText("");
        }
    }
}
