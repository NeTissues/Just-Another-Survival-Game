package jogo;

import src.jplay.GameObject;
import src.jplay.TileInfo;

public class Controle {
	
	public boolean colisao(GameObject obj, TileInfo tile){
		if((tile.id!=01) && (tile.id!=03) && (tile.id!=32) && (tile.id!=31) && (tile.id!=05) && (tile.id!=34) && (tile.id!=06) && (tile.id!=42) && obj.collided(tile)){
			return true;
		}
		return false;
	}
}
/*numero depende de quantos tiles q n pode atravessar*/