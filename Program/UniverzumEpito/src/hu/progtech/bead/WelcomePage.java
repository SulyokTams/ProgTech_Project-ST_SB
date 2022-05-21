package hu.progtech.bead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");
    JButton addButton = new JButton("Add Universe");
    JButton editButton = new JButton("Edit Universe");
    JButton deleteButton = new JButton("Delete Universe");

    String[] data = {"one", "two", "three", "four"};
    JList universeList = new JList(data);
    JLabel listLabel = new JLabel("Universe List");

    WelcomePage(String username){

        welcomeLabel.setBounds(10,10,400,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Welcome " + "username!");

        universeList.setBounds(800,70,370,680);
        listLabel.setBounds(785,10,400,50);
        listLabel.setHorizontalAlignment(SwingConstants.CENTER);
        listLabel.setFont(new Font(null,Font.PLAIN,35));



        addButton.setBounds(25,150,150,50);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        editButton.setBounds(25,300,150,50);
        editButton.setFocusable(false);
        editButton.addActionListener(this);
        deleteButton.setBounds(25,450,150,50);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(addButton);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(universeList);
        frame.add(listLabel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
