package jogo;

import src.jplay.GameImage;
import src.jplay.Keyboard;
import src.jplay.Window;
import java.util.concurrent.TimeUnit;

public class Zumbi extends Ator{

	private double ataque = 1;
	double velocidade = 2;

	public Zumbi(int x, int y) {
		super("Zumbi.png", 16);
		this.x = x;
		this.y = y;
		this.setTotalDuration(2000);
		this.velocidade = 0.1;
		
	}

	public void perseguir(double x, double y){
		
		if(this.x > x && this.y <= y + 50 && this.y >= y - 50){
			moveTo(x, y, velocidade);
			if(direcao != 1){
				setSequence(5, 8);
				direcao = 1;
			}
			movendo = true;
		}
		
		else if(this.x < x && this.y <= y + 50 && this.y >= - 50){
			moveTo(x, y, velocidade);
			if(direcao != 2){
				setSequence(9, 12);
				direcao = 2;
			}
			movendo = true;
			
		}
		
		else if(this.y > y){
			moveTo(x, y, velocidade);
			if(direcao != 4){
				setSequence(13, 16);
				direcao = 4;
			}
			movendo = true;
		}
		
		else if(this.y < y){
			moveTo(x, y, velocidade);
			moveTo(x, y, velocidade);
			if(direcao != 5){
				setSequence(1, 4);
				direcao = 5;
		}
			movendo = true;
	}
		if(movendo){
			update();
			movendo = false;
		}
}

	public void morrer() {
		if(this.energia <= 0){
			this.velocidade = 0;
			this.ataque = 0;
			this.direcao = 0;
			this.movendo = false;
			this.x = 1_000_000;
			}
		}
	
	public void atacar(Jogador jogador){
		if(this.collided(jogador)){
			Jogador.energia -= this.ataque ;
		}
		
		if(Jogador.energia <= 0){

			System.exit(0);
			
			
		}
		
	}
}
