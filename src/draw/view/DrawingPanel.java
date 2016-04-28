package draw.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import draw.controller.DrawController;

public class DrawingPanel extends JPanel
{
	private DrawController baseController;
	private DrawFrame baseFrame;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	
	private JLabel countLabel;
	
	public DrawingPanel(DrawController baseController, DrawFrame baseFrame)
	{
		this.baseController = baseController;
		this.baseFrame = baseFrame;
		
		shapePanel = new ShapePanel(baseController, baseFrame, this);
		baseLayout = new SpringLayout();
		countLabel = new JLabel("0");
		baseLayout.putConstraint(SpringLayout.NORTH, countLabel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, countLabel, 0, SpringLayout.WEST, this);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(shapePanel);
		this.add(countLabel);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 60, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, 0, SpringLayout.EAST, this);
		
	}

	private void setupListeners()
	{
	}

	public void updateCounter(int count)
	{
		countLabel.setText(""+count);
	}
	
}
