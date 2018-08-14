package com.mnd.sample;

import javax.swing.*;

public class myFirstApplication extends JFrame{


    public myFirstApplication(){

        super("My First ProximaX Application");
        setContentPane(mainPanel);
        pack();

        //setting the form icon
        ImageIcon img = new ImageIcon("C:/projects/mavenguiTest/src/main/resources/logo.png");
        setIconImage(img.getImage());

        setVisible(true);
    }

    public JPanel mainPanel;
    public JTextField txtTags;
    public JComboBox cboFiles;
    public JTextField txtSearchName;
    public JTextField txtFilePath;
    public JButton btndownload;
    public JButton btnsearch;
    public JButton btnselect;
    public JTextField txtUploader;
    public JButton btnupload;
    public JTextArea txtFiles;
    public JTextArea textResults;
}
