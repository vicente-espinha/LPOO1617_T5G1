package com.mygdx.game.Sprites.Foods;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.ChickenVsFood;

/**
 * Created by vitor on 29/05/2017.
 */

public class Carrot extends Food {
    private World world;
    private Body b2body;
    private ChickenVsFood game;
    private TextureRegion ChickenTexture;
    private int HEALTH = 5;

    public Carrot(World world, ChickenVsFood game) {
        super(world, game);
    }

    @Override
    public void defineFood(int i, int i1) {

    }

    @Override
    public void update(float v) {

    }

    @Override
    public Body getBody() {
        return null;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    public void hit() {}

    @Override
    public boolean isDead() {
        if (getHealth() == 0)
            return true;
        return false;
    }

    @Override
    public void decreaseHealth() {
        this.HEALTH--;
    }
}