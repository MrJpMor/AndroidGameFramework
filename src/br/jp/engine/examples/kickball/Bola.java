package br.jp.engine.examples.kickball;

import br.jp.engine.core.GameObject;
import br.jp.game.R;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bola extends GameObject {

	private int  pX = 0, pY = 0;

	public Bola(Context context, int x, int y) {
		super(context,96,96);

		this.x = y;
		this.y = y;
		this.pX = 15;
		this.pY = 15;

	}

	@Override
	public void update(Canvas canvas) {

		if (x>=(canvas.getWidth()-WIDTH) || x<=0) {
			pX = -pX;
		}
		if (y>=(canvas.getHeight()-HEIGHT) || y<=0) {
			pY = -pY;
		}

		if(x+pX>canvas.getWidth()-WIDTH) x = canvas.getWidth()-WIDTH;
		else x += pX;
		if(y+pY>canvas.getHeight()) y = canvas.getHeight()-HEIGHT;
		else y += pY;

	}

	@Override
	public void draw(Canvas canvas) {
	
		Rect src = new Rect(0, 0, 64, 64);
		Rect dst = new Rect(x, y, (x+WIDTH), (y+HEIGHT));
		
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
				R.drawable.ball), src, dst, null);

	}

	private void invertY(){
		pY *= -1;
	}

	public void touchedBall(float touchX, float touchY){
		if(( touchX >= x)&&
				(touchX <= (x+WIDTH)) ){

			if(( touchY >= y)&&
					(touchY <= (y+HEIGHT)) ){
				invertY();
				System.out.println("!!!!!inverted!!!!!!!");
			}

		}
	}
	
	public void touchedBall(){
		
		invertY();
		
	}

}
