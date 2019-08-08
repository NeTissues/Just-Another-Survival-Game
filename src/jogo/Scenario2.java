package jogo;

import src.jplay.Keyboard;
import src.jplay.Scene;
import src.jplay.Window;

public class Scenario2 extends Scenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi[];
	
	public Scenario2(Window window){
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile("classRoom1.scn");
		jogador = new Jogador(140, 350);
		teclado = janela.getKeyboard();
		zumbi = new Zumbi[10];
		
		
		run();
		
	}
	
	private void run() {
		
		for (int i = 0; i < zumbi.length; i++) {
			zumbi[i] = new Zumbi(100 * i, 100 * i);
			zumbi[6] = new Zumbi(457 , 320);
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
			
			janela.update();
			
		}
	}
}