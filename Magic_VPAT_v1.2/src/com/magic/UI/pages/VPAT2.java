package com.magic.UI.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VPAT2 extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> comboBox;

    public VPAT2() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("VPAT");
        setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 31, 63));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        createComponents();
        layoutComponents();

        pack();
        setLocationRelativeTo(null);
    }

    private void createComponents() {
        // Create components here
        comboBox = new JComboBox<>(new String[]{"Select VPAT Data", "VPAT 2.5 Rev EU", "VPAT 2.5 INT", "VPAT 2.5 508", "VPAT 2.5 WCAG", "VPAT Change Tracking"});
        // Other components...
    }

    private void layoutComponents() {
        contentPane.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0, 31, 63));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("VPAT TOOL");
        titleLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);

        contentPane.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(new JLabel("Select Document"));
        comboBoxPanel.add(comboBox);

        centerPanel.add(comboBoxPanel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 2));

        // Add other components to detailsPanel...

        centerPanel.add(detailsPanel, BorderLayout.CENTER);

        contentPane.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0, 31, 63));
        bottomPanel.setLayout(new BorderLayout());

        JLabel rightsLabel = new JLabel("@2024 all rights reserved");
        rightsLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        rightsLabel.setForeground(Color.WHITE);

        JLabel developedByLabel = new JLabel("Developed By : Magic Edtech");
        developedByLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        developedByLabel.setForeground(Color.WHITE);
        developedByLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        bottomPanel.add(rightsLabel, BorderLayout.WEST);
        bottomPanel.add(developedByLabel, BorderLayout.EAST);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VPAT frame = new VPAT();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

