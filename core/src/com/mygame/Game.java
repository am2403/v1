package com.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Game extends ApplicationAdapter {

	static OrthographicCamera camera;
	static final float MAP_WIDTH = 320;	//Arbitrary units used instead of pixels to position things
	static final float MAP_HEIGHT = 318;
	Sprites sprite = new Sprites();
	int shipSpeed = 2;


	@Override
	public void create () {
		sprite.initiateSprites();

		float aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
		camera = new OrthographicCamera(MAP_WIDTH/2, MAP_HEIGHT/2);
		//To zoom out, remove the /2 above ^^^ on MAP_WIDTH AND MAP_HEIGHT
		camera.position.set(MAP_WIDTH/2, MAP_HEIGHT/2, 0);

	}


	@Override
	public void render () {

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			sprite.ship.translateY(shipSpeed);
			//sprite.maps.translateY(-shipSpeed);
			camera.translate(0, shipSpeed);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			sprite.ship.translateY(-shipSpeed);
			//sprite.maps.translateY(shipSpeed);
			camera.translate(0, -shipSpeed);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			sprite.ship.translateX(-shipSpeed);
			//sprite.maps.translateX(shipSpeed);
			camera.translate(-shipSpeed, 0);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			sprite.ship.translateX(shipSpeed);
			//sprite.maps.translateX(-shipSpeed);
			camera.translate(shipSpeed, 0);
		}

		sprite.clearScreen();
		sprite.draw();





	}
	
	@Override
	public void dispose () {

		sprite.dispose();
	}


}
