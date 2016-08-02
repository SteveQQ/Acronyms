import javax.swing.*;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-01.
 */
public class GUI {
    public static void main(String[] args) {
        new GUI().createGUI();
    }

    public void createGUI(){
        JFrame frame = new JFrame("Acronyms Gnerator");
        JPanel mainPanel = new JPanel();
        JPanel wrappingPanel = new JPanel();
        JTextArea inputWords = new JTextArea(10, 40);
        JScrollPane textInputScrollPane = new JScrollPane(inputWords, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        wrappingPanel.setLayout(new BoxLayout(wrappingPanel, BoxLayout.Y_AXIS));

        inputWords.setLineWrap(true);

        wrappingPanel.add(textInputScrollPane);
        mainPanel.add(wrappingPanel);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(700,700);
        frame.setVisible(true);
    }
}
