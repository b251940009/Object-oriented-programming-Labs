package lab14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class fileedit {
    
    public String currentPath = "";

    public void printfile(String text) {
        try {
            if (currentPath == null || currentPath.isEmpty()) {
                throw new IOException("Файл сонгогдоогүй байна.");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(currentPath));
            writer.write(text);
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Алдаа гарлаа: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String readfile(String fname) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fname));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Алдаа гарлаа: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return content.toString();
    }
}