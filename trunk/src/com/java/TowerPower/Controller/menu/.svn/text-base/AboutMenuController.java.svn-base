package com.java.TowerPower.Controller.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Canvas;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.TowerPowerConstants;
import com.java.TowerPower.Controller.ButtonController;
import com.java.TowerPower.Controller.TowerPowerController;
import com.java.TowerPower.Model.ButtonModel;
import com.java.TowerPower.util.TextureManager;
public class AboutMenuController extends MenuController{
	
		private ButtonModel backButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON, "Back to Main Menu", new Point(520, 400));
		
		public AboutMenuController()
		{
			super(TowerPowerController.ABOUT_MENU);
			buttonController.addModel(backButtonModel);
		}
		
		protected Texture getBackground()
		{
			return TextureManager.getTexture("background_about");
		}
		
		//@override method
		public void draw(){
			super.draw();
			buttonController.drawModels();
			
			Canvas canvas = Display.getInstance().getCanvas();
			
			Font font = TowerPowerConstants.ABOUT_FONT;
			String text = TowerPowerConstants.ABOUT_TEXT;
			
			String[] list = text.split("\n");
			
			int yPos = 175;
			int centerX = Display.getInstance().getSize().width/2;
			int space = font.getSize() + 5;
			for (String p : list){
				canvas.drawTextOnCenter(p, font, Color.black, new Point(centerX,yPos));
				yPos += space;
			}
			
			
		}
		
		@Override
		public void update()
		{
			
		}
		
		@Override
		public void onMouseInput(MouseEvent event)
		{
			ButtonModel buttonModel= getClickedButton(event);

			if (buttonModel != null){
				if(buttonModel.getId()==backButtonModel.getId())
					this.state=TowerPowerController.MAIN_MENU;
			}
		}
		
		@Override
		public void onKeyboardInput(KeyEvent event){}
}
