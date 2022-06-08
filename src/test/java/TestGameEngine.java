import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestGameEngine {

    @Test
    void testGetSize() {
        //fail("Not yet implemented");
        GameEngine e = new GameEngine(10);
        int size = e.getSize();
        assertTrue(size == 10);
    }

    @Test
    void testgenerateRandomCells() {
        GameEngine e = new GameEngine(10);
        int []positions = e.generateRandomCells();
        int s = positions.length;
        assertTrue(s == 15);
    }

    @Test
    void testInitializeMap() {
        GameEngine e = new GameEngine(10);
        e.initialize_map(5);
        int t = 0;
        for(int i =0; i < 10; i++) {
            for(int j =0; j < 10; j++) {
                CellType c = e.getCell(i, j);
                if(c.getLabel() == 'T') {
                    t++;
                }
            }
        }

        assertTrue(t == 5);
    }

    @Test
    void testGameOver() {
        GameEngine e = new GameEngine(10);
        Player p = new Player(0,9);
        e.initialize_map(5);
        int over = e.gameOver(p, 100);
        assertTrue(over == -1000);
    }

    @Test
    void testGameOver2() {
        GameEngine e = new GameEngine(10);
        Player p = new Player(0,9);
        e.initialize_map(5);
        int over = e.gameOver(p, 0);
        assertTrue(over == -1000);
    }

    @Test
    void testGetCell() {
        GameEngine e = new GameEngine(10);
        e.initialize_map(5);
        CellType c = e.getCell(0, 9);
        assertTrue(c.getLabel() == 'P');
    }

    @Test
    void testSetCell() {
        GameEngine e = new GameEngine(10);
        e.initialize_map(5);
        CellType c = new CellType('T');
        e.setCell(0, 9, c);
        CellType c1 = e.getCell(0, 9);
        assertTrue(c1.getLabel() == 'T');
    }




}

