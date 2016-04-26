package draw.view;

import javax.swing.JFrame;

import draw.controller.DrawController;

public class DrawFrame extends JFrame
{
	
	DrawController baseController;
	DrawingPanel basePanel;
	
	public DrawFrame(DrawController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController, this);
		
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("ART!!!");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
}
