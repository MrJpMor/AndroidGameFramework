package br.jp.engine.examples.Spaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.Toast;
import br.jp.engine.core.Animation;
import br.jp.engine.core.GameObject;
import br.jp.engine.core.Animation.ANIMATION_STYLE;
import br.jp.game.R;

public class Spaceship extends GameObject {

	private Bitmap image;
	private Animation animation;

	private int  pX = 0, pY = 0;

	public Spaceship(Context context, int w, int h) {
		super(context, w, h);

		animation = new Animation(3, 4, 32, 32, ANIMATION_STYLE.MULTI_DIR);

		this.x = 0;
		this.y = 0;
		this.pX = 16;
		this.pY = 16;

	}

	@Override
	public void update(Canvas canvas, boolean isColliding) {

		x = (canvas.getWidth()/2)-WIDTH;
		y = canvas.getHeight()-HEIGHT;
		if (isColliding) {
			Log.i("COLLISION", "Collided");
		}

	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
				R.drawable.ball), x, y, null);
	}

}
