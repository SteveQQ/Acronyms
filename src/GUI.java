import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by SteveQ on 2016-08-01.
 */
public class GUI {
    public static JFrame frame;

    public static JPanel mainPanel;
    public static JPanel wrappingPanel;
    public static JPanel horizontalPanel;
    public static JPanel horizontalPanel2;

    public static JTextArea inputWords;
    public static JTextArea outputAcronyms;

    public static JButton loadWordsButton;
    public static JButton generateAcronyms;
    public static JButton saveAcronymsButton;
    public static JButton searchRealWords;
    public static JButton clearOutcomes;
    public static JButton clearInputs;
    public static JButton getAllAcronyms;

    public static void createGUI(){
        frame = new JFrame("Acronyms Generator");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#5597C2"));

        wrappingPanel = new JPanel();
        BoxLayout box = new BoxLayout(wrappingPanel, BoxLayout.Y_AXIS);
        wrappingPanel.setLayout(box);
        wrappingPanel.setBackground(Color.decode("#5597C2"));

        horizontalPanel = new JPanel();
        horizontalPanel.setBackground(Color.decode("#5597C2"));

        horizontalPanel2 = new JPanel();
        horizontalPanel2.setBackground(Color.decode("#5597C2"));

        inputWords = new JTextArea(10, 40);
        JScrollPane textInputScrollPane = new JScrollPane(inputWords, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputWords.setLineWrap(true);
        inputWords.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputWords.setFont(new Font(Font.SANS_SERIF, 0, 14));

        loadWordsButton = new JButton("LOAD WORDS");
        loadWordsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadWordsButton.addActionListener(new LoadWords());


        clearInputs = new JButton("CLEAR INPUTS");
        clearInputs.addActionListener(new Cleaner.InputCleaner());

        generateAcronyms = new JButton("GENERATE ACRONYMS");
        generateAcronyms.addActionListener(new Generator());

        clearOutcomes = new JButton("CLEAR OUTCOMES");
        clearOutcomes.addActionListener(new Cleaner());

        getAllAcronyms = new JButton("GET ALL ACRONYMS");
        getAllAcronyms.addActionListener(new Generator().new CompleteGenerator());

        outputAcronyms = new JTextArea(10, 40);
        JScrollPane textOutputScrollPane = new JScrollPane(outputAcronyms, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAcronyms.setLineWrap(true);
        outputAcronyms.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        outputAcronyms.setFont(new Font(Font.SANS_SERIF, 0, 14));
        outputAcronyms.setEditable(false);

        saveAcronymsButton = new JButton("SAVE ACRONYMS");
        saveAcronymsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveAcronymsButton.addActionListener(new SaveWords());

        searchRealWords = new JButton("SEARCH REAL WORDS");
        searchRealWords.setAlignmentX(Component.CENTER_ALIGNMENT);


        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textInputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        horizontalPanel.add(loadWordsButton);
        horizontalPanel.add(clearInputs);
        horizontalPanel.add(getAllAcronyms);

        wrappingPanel.add(horizontalPanel);

        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        horizontalPanel2.add(generateAcronyms);
        horizontalPanel2.add(clearOutcomes);

        wrappingPanel.add(horizontalPanel2);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textOutputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(saveAcronymsButton);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(searchRealWords);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(wrappingPanel);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }
}
