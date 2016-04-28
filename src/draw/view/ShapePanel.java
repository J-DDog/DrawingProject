package draw.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import draw.controller.DrawController;
import javax.swing.JLabel;

public class ShapePanel extends JPanel
{
	private DrawController baseController;
	private DrawFrame baseFrame;
	private DrawingPanel basePanel;
	
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	
	private int totalShapes;
 	
	public ShapePanel(DrawController baseController, DrawFrame baseFrame, DrawingPanel basePanel)
	{
		this.baseController = baseController;
		this.baseFrame = baseFrame;
		this.basePanel = basePanel;
		
		totalShapes = 0;
		
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		polygonList = new ArrayList<Polygon>();
		triangleList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
		
	}

	private void setupLayout()
	{
		// TODO Auto-generated method stub
		
	}

	private void setupListeners()
	{
		this.addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseDragged(MouseEvent e)
			{
				addRectangle(e.getX(), e.getY());
				updateShapeCount();
				
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				addRectangle();
				addTriangle();
				updateShapeCount();
			}
			
		});
		
		
	}
	
	private void updateShapeCount()
	{
		totalShapes = 0;
		totalShapes += rectangleList.size();
		totalShapes += squareList.size();
		totalShapes += polygonList.size();
		totalShapes += triangleList.size();
		totalShapes += ellipseList.size();
		totalShapes += circleList.size();
		basePanel.updateCounter(totalShapes);
	}

	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * baseFrame.getWidth());
		int yPosition = (int)(Math.random() * baseFrame.getHeight());
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random() * 50);
		
		xPosition -= width/2;
		yPosition -= height/2;
		
		Rectangle rectangle = new Rectangle(xPosition, yPosition, width, height);
		rectangleList.add(rectangle);
		repaint();
	}
	
	private void addRectangle(int xPosition, int yPosition)
	{
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random() * 50);
		
		xPosition -= width/2;
		yPosition -= height/2;
		
		Rectangle rectangle = new Rectangle(xPosition, yPosition, width, height);
		rectangleList.add(rectangle);
		repaint();
	}
	
	public void addSquare()
	{
		
	}
	
	public void addEllipse()
	{
		
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 100);
		int yPoint = (int)(Math.random() * 100);
		int diameter = (int)(Math.random() * 100);
		
	}
	
	public void addTriangle()
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		xPoints[0] = (int)(Math.random() * baseFrame.getWidth());
		xPoints[1] = (int)(Math.random() * 50) + xPoints[0] - 25;
		xPoints[2] = (int)(Math.random() * 50) + xPoints[0] - 25;
		
		yPoints[0] = (int)(Math.random() * baseFrame.getHeight());
		yPoints[1] = (int)(Math.random() * 50) + yPoints[0] - 25;
		yPoints[2] = (int)(Math.random() * 50) + yPoints[0] - 25;
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 10) + 3;
		int[] xPoints = new int[numberOfSides];
		int[] yPoints = new int[numberOfSides];
		
		for(int count = 0; count < numberOfSides; count++)
		{
			xPoints[count] = (int)(Math.random() * 250);
			yPoints[count] = (int)(Math.random() * 250);
		}
		
		Polygon polygon = new Polygon(xPoints, yPoints, numberOfSides);
		
		polygonList.add(polygon);
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
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
		
		for(Rectangle current : squareList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(current);
		}
		
		for(Polygon current : polygonList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(current);
		}
		
		for(Polygon current : triangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(current);
		}
		
		for(Ellipse2D current : ellipseList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			g2d.setColor(new Color(red, green, blue));
			g2d.setStroke(new BasicStroke(randomStroke));
			
			g2d.fill(current);
		}
		
		for(Ellipse2D current : circleList)
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
