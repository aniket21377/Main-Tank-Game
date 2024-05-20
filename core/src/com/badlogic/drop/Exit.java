package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
public class Exit implements Screen {

    final FireTank game;
    private Texture backgroundImage;

    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public Exit(final FireTank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("main.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 800, 450);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.font.draw(game.batch, "Exit Game", 300, 470);
        game.font.draw(game.batch, "If you really want to exit game press Y?", 300, 450);
        game.font.draw(game.batch, "If you don't want to exit game press press N?", 300, 410);


        game.batch.end();


        if (Gdx.input.isKeyPressed(Input.Keys.Y)){
            Gdx.app.exit();
            System.exit(0);
            dispose();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.N)){
            game.setScreen(new MainMenu(game));
            dispose();
            dispose();

        }
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
