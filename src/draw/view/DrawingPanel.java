package draw.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
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
	private ArrayList<Rectangle> rectangleList;
	
	private int currentX;
	private int currentY;
	
	private boolean wIsPressed;
	private boolean sIsPressed;
	private boolean aIsPressed;
	private boolean dIsPressed;
	private boolean eIsPressed;
	private boolean qIsPressed;
	
	
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
		
		currentX = 100;
		currentY = 0;
		
		wIsPressed = false;
		sIsPressed = false;
		aIsPressed = false;
		dIsPressed = false;
		eIsPressed = false;
		qIsPressed = false;
		
		setupPanel();
		setupLayout();
		setupListeners();
		startLoop();
	}
	
	private void startLoop()
	{
		while(qIsPressed == false)
		{
			
		}
		
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
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e)
			{
				char key = e.getKeyChar();
				switch(key)
				{
					case 'w':
						wIsPressed = true;
						break;
						
					case 's':
						sIsPressed = true;
						break;
						
					case 'a':
						aIsPressed = true;
						break;
						
					case 'd':
						dIsPressed = true;
						break;
						
					case 'e':
						eIsPressed = true;
						break;
						
					case 'q':
						qIsPressed = true;
						break;
						
					default:
						
						break;
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		});
	}


	public void updateCounter(int count)
	{
		countLabel.setText(""+count);
	}

	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		for(Rectangle rectangle: rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(rectangle);
		}
		
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(5));
		g2d.draw(new Ellipse2D.Double(currentX, currentY, 50, 50));
	}
	
}
