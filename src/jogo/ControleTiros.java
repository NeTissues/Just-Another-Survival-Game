package jogo;

import java.util.LinkedList;

import src.jplay.Scene;
import src.jplay.Sound;

public class ControleTiros {
		
	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adicionaTiro(double x, double y, int caminho , Scene cena){
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		somDisparo();
	}
	
	public void run(Ator inimigo){
		for(int i = 0; i < tiros.size(); i++){
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)){
				tiro.x = 1_000_000_000;
				inimigo.energia -= 250;
			}
			
		}
	}
	
	private void somDisparo(){
		new Sound("flecha.wav").play();
	}
	}
