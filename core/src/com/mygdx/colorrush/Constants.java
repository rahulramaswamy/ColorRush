package com.mygdx.colorrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ramas_000 on 2/1/2017.
 */

public class Constants {
    //Screen
    public static final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    //Menu
    public static final Color MENU_BACKGROUND_COLOR = Color.LIGHT_GRAY;
    public static final int MENU_ITEM_WIDTH = SCREEN_WIDTH / 2;
    public static final int SETTINGS_BUTTON_SIZE = SCREEN_HEIGHT / 16;
    public static final int MENU_ITEM_HEIGHT = SCREEN_HEIGHT / 8;
    public static final int MENU_ITEM_X = SCREEN_WIDTH / 4;
    public static final Vector2 CAMPAIGN_BUTTON_LOCATION = new Vector2(MENU_ITEM_X, (SCREEN_HEIGHT * 12 / 16));
    public static final Vector2 ENDLESS_BUTTON_LOCATION = new Vector2(MENU_ITEM_X, (SCREEN_HEIGHT * 9 / 16));
    public static final Vector2 ARCADE_BUTTON_LOCATION = new Vector2(MENU_ITEM_X, (SCREEN_HEIGHT * 3 / 8));
    public static final Vector2 VERSUS_BUTTON_LOCATION = new Vector2(MENU_ITEM_X, (SCREEN_HEIGHT * 3 / 16));
    public static final Vector2 SETTINGS_BUTTON_LOCATION = new Vector2(SCREEN_WIDTH * 13 / 16, (SCREEN_HEIGHT * 29 / 32));

    //Game
    public static final int SQUARE_SIZE = SCREEN_WIDTH / 3;
    public static final int BALL_SIZE = SCREEN_HEIGHT / 12;
    public static final Vector2 SQUARE_ONE_LOCATION = new Vector2(0, 0);
    public static final Vector2 SQUARE_TWO_LOCATION = new Vector2(0, (SCREEN_HEIGHT * 11 / 16));
    public static final Vector2 SQUARE_THREE_LOCATION = new Vector2(SCREEN_WIDTH * 2 / 3, 0);
    public static final Vector2 SQUARE_FOUR_LOCATION = new Vector2(SCREEN_WIDTH * 2 / 3, (SCREEN_HEIGHT * 11 / 16));
    public static final Vector2 BALL_CENTER = new Vector2(SCREEN_WIDTH / 2 - BALL_SIZE / 2, (SCREEN_HEIGHT * 11 / 32) + BALL_SIZE / 2);

}
