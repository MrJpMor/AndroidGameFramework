package br.jp.engine.examples.reverse;

import br.jp.engine.core.Animation;
import br.jp.engine.core.Animation.ANIMATION_STYLE;
import br.jp.engine.core.GameObject;
import br.jp.game.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Character extends GameObject {

	private Bitmap image;
	private Animation animation;

	private int  pX = 0, pY = 0;
	
	public Character(Context context) {
		super(context,128,128);
		
		animation = new Animation(3, 4, 32, 32, ANIMATION_STYLE.MULTI_DIR);
		
		this.x = 0;
		this.y = 0;
		this.pX = 16;
		this.pY = 16;

	}

	@Override
	public void update(Canvas canvas) {

		int curDir=0;
		
		if (x>=(canvas.getWidth()-WIDTH)) {
			curDir=1;
			y += pY*clickEffect;
			if(y>(canvas.getHeight()-HEIGHT)) y=(canvas.getHeight()-HEIGHT);
			if(x<0) x = 0;
		}
		if (y>=(canvas.getHeight()-HEIGHT)) {
			curDir=2;
			x += -pX*clickEffect;
			if(x>(canvas.getWidth()-WIDTH)) x=(canvas.getWidth()-WIDTH);
			if(y<0) y = 0;
		}
		if (x<=0) {
			curDir=3;
			y += -pY*clickEffect;
			if(y<0) y = 0;
			if(x>(canvas.getWidth()-WIDTH)) x=(canvas.getWidth()-WIDTH);
		}
		if (y<=0){
			curDir=0;
			x += pX*clickEffect;
			if(x<0) x = 0;
			if(y>(canvas.getHeight()-HEIGHT)) y=(canvas.getHeight()-HEIGHT);
		}

		dstX = x+WIDTH;
		dstY = y+HEIGHT;
		
		animation.setFrame(curDir, x, y, dstX, dstY);

	}

	@Override
	public void draw(Canvas canvas) {
		
		if (clickEffect>0) {
			image = BitmapFactory.decodeResource(getResources(), R.drawable.character_a);
		} else {
			image = BitmapFactory.decodeResource(getResources(), R.drawable.character_b);
		}

		canvas.drawBitmap(image, animation.src, animation.dst, null);

	}

}
