import javax.swing.*;
import java.awt.*;

public class RecursiveListerGUI extends JFrame {

    RecursiveLister lister;

    JPanel mainPanel, controlPanel;
    JLabel titleLabel;
    JTextArea displayTA;
    JScrollPane scroller;
    JButton chooseBtn, exitBtn;

    RecursiveListerGUI(RecursiveLister lister) {
        this.lister = lister;
        setTitle("Recursive Lister");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Recursive Lister");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        displayTA = new JTextArea();
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        mainPanel.add(scroller, BorderLayout.CENTER);

        createControlPanel();

        add(mainPanel);
        setVisible(true);
    }
    private void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,2));
        chooseBtn = new JButton("Choose Directory");
        chooseBtn.addActionListener(e -> {
            lister.listFiles(lister.chooseDirectory());
        });
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(this,"Are you sure you want to exit?","Confirm Exit",JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        controlPanel.add(chooseBtn);
        controlPanel.add(exitBtn);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);
    }
    public void updateDisplay(String file) {
        displayTA.append(file + "\n");
    }
}
