package br.jp.engine.examples.Spaceship;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import br.jp.engine.core.GameObject;
import br.jp.game.R;

public class BigBadRock extends GameObject {

	private int  pX = 0, pY = 16;
	
	public BigBadRock(Context context, int w, int h) {
		super(context, w, h);
		this.x = 0;
		this.y = HEIGHT;
	}

	@Override
	public void update(Canvas canvas, boolean isColliding) {
		if (!isColliding) {
			x = (canvas.getWidth()/2)-WIDTH;
			y += pY;
		} else x = (canvas.getWidth()/2)-WIDTH;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
				R.drawable.ball), x, y, null);
	}

}
