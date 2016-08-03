import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-01.
 */
public class GUI {
    public JTextArea inputWords;
    public void createGUI(){
        JFrame frame = new JFrame("Acronyms Gnerator");
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#5597C2"));

        JPanel wrappingPanel = new JPanel();
        BoxLayout box = new BoxLayout(wrappingPanel, BoxLayout.Y_AXIS);
        wrappingPanel.setLayout(box);
        wrappingPanel.setBackground(Color.decode("#5597C2"));

        inputWords = new JTextArea(10, 40);
        JScrollPane textInputScrollPane = new JScrollPane(inputWords, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputWords.setLineWrap(true);
        inputWords.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputWords.setFont(new Font(Font.SANS_SERIF, 0, 14));

        JButton loadWordsButton = new JButton("LOAD WORDS");
        loadWordsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadWordsButton.addActionListener(new LoadWords());

        JButton generateAcronyms = new JButton("GENERATE ACRONYMS");
        generateAcronyms.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea outputAcronyms = new JTextArea(10, 40);
        JScrollPane textOutputScrollPane = new JScrollPane(outputAcronyms, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAcronyms.setLineWrap(true);
        outputAcronyms.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        outputAcronyms.setFont(new Font(Font.SANS_SERIF, 0, 14));

        JButton saveAcronymsButton = new JButton("SAVE ACRONYMS");
        saveAcronymsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton searchRealWords = new JButton("SEARCH REAL WORDS");
        searchRealWords.setAlignmentX(Component.CENTER_ALIGNMENT);


        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textInputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(loadWordsButton);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(generateAcronyms);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textOutputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(saveAcronymsButton);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(searchRealWords);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(wrappingPanel);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }
}
