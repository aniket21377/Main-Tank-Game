package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
public class resumeScreen7 implements Screen {

    final FireTank game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public resumeScreen7(final FireTank game) {
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
        game.font.draw(game.batch, "Resume", 350, 470);
        game.font.draw(game.batch, "Restart", 350, 450);
        game.font.draw(game.batch, "Press R to Resume", 30, 160);
        game.font.draw(game.batch, "Press N to start a new game!", 30, 140);
        game.font.draw(game.batch, "Press E to Exit Game", 30, 120);

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.R)){
            game.setScreen(new GameScreen9(game));
            dispose();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.N)){
            game.setScreen(new MainMenu(game));
            dispose();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)){
            game.setScreen(new Exit(game));
            dispose();

        }

        if (Gdx.input.isTouched()) {
            game.setScreen(new tank_selection(game));
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
