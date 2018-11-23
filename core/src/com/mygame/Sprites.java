package com.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Sprites {
    SpriteBatch batch;
    //Texture mapTextures;
    Texture shipTexture;
    //Sprite maps;
    Sprite ship;
    public TiledMap map;
    private OrthogonalTiledMapRenderer renderer;



    public void initiateSprites(){
        batch = new SpriteBatch();

        //mapTextures = new Texture("map.png");
        //maps = new Sprite(mapTextures);
        //maps.setPosition(0,0);
        //maps.setSize(Game.MAP_WIDTH, Game.MAP_HEIGHT);



        shipTexture = new Texture("ship.png");
        ship = new Sprite(shipTexture);
        ship.setPosition(Game.MAP_WIDTH/2, Game.MAP_HEIGHT/2);
        ship.setSize(15,20);
        ship.setOrigin(ship.getWidth()/2, ship.getHeight()/2);

        map = new TmxMapLoader().load("Map/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    public void draw(){

        Game.camera.update();
        batch.begin();
        batch.setProjectionMatrix(Game.camera.combined);
        //maps.draw(batch);

        renderer.render();
        renderer.setView(Game.camera);

        renderer.getBatch().begin(); //Renders batches only
        ship.draw(renderer.getBatch());
        renderer.getBatch().end();

        batch.end();
    }

    public void clearScreen(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    public void dispose(){
        batch.dispose();
        //mapTextures.dispose();
        shipTexture.dispose();
        map.dispose();
        renderer.dispose();
    }



}
