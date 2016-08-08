import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by SteveQ on 2016-08-03.
 */
public class LoadWords implements ActionListener {
    public void actionPerformed(ActionEvent ev){
        BufferedReader loader = null;
        try {
            String workingDirectory = System.getProperty("user.dir");
            File words = new File(workingDirectory, "res\\words.txt");
            loader = new BufferedReader(new FileReader(words));
            String line = null;
            while((line = loader.readLine()) != null){
                GUI.inputWords.append(line + "\n");
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
    }
}
