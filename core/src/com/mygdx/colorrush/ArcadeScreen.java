package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by ramas_000 on 2/2/2017.
 */
public class ArcadeScreen extends InputAdapter implements Screen {
    ColorRush game;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    FitViewport fitViewport;

    public ArcadeScreen(ColorRush colorRushGame) {
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
    }

    @Override
    public void render(float delta) {
        fitViewport.apply();
        Gdx.gl.glClearColor(Constants.MENU_BACKGROUND_COLOR.r, Constants.MENU_BACKGROUND_COLOR.g, Constants.MENU_BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
