package draw.controller;

import draw.view.DrawFrame;
import draw.view.DrawingPanel;

public class DrawController
{
	DrawingPanel basePanel;
	DrawFrame baseFrame;
	
	public DrawController()
	{
		baseFrame = new DrawFrame(this);
	}
	
	public void start()
	{
		
	}
}
