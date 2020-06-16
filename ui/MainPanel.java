package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

import entity.Grid;
import entity.Images;
import entity.Score;
import entity.Score_Num;
import entity.Tile;


public class MainPanel extends JPanel{
	
	
	
	private MainFg mainFg;
	private Score score;
	private Score_Num scoreNum;
	private MainGame mainGame;
	private Grid grid;
	
	public MainPanel(Grid grid,Tile tile){
		this.grid = grid;
		this.mainFg = new MainFg(grid);
		this.score = new Score();
		this.mainGame = new MainGame(grid, tile);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		this.scoreNum = new Score_Num(grid);
		
		g.drawImage(Images.img_bg, 0, 0, null);
		
		
		this.mainFg.drawWin(g);
		
		
		this.score.drawScore(g);
		
		
		this.scoreNum.drawNum(g);
		
		
		this.mainGame.GamePaint(g);
		
	}
	
}