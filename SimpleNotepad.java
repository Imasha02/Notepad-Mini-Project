import javax.swing.*;
import java.awt.event.*;

public class SimpleNotepad extends JFrame implements ActionListener {

    JTextArea textArea;

    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem newFile, openFile, saveFile, exit;
    JMenuItem cut, copy, paste;

    public SimpleNotepad() {
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Menu bar
        menuBar = new JMenuBar();

        // File menu
        fileMenu = new JMenu("File");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        // Edit menu
        editMenu = new JMenu("Edit");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        // Listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            textArea.setText("");
        } else if (e.getSource() == openFile) {
            FileHandler.openFile(this, textArea);   
        } else if (e.getSource() == saveFile) {
            FileHandler.saveFile(this, textArea);   
        } else if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == cut) {
            textArea.cut();
        } else if (e.getSource() == copy) {
            textArea.copy();
        } else if (e.getSource() == paste) {
            textArea.paste();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleNotepad().setVisible(true));
    }
}
