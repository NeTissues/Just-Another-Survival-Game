package jogo;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import src.jplay.GameObject;
import src.jplay.Scene;
import src.jplay.Sprite;
import src.jplay.TileInfo;

public class Ator extends Sprite implements ActionListener,MouseListener{
	
	

	protected int direcao = 3;
	double velocidade = 1;
	boolean movendo = false;
	
	
	
	Controle controle = new Controle();
	public double energia = 1000;
	
	
	
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
		
	}
	
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
				if(colisaoHorizontal((this), tile)){
					if(tile.x + tile.height - 2 < this.x){
						this.x = tile.x + tile.height;
						
					}
					
					else if(tile.x > this.x + this.height - 2){
						this.x = tile.x - tile.height;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
