package gameoflife;

import java.util.Random;

public class World {

	private int[][] world;

	public World(int width, int length) {
		world = new int[width][length];
	}

	public void setCell(int x, int y, int value) {
		if (value != 0 && value != 1) {
			throw new IllegalArgumentException();
		}
		world[x][y] = value;
	}

	public int getCell(int x, int y) {
		return world[x][y];
	}

	public void populate(int density) {
		for (int x = 0; x < world.length; x++) {
			for (int y = 0; y < world[0].length; y++) {
				Random random = new Random();
				int probability = random.nextInt(100);
				if (probability < density) {
					world[x][y] = 1;
				}
			}
		}
	}

	public void nextGeneration() {
		int[][] nextGen = new int[getWorldWidth()][getWorldLength()];
		for (int x = 0; x < world.length; x++) {
			for (int y = 0; y < world[0].length; y++) {
				//Rule 1
				if (isCellLiving(x, y) && countNeighbors(x, y) < 2) {
					nextGen[x][y] = 0;
				}
				//Rule 2
				else if (isCellLiving(x, y) && (countNeighbors(x, y) == 2 || countNeighbors(x, y) == 3)) {
					nextGen[x][y] = 1;
				}
				//Rule 3
				else if (isCellLiving(x, y) && countNeighbors(x, y) > 3) {
					nextGen[x][y] = 0;
				}
				//Rule 4
				else if (!isCellLiving(x, y) && countNeighbors(x, y) == 3) {
					nextGen[x][y] = 1;
				}
			}
		}
		world = nextGen;
	}

	private int getWorldWidth() {
		return world.length;
	}

	public int getWorldLength() {
		return world[0].length;
	}

	public int countNeighbors(int x, int y) {
		int count = 0;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nX = x + dx;
				int nY = y + dy;
				try {

					if (getCell(nX, nY) == 1 && (nX != x || nY != y)) {
						count++;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// ignore invalid Fields
				}
			}
		}
		return count;
	}

	public void printWorld() {
		for (int x = 0; x < world.length; x++) {
			for (int y = 0; y < world[0].length; y++) {
				System.out.print(world[x][y]);
			}
			System.out.println();
		}
	}

	public boolean isCellLiving(int i, int j) {
		return world[i][j] == 1;
	}
	

}
