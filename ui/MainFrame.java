package ui;

import javax.swing.JFrame;
	
public class MainFrame extends JFrame{

	int aW = 1280;
	int aH = 800;

	public MainFrame(){
		this.setTitle("LDM 2048");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize( aW + 5, aH + 28);
		this.setLocationRelativeTo(null);
	}
}