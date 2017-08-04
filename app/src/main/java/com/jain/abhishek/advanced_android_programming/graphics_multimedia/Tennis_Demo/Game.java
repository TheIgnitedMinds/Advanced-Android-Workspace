package com.jain.abhishek.advanced_android_programming.graphics_multimedia.Tennis_Demo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.jain.abhishek.advanced_android_programming.R;


public class Game {

	private enum State {
		PAUSED, WON, LOST, RUNNING
	}
	
	private SoundPool soundPool;

	private State state = State.PAUSED;

	private SurfaceHolder holder;
	private Resources resources;

	private Ball ball;
	private Bat player;
	private Bat opponent;

	private Paint textPaint;
	private Context context;
	
	private int[] sounds = new int[5];

	public Game(Context context, int width, int height, SurfaceHolder holder, Resources resources) {
		this.holder = holder;
		this.resources = resources;
		this.context = context;
		
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

		ball = new Ball(width, height);
		player = new Bat(width, height, Bat.Position.LEFT);
		opponent = new Bat(width, height, Bat.Position.RIGHT);

		textPaint = new Paint();
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setAntiAlias(true);
		textPaint.setColor(Color.BLUE);
		textPaint.setTextSize(20);
		textPaint.setTypeface(Typeface.DEFAULT_BOLD);
	}

	public void init() {

		Bitmap ballImage = BitmapFactory.decodeResource(resources,
				R.drawable.button);
		Bitmap ballShadow = BitmapFactory.decodeResource(resources,
				R.drawable.buttonshadow);

		Bitmap batImage = BitmapFactory.decodeResource(resources,
				R.drawable.bat);
		Bitmap batShadow = BitmapFactory.decodeResource(resources,
				R.drawable.batshadow);

		ball.init(ballImage, ballShadow, -3, 0);
		player.init(batImage, batShadow, -3, 0);
		opponent.init(batImage, batShadow, -3, 0);
		
		sounds[Sounds.START] = soundPool.load(context, R.raw.start, 1);
		sounds[Sounds.WIN] = soundPool.load(context, R.raw.win, 1);
		sounds[Sounds.LOSE] = soundPool.load(context, R.raw.lose, 1);
		sounds[Sounds.BOUNCE1] = soundPool.load(context, R.raw.bounce1, 1);
		sounds[Sounds.BOUNCE2] = soundPool.load(context, R.raw.bounce2, 1);
		
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
				if(sounds[Sounds.START] == sampleId) {
					soundPool.play(sampleId, 1, 1, 1, 0, 1);
				}
			}
		});
	}

	public void update(long elapsed) {
		if (state == State.RUNNING) {
			updateGame(elapsed);
		}
	}
	
	private void initObjectPositions() {
		ball.initPosition();
		player.initPosition();
		opponent.initPosition();
	}

	private void updateGame(long elapsed) {
		if (player.getScreenRect().contains(ball.getScreenRect().left,
				ball.getScreenRect().centerY())) {
			ball.moveRight();
			soundPool.play(sounds[Sounds.BOUNCE1], 1, 1, 1, 0, 1);
		} else if (opponent.getScreenRect().contains(
				ball.getScreenRect().right, ball.getScreenRect().centerY())) {
			ball.moveLeft();
			soundPool.play(sounds[Sounds.BOUNCE2], 1, 1, 1, 0, 1);
		} else if (ball.getScreenRect().left < player.getScreenRect().right) {
			state = State.LOST;
			soundPool.play(sounds[Sounds.LOSE], 1, 1, 1, 0, 1);
			initObjectPositions();
		} else if (ball.getScreenRect().right > opponent.getScreenRect().left) {
			state = State.WON;
			soundPool.play(sounds[Sounds.WIN], 1, 1, 1, 0, 1);
			initObjectPositions();
		}

		ball.update(elapsed);
		opponent.update(elapsed, ball);
	}

	private void drawText(Canvas canvas, String text) {
		canvas.drawText(text, canvas.getWidth() / 2, canvas.getHeight() / 2,
				textPaint);
	}

	public void draw() {

		Canvas canvas = holder.lockCanvas();

		if (canvas != null) {
			canvas.drawColor(Color.WHITE);

			switch (state) {
			case LOST:
				drawText(canvas, "You lost :(");
				break;
			case PAUSED:
				drawText(canvas, "Tap screen to start ...");
				break;
			case RUNNING:
				drawGame(canvas);
				break;
			case WON:
				drawText(canvas, "You won!");
				break;
			}

			holder.unlockCanvasAndPost(canvas);
		}
	}

	private void drawGame(Canvas canvas) {
		ball.draw(canvas);
		player.draw(canvas);
		opponent.draw(canvas);
	}

	public void onTouchEvent(MotionEvent event) {

		if (state == State.RUNNING) {
			player.setPosition(event.getY());
		}
		else {
			state = State.RUNNING;
		}		
	}

}
