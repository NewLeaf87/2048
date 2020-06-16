package ui;

import java.awt.Graphics;

import entity.Grid;
import entity.Images;
import entity.Tile;


public class MainGame {

	private static final int SIZE = 90;
	private int x;
	private int y;
	private Grid grid;
	private int[][] gameMap;

	public MainGame(Grid grid, Tile tile) {
		tile.newBlok();
		tile.newBlok();
		this.grid = grid;
		this.x = grid.getX();
		this.y = grid.getY();
	}

	
	public void GamePaint(Graphics g) {
		this.gameMap = grid.getMap();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				
				int gameindex = gameMap[i][j];
				
				if (gameindex != 0) {
					
					int dx1 = this.x + i * SIZE;
					int dy1 = this.y + j * SIZE;
					
					int dx2 = this.x + i * SIZE + SIZE;
					int dy2 = this.y + j * SIZE + SIZE;
					
					int sx1 = 0 + (gameindex - 1) * SIZE;
					int sy1 = 0;
					
					int sx2 = SIZE + (gameindex - 1) * SIZE;
					int sy2 = SIZE;
					

					g.drawImage(Images.img_2048, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
				}
			}
		}
	}
}