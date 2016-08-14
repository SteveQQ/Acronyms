import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-13.
 */
public class SearchForWords implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ev){
        for (String stringElement : getRealWordsList(GUI.outputAnagrams.getText().split("\\n"))) {
            GUI.secondWindowGUI.realWords.append(stringElement + "\n");
        }
    }
    public ArrayList<String> loadDictWords(){
        ArrayList<String> realWordsList = new ArrayList<String>();
        BufferedReader loader = null;
        try {
            String workingDirectory = System.getProperty("user.dir");
            File words = new File(workingDirectory, "res\\dict\\slowa.txt");
            loader = new BufferedReader(new FileReader(words));
            String line = null;
            while((line = loader.readLine()) != null){
                if(line.length() < 9) {
                    realWordsList.add(line);
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                loader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return realWordsList;
    }

    public ArrayList<String> getRealWordsList(String[] anagrams){
        ArrayList<String> realWordsList = new ArrayList<String>();
        realWordsList = loadDictWords();
        ArrayList<String> foundWords = new ArrayList<String>();
        for(String stringElement : anagrams) {
            if(realWordsList.indexOf(stringElement) != -1){
                foundWords.add(stringElement);
            }
        }
        return foundWords;
    }
}
