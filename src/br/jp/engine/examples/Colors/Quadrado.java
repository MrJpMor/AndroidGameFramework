package br.jp.engine.examples.Colors;

import br.jp.engine.core.GameObject;
import br.jp.game.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Quadrado extends GameObject {

	private Bitmap image;
	private Rect src,dst;

	private int nRows = 2;
	private int nCols = 2;
	private int wFrame = 50;
	private int hFrame = 50;
	private int curRow = 0;
	private int curCol = 0;

	private int wait,hMuch=5;

	public Quadrado(Context context) {
		super(context,540,960);

		image = BitmapFactory.decodeResource(getResources(), R.drawable.quadros);

		this.x = 0;
		this.y = 0;

	}

	@Override
	public void update(Canvas canvas) {

		wait++;

		if (wait>=hMuch) {
			wait=0;
			hMuch = 5;
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

	@Override
	public void draw(Canvas canvas) {

		int l = curCol*wFrame;
		int t = curRow*hFrame;
		int r = l+wFrame;
		int b = t+hFrame;

		src = new Rect(l, t, r, b);
		dst = new Rect( 0, 0, WIDTH,HEIGHT);

		canvas.drawBitmap(image, src, dst, null);

	}

	public void setWait(int wait) {
		hMuch = 30;
		this.wait = wait;
	}

}
