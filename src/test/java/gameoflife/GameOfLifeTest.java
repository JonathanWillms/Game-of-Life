package gameoflife;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


import static org.junit.Assert.fail;

import org.hamcrest.core.IsNot;

public class GameOfLifeTest {

    @Test
    public void createsPreDefinedWorld() {
        // given
    	// when
    	World world = new World(3,3);
    	// then
    	assertThat(world).isNotNull(); 
    }
    
    @Test
    public void getLength() {
    	World world = new World(5,9);
    	
    	int length = world.getWorldLength(); 
    	
    	assertThat(length).isEqualTo(9);
    }
    
    @Test
    public void getLengthWhenWidhtIsOne() {
    	World world = new World(1,9);
    	
    	int length = world.getWorldLength(); 
    	
    	assertThat(length).isEqualTo(9);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setCellWithWrongValue() {
    	World world = new World(5,5);
    		world.setCell(3, 2, 100);    	
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setCellWithNegativeValue() {
    	World world = new World(5,5);
    	world.setCell(3, 2, -5);
    }
    
    @Test
    public void setCell() {
    	World world = new World(5,5);
    	world.setCell(3, 2, 1);
    	int cellValue = world.getCell(3, 2);
    	
    	assertThat(cellValue).isEqualTo(1);
    }
    
    @Test
    public void clearCell() {
    	World world = new World(5,5);
    	world.setCell(3, 2, 0);
    	int cellValue = world.getCell(3, 2);
    	
    	assertThat(cellValue).isEqualTo(0);
    }

    @Test
    public void fewerThanTwoNeighbors() {
    	World world = new World(5,5);
    	world.setCell(1,1,1);
    	
    	world.nextGeneration();
    	int cellValue = world.getCell(1,1);
    	
    	assertThat(cellValue).isEqualTo(0);
    }

//    @Test
//    public void countNeighborsEdge() {
//    	World world = new World(5,5);
//    	world.setCell(1,1,1);
//    	world.setCell(0,0,1);
//    	world.setCell(0,2,1);
//    	
//    	int count = world.countNeighbors(0,1);
//    	
//    	assertThat(count).isEqualTo(1);
//    }
//    
    @Test
    public void countNeighbors() {
    	World world = new World(5,5);
    	world.setCell(1,1,1);
    	world.setCell(2,1,1);
    	world.setCell(2,2,1);
    	
    	int count = world.countNeighbors(2,1);
    	
    	assertThat(count).isEqualTo(2);
    }
    
    @Test
    public void testRule2WithTwo() {
    	World world = new World(5,5);
    	world.setCell(1,1,1);
    	world.setCell(0,0,1);
    	world.setCell(1,0,1);
    	
    	world.nextGeneration();
    	int cellValue = world.getCell(1,1);
    	
    	assertThat(cellValue).isEqualTo(1);
    }
    
    @Test
    public void testRule2WithThree() {
    	World world = new World(5,5);
    	world.setCell(1,1,1);
    	world.setCell(0,0,1);
    	world.setCell(1,0,1);
    	world.setCell(1,2,1);
    	
    	world.nextGeneration();
    	int cellValue = world.getCell(1,1);
    	
    	assertThat(cellValue).isEqualTo(1);
    }
    
    @Test
    public void testRule3() {
    	World world = new World(5,5);
    	world.setCell(1,1,1);
    	world.setCell(0,0,1);
    	world.setCell(1,0,1);
    	world.setCell(1,2,1);
    	world.setCell(2,0,1);
    	
    	world.nextGeneration();
    	int cellValue = world.getCell(1,1);
    	
    	assertThat(cellValue).isEqualTo(0);
    }

    @Test
    public void testRule4() {
    	World world = new World(5,5);
    	world.setCell(0,0,1);
    	world.setCell(1,0,1);
    	world.setCell(1,2,1);
    	
    	world.nextGeneration();
    	int cellValue = world.getCell(1,1);
    	
    	assertThat(cellValue).isEqualTo(1);
    }


/*    @Test
    public void canCreateNewGeneration() {
        // given
    	// when
    	World world = new World(3,3);
    	world.nextGeneration();
    	World nextGen = 
    	// then
    	assertThat(nextGen).isNotNull(); 
    	
    }*/
    
//    @Test
//    public void cellWithNoNeighborsDies() {
//    	// given
//    	int[][] start = new int[3][3];
//    	start[1][1] = 1;
//    	// when
//    	World world = new World(start);
//    	World nextGen = world.nextGeneration();
//    	// then
//    	assertThat(nextGen.isCellLiving(1,1)).isTrue(); 
//    	
//    }
    
//    @Test
//    public void cellWithNoExactlyThreeNeighborsSurvives() {
//    	// given
//    	int[][] start = new int[3][3];
//    	start[1][1] = 1;
//    	start[1][0] = 1;
//    	start[0][1] = 1;
//    	start[0][0] = 1;
//    	// when
//    	World world = new World(start);
//    	World nextGen = world.nextGeneration();
//    	// then
//    	nextGen.printWorld();
//    	assertThat(nextGen.isCellLiving(1,1)).isTrue(); 
//    	
//    }


}
