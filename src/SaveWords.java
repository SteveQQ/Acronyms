import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by SteveQ on 2016-08-08.
 */
public class SaveWords implements ActionListener {
    public void actionPerformed(ActionEvent ev){
        BufferedWriter saver = null;
        try {
           String workingDirectory = System.getProperty("user.dir");
            File acronyms = new File(workingDirectory, "res\\" + GUI.inputWords.getSelectedText() + "_acro.txt");
            saver = new BufferedWriter(new FileWriter(acronyms));
            String[] fragmentedAcronyms = GUI.outputAcronyms.getText().split("\\n");
            for(String el : fragmentedAcronyms){
                saver.write(el);
                saver.newLine();
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally{
            try{
                saver.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
