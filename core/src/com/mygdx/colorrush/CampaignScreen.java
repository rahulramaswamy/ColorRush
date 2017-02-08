package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import sun.rmi.runtime.Log;

/**
 * Created by ramas_000 on 2/2/2017.
 */
public class CampaignScreen extends InputAdapter implements Screen {
    ColorRush game;
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    FitViewport fitViewport;
    Array<Square> squaresList;
    Stage stage;
    Image background;
    Ball ball;
    String square1Img, square2Img, square3Img, square4Img;
    boolean isTouched = false;

    public CampaignScreen(ColorRush colorRushGame) {
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isTouched = false;
        System.out.println("Test");

        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Vector2 touch = new Vector2(screenX, screenY);
        if (ball.getCircle().contains(touch)){
            isTouched = true;
        }
        if (isTouched) {
            ball.setXY(screenX, Constants.SCREEN_HEIGHT - screenY);
        }
        for (int i = 0; i < squaresList.size; i++){
            System.out.println(squaresList.get(i).getRectangle().toString() + "\n" + ball.getCircle().toString());
            if (squaresList.get(i).getRectangle().contains(ball.getCircle())){
                System.out.println("Test");
                ball.destroy();
                ball = new Ball();
                stage.addActor(ball);
                isTouched = false;
                return true;
            }
        }
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        fitViewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        stage = new Stage(fitViewport);
        InputMultiplexer iM = new InputMultiplexer();
        iM.addProcessor(this);
        iM.addProcessor(stage);
        Gdx.input.setInputProcessor(iM);
        Gdx.input.setCatchBackKey(true);
        squaresList = new Array<Square>();
        background = new Image(new Texture(Gdx.files.internal("game_screen.png")));
        background.setBounds(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        ball = new Ball();
        stage.addActor(background);
        square1Img = "red_square.png";
        square2Img = "blue_square.png";
        square3Img = "yellow_square.png";
        square4Img = "green_square.png";
        squaresList.add(new Square(Constants.SQUARE_ONE_LOCATION.x, Constants.SQUARE_ONE_LOCATION.y, new Texture(Gdx.files.internal("blue_square.png"))));
        squaresList.add(new Square(Constants.SQUARE_TWO_LOCATION.x, Constants.SQUARE_TWO_LOCATION.y, new Texture(Gdx.files.internal("red_square.png"))));
        squaresList.add(new Square(Constants.SQUARE_THREE_LOCATION.x, Constants.SQUARE_THREE_LOCATION.y, new Texture(Gdx.files.internal("green_square.png"))));
        squaresList.add(new Square(Constants.SQUARE_FOUR_LOCATION.x, Constants.SQUARE_FOUR_LOCATION.y, new Texture(Gdx.files.internal("yellow_square.png"))));
        for (int i = 0; i < squaresList.size; i++){
            stage.addActor(squaresList.get(i));
        }
        stage.addActor(ball);
    }

    @Override
    public void render(float delta) {
        fitViewport.apply();
        Gdx.gl.glClearColor(Constants.MENU_BACKGROUND_COLOR.r, Constants.MENU_BACKGROUND_COLOR.g, Constants.MENU_BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.setProjectionMatrix(fitViewport.getCamera().combined);
        spriteBatch.begin();
        stage.draw();
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
