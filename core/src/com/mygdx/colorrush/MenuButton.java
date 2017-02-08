package com.mygdx.colorrush;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import sun.rmi.runtime.Log;

/**
 * Created by ramas_000 on 2/2/2017.
 */

public class MenuButton {
    Rectangle rect;
    float x, y;
    int width, height;
    public MenuButton(float x, float y){
        this.x = x;
        this.y = y;
        this.width = Constants.MENU_ITEM_WIDTH;
        this.height = Constants.MENU_ITEM_HEIGHT;
        this.rect = new Rectangle(this.x, this.y, width, height);
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
