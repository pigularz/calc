package com.maciej.viewer;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.maciej.controller.AppController;

public class Frame extends JFrame { 
	
	private final String APP_NAME = "Simple Calc";
	private final int BUTTON_COUNT = 10;
	private final int BUTTON_SIZE = 45; 
	private JPanel backgroundPanel, numbersButtonPanel;
	private JTextField numberValues;
	
	
	public Frame() {
		
		initializeComponents();
		
	}
	
	private void initializeComponents() {
		
		this.setTitle(APP_NAME);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setBounds(120, 120, 220, 200);
		
		// ------------------ Background Panel ----------------------------- //
		
		backgroundPanel = new JPanel();		
		numberValues = new JTextField(15);
		//numberValues.setEditable(false);
		//numberValues.setFocusable(false);
		numberValues.setHorizontalAlignment(SwingConstants.RIGHT);
		numberValues.setBounds(25, 25, 30, 25);
		backgroundPanel.add(numberValues);
		
		
		// ----------------- Numbers Panel --------------------------------- //
		numbersButtonPanel = new JPanel();
		numbersButtonPanel.setBounds(10, BUTTON_SIZE, 140, 190);
		numbersButtonPanel.setLayout(new FlowLayout());
		JButton[] buttons = new JButton[BUTTON_COUNT];
		for (int i = 0; i < BUTTON_COUNT; i++) {
			buttons[i] =  new JButton(Integer.toString(i));
			
			AppController controll = new AppController();
			buttons[i].setBounds(i, i + BUTTON_SIZE, BUTTON_SIZE, BUTTON_SIZE);
			buttons[i].addMouseListener(new AppController());

			
			numbersButtonPanel.add(buttons[i]);
			
		}
		
		this.add(backgroundPanel, BorderLayout.NORTH);
		this.add(numbersButtonPanel);		
		

	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
}
