package com.mygdx.game.Sprites.Foods;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.ChickenVsFood;

/**
 * Created by vitor on 29/05/2017.
 */

public abstract class Food extends Sprite {
    private Body b2body;
    private World world;
    private boolean hit;

    /**
     * Constructor for a Food
     * @param world game world
     */
    public Food(World world){
        this.world = world;
        setHit(false);
    }

    /**
     * Defines a food's body
     * @param x x coordinate
     * @param y y coordinate
     */
     public void defineFood(int x, int y){
         BodyDef bdef = new BodyDef();
         bdef.position.set(x,y);
         bdef.type = BodyDef.BodyType.StaticBody;
         this.b2body = world.createBody(bdef);

         FixtureDef fdef = new FixtureDef();
         CircleShape shape = new CircleShape();
         shape.setRadius(35);

         fdef.shape = shape;
         fdef.filter.categoryBits = ChickenVsFood.FOOD_BIT;
         fdef.filter.maskBits = ChickenVsFood.CHICKEN_BIT ;

         this.b2body.createFixture(fdef).setUserData(this);
     }

    /**
     * Updates the food
     * @param dt time interval
     */
    public abstract void update(float dt);

    /**
     * Draws the food
     * @param batch spritebatch
     */
    public abstract void draw(SpriteBatch batch);

    /**
     * @return Returns the health
     */
    public abstract int getHealth();

    /**
     * Sets the health field with the health value
     * @param health value for the health field
     */
    public abstract void setHealth(int health);

    /**
     * Sets the hit field with the value b
     * @param b new value of the hit field
     */
    public  void setHit(boolean b){
        this.hit = b;
    }

    /**
     * @return Returns the value of the hit field
     */
    public boolean getHit(){
        return this.hit;
    }

    /**
     * @return Returns the world
     */
    public World getWorld(){return this.world;}

    /**
     * @return Returns the body of the food
     */
    public Body getBody(){return this.b2body;}

    /**
     * Verifies if the food is dead
     * @return true if dead, false if alive
     */
    public boolean isDead() {
        if (getHealth() == 0){
            this.world.destroyBody(this.b2body);
            return true;
        }
        return false;
    }

    /**
     * decreases the health of the food by 1
     */
    public void decreaseHealth() {   setHealth(getHealth()-1);  }

}
