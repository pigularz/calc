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
	private String operator = "=";
	private double result = 0;
	private boolean canCalculate = true;
	
	public Frame() {
		
		initializeComponents();
		
	}
	
	private void initializeComponents() {
		
		this.setTitle(APP_NAME);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(120, 120, 220, 220);
		
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
		numbersButtonPanel.setBounds(10, BUTTON_SIZE, 180, 190);
		numbersButtonPanel.setLayout(new FlowLayout(5));
		String buttonLabels = "789/456*123-0.=+C";
		
		for(int i = 0; i < buttonLabels.length();i++) {
			JButton b = new JButton(buttonLabels.substring(i, i + 1));
			numbersButtonPanel.add(b);
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					
					if(cmd.equals("C")) {
						numberValues.setText("0");					
					}
					
					numberValues.setText(numberValues.getText() + cmd);

			
				}

		});
		
		}
		this.add(backgroundPanel, BorderLayout.NORTH);
		this.add(numbersButtonPanel);		
		

	}
	
	private void calculate(double x) {
		if(operator.equals("+")) 
			result += x;
		else if (operator.equals("-"))
			result -= x;
		else if (operator.equals("*"))
			result *= x;
		else if (operator.equals("/"))
			result /= x;
		else if (operator.equals("="))
			result = x;
		numberValues.setText("" + result);
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
	
}
