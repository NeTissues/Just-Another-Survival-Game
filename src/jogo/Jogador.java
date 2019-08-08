package jogo;

import src.jplay.TileInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Vector;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import src.jplay.GameObject;
import src.jplay.Keyboard;
import src.jplay.Scene;
import src.jplay.Window;

public class Jogador extends Ator{
	
	static double energia = 4000;
	private double stamina = 100;
	
	//private double velocidade = 1;
	//private int direcao = 3;
	private Keyboard teclado;
	private boolean movendo = false;
	
	public String mouse = "No input yet"; 
	
	public Jogador(int x, int y) {
		super("fs.png", 20);
		this.x = x;
		this.y = y;
		
		
		this.setTotalDuration(2000);
	}
	ControleTiros tiros = new ControleTiros();
	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo){
		
		if(teclado.keyDown(KeyEvent.VK_A)){
			tiros.adicionaTiro(x, y, direcao, cena);
		}
		tiros.run(inimigo);
	}
	
	
	
	public void controle(Window janela, Keyboard teclado){
		/*if(teclado == null){
			teclado = janela.getKeyboard();
		} removido?*/
		
		if(teclado.keyDown(Keyboard.LEFT_KEY)){
			if(this.x > 0)
				//correr();
				this.x -= velocidade;
			if(direcao != 1){
				setSequence(4, 8);
				direcao = 1;
			}movendo = true;
		}else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
			if(this.x < janela.getWidth() - 60)
				//correr();
				this.x += velocidade;
			if(direcao != 2){
				setSequence(8, 12);
				direcao = 2;
			}movendo = true;
			
		}else if(teclado.keyDown(Keyboard.UP_KEY)){
			if(this.y > 0)
				//correr();
				this.y -= velocidade;
			if(direcao != 4){
				setSequence(12, 16);
				direcao = 4;
			}movendo = true;
			
		}else if(teclado.keyDown(Keyboard.DOWN_KEY)){
			if(this.y < janela.getHeight() - 60)
				//correr();
				this.y += velocidade;
			if(direcao != 5){
				setSequence(0, 4);
				direcao = 5;
			}movendo = true;	
		}
		
		if(movendo){
			update();
			movendo = false;
		}
		
	}
	
	Font f = new Font("arial", Font.BOLD, 30);
	public void energia(Window janela){
		janela.drawText("	HP:" + Jogador.energia, 30, 30, Color.GREEN, f);
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "x: " + xpos + " y: " + ypos;
		janela.drawText(mouse , 30, 60, Color.RED, f);
		//update();
	}
	
	Controle controle = new Controle();
	/*
	 * Controle do caminho percorrido para o personagem nao ultrapassar os bloqueios
	 * */
	public void caminho(Scene cena) {
		Point min = new Point((int)this.x, (int)this.y);
		Point max = new Point((int)this.x + this.width, (int)this.y + this.height);
		
		Vector<?>tiles = cena.getTilesFromPosition(min, max);
		
		for (int i = 0; i < tiles.size(); i++){
			TileInfo tile = (TileInfo)tiles.elementAt(i);
			
			if(controle.colisao(this, tile)==true){
				if(colisaoVertical(this, tile)){
				if(tile.y + tile.height - 2 < this.y){
					this.y = tile.y + tile.height;
					
				}
				
				else if(tile.y > this.y + this.height - 2){
					this.y = tile.y - this.height;
				}
				
			}
				if(colisaoHorizontal(this, tile)){
					if(tile.x + tile.height - 2 < this.x){
						this.x = tile.x + tile.width;
						
					}
					
					else if(tile.x > this.x + this.width - 2){
						this.x = tile.x - tile.width;
					}
				}
				
			}
		}
		
	}
	
	private boolean colisaoVertical(GameObject obj , GameObject obj2){
		if(obj2.x + obj2.width <= obj.x)
			return false;
		if(obj.x + obj.width <= obj2.x) 
				return false;
		return true;
	}
	
	private boolean colisaoHorizontal(GameObject obj , GameObject obj2){
		if(obj2.y + obj2.width <= obj.y)
			return false;
		if(obj.y + obj.width <= obj2.y)
				return false;
		return true;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Font f = new Font("arial", Font.BOLD, 30);
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "x: " + xpos + " y: " + ypos;
		update();
		
		//g.drawString(mouse , 30, 60);
	}
	
	// Ainda não Funciona
	
	/*public boolean correr(){
		if(teclado.keyDown(Keyboard.SPACE_KEY)){
			for (int stamina = 100; stamina >= 0 ; stamina--) {
				velocidade = 2;
				return true;
			}
		}
		return movendo;
	*/
	}
	
	
	
	
	

