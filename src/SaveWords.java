import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by SteveQ on 2016-08-08.
 */
public class SaveWords implements ActionListener {
    String workingDirectory = System.getProperty("user.dir");
    public void actionPerformed(ActionEvent ev){
        BufferedWriter saver = null;
        try {
            File anagrams = new File(workingDirectory, "res\\" + Generator.inputWord + "_acro.txt");
            saver = new BufferedWriter(new FileWriter(anagrams));
            String[] fragmentedAnagrams = GUI.outputAnagrams.getText().split("\\n");
            for(String el : fragmentedAnagrams){
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

    public class SaveRealWords implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev){
            BufferedWriter saver = null;
            try {
                File acronyms = new File(workingDirectory, "res\\" + "realWords.txt");
                saver = new BufferedWriter(new FileWriter(acronyms));
                String[] fragmentedAnagrams = GUI.secondWindowGUI.realWords.getText().split("\\n");
                for(String el : fragmentedAnagrams){
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
}
