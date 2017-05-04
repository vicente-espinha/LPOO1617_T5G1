package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MainMenuScreen;
import com.mygdx.game.Screens.PlayScreen;

//implements the game loop
public class ChickenVsFood extends Game {
	public static final int V_WIDTH = 1900;
	public static final int V_HEIGHT = 900;
	public static final float PPM = 100;
	public SpriteBatch batch;
	private AssetManager assetManager;


	public ChickenVsFood getCVFGame(){
		return this;
	}

	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
}
