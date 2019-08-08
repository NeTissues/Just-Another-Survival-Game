package jogo;

import src.jplay.Window;
import src.jplay.Keyboard;
import src.jplay.Scene;

public class Cenario3 extends Scenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi[];
	
	public Cenario3(src.jplay.Window janela2){
		
		janela = janela2;
		cena = new Scene();
		cena.loadFromFile("Cenario3.scn");
		jogador = new Jogador(140, 350);
		teclado = janela.getKeyboard();
		zumbi = new Zumbi[6];
		
		
		run();
		
	}
	
	private void run() {
		
		for (int i = 0; i < zumbi.length; i++) {
			zumbi[i] = new Zumbi(100 * i, 100 * i);
		}
		
		while(true){
			//cena.draw();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			
			
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			for (int i = 0; i < zumbi.length; i++) {
				
			zumbi[i].x += cena.getXOffset();
			zumbi[i].y += cena.getYOffset();	
			zumbi[i].morrer();
			zumbi[i].atacar(jogador);
			zumbi[i].caminho(cena);
			zumbi[i].perseguir(jogador.x, jogador.y);
			zumbi[i].draw();
			jogador.atirar(janela, cena, teclado, zumbi[i]);
			}
			
			
			jogador.energia(janela);
			
			jogador.draw();
			
			janela.delay(1);
			janela.update();
			
            changeScenario();
			
		}
	}
	
	private void changeScenario(){
		if(tileCollision(8, jogador, cena)==true){
			new Scenario2(janela);
		}
	}
}