package SelectMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectPersonView extends JFrame{

    JButton adButton=new JButton("Administrator");
    JButton waiterButton=new JButton("Waiter");
    JButton chefButton=new JButton("Chef");

    public SelectPersonView(){

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new FlowLayout(5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setBounds(500, 500, 550, 200);
        mainPanel.setBackground(Color.GRAY);

        mainPanel.add(new JLabel("<html><b><font size=12 color='white'>Please select who you are!</font></b></html>"));

        JPanel functions=new JPanel();
        functions.setBackground(Color.GRAY);
        functions.add(adButton);
        functions.add(waiterButton);
        functions.add(chefButton);
        mainPanel.add(functions);

        this.add(mainPanel);
    }

    public void selectAdmin(ActionListener listener){
        adButton.addActionListener(listener);
    }

    public void selectWaiter(ActionListener listener){
        waiterButton.addActionListener(listener);
    }

    public void selectChef(ActionListener listener){
        chefButton.addActionListener(listener);
    }
}
