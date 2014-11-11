package br.jp.engine.examples.Spaceship;

import android.content.Context;
import android.graphics.Canvas;
import br.jp.engine.core.Collision;
import br.jp.engine.core.GameController;

public class SpaceController extends GameController {

	private Spaceship ship;
	private BigBadRock rock;
	private Backgound bg;
	
	public SpaceController(Context context) {
		super(context);
		
		ship = new Spaceship(context, 128, 128);
		rock = new BigBadRock(context, 128, 128);
		bg = new Backgound(context);
		
	}

	@Override
	public void updateObjs(Canvas canvas) {

		bg.update(canvas);
		rock.update(canvas,Collision.isColliding(rock, ship));
		ship.update(canvas,Collision.isColliding(rock, ship));
		
	}

	@Override
	public void drawObjs(Canvas canvas) {

		bg.draw(canvas);
		rock.draw(canvas);
		ship.draw(canvas);
		
	}

}
