import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by SteveQ on 2016-08-01.
 */
public class GUI {
    public static JFrame frame;

    public static JPanel mainPanel;
    public static JPanel wrappingPanel;

    public static JTextArea inputWords;
    public static JTextArea outputAcronyms;

    public static JButton loadWordsButton;
    public static JButton generateAcronyms;
    public static JButton saveAcronymsButton;
    public static JButton searchRealWords;

    public static void createGUI(){
        frame = new JFrame("Acronyms Gnerator");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#5597C2"));

        wrappingPanel = new JPanel();
        BoxLayout box = new BoxLayout(wrappingPanel, BoxLayout.Y_AXIS);
        wrappingPanel.setLayout(box);
        wrappingPanel.setBackground(Color.decode("#5597C2"));

        inputWords = new JTextArea(10, 40);
        JScrollPane textInputScrollPane = new JScrollPane(inputWords, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputWords.setLineWrap(true);
        inputWords.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputWords.setFont(new Font(Font.SANS_SERIF, 0, 14));
        inputWords.setEditable(false);

        loadWordsButton = new JButton("LOAD WORDS");
        loadWordsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadWordsButton.addActionListener(new LoadWords());

        generateAcronyms = new JButton("GENERATE ACRONYMS");
        generateAcronyms.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateAcronyms.addActionListener(new Generator());

        outputAcronyms = new JTextArea(10, 40);
        JScrollPane textOutputScrollPane = new JScrollPane(outputAcronyms, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAcronyms.setLineWrap(true);
        outputAcronyms.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        outputAcronyms.setFont(new Font(Font.SANS_SERIF, 0, 14));
        outputAcronyms.setEditable(false);

        saveAcronymsButton = new JButton("SAVE ACRONYMS");
        saveAcronymsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        searchRealWords = new JButton("SEARCH REAL WORDS");
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
