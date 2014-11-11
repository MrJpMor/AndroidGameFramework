package br.jp.engine.core;

import android.graphics.Rect;

public class Animation {

//	public Bitmap sourceImage, curFrameImage;
	public Rect src,dst;
	
	private int nCols, nRows;
	private int wFrame, hFrame;
	private int curRow, curCol;
	private int curDir;
	
	private ANIMATION_STYLE style;
	
	public enum ANIMATION_STYLE{
		MONO_DIR, MULTI_DIR
	}
	public enum LOOP_ORDER{
		REGULAR, REVERSED
	}

	public Animation(int nCols, int nRows, int wFrame,
			int hFrame, ANIMATION_STYLE style) {
		super();
		this.nCols = nCols;
		this.nRows = nRows;
		this.wFrame = wFrame;
		this.hFrame = hFrame;
		this.style = style;
	}
	 
	
	public void setFrame(int curDir, int x, int y, int dstX, int dstY){

		switch (curDir) {
		case 0:
			curRow=2;
			curCol++;
			if (curCol>=nCols) {
				curCol=0;
			}
			break;
		case 1:
			curRow=0;
			curCol++;
			if (curCol>=nCols) {
				curCol=0;
			}
			break;
		case 2:
			curRow=1;
			curCol++;
			if (curCol>=nCols) {
				curCol=0;
			}
			break;
		case 3:
			curRow=3;
			curCol++;
			if (curCol>=nCols) {
				curCol=0;
			}
			break;

		default:
			break;
		}
		
		int l = curCol*wFrame;
		int t = curRow*hFrame;
		int r = l+wFrame;
		int b = t+hFrame;

		src = new Rect(l, t, r, b);
		dst = new Rect( x, y, dstX,dstY);

	}

	
	
	
}
