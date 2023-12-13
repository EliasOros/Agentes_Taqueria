package View;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Principal extends JFrame {
	
	public Principal() {
		
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("Tacos y mas Allá");
		
		getContentPane().setBackground(new Color(255, 127, 80));
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,300);
		
		JLabel lblNewLabel = new JLabel("Tacos y mas allá");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(72, 49, 289, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenidos a");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(10, 11, 289, 41);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnIniciarOrden = new JButton("Iniciar Orden");
		btnIniciarOrden.setFocusPainted(false);
		btnIniciarOrden.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		btnIniciarOrden.setBackground(new Color(50, 205, 50));
		btnIniciarOrden.setFont(new Font("Segoe UI Variable", Font.ITALIC, 20));
		btnIniciarOrden.setForeground(new Color(255, 255, 0));
		btnIniciarOrden.setBounds(72, 126, 174, 76);
		getContentPane().add(btnIniciarOrden);
		
		
		setVisible(true);
	}

	
	
	/*
	public static void main(String[] args) {
		
		Principal pr = new Principal();

	}
	*/
}
