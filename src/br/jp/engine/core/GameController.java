package br.jp.engine.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class GameController extends SurfaceView implements Runnable {
	
	private Thread thread;
	private boolean isRunning = false;
	private SurfaceHolder holder;
	
	public GameController(Context context) {
		super(context);
		holder = getHolder();
	}
	public abstract void updateObjs(Canvas canvas);
	public abstract void drawObjs(Canvas canvas);
	
	@Override
	public void run() {
		while(isRunning){
			
			if (!holder.getSurface().isValid()) continue;
				
			Canvas canvas = holder.lockCanvas();
			
			updateObjs(canvas);
			drawObjs(canvas);
			
			holder.unlockCanvasAndPost(canvas);

		}
	}
	 
	
	public void resume(){
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public void pause(){
		isRunning = false;
	}
	
	public void stop(){
		isRunning = false;
	}
	
	
	
}
