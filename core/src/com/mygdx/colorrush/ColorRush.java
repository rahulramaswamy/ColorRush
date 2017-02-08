package com.mygdx.colorrush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ColorRush extends Game {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create() {
		showMenuScreen();
	}
	public void showMenuScreen(){
		setScreen(new MenuScreen(this));
	}

	public void showCampaignScreen(){
		setScreen(new CampaignScreen(this));
	}

	public void showEndlessScreen() {
		setScreen(new EndlessScreen(this));
	}

	public void showArcadeScreen() {
		setScreen(new ArcadeScreen(this));
	}
}
