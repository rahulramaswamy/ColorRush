package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by ramas_000 on 2/2/2017.
 */
public class GameMenuScreen extends InputAdapter implements Screen {
    ColorRush game;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    FitViewport fitViewport;
    MenuButton campaignButton, endlessButton, arcadeButton;
    TextureRegionDrawable backgroundRegionDrawable;

    public GameMenuScreen(ColorRush colorRushGame) {
        this.game = colorRushGame;
    }
    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.BACK){
            game.showMenuScreen();
        }
        return super.keyDown(keycode);
    }
    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        fitViewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
        backgroundRegionDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("game_menu_screen.png"))));
    }

    @Override
    public void render(float delta) {
        fitViewport.apply();
        Gdx.gl.glClearColor(Constants.MENU_BACKGROUND_COLOR.r, Constants.MENU_BACKGROUND_COLOR.g, Constants.MENU_BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(fitViewport.getCamera().combined);
        spriteBatch.begin();
        backgroundRegionDrawable.draw(spriteBatch, 0f, 0f, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        fitViewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        spriteBatch.dispose();
    }

    @Override
    public void dispose() {

    }
}
