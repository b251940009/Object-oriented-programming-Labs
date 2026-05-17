package lab14;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Текст засварлагч");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JButton btnClear = new JButton("Clear");
        JButton btnSave = new JButton("Save");
        JButton btnOpen = new JButton("Open");

        buttonPanel.add(btnClear);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnOpen);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        fileedit editor = new fileedit();

        btnClear.addActionListener(e -> textArea.setText(""));

        btnSave.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                editor.currentPath = file.getAbsolutePath();
                editor.printfile(textArea.getText());
            }
        });

        btnOpen.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String content = editor.readfile(file.getAbsolutePath());
                textArea.setText(content);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}