package com.badlogic.drop;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class GameScreen2 implements Screen {
    final FireTank game;
    Texture First_Missile ;
    Texture Second_Missile;
    Texture tank1Image;
    Texture tank2Image;

    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    Sound dropSound;
    Music Background_Sound;
    OrthographicCamera camera;
    Rectangle tank1;
    Rectangle tank2;

    Array<Rectangle> Missile ;
    Array<Rectangle> Missile2 ;
    long lastDropTime;

    int health1=100;
    int health2=100;

    public GameScreen2(final FireTank game) {
        this.game = game;
        First_Missile  = new Texture(Gdx.files.internal("Missile.png"));
        Second_Missile = new Texture(Gdx.files.internal("Missile2.png"));
        tank1Image = new Texture(Gdx.files.internal("tank1.png"));
        tank2Image = new Texture(Gdx.files.internal("tank4.png"));
        backgroundImage = new Texture(Gdx.files.internal("Mountain_Background.jpeg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1280, 800);
        Background_Sound = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        Background_Sound.setLooping(true);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);


        tank1 = new Rectangle();
        tank1.x = 800 / 2 - 64 / 2;
        tank1.y = 10;
        tank1.width = 140;
        tank1.height = 140;


        tank2 = new Rectangle();
        tank2.x = 800 / 2 - 64 / 2;
        tank2.y = 10;
        tank2.width = 180;
        tank2.height = 180;

        Missile  = new Array<Rectangle>();
        Missile2  = new Array<Rectangle>();
        Missile1();

        Missile2();
    }
    private void Missile1() {
        Rectangle Main_Missile = new Rectangle();
        Main_Missile.x = tank1.x+64;
        Main_Missile.y = tank1.y+120;
        Main_Missile.width = 10;
        Main_Missile.height = 10;
        Missile .add(Main_Missile);
        long now1=TimeUtils.nanoTime();
        lastDropTime =TimeUtils.nanosToMillis(now1);

    }

    private void Missile2() {
        Rectangle Main_Missile = new Rectangle();
        Main_Missile.x = tank2.x+64;
        Main_Missile.y = tank2.y+120;
        Main_Missile.width = 10;
        Main_Missile.height = 10;
        Missile2 .add(Main_Missile);
        long now2=TimeUtils.nanoTime();
        lastDropTime =TimeUtils.nanosToMillis(now2);

    }


    @Override
    public void render(float delta)  {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();


        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.font.draw(game.batch, "Total health: " + health1, 15, 478);
        game.batch.draw(tank1Image, tank1.x, tank1.y, tank1.width, tank1.height);
        game.font.draw(game.batch, "Total health: " + health2, 650, 478);
        game.batch.draw(tank2Image, tank2.x, tank2.y, tank2.width, tank2.height);
        game.font.draw(game.batch, "Press Esc to Pause", 350, 479);
        for (Rectangle Main_Missile : Missile ) {
            game.batch.draw(First_Missile , Main_Missile.x, Main_Missile.y);
        }
        for (Rectangle Main_Missile : Missile2 ) {
            game.batch.draw(Second_Missile, Main_Missile.x, Main_Missile.y);
        }
        game.batch.end();

        if (Gdx.input.isKeyPressed(Keys.ESCAPE)){
            game.setScreen(new resumeScreen(game));
            dispose();

        }
        if (Gdx.input.isKeyPressed(Keys.LEFT))
            tank1.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            tank1.x += 200 * Gdx.graphics.getDeltaTime();

        if (tank1.x < 0)
            tank1.x = 0;
        if (tank1.x > 800 - 64)
            tank1.x = 800 - 64;
        if (Gdx.input.isKeyPressed(Keys.UP))
            tank2.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            tank2.x += 200 * Gdx.graphics.getDeltaTime();

        if (tank2.x < 0)
            tank2.x = 0;
        if (tank2.x > 800 - 64)
            tank2.x = 800 - 64;



        if (tank1.x <=100) {
            tank1.y = 210;
        }
        if (100<tank1.x && tank1.x <200) {
            tank1.y = 210;
        }
        if (200<tank1.x && tank1.x <250) {
            tank1.y = 180;
        }
        if (250<tank1.x && tank1.x <=300) {
            tank1.y = 150;
        }
        if (300<tank1.x && tank1.x <= 350) {
            tank1.y = 120;
        }
        if (350<tank1.x && tank1.x <400) {
            tank1.y = 130;
        }
        if (400<tank1.x && tank1.x <450) {
            tank1.y = 160;
        }
        if (450<tank1.x && tank1.x <500) {
            tank1.y = 200;
        }
        if (500<tank1.x && tank1.x <600) {
            tank1.y = 250;
        }
        if (600<tank1.x && tank1.x <700) {
            tank1.y = 270;
        }
        if (700<tank1.x && tank1.x <800) {
            tank1.y = 280;
        }




        if (tank2.x <=100) {
            tank2.y = 210;
        }
        if (100<tank2.x && tank2.x <200) {
            tank2.y = 210;
        }
        if (200<tank2.x && tank2.x <250) {
            tank2.y = 160;
        }
        if (250<tank2.x && tank2.x <=300) {
            tank2.y = 140;
        }
        if (300<tank2.x && tank2.x <= 350) {
            tank2.y = 120;
        }
        if (350<tank2.x && tank2.x <400) {
            tank2.y = 130;
        }
        if (400<tank2.x && tank2.x <450) {
            tank2.y = 160;
        }
        if (450<tank2.x && tank2.x <500) {
            tank2.y = 200;
        }
        if (500<tank2.x && tank2.x <600) {
            tank2.y = 250;
        }
        if (600<tank2.x && tank2.x <700) {
            tank2.y = 270;
        }
        if (700<tank2.x && tank2.x <800) {
            tank2.y = 280;
        }

        if (Gdx.input.isKeyPressed(Keys.F))
            Missile1();
        if (Gdx.input.isKeyPressed(Keys.J))
            Missile2();

        Iterator<Rectangle> iter = Missile .iterator();

        while (iter.hasNext()) {
            Rectangle Main_Missile = iter.next();

            Main_Missile.x += 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(Main_Missile.x<=400 && Main_Missile.y<=480){

                Main_Missile.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);


            }

            if((Main_Missile.x>=400 && Main_Missile.y>=0)||(Main_Missile.y>=480) ){

                Main_Missile.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);


            }

            if (Main_Missile.x + 10 >800)
                iter.remove();
            if (Main_Missile.overlaps(tank2)) {
                health2=health2-10;
                iter.remove();

            }

        }



        Iterator<Rectangle> iter2 = Missile2 .iterator();

        while (iter2.hasNext()) {
            Rectangle Main_Missile = iter2.next();

            Main_Missile.x -= 50 * (Gdx.graphics.getDeltaTime()+0.01);
            if(Main_Missile.x>=400 && Main_Missile.y<=480){

                Main_Missile.y+=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);


            }

            if((Main_Missile.x<=400 && Main_Missile.y>=0)||(Main_Missile.y>=480) ){

                Main_Missile.y-=(50/(1.732))*(Gdx.graphics.getDeltaTime()+0.01);


            }

            if (Main_Missile.x + 10 >800)
                iter2.remove();
            if (Main_Missile.overlaps(tank1)) {
                health1=health1-10;
                iter2.remove();

            }
        }



    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

        Background_Sound.play();
    }



    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        First_Missile.dispose();
        Second_Missile.dispose();
        tank1Image.dispose();
        tank2Image.dispose();
        Background_Sound.dispose();
    }

}
