package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by ramas_000 on 2/1/2017.
 */
public class MenuScreen extends InputAdapter implements Screen {
    ColorRush game;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    FitViewport fitViewport;
    MenuButton campaignButton, endlessButton, arcadeButton, versusButton;
    Rectangle settingsButton;
    TextureRegionDrawable backgroundRegionDrawable;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector2 touchLoc = new Vector2(screenX, Constants.SCREEN_HEIGHT - screenY);
        if (campaignButton.getRect().contains(touchLoc)){
            Gdx.input.vibrate(25);
            game.showCampaignScreen();
        } else if (endlessButton.getRect().contains(touchLoc)){
            Gdx.input.vibrate(25);
            game.showEndlessScreen();
        } else if (arcadeButton.getRect().contains(touchLoc)){
            Gdx.input.vibrate(25);
            game.showArcadeScreen();
        } else if (versusButton.getRect().contains(touchLoc)){
            Gdx.input.vibrate(25);
        } else if (settingsButton.contains(touchLoc)){
            Gdx.input.vibrate(25);
        }
        return super.touchDown(screenX, screenY, pointer, button);
    }

    public MenuScreen(ColorRush colorRushGame) {
        this.game = colorRushGame;
    }

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        fitViewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        backgroundRegionDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("main_menu_screen.png"))));

        Gdx.input.setInputProcessor(this);
        campaignButton = new MenuButton(Constants.CAMPAIGN_BUTTON_LOCATION.x,
                Constants.CAMPAIGN_BUTTON_LOCATION.y);
        endlessButton = new MenuButton(Constants.ENDLESS_BUTTON_LOCATION.x,
                Constants.ENDLESS_BUTTON_LOCATION.y);
        arcadeButton = new MenuButton(Constants.ARCADE_BUTTON_LOCATION.x,
                Constants.ARCADE_BUTTON_LOCATION.y);
        versusButton = new MenuButton(Constants.VERSUS_BUTTON_LOCATION.x,
                Constants.VERSUS_BUTTON_LOCATION.y);
        settingsButton = new Rectangle(Constants.SETTINGS_BUTTON_LOCATION.x, Constants.SETTINGS_BUTTON_LOCATION.y, Constants.SETTINGS_BUTTON_SIZE, Constants.SETTINGS_BUTTON_SIZE);

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
