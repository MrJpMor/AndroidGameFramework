package br.jp.engine.examples.kickball;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import br.jp.engine.core.GameController;

public class KickController extends GameController {

	private Bola b;
	private Backgound bg;

	public KickController(Context context) {
		super(context);

		bg = new Backgound(context);
		b = new Bola(context, 200, 20);   

	}

	@Override
	public void updateObjs(Canvas canvas) {

		bg.update(canvas);
		b.update(canvas);

	}

	@Override
	public void drawObjs(Canvas canvas) {


		bg.draw(canvas);
		b.draw(canvas);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		b.touchedBall();
		
		return super.onTouchEvent(event);
	}


}
