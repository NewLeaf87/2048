package entity;

import java.util.Random;

import javax.swing.JOptionPane;


public class Tile {

	private int num;
	private Random random;
	private Grid grid;
	private int[][] map;
	
	
	public Tile(Grid grid) {
		this.random = new Random();
		this.grid = grid;
		this.map = grid.getMap();
		this.num = grid.getNum();
	}

	
	public int getMapId() {
		int x = random.nextInt(4);
		return x;
	}

	
	public int getGameNum() {
		int x = random.nextInt(2) + 1;
		return x;
	}

	
	public void newBlok() {
		int x = getMapId();
		int y = getMapId();
		while (map[x][y] != 0) {
			x = getMapId();
			y = getMapId();
		}
		
		map[x][y] = getGameNum();
		this.grid.setMap(map);
	}

	
	public boolean isFull() {
		int index = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] != 0) {
					index++;
				}
			}
		}
		if (index == 16 && !canRemove()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canRemove() {
		boolean canRemove = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == map[i + 1][j]
						|| map[i][j] == map[i][j + 1]) {
					canRemove = true;
				}
			}
		}
		return canRemove;
	}

	
	public void isGameOver() {
		if (isFull()) {
			JOptionPane.showMessageDialog(null, "GameOver!：" + this.grid.getNum());
		} else if (is2048()) {
			JOptionPane.showMessageDialog(null, "!！2048 ");
		}
	}

	
	public boolean is2048() {
		boolean isok = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 11) {
					isok = true;
				}
			}
		}
		return isok;
	}

	
	public int moveLeft() {
		int ismov = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i < 4; i++) {
				int mov_i = i;
				int mov_j = j;
				while (map[mov_i][mov_j] != 0
						&& map[mov_i - 1][mov_j] == 0) {
					map[mov_i - 1][mov_j] = map[mov_i][mov_j];
					map[mov_i][mov_j] = 0;
					if (mov_i > 1) {
						mov_i--;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	
	public int moveRight() {
		int ismov = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 2; i >= 0; i--) {
				int mov_i = i;
				int mov_j = j;
				while (map[mov_i][mov_j] != 0
						&& map[mov_i + 1][mov_j] == 0) {
					map[mov_i + 1][mov_j] = map[mov_i][mov_j];
					map[mov_i][mov_j] = 0;
					if (mov_i < 2) {
						mov_i++;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	
	public int moveDown() {
		int ismov = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j >= 0; j--) {
				int mov_i = i;
				int mov_j = j;
				while (map[mov_i][mov_j] != 0
						&& map[mov_i][mov_j + 1] == 0) {
					map[mov_i][mov_j + 1] = map[mov_i][mov_j];
					map[mov_i][mov_j] = 0;
					if (mov_j < 2) {
						mov_j++;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	
	public int moveUp() {
		int ismov = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 4; j++) {
				int mov_i = i;
				int mov_j = j;
				while (map[mov_i][mov_j] != 0
						&& map[mov_i][mov_j - 1] == 0) {
					map[mov_i][mov_j - 1] = map[mov_i][mov_j];
					map[mov_i][mov_j] = 0;
					if (mov_j > 1) {
						mov_j--;
					}
					ismov = 1;
				}
			}
		}
		return ismov;
	}

	
	public int removeLeft() {
		int isremove = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				while (map[i][j] == map[i + 1][j]
						&& map[i][j] != 11 && map[i][j] != 0) {
					map[i][j] = map[i + 1][j] + 1;
					map[i + 1][j] = 0;
					
					this.num++;
					this.grid.setNum(num);
					isremove = 1;
				}
			}
		}
		moveLeft();
		return isremove;
	}

	
	public int removeRight() {
		int isremove = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 3; i > 0; i--) {
				while (map[i][j] == map[i - 1][j]
						&& map[i][j] != 11 && map[i][j] != 0) {
					map[i][j] = map[i - 1][j] + 1;
					map[i - 1][j] = 0;
					
					this.num++;
					this.grid.setNum(num);
					isremove = 1;
				}
			}
		}
		moveRight();
		return isremove;
	}

	
	public int removeUp() {
		int isremove = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				while (map[i][j] == map[i][j + 1]
						&& map[i][j] != 11 && map[i][j] != 0) {
					map[i][j] = map[i][j + 1] + 1;
					map[i][j + 1] = 0;
					
					this.num++;
					this.grid.setNum(num);
					isremove = 1;
				}
			}
		}
		moveUp();
		return isremove;
	}

	
	public int removeDown() {
		int isremove = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j > 0; j--) {
				while (map[i][j] == map[i][j - 1] && map[i][j] != 11 && map[i][j] != 0) {
					map[i][j] = map[i][j - 1] + 1;
					map[i][j - 1] = 0;
					
					this.num++;
					this.grid.setNum(num);
					isremove = 1;
				}
			}
		}
		moveDown();
		return isremove;
	}
}