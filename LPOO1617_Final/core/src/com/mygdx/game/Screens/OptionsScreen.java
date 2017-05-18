package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.ButtonImg;
import com.mygdx.game.ChickenVsFood;

/**
 * Created by vitor on 02/05/2017.
 */

public class OptionsScreen implements Screen {
    private Stage stage;
    private ChickenVsFood game;
    private Viewport viewport;

    public OptionsScreen(final ChickenVsFood game){
        this.game = game;
        viewport = new FitViewport(ChickenVsFood.V_WIDTH,ChickenVsFood.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);

        Texture tex = new Texture("Fence.png");
        ButtonImg Music = new ButtonImg(tex,tex,tex);
        Music.setWidth(Gdx.graphics.getWidth()/3);
        Music.setPosition(200,2*ChickenVsFood.V_HEIGHT/3 + 40);
        Music.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
            }
        });
        stage.addActor(Music);

        Image music = new Image(new Texture("Relva1.png"));

        music.setWidth(100);
        music.setPosition(100,2*ChickenVsFood.V_HEIGHT/3 + 40);

        stage.addActor(music);

        Texture tex1 = new Texture("Fence.png");
        ButtonImg Sound = new ButtonImg(tex1,tex1,tex1);
        Sound.setWidth(Gdx.graphics.getWidth()/3);
        Sound.setPosition(200,ChickenVsFood.V_HEIGHT/2);
        Sound.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                game.setScreen(new OptionsScreen(game));
                dispose();
            }
        });
        stage.addActor(Sound);

        Image sound = new Image(new Texture("Relva2.png"));

        sound.setWidth(100);
        sound.setPosition(100,ChickenVsFood.V_HEIGHT/2);

        stage.addActor(sound);


        Texture tex2 = new Texture("Tree1.png");
        ButtonImg ExitButton = new ButtonImg(tex2,tex2,tex2);
        ExitButton.setWidth(Gdx.graphics.getWidth()/3);
        ExitButton.setPosition(200,ChickenVsFood.V_HEIGHT/3 - 40);
        ExitButton.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }
        });
        stage.addActor(ExitButton);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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