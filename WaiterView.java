package Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WaiterView  extends JFrame{

    private JButton makeOrder = new JButton("Make new order");
    private JButton generateBill = new JButton("Generate bill");
    private JButton computePrice = new JButton("Compute price");
    private JButton showOrders = new JButton("Show orders");
    private JButton op = new JButton("Back to menu");
    private JTextField items=new JTextField(30);
    private JTextField adminIDText = new JTextField(10);
    private JTextField dateText=new JTextField(10);
    private JTextField price=new JTextField(10);



    public WaiterView() throws IOException {
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new FlowLayout(5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setBounds(500, 500, 600, 500);
        mainPanel.setBackground(Color.pink);

        JPanel messagePanel=new JPanel();
        JLabel welcomeLabel = new JLabel("<html><b><font size=18>Welcome back, Waiter!</font></b></html>", JLabel.CENTER);
        welcomeLabel.setBackground(Color.pink);
        welcomeLabel.setForeground(Color.BLACK);
        messagePanel.add(welcomeLabel);
        messagePanel.setBackground(Color.pink);
        mainPanel.add(messagePanel);

        JPanel options=new JPanel();
        options.setBackground(Color.pink);

        options.add(new JLabel("<html></b><font color='black'>Please select operation: </font></b></html>"), BorderLayout.WEST);


        options.add(makeOrder);

        options.add(computePrice);

        options.add(generateBill);

        options.add(showOrders);
        mainPanel.add(options);


        JPanel waiterID=new JPanel();
        JLabel IDLabel = new JLabel("<html><font color='black'>ID:</font></html>");
        waiterID.add(IDLabel);

        waiterID.add(adminIDText);
        waiterID.setBackground(Color.pink);

        waiterID.add(new JLabel("<html><font color='black'>Date:</font></html>"));
        waiterID.add(dateText);
        waiterID.setBackground(Color.pink);
        mainPanel.add(waiterID);

        JPanel waiterProduct=new JPanel();
        waiterProduct.add(new JLabel("<html><b><font color='black'>Product(s):</font></b></html>"));
        waiterProduct.add(items);
        waiterProduct.setBackground(Color.pink);
        mainPanel.add(waiterProduct);

        JPanel waiterPrice=new JPanel();
        waiterPrice.add(new JLabel("<html><b><font color='black'>Price:</font></b></html>"));
        price.setEditable(false);
        waiterPrice.add(price);
        waiterPrice.setBackground(Color.pink);
        mainPanel.add(waiterPrice);



        this.setLayout(new BorderLayout());
        JPanel doOperation = new JPanel();
        doOperation.setLayout(new FlowLayout(FlowLayout.RIGHT));

        doOperation.add(op);
        this.add(doOperation,BorderLayout.SOUTH);
        this.add(mainPanel);
    }

    public void setShowOrders(ActionListener listener){
        showOrders.addActionListener(listener);
    }

    public void setPrice(String price){
        this.price.setText(price);
    }

    public void newOrderAction(ActionListener listener){
        makeOrder.addActionListener(listener);
    }

    public void compute(ActionListener listener){
        computePrice.addActionListener(listener);
    }

    public void generateB(ActionListener listener){
        generateBill.addActionListener(listener);
    }

    public void getback(ActionListener listener){
        op.addActionListener(listener);
    }

    public String getItems(){
        return items.getText();
    }
    public String getID(){
        return adminIDText.getText();
    }
    public String getDate(){
        return dateText.getText();
    }

}
