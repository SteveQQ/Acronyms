import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by SteveQ on 2016-08-01.
 */
public class GUI {
    public static JFrame frame;

    public static JPanel mainPanel, wrappingPanel, horizontalPanel,
                            horizontalPanel2, horizontalPanel3;

    public static JTextArea inputWords, outputAcronyms;

    public static JButton loadWordsButton, generateAcronyms, saveAcronymsButton,
                            searchRealWords, clearOutcomes, clearInputs, getAllAcronyms;

    public static void createGUI(){
        frame = new JFrame("Acronyms Generator");

        //-------PANELS--------//
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#5597C2"));

        wrappingPanel = new JPanel();
        BoxLayout box = new BoxLayout(wrappingPanel, BoxLayout.Y_AXIS);
        wrappingPanel.setLayout(box);
        wrappingPanel.setBackground(Color.decode("#5597C2"));

        horizontalPanel = buildPanel(horizontalPanel,"#5597C2");
        horizontalPanel2 = buildPanel(horizontalPanel2,"#5597C2");
        horizontalPanel3 = buildPanel(horizontalPanel3,"#5597C2");
        //-------PANELS--------//


        //-------BUTTONS---------//
        loadWordsButton = buildButton(loadWordsButton, "LOAD WORDS", new LoadWords());
        clearInputs = buildButton(clearInputs, "CLEAR INPUTS", new Cleaner.InputCleaner());
        generateAcronyms = buildButton(generateAcronyms, "GENERATE ACRONYMS", new Generator());
        clearOutcomes = buildButton(clearOutcomes, "CLEAR OUTCOMES", new Cleaner());
        getAllAcronyms = buildButton(getAllAcronyms, "GET ALL ACRONYMS", new Generator().new CompleteGenerator());
        saveAcronymsButton = buildButton(saveAcronymsButton, "SAVE ACRONYMS", new SaveWords());
        saveAcronymsButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        //searchRealWords = buildButton(searchRealWords, "SEARCH REAL WORDS");
        //-------BUTTONS---------//


        //-------TEXT AREAS--------//
        inputWords = new JTextArea(10, 40);
        JScrollPane textInputScrollPane = new JScrollPane(inputWords, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputWords.setLineWrap(true);
        inputWords.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputWords.setFont(new Font(Font.SANS_SERIF, 0, 14));

        outputAcronyms = new JTextArea(10, 40);
        JScrollPane textOutputScrollPane = new JScrollPane(outputAcronyms, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAcronyms.setLineWrap(true);
        outputAcronyms.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        outputAcronyms.setFont(new Font(Font.SANS_SERIF, 0, 14));
        outputAcronyms.setEditable(false);
        //-------TEXT AREAS--------//


        //-------GUI BUILD--------//
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textInputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        horizontalPanel.add(loadWordsButton);
        horizontalPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalPanel.add(clearInputs);
        horizontalPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalPanel.add(getAllAcronyms);

        wrappingPanel.add(horizontalPanel);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        horizontalPanel2.add(generateAcronyms);
        horizontalPanel2.add(Box.createRigidArea(new Dimension(20, 0)));
        horizontalPanel2.add(clearOutcomes);

        wrappingPanel.add(horizontalPanel2);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        wrappingPanel.add(textOutputScrollPane);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        horizontalPanel3.add(saveAcronymsButton);
        //horizontalPanel3.add(searchRealWords);

        wrappingPanel.add(horizontalPanel3);
        wrappingPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(wrappingPanel);
        //-------GUI BUILD--------//


        //--------FRAME SETUP--------//
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
        //--------FRAME SETUP--------//
    }

    

    //--------HELPER METHODS--------//
    public static JButton buildButton(JButton ref, String name, ActionListener actionListener){
        ref = new JButton(name);
        ref.addActionListener(actionListener);
        return ref;
    }
    public static JPanel buildPanel(JPanel ref, String colorCode){
        ref = new JPanel();
        ref.setBackground(Color.decode(colorCode));
        return ref;
    }
    //--------HELPER METHODS--------//
}
