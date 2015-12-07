package com.java.TowerPower.Controller.menu;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.java.GameEngine.Model.Texture;
import com.java.GameEngine.View.Display;
import com.java.TowerPower.Controller.ButtonController;
import com.java.TowerPower.Controller.TowerPowerController;
import com.java.TowerPower.Model.ButtonModel;
import com.java.TowerPower.util.TextureManager;
public class HelpMenuController extends MenuController{
	
		private ButtonModel backButtonModel = ButtonController.createButton(ButtonController.MENU_BUTTON,
				"Back to Main Menu", new Point(320, 420));
		private ButtonModel previousButtonModel = ButtonController.createButton(ButtonController.PREV_BUTTON,
				"", new Point(64, 420));
		private ButtonModel nextButtonModel = ButtonController.createButton(ButtonController.NEXT_BUTTON,
				"", new Point(640 - 64, 420));
		private int loadedHelpImageId = 0;
		private int currentImageId = 0;
		private static final int HELP_IMAGE_COUNT = 6;
		private Texture helpImage;
		private static final Point HELP_IMAGE_POSITION = new Point(120,80);
		
		public HelpMenuController()
		{
			super(TowerPowerController.HELP_MENU);
			buttonController.addModel(backButtonModel);
			buttonController.addModel(previousButtonModel);
			buttonController.addModel(nextButtonModel);
			changeHelpImage();
		}
		
		//@override method
		public void draw(){
			super.draw();
			buttonController.drawModels();
			Display.getInstance().getCanvas().drawTexture(helpImage, HELP_IMAGE_POSITION, 0);
		}
		
		private void changeHelpImage()
		{
			helpImage = TextureManager.loadHelpImage(currentImageId);
			loadedHelpImageId = currentImageId;
			System.gc();//Request garbage collection
		}
		public int getState(){
			return this.state;
		}
		
		@Override
		public void preUpdate()
		{
			previousButtonModel.setPressed(false);
			nextButtonModel.setPressed(false);
		}
		
		@Override
		public void update()
		{
			//Changes help image when requested
			if (loadedHelpImageId != currentImageId)
				changeHelpImage();
		}
		@Override
		public void onMouseInput(MouseEvent event)
		{
			ButtonModel buttonModel= getClickedButton(event);
			if(buttonModel != null)
				if(buttonModel.getId()==backButtonModel.getId())
					this.state=TowerPowerController.MAIN_MENU;
				else if(buttonModel.getId()==previousButtonModel.getId()){
					currentImageId =  (HELP_IMAGE_COUNT + (currentImageId - 1)) % HELP_IMAGE_COUNT;
					previousButtonModel.setPressed(true);
				}
				else if(buttonModel.getId()==nextButtonModel.getId()){
					currentImageId = (currentImageId + 1) % HELP_IMAGE_COUNT;
					nextButtonModel.setPressed(true);
				}
			
		}
		@Override
		public void onKeyboardInput(KeyEvent event)
		{
			// TODO Auto-generated method stub
			
		}
}