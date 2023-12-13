package View;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.SystemColor;

public class TicketView extends JFrame {
	
	public TicketView(String msj) {
		setTitle("Ticket");
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		setSize(500, 600);
	    
		
		JTextPane txtpnOls = new JTextPane();
		txtpnOls.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		txtpnOls.setBounds(10, 11, 464, 535);
		txtpnOls.setBorder(new LineBorder(SystemColor.activeCaption, 4, true));
		txtpnOls.setBackground(Color.LIGHT_GRAY);
		txtpnOls.setText(msj);
		getContentPane().add(txtpnOls);
		
		setVisible(true);
	}
	

}
