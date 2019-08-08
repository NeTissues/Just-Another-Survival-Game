package jogo;



import src.jplay.GameImage;
import src.jplay.Keyboard;

import src.jplay.Window;
import org.lwjgl.input.Mouse;

public class Main {

	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		GameImage plano = new GameImage("tela inicio.png");
		Keyboard teclado = janela.getKeyboard();
		
		
		while(true){
			plano.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)){
				new Cenario3(janela);
			}
		}

	}

}
