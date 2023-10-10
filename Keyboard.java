import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// created a swing interface to read the UPC code and send it to the cash register


public class Keyboard {

    private JFrame frame;
    private JLabel UPCLabel;
    private JTextField UPCTextfield;
    private JButton UPCButton;
    private CashRegisterModel cashRegister;

    Keyboard(String title, CashRegisterModel register) {

        this.cashRegister = register;

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Create UI elements
        UPCLabel = new JLabel("UPC:");
        UPCTextfield = new JTextField();
        UPCButton = new JButton("Enter");

        // Add UI element to frame

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(UPCLabel)
                        .addComponent(UPCTextfield).addComponent(UPCButton)));


        frame.getContentPane().setLayout(layout);

        //	  set the keyboard to manage the UPC Enter button event

        this.UPCButton.addActionListener(e -> processUPCCode());

    }

    // Keyboard.java

    private void processUPCCode() {
        try {
            int upcCode = Integer.parseInt(UPCTextfield.getText());
            cashRegister.processUPC(upcCode);
        } catch (NumberFormatException e) {
            System.out.println("Invalid UPC format. Please enter a numeric UPC.");
        }
    }





}
