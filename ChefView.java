package Chef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChefView  extends JFrame {

    private JButton op = new JButton("Back to menu");

    public ChefView() throws IOException {
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new FlowLayout(5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);


        this.setBounds(500, 500, 900, 500);
        mainPanel.setBackground(Color.GRAY);

        JPanel messagePanel=new JPanel();
        JLabel welcomeLabel = new JLabel("<html><b><font size=18>Welcome back, Chef!</font></b></html>", JLabel.CENTER);
        welcomeLabel.setBackground(Color.GRAY);
        welcomeLabel.setForeground(Color.WHITE);
        messagePanel.add(welcomeLabel);
        messagePanel.setBackground(Color.GRAY);
        mainPanel.add(messagePanel);


        this.setLayout(new BorderLayout());
        JPanel doOperation = new JPanel();
        doOperation.setLayout(new FlowLayout(FlowLayout.RIGHT));

        doOperation.add(op);
        this.add(doOperation,BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    void getBack(ActionListener listener){
        op.addActionListener(listener);
    }

}
