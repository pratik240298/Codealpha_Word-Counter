package wordcounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void initComponents() {
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Number of words: ");
    }

    private void addComponents() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JScrollPane(textArea));
        add(countButton);
        add(resultLabel);
    }

    private void countWords() {
        String paragraph = textArea.getText();
        StringTokenizer tokenizer = new StringTokenizer(paragraph);
        int wordCount = tokenizer.countTokens();
        resultLabel.setText("Number of words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounter app = new WordCounter();
                app.setVisible(true);
            }
        });
    }
}
