package Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminView  extends JFrame {

    private JButton addItem1 = new JButton("Add Item");
    private JButton removeItem1 = new JButton("Remove Item");
    private JButton modifyItem1 = new JButton("Edit Item");

    private JButton addItem2 = new JButton("Add Item");
    private JButton removeItem2 = new JButton("Remove Item");
    private JButton modifyItem2 = new JButton("Edit Item");

    JTextField price2Text = new JTextField(30);
    JTextField price1Text = new JTextField(30);
    JTextField prod2Text=new JTextField(30);
    JTextField prod1Text=new JTextField(30);


    private JButton op = new JButton("Back to menu");

    public AdminView() throws IOException {
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new FlowLayout(5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setBounds(500, 500, 550, 400);
        mainPanel.setBackground(Color.DARK_GRAY);

        JPanel messagePanel=new JPanel();
        JLabel welcomeLabel = new JLabel("<html><b><font size=18>Welcome back, Administrator!</font></b></html>", JLabel.CENTER);
        welcomeLabel.setBackground(Color.DARK_GRAY);
        welcomeLabel.setForeground(Color.WHITE);
        messagePanel.add(welcomeLabel);
        messagePanel.setBackground(Color.DARK_GRAY);
        mainPanel.add(messagePanel);


        JPanel price1=new JPanel();
        JLabel IDLabel = new JLabel("<html><font color='white'>Price(s) - basic:</font></html>");
        price1.add(IDLabel);

        price1.add(price1Text);
        price1.setBackground(Color.DARK_GRAY);
        mainPanel.add(price1);

        JPanel prod1=new JPanel();
        prod1.add(new JLabel("<html><b><font color='white'>Product(s) - basic:</font></b></html>"));
        prod1.add(prod1Text);
        prod1.setBackground(Color.DARK_GRAY);

        mainPanel.add(prod1);

        JPanel options1=new JPanel();
        options1.setBackground(Color.DARK_GRAY);

        options1.add(new JLabel("<html></b><font color='white'>Please select operation: </font></b></html>"), BorderLayout.WEST);

        options1.add(addItem1);
        options1.add(removeItem1);
        options1.add(modifyItem1);
        mainPanel.add(options1);


        JPanel price2=new JPanel();
        JLabel IDLabel2 = new JLabel("<html><font color='white'>Name - composite:</font></html>");
        price2.add(IDLabel2);
        price2.add(price2Text);
        price2.setBackground(Color.DARK_GRAY);
        mainPanel.add(price2);

        JPanel prod2=new JPanel();
        prod2.add(new JLabel("<html><b><font color='white'>Product(s) - composite:</font></b></html>"));
        prod2.add(prod2Text);
        prod2.setBackground(Color.DARK_GRAY);

        mainPanel.add(prod2);

        JPanel options=new JPanel();
        options.setBackground(Color.DARK_GRAY);

        options.add(new JLabel("<html></b><font color='white'>Please select operation: </font></b></html>"), BorderLayout.WEST);

        options.add(addItem2);
        options.add(removeItem2);
        options.add(modifyItem2);
        mainPanel.add(options);

        this.setLayout(new BorderLayout());
        JPanel doOperation = new JPanel();
        doOperation.setLayout(new FlowLayout(FlowLayout.RIGHT));

        doOperation.add(op);
        this.add(doOperation,BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    String getPrice1(){
        return price1Text.getText();
    }

    String getPrice2(){
        return price2Text.getText();
    }

    String getProd1(){
        return prod1Text.getText();
    }

    String getProd2(){
        return prod2Text.getText();
    }

    void addItemAdmin1(ActionListener listener){
        addItem1.addActionListener(listener);
    }

    void removeItemAdmin1(ActionListener listener){
        removeItem1.addActionListener(listener);
    }

    void editItemAdmin1(ActionListener listener){
        modifyItem1.addActionListener(listener);
    }

    void addItemAdmin2(ActionListener listener){
        addItem2.addActionListener(listener);
    }

    void removeItemAdmin2(ActionListener listener){
        removeItem2.addActionListener(listener);
    }

    void editItemAdmin2(ActionListener listener){
        modifyItem2.addActionListener(listener);
    }

    void getBack(ActionListener listener){
        op.addActionListener(listener);
    }

}
