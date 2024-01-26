package com.magic.UI.pages;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.hc.core5.http.Message;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.magic.UI.utils.CommonFuntions;
import com.magic.UI.utils.InputGetterSetter;
import com.magic.UI.utils.WordDocs;
public class GetInputDetailsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextArea prdDescription;
	public static JTextArea leaglDisclaimerTxtArea;
	public static JTextField nameOfProduct;
	public static JTextField reportData;
	public static JTextField contactInformation;
	public static JTextField preapredByTxt;
	public static JLabel dropDownShowLbl;
	String message="";

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GetInputDetailsFrame frame = new GetInputDetailsFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GetInputDetailsFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/lib/img/logo.png"));
		setTitle("Input Details Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 847, 690);
		setBounds(100, 100, 847, 890);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 31, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 31, 63));
		panel.setBounds(10, 11, 811, 790);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name of Product/Version");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 47, 186, 30);
		panel.add(lblNewLabel);
		
		nameOfProduct = new JTextField();
		nameOfProduct.setSelectedTextColor(Color.WHITE);
		nameOfProduct.setSelectionColor(new Color(255, 255, 255));
		nameOfProduct.setFont(new Font("Verdana", Font.PLAIN, 13));
		nameOfProduct.setBounds(297, 47, 493, 30);
		panel.add(nameOfProduct);
		nameOfProduct.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Report Date");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 91, 177, 30);
		panel.add(lblNewLabel_1);
		
		reportData = new JTextField();
		reportData.setSelectionColor(new Color(255, 255, 255));
		reportData.setSelectedTextColor(Color.WHITE);
		reportData.setFont(new Font("Verdana", Font.PLAIN, 13));
		reportData.setBounds(297, 88, 493, 30);
		panel.add(reportData);
		reportData.setColumns(10);
		
		JLabel productDescription = new JLabel("Product Description");
		productDescription.setForeground(Color.WHITE);
		productDescription.setFont(new Font("Verdana", Font.BOLD, 13));
		productDescription.setBounds(10, 132, 177, 30);
		panel.add(productDescription);
		
		JLabel contactInfo = new JLabel("Contact Information");
		contactInfo.setForeground(Color.WHITE);
		contactInfo.setFont(new Font("Verdana", Font.BOLD, 13));
		contactInfo.setBounds(10, 254, 177, 30);
		panel.add(contactInfo);
		
		contactInformation = new JTextField();
		contactInformation.setSelectedTextColor(Color.WHITE);
		contactInformation.setSelectionColor(new Color(255, 255, 255));
		contactInformation.setFont(new Font("Verdana", Font.PLAIN, 13));
		contactInformation.setColumns(10);
		contactInformation.setBounds(297, 254, 493, 30);
		panel.add(contactInformation);
		
		JLabel preparedByLbl = new JLabel("Client Name");
		preparedByLbl.setForeground(Color.WHITE);
		preparedByLbl.setFont(new Font("Verdana", Font.BOLD, 13));
		preparedByLbl.setBounds(10, 295, 177, 30);
		panel.add(preparedByLbl);
		
		preapredByTxt = new JTextField();
		preapredByTxt.setSelectedTextColor(Color.WHITE);
		preapredByTxt.setSelectionColor(new Color(255, 255, 255));
		preapredByTxt.setFont(new Font("Verdana", Font.PLAIN, 13));
		preapredByTxt.setColumns(10);
		preapredByTxt.setBounds(297, 295, 493, 30);
		panel.add(preapredByTxt);
		
		
		
		dropDownShowLbl = new JLabel("");
		dropDownShowLbl.setFont(new Font("Verdana", Font.BOLD, 16));
		dropDownShowLbl.setForeground(new Color(255,255,191));
		dropDownShowLbl.setBounds(295, 0, 302, 35);
		panel.add(dropDownShowLbl);
		
		JLabel lblNewLabel_3 = new JLabel("You have selected");
		lblNewLabel_3.setForeground(new Color(255,255,191));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 0, 198, 35);
		panel.add(lblNewLabel_3);
		
		JButton btnDownloadFile = new JButton("Download VPAT");
		btnDownloadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					message = CommonFuntions.downloadVPAT(dropDownShowLbl.getText());
					
					message.replace("doc", "docx");
					System.out.println("Notification Message : "+message);
				} catch (Exception e1) {
				}
				if(message!=null) {
				 JOptionPane.showMessageDialog(null, message, "File Download Notification", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "File is not DOWNLOADED", "File Download Notification", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnDownloadFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDownloadFile.setBackground(new Color(255,255,191));
		btnDownloadFile.setBounds(650, 3, 130, 29);
		panel.add(btnDownloadFile);
		
		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(0, 625, 831, 3);
		panel_1.setBounds(0, 810, 890, 3);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Developed By  MagicEdtech");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(595, 815, 236, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!nameOfProduct.getText().trim().isEmpty()
						&& !reportData.getText().trim().isEmpty()
						&& !prdDescription.getText().trim().isEmpty()
						&& !contactInformation.getText().trim().isEmpty()
						&& !preapredByTxt.getText().trim().isEmpty()) {
					InputGetterSetter input = new InputGetterSetter();
					input.setStrNameOfProduct(nameOfProduct.getText().trim());
					input.setStrReportData(reportData.getText().trim());
					input.setStrPrdDescription(prdDescription.getText().trim());
					input.setStrContactInformation(contactInformation.getText().trim());
					input.setStrPreapredByTxt(preapredByTxt.getText().trim());
					System.out.println(input.getStrNameOfProduct());
					System.out.println(input.getStrReportData());
					System.out.println(input.getStrPrdDescription());
					System.out.println(input.getStrContactInformation());
					System.out.println(input.getStrPreapredByTxt());
					dispose();
					
					VPAT.prdNameLbl.setText(input.getStrNameOfProduct());
					VPAT.reportDateLbl.setText(input.getStrReportData().trim());
					VPAT.prdDescriptionLbl.setText(input.getStrPrdDescription());
					VPAT.conInfoLbl.setText(input.getStrContactInformation());
					VPAT.preparedByLbl.setText(input.getStrPreapredByTxt());
					VPAT.panel_1.setVisible(true);
				}
				
				try {
					WordDocs.readDoc("C:\\Users\\magic\\Downloads\\VPAT2.5508(November2023).docx",dropDownShowLbl.getText()+".docx");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setBackground(new Color(255,255,191));
		btnSubmit.setBounds(712, 765, 89, 29);
		panel.add(btnSubmit);
		
		prdDescription = new JTextArea();
		prdDescription.setBounds(296, 137, 494, 106);
		panel.add(prdDescription);
		
		JLabel lblNewLabel_4 = new JLabel("Web Content Accessibility Guidelines 2.0");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 341, 268, 30);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 191));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Level A", "Yes", "No"}));
		comboBox.setBounds(297, 345, 120, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 191));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level AA", "Yes", "No"}));
		comboBox_1.setBounds(437, 345, 130, 22);
		panel.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setForeground(Color.BLACK);
		comboBox_1_1.setBackground(new Color(255, 255, 191));
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level AAA", "Yes", "No"}));
		comboBox_1_1.setBounds(577, 345, 150, 22);
		panel.add(comboBox_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("NA");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBackground(new Color(0, 31, 63));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(733, 345, 57, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_4_1 = new JLabel("Web Content Accessibility Guidelines 2.1");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(10, 372, 268, 30);
		panel.add(lblNewLabel_4_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select Level A", "Yes", "No"}));
		comboBox_2.setBackground(new Color(255, 255, 191));
		comboBox_2.setBounds(297, 376, 120, 22);
		panel.add(comboBox_2);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"Select Level AA", "Yes", "No"}));
		comboBox_1_2.setBackground(new Color(255, 255, 191));
		comboBox_1_2.setBounds(437, 376, 130, 22);
		panel.add(comboBox_1_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level AAA", "Yes", "No"}));
		comboBox_1_1_1.setForeground(Color.BLACK);
		comboBox_1_1_1.setBackground(new Color(255, 255, 191));
		comboBox_1_1_1.setBounds(577, 376, 150, 22);
		panel.add(comboBox_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("NA");
		chckbxNewCheckBox_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1.setBackground(new Color(0, 31, 63));
		chckbxNewCheckBox_1.setBounds(733, 376, 57, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("<html>Revised Section 508 standards published January 18,<br/>\r\n2017 and corrected January 22, 2018<html>");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_1_1.setBounds(10, 413, 268, 67);
		panel.add(lblNewLabel_4_1_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level A", "Yes", "No"}));
		comboBox_2_1.setBackground(new Color(255, 255, 191));
		comboBox_2_1.setBounds(297, 430, 120, 22);
		panel.add(comboBox_2_1);
		
		JComboBox comboBox_1_2_1 = new JComboBox();
		comboBox_1_2_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level AA", "Yes", "No"}));
		comboBox_1_2_1.setBackground(new Color(255, 255, 191));
		comboBox_1_2_1.setBounds(437, 430, 130, 22);
		panel.add(comboBox_1_2_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Select Level AAA", "Yes", "No"}));
		comboBox_1_1_1_1.setForeground(Color.BLACK);
		comboBox_1_1_1_1.setBackground(new Color(255, 255, 191));
		comboBox_1_1_1_1.setBounds(577, 430, 150, 22);
		panel.add(comboBox_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("NA");
		chckbxNewCheckBox_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1_1.setBackground(new Color(0, 31, 63));
		chckbxNewCheckBox_1_1.setBounds(733, 430, 57, 23);
		panel.add(chckbxNewCheckBox_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("<html>EN 301 549 Accessibility requirements for ICT products<br/>\r\nand services - V3.1.1 (2019-11)<b> AND </b>EN 301 549</br>\r\nAccessibility requirements for ICT products and services -<br/>\r\nV3.2.1 (2021-03)<br/></html>");
		lblNewLabel_4_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_2.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_1_2.setBounds(10, 501, 268, 91);
		panel.add(lblNewLabel_4_1_2);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"Select Level A", "Yes", "No"}));
		comboBox_2_2.setBackground(new Color(255, 255, 191));
		comboBox_2_2.setBounds(297, 505, 120, 22);
		panel.add(comboBox_2_2);
		
		JComboBox comboBox_1_2_2 = new JComboBox();
		comboBox_1_2_2.setModel(new DefaultComboBoxModel(new String[] {"Select Level AA", "Yes", "No"}));
		comboBox_1_2_2.setBackground(new Color(255, 255, 191));
		comboBox_1_2_2.setBounds(437, 505, 130, 22);
		panel.add(comboBox_1_2_2);
		
		JComboBox comboBox_1_1_1_2 = new JComboBox();
		comboBox_1_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"Select Level AAA", "Yes", "No"}));
		comboBox_1_1_1_2.setForeground(Color.BLACK);
		comboBox_1_1_1_2.setBackground(new Color(255, 255, 191));
		comboBox_1_1_1_2.setBounds(577, 505, 150, 22);
		panel.add(comboBox_1_1_1_2);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("NA");
		chckbxNewCheckBox_1_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1_2.setBackground(new Color(0, 31, 63));
		chckbxNewCheckBox_1_2.setBounds(733, 505, 57, 23);
		panel.add(chckbxNewCheckBox_1_2);
		
		
		JLabel legalDesclaimer = new JLabel("Legal Desclaimer");
		legalDesclaimer.setForeground(Color.WHITE);
		legalDesclaimer.setFont(new Font("Verdana", Font.BOLD, 10));
		legalDesclaimer.setBounds(10, 561, 268, 121);
		panel.add(legalDesclaimer);

		leaglDisclaimerTxtArea = new JTextArea();
		leaglDisclaimerTxtArea.setBounds(296, 610, 494, 106);
		panel.add(leaglDisclaimerTxtArea);
	}
}
