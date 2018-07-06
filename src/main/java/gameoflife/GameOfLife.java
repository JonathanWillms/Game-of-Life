package gameoflife;

public class GameOfLife {

	public static void main(String[] args) {
		World world = new World(5,5);
		world.populate(33);
		world.printWorld();
		world.nextGeneration();
		System.out.println();
		world.printWorld();
	}

}
