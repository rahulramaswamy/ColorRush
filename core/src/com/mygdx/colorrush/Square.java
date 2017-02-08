package com.mygdx.colorrush;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by ramas_000 on 2/3/2017.
 */
public class Square extends Actor{
    Rectangle rectangle;
    Sprite sprite;
    int width, height;

    public Square(float x, float y, Texture texture){
        super();
        this.sprite = new Sprite(texture);
        this.width = Constants.SQUARE_SIZE;
        this.height = Constants.SQUARE_SIZE;
        setBounds(x, y, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        this.rectangle = new Rectangle(x, 13 * Constants.SCREEN_HEIGHT / 16 - y, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        this.setTouchable(Touchable.enabled);
        sprite.setPosition(getX(),getY());
        sprite.setSize(width, height);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
    @Override
    public void act(float delta){
        super.act(delta);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getSize() {
        return height;
    }
}
