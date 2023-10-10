import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		UPCTextfield = new JTextField(15);  // set length for the text field
		UPCButton = new JButton("Enter");

		// Add UI element to frame
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(
				layout.createSequentialGroup()
						.addComponent(UPCLabel)
						.addComponent(UPCTextfield)
						.addComponent(UPCButton)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(UPCLabel)
						.addComponent(UPCTextfield)
						.addComponent(UPCButton)
		);

		frame.getContentPane().setLayout(layout);

		// set the keyboard to manage the UPC Enter button event
		this.UPCButton.addActionListener(e -> processUPCCode());
	}

	private void processUPCCode() {
		try {
			int upcCode = Integer.parseInt(UPCTextfield.getText());
			cashRegister.processUPC(upcCode);
		} catch (NumberFormatException e) {
			System.err.println("Invalid UPC code entered.");
		}
	}



}
