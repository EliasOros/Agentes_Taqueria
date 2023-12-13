package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InterfazCli extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCli frame = new InterfazCli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	String[] columnNames = {"Taco", "Cantidad", "Precio"};
	String[][] cont = {};
	public InterfazCli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		panel.setLayout(new GridLayout(4, 5, 0, 0));
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton Pastor = new JButton("");
		Image img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/Pastor.jpg")).getImage(); 
		ImageIcon img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Pastor.setIcon(img2);
		
		Pastor.setBorder(null);
		Pastor.setBorderPainted(false);
		Pastor.setContentAreaFilled(false);
		Pastor.setOpaque(false);
		
		panel_1.add(Pastor);
		
		JLabel lblNewLabel = new JLabel("Pastor: 12$/c");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton Barbacoa = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/barbacoa.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Barbacoa.setIcon(img2);
		
		Barbacoa.setBorder(null);
		Barbacoa.setBorderPainted(false);
		Barbacoa.setContentAreaFilled(false);
		Barbacoa.setOpaque(false);
		
		panel_2.add(Barbacoa, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Barbacoa: 12$/c");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		JButton Carnitas = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/carnitas.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Carnitas.setIcon(img2);
		
		Carnitas.setBorder(null);
		Carnitas.setBorderPainted(false);
		Carnitas.setContentAreaFilled(false);
		Carnitas.setOpaque(false);
		
		panel_2_1.add(Carnitas, BorderLayout.CENTER);
		
		JLabel lblCarnitasc = new JLabel("Carnitas: 12$/c");
		lblCarnitasc.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1.add(lblCarnitasc, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1 = new JPanel();
		panel.add(panel_2_1_1);
		panel_2_1_1.setLayout(new BorderLayout(0, 0));
		
		JButton Carne_asada = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/CarneAsada.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Carne_asada.setIcon(img2);
		
		Carne_asada.setBorder(null);
		Carne_asada.setBorderPainted(false);
		Carne_asada.setContentAreaFilled(false);
		Carne_asada.setOpaque(false);
		
		panel_2_1_1.add(Carne_asada, BorderLayout.CENTER);
		
		JLabel lblCarneAsadac = new JLabel("Carne asada: 12$/c");
		lblCarneAsadac.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1.add(lblCarneAsadac, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel.add(panel_2_1_1_1);
		panel_2_1_1_1.setLayout(new BorderLayout(0, 0));
		
		JButton Suadero = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/suadero.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Suadero.setIcon(img2);
		
		Suadero.setBorder(null);
		Suadero.setBorderPainted(false);
		Suadero.setContentAreaFilled(false);
		Suadero.setOpaque(false);
		
		panel_2_1_1_1.add(Suadero, BorderLayout.CENTER);
		
		JLabel lblCarnitasc_1 = new JLabel("Suadero: 12$/c");
		panel_2_1_1_1.add(lblCarnitasc_1, BorderLayout.NORTH);
		lblCarnitasc_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		JPanel panel_2_1_1_2 = new JPanel();
		panel.add(panel_2_1_1_2);
		panel_2_1_1_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Bistec: 12$/c");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JButton Bistec = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/bistec.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Bistec.setIcon(img2);
		
		Bistec.setBorder(null);
		Bistec.setBorderPainted(false);
		Bistec.setContentAreaFilled(false);
		Bistec.setOpaque(false);
		
		panel_2_1_1_2.add(Bistec, BorderLayout.CENTER);
		
		
		
		
		JPanel panel_2_1_1_2_1 = new JPanel();
		panel.add(panel_2_1_1_2_1);
		panel_2_1_1_2_1.setLayout(new BorderLayout(0, 0));
		
		JButton Cochinita = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/cochinita.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Cochinita.setIcon(img2);
		
		Cochinita.setBorder(null);
		Cochinita.setBorderPainted(false);
		Cochinita.setContentAreaFilled(false);
		Cochinita.setOpaque(false);
		
		panel_2_1_1_2_1.add(Cochinita, BorderLayout.CENTER);
		
		JLabel lblCarnitasc_1_1 = new JLabel("Cochinita: 12$/c");
		lblCarnitasc_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_1.add(lblCarnitasc_1_1, BorderLayout.NORTH);
		
		
		
		
		
		JPanel panel_2_1_1_2_2 = new JPanel();
		panel.add(panel_2_1_1_2_2);
		panel_2_1_1_2_2.setLayout(new BorderLayout(0, 0));
		
		JButton Birria = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/Birria.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Birria.setIcon(img2);
		
		Birria.setBorder(null);
		Birria.setBorderPainted(false);
		Birria.setContentAreaFilled(false);
		Birria.setOpaque(false);
		
		panel_2_1_1_2_2.add(Birria, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1 = new JLabel("Birria: 12$/c");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_2.add(lblNewLabel_2_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1_2_3 = new JPanel();
		panel.add(panel_2_1_1_2_3);
		panel_2_1_1_2_3.setLayout(new BorderLayout(0, 0));
		
		JButton Tripa = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/tripa.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Tripa.setIcon(img2);
		
		Tripa.setBorder(null);
		Tripa.setBorderPainted(false);
		Tripa.setContentAreaFilled(false);
		Tripa.setOpaque(false);
		
		panel_2_1_1_2_3.add(Tripa, BorderLayout.CENTER);
		
		JLabel lblCarnitasc_1_1_1 = new JLabel("Tripa: 12$/c");
		lblCarnitasc_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_3.add(lblCarnitasc_1_1_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1_2_4 = new JPanel();
		panel.add(panel_2_1_1_2_4);
		panel_2_1_1_2_4.setLayout(new BorderLayout(0, 0));
		
		JButton Cabeza = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/cabeza.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Cabeza.setIcon(img2);
		
		Cabeza.setBorder(null);
		Cabeza.setBorderPainted(false);
		Cabeza.setContentAreaFilled(false);
		Cabeza.setOpaque(false);
		
		panel_2_1_1_2_4.add(Cabeza, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Cabeza: 12$/c");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_4.add(lblNewLabel_2_1_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1_2_4_1 = new JPanel();
		panel.add(panel_2_1_1_2_4_1);
		panel_2_1_1_2_4_1.setLayout(new BorderLayout(0, 0));
		
		JButton Cecina = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/cecina.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Cecina.setIcon(img2);
		
		Cecina.setBorder(null);
		Cecina.setBorderPainted(false);
		Cecina.setContentAreaFilled(false);
		Cecina.setOpaque(false);
		
		panel_2_1_1_2_4_1.add(Cecina, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Cecina: 12$/c");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_4_1.add(lblNewLabel_2_1_1_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_1_2_4_2 = new JPanel();
		panel.add(panel_2_1_1_2_4_2);
		panel_2_1_1_2_4_2.setLayout(new BorderLayout(0, 0));
		
		JButton Adobada = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/adobada.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Adobada.setIcon(img2);
		
		Adobada.setBorder(null);
		Adobada.setBorderPainted(false);
		Adobada.setContentAreaFilled(false);
		Adobada.setOpaque(false);
		
		panel_2_1_1_2_4_2.add(Adobada, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Adobada: 12$/c");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_1_2_4_2.add(lblNewLabel_2_1_1_2, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_2 = new JPanel();
		panel.add(panel_2_1_2);
		panel_2_1_2.setLayout(new BorderLayout(0, 0));
		
		JButton Lengua = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/lengua.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Lengua.setIcon(img2);
		
		Lengua.setBorder(null);
		Lengua.setBorderPainted(false);
		Lengua.setContentAreaFilled(false);
		Lengua.setOpaque(false);
		
		panel_2_1_2.add(Lengua, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Lengua: 12$/c");
		lblNewLabel_2_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_2.add(lblNewLabel_2_1_1_2_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_3 = new JPanel();
		panel.add(panel_2_1_3);
		panel_2_1_3.setLayout(new BorderLayout(0, 0));
		
		JButton Ojo = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/ojo.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Ojo.setIcon(img2);
		
		Ojo.setBorder(null);
		Ojo.setBorderPainted(false);
		Ojo.setContentAreaFilled(false);
		Ojo.setOpaque(false);
		
		panel_2_1_3.add(Ojo, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("Ojo: 12$/c");
		lblNewLabel_2_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_3.add(lblNewLabel_2_1_1_2_1_1, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_4 = new JPanel();
		panel.add(panel_2_1_4);
		panel_2_1_4.setLayout(new BorderLayout(0, 0));
		
		JButton Campechanos = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/campechanos.jpg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Campechanos.setIcon(img2);
		
		Campechanos.setBorder(null);
		Campechanos.setBorderPainted(false);
		Campechanos.setContentAreaFilled(false);
		Campechanos.setOpaque(false);
		
		panel_2_1_4.add(Campechanos, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2_1_1_2_1_2 = new JLabel("Campechanos: 12$/c");
		lblNewLabel_2_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_4.add(lblNewLabel_2_1_1_2_1_2, BorderLayout.NORTH);
		
		
		
		
		JPanel panel_2_1_5 = new JPanel();
		panel.add(panel_2_1_5);
		panel_2_1_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2_1_1_2_1_2_1 = new JLabel("Alambre: 12$/c");
		lblNewLabel_2_1_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1_5.add(lblNewLabel_2_1_1_2_1_2_1, BorderLayout.NORTH);
		
		JButton Alambre = new JButton("");
		img= new ImageIcon(InterfazCli.class.getResource("/Resources/Images/Alambre.jpeg")).getImage(); 
		img2=new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		Alambre.setIcon(img2);
		
		Alambre.setBorder(null);
		Alambre.setBorderPainted(false);
		Alambre.setContentAreaFilled(false);
		Alambre.setOpaque(false);
		
		panel_2_1_5.add(Alambre, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2,0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{213, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_4.add(btnNewButton, gbc_btnNewButton);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_4.add(panel_5, gbc_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable(cont,columnNames);
		scrollPane.setViewportView(table);
	}
	/*
	 	"Pastor"
       "Barbacoa"
       "Carnitas"
       "Carne asada "
       "Suadero"
       "Bistec"
       "Cochinita"
       "Birria"
       "Tripa"
       "Cabeza"
       "Cecina"
       "Adobada"
       "Lengua"
       "Ojo"
       "Campechanos"
       "Alambre"
       "Buche"
	 * */
}
