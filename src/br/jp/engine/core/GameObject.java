package br.jp.engine.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public abstract class GameObject extends View {

	protected int x, y, dstX, dstY;
	protected final int WIDTH, HEIGHT;
	public int clickEffect = 1;
	
	public GameObject(Context context, int w, int h) {
		super(context);
		WIDTH = w;
		HEIGHT = h;
		dstX = x+WIDTH;
		dstY = y+HEIGHT;
	}
	public void update(Canvas canvas) {
	}
	public void update(Canvas canvas, boolean isColliding) {
	}
	public abstract void draw(Canvas canvas);
	public int getDstX() {
		return dstX;
	}
	public int getDstY() {
		return dstY;
	}
	public int getWIDTH() {
		return WIDTH;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public int getObjX() {
		return x;
	}
	public int getObjY() {
		return y;
	}
	
}
