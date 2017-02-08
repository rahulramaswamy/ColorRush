package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by ramas_000 on 2/3/2017.
 */

public class Ball extends Actor {
    Sprite sprite = new Sprite(new Texture(Gdx.files.internal("ball.png")));
    Circle circle;
    public Ball() {

        setBounds(Constants.BALL_CENTER.x, Constants.BALL_CENTER.y, Constants.BALL_SIZE, Constants.BALL_SIZE);
        circle = new Circle(new Vector2(Constants.BALL_CENTER.x + Constants.BALL_SIZE / 2, Constants.BALL_CENTER.y + Constants.BALL_SIZE), Constants.BALL_SIZE / 2);
        setTouchable(Touchable.enabled);
        sprite.setSize(Constants.BALL_SIZE, Constants.BALL_SIZE);
    }
    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
    @Override
    public void act(float delta){
        super.act(delta);
    }

    public Circle getCircle() {
        return circle;
    }
    public void setXY(float x, float y){
        circle = new Circle(new Vector2(x, Constants.SCREEN_HEIGHT - y), Constants.BALL_SIZE / 2);
        this.setX(x - Constants.BALL_SIZE / 2);
        this.setY(y - Constants.BALL_SIZE / 2);
    }
    public void destroy(){
        this.sprite.setAlpha(0.0f);
    }
}
