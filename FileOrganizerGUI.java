import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileOrganizerGUI extends JFrame implements ActionListener {
    private JLabel sourceLabel, destinationLabel;
    private JTextField sourceText, destinationText;
    private JButton browseSourceBtn, browseDestinationBtn, organizeBtn;

    public FileOrganizerGUI() {
        setTitle("File Organizer");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        sourceLabel = new JLabel("Source Folder:");
        destinationLabel = new JLabel("Destination Folder:");
        sourceText = new JTextField();
        destinationText = new JTextField();
        browseSourceBtn = new JButton("Browse");
        browseDestinationBtn = new JButton("Browse");
        organizeBtn = new JButton("Organize");

        browseSourceBtn.addActionListener(this);
        browseDestinationBtn.addActionListener(this);
        organizeBtn.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(2, 3));
        panel.add(sourceLabel);
        panel.add(sourceText);
        panel.add(browseSourceBtn);
        panel.add(destinationLabel);
        panel.add(destinationText);
        panel.add(browseDestinationBtn);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(organizeBtn, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseSourceBtn) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                sourceText.setText(chooser.getSelectedFile().getPath());
            }
        } else if (e.getSource() == browseDestinationBtn) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                destinationText.setText(chooser.getSelectedFile().getPath());
            }
        } else if (e.getSource() == organizeBtn) {
            File sourceFolder = new File(sourceText.getText());
            File destinationFolder = new File(destinationText.getText());

            if (!sourceFolder.exists() || !destinationFolder.exists()) {
                JOptionPane.showMessageDialog(this, "Please select valid source and destination folders.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                File[] files = sourceFolder.listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        File subFolder = new File(destinationFolder, extension);
                        if (!subFolder.exists()) {
                            subFolder.mkdir();
                        }

                        File newFile = new File(subFolder, fileName);
                        try {
                            FileInputStream fis = new FileInputStream(file);
                            FileOutputStream fos = new FileOutputStream(newFile);
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = fis.read(buffer)) > 0) {
                                fos.write(buffer, 0, length);
                            }
                            fis.close();
                            fos.close();
                            file.delete();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Error organizing files.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Files organized successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        FileOrganizerGUI organizer = new FileOrganizerGUI();
        organizer.setVisible(true);
    }
}
