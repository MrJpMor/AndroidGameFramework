package br.jp.engine.core;

public class Collision {

	public static boolean isColliding(GameObject g1, GameObject g2){
		
		if (g1.dstX >= g2.x       && g1.dstY >= g2.y) return true;
		else if(g1.x <= g2.x+g2.WIDTH && g1.y+g1.HEIGHT >= g2.y) return true;
		else if(g1.x <= g2.dstX       && g1.y <= g2.dstY  ) return true;
		else if(g1.x+g1.WIDTH >= g2.x && g1.y <= g2.y+g2.HEIGHT) return true;
		else return false;
		
	}
	
}
