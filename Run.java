import entity.Grid;
import entity.Tile;
import ui.MainFrame;
import ui.MainPanel;

public class Run {

	public static void main(String[] args) {
		
		
		Grid grid = new Grid();
		
		
		Tile tile = new Tile(grid);
		
		
		MainFrame mainFrame = new MainFrame();
		
		
		MainPanel mainPanel = new MainPanel(grid, tile);
		
		
		GameControl gameControl = new GameControl(mainPanel, tile);
		
		
		mainFrame.setVisible(true);
		
		
		mainFrame.addKeyListener(gameControl);
		
		
		mainFrame.setContentPane(mainPanel);
		
	}
}