package br.jp.engine.examples.reverse;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import br.jp.engine.core.GameController;
import br.jp.engine.examples.kickball.Backgound;
import br.jp.game.R;

public class ReverseController extends GameController {


//	private Quadrado qd;
	private Backgound bg;
	private Character chr;
	
	private MediaPlayer mp;

	public ReverseController(Context context) {
		super(context);
		
//		qd = new Quadrado(context);
		bg = new Backgound(context);
		chr = new Character(context);
			
	}

	@Override
	public void updateObjs(Canvas canvas) {

//		qd.update(canvas);
		bg.update(canvas);
		chr.update(canvas);
		
	}

	@Override
	public void drawObjs(Canvas canvas) {

		
		bg.draw(canvas);
//		qd.draw(canvas);
		chr.draw(canvas);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

//		System.out.println("touch event on X:" + event.getX() + " Y: " + event.getY());
//		qd.setWait(0);
		chr.clickEffect *= -1;
		bg.clickEffect *= -1;
		mp = MediaPlayer.create(getContext(), R.raw.test_sound);
		mp.start();
//		Toast.makeText(getContext(), "!!Reverse!!", Toast.LENGTH_SHORT).show();
		
		return super.onTouchEvent(event);
	}
	

}
