import javax.swing.*;
import java.io.*;

public class FileHandler {

    public static void openFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(parent);

        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void saveFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(parent);

        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
