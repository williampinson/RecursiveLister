import javax.swing.*;
import java.io.File;

public class RecursiveLister {

    RecursiveListerGUI listerGUI;
    JFileChooser fileChooser = new JFileChooser();
    File inputFile;

    public RecursiveLister() {
        listerGUI = new RecursiveListerGUI(this);
    }
    public File chooseDirectory() {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File userDir = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(userDir);
        if (fileChooser.showOpenDialog(listerGUI) == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
        }
        else {
            System.out.println("No file selected");
        }
        return inputFile;
    }
    public void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
                listerGUI.updateDisplay(file.getAbsolutePath());
                if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }
}
