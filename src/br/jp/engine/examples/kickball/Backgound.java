package br.jp.engine.examples.kickball;

import br.jp.engine.core.GameObject;
import br.jp.game.R;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Backgound extends GameObject {

	private Rect src,dst;

	private int nRows=2, nCols=3;
	private int wFrame=64,hFrame=64;
	private int curCol=0,curRow=0;

	public Backgound(Context context) {
		super(context,540,960);

		src = new Rect(0, 0, 540, 960);
		dst = new Rect(0, 0, 540, 960);

	}

	@Override
	public void update(Canvas canvas) {
		if (clickEffect<0) {
			setFrame();
		}
	}

	@Override
	public void draw(Canvas canvas) {

		src = new Rect(0, 0, WIDTH, HEIGHT);
		dst = new Rect(0, 0, canvas.getWidth(),canvas.getHeight());


		if (clickEffect>0) {
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
					R.drawable.backgound_a), src, dst, null);
		} 
		if(clickEffect<0 && curCol>=nCols && curRow>=nRows){
			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
					R.drawable.backgound_b), src, dst, null);
		}
		if (clickEffect<0 && curCol<=nCols && curRow<=nRows) {

			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
					R.drawable.backgound_a), src, dst, null);
			
			int l = curCol*wFrame;
			int t = curRow*hFrame;
			int r = l+wFrame;
			int b = t+hFrame;

			src = new Rect(l, t, r, b);
			dst = new Rect((canvas.getWidth()/2)-WIDTH, (canvas.getHeight()/2)-HEIGHT, (canvas.getWidth()/2)+WIDTH,(canvas.getHeight()/2)+HEIGHT);

			canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 
					R.drawable.warp_effect), src, dst, null);
			
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		dst = new Rect(0, 0, w, h);

	}

	private void setFrame(){
		curCol++;
		if (curCol>=nCols) {
			curCol=0;
			curRow++;
			if (curRow>=nRows) {
				curRow=0;
			}
		}
	}

}
