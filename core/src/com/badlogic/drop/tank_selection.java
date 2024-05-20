package com.badlogic.drop;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.ScreenUtils;
public class tank_selection implements Screen {

    final FireTank game;
    private Texture backgroundImage;
    Music musicMusic;
    Texture tank1Image;

    Texture tank3Image;

    Texture tank5Image;


    Rectangle tank1;
    Rectangle tank3;
    Rectangle tank5;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    public tank_selection(final FireTank game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("select.jpg"));
        tank1Image = new Texture(Gdx.files.internal("tank1.png"));
        tank3Image = new Texture(Gdx.files.internal("tank3.png"));
        tank5Image = new Texture(Gdx.files.internal("tank5.png"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        musicMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        musicMusic.setLooping(true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // create a Rectangle to logically represent the tank1
        tank1 = new Rectangle();
        tank1.x = 100; // center the tank1 horizontally
        tank1.y = 230; // bottom left corner of the tank1 is 20 pixels above
        // the bottom screen edge
        tank1.width = 220;
        tank1.height = 220;

        // create a Rectangle to logically represent the tank1
        tank3 = new Rectangle();
        tank3.x = 500; // center the tank1 horizontally
        tank3.y = 230; // bottom left corner of the tank1 is 20 pixels above
        // the bottom screen edge
        tank3.width = 220;
        tank3.height = 260;

        // create a Rectangle to logically represent the tank1
        tank5 = new Rectangle();
        tank5.x = 300; // center the tank1 horizontally
        tank5.y = 50; // bottom left corner of the tank1 is 20 pixels above
        // the bottom screen edge
        tank5.width = 220;
        tank5.height = 220;


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, 800, 480);
        game.font.draw(game.batch, "Player 1 Please Choose your Tank", 300, 480);

        game.font.draw(game.batch, "Press 1 to choose tank 1", 0, 60);
        game.font.draw(game.batch, "Press 2 to choose tank 2", 0, 40);
        game.font.draw(game.batch, "Press 3 to choose tank 3", 0, 20);
        game.font.draw(game.batch, "tank 1", 130, 215);
        game.font.draw(game.batch, "tank 2", 530, 215);
        game.font.draw(game.batch, "tank 3", 330, 35);
        game.batch.draw(tank1Image, tank1.x, tank1.y, tank1.width, tank1.height);
        game.batch.draw(tank3Image, tank3.x, tank3.y, tank3.width, tank3.height);
        game.batch.draw(tank5Image, tank5.x, tank5.y, tank5.width, tank5.height);
        game.batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            game.setScreen(new tank_selection_A(game));
            dispose();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            game.setScreen(new tank_selection_B(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            game.setScreen(new tank_selection_C(game));
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
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        musicMusic.play();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        musicMusic.dispose();
    }

}
