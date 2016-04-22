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
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import draw.controller.DrawController;

public class DrawingPanel extends JPanel
{
	private DrawController baseController;
	private DrawFrame baseFrame;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private JButton drawRectangleButton;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawController baseController, DrawFrame baseFrame)
	{
		this.baseController = baseController;
		this.baseFrame = baseFrame;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePanel();
		rectangleList = new ArrayList<Rectangle>();
		
		drawRectangleButton = new JButton("Draw the rectangle");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(drawRectangleButton);
	}

	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				addRectangle();
			}
			
		});
	
		this.addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseDragged(MouseEvent e)
			{
				addRectangle(e.getX(), e.getY());
				addRectangle();
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				addRectangle();
				
			}

			
			
		});
		
		
	}

	private void addRectangle()
	{
		int xPosition = (int)(Math.random() * baseFrame.getWidth());
		int yPosition = (int)(Math.random() * baseFrame.getHeight());
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random() * 50);
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
		repaint();
	}
	
	private void addRectangle(int x, int y)
	{
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random() * 50);
		
		rectangleList.add(new Rectangle(x, y, width, height));
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(15));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(current);
		}
	}
}
