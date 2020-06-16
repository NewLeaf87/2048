import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entity.Tile;
import ui.MainPanel;


public class GameControl extends KeyAdapter {

	private MainPanel mainPanel;
	private Tile tile;
	
	public GameControl(MainPanel mainPanel, Tile tile) {
		this.mainPanel = mainPanel;
		this.tile = tile;
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		switch (e.getKeyCode()) {
		
		case 37: {
			int ismov = tile.moveLeft();
			int isremove = tile.removeLeft();
			if (ismov == 1 || isremove == 1) {
				// new block
				tile.newBlok();
			}
		}
			break;
		
		case 38: {
			int ismov = tile.moveUp();
			int isremove = tile.removeUp();
			if (ismov == 1 || isremove == 1) {
				// new block
				tile.newBlok();
			}
		}
			break;
		
		case 39: {
			int ismov = tile.moveRight();
			int isremove = tile.removeRight();
			if (ismov == 1 || isremove == 1) {
				// new block
				tile.newBlok();
			}
		}
			break;
		
		case 40: {
			int ismov = tile.moveDown();
			int isremove = tile.removeDown();
			if (ismov == 1 || isremove == 1) {
				// new block
				tile.newBlok();
			}
		}
			break;
		}
		
		
		this.mainPanel.repaint();
		
		
		tile.isGameOver();
	}
}