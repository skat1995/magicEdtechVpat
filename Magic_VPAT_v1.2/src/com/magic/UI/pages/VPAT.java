package com.magic.UI.pages;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.magic.UI.utils.InputGetterSetter;


public class VPAT extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<String> comboBox;
	public static Panel panel_1;
	public static InputGetterSetter details;
	public static JLabel prdNameLbl;
	public static JLabel reportDateLbl;
	public static JLabel prdDescriptionLbl;
	public static JLabel conInfoLbl;
	public static JLabel preparedByLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details=new InputGetterSetter();
					VPAT frame = new VPAT();
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
	public VPAT() {
		String vpatData[] = { "Select VPAT Data", "VPAT 2.5 Rev EU", "VPAT 2.5 INT", "VPAT 2.5 508","VPAT 2.5 WCAG","VPAT Change Tracking" };
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/lib/img/logo.png"));
		setTitle("VPAT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 501);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 31, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("VPAT TOOL");
		label.setBackground(new Color(0, 31, 63));
		label.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
		label.setForeground(new Color(255, 255, 255));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 0, 598, 30);
		contentPane.add(label);
		
		Panel panel = new Panel();
		panel.setBounds(10, 57, 731, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_1 = new Label("Select Document");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 17));
		label_1.setBounds(10, 10, 246, 38);
		panel.add(label_1);
		
		comboBox= new JComboBox<String>(vpatData);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				if(selectedOption.equals("VPAT 2.5 Rev EU") ||selectedOption.equals("VPAT 2.5 INT")
						|| selectedOption.equals("VPAT 2.5 508") || selectedOption.equals("VPAT 2.5 WCAG")
						||selectedOption.equals("VPAT Change Tracking")) {
				getInputDetailsFormWindow();
				GetInputDetailsFrame.dropDownShowLbl.setText(selectedOption);
				}
			}
		});
		comboBox.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		comboBox.setForeground(new Color(0,0,0));
		comboBox.setBackground(new Color(255,255,191));
		comboBox.setBounds(409, 10, 312, 38);
		panel.add(comboBox);
		
		
		panel_1 = new Panel();
		panel_1.setBounds(10, 54, 711, 297);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Name of Product/Version");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 175, 29);
		panel_1.add(lblNewLabel);
		
		prdNameLbl = new JLabel("");
		prdNameLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		prdNameLbl.setForeground(Color.WHITE);
		prdNameLbl.setBounds(196, 11, 505, 29);
		panel_1.add(prdNameLbl);
		
		
		JLabel lblReportDate = new JLabel("Report Date");
		lblReportDate.setForeground(Color.WHITE);
		lblReportDate.setFont(new Font("Verdana", Font.BOLD, 12));
		lblReportDate.setBounds(10, 50, 175, 29);
		panel_1.add(lblReportDate);
		
		reportDateLbl = new JLabel("");
		reportDateLbl.setForeground(Color.WHITE);
		reportDateLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		reportDateLbl.setBounds(196, 50, 505, 29);
		panel_1.add(reportDateLbl);
		
		JLabel lblProductDescription = new JLabel("Product Description");
		lblProductDescription.setForeground(Color.WHITE);
		lblProductDescription.setFont(new Font("Verdana", Font.BOLD, 12));
		lblProductDescription.setBounds(10, 90, 149, 29);
		panel_1.add(lblProductDescription);
		
		prdDescriptionLbl = new JLabel("");
		prdDescriptionLbl.setForeground(Color.WHITE);
		prdDescriptionLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		prdDescriptionLbl.setBounds(196, 90, 505, 29);
		
		panel_1.add(prdDescriptionLbl);
		
		JLabel lblContactInformation = new JLabel("Contact Information");
		lblContactInformation.setForeground(Color.WHITE);
		lblContactInformation.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContactInformation.setBounds(10, 143, 175, 29);
		panel_1.add(lblContactInformation);
		
		conInfoLbl = new JLabel("");
		conInfoLbl.setForeground(Color.WHITE);
		conInfoLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		conInfoLbl.setBounds(196, 143, 505, 61);
		
		panel_1.add(conInfoLbl);
		
		JLabel lblPreparedBy = new JLabel("Client Name");
		lblPreparedBy.setForeground(Color.WHITE);
		lblPreparedBy.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPreparedBy.setBounds(20, 215, 139, 29);
		panel_1.add(lblPreparedBy);
		
		preparedByLbl = new JLabel("");
		preparedByLbl.setForeground(Color.WHITE);
		preparedByLbl.setFont(new Font("Verdana", Font.PLAIN, 11));
		preparedByLbl.setBounds(206, 215, 505, 29);
		
		panel_1.add(preparedByLbl);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 255, 191));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(622, 255, 89, 31);
		panel_1.add(btnNewButton);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 31, 63));
		panel_2.setBounds(10, 435, 731, 27);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_2 = new Label("@2024 all rights reserved");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setBounds(0, 0, 231, 27);
		panel_2.add(label_2);
		
		Label label_3 = new Label("Developed By : Magic Edtech");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setAlignment(Label.RIGHT);
		label_3.setBounds(498, 0, 223, 27);
		panel_2.add(label_3);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 31, 751, 5);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(0, 424, 751, 5);
		contentPane.add(panel_3_1);
	}
	
	
	private void getInputDetailsFormWindow() {
		GetInputDetailsFrame inputDetailsFrame=new GetInputDetailsFrame();
		setVisible(false);
		inputDetailsFrame.setVisible(true);
		inputDetailsFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Show the main window
                setVisible(true);
            }
        });
	}
}
