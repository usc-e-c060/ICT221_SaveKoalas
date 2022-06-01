import java.util.*;

public class GameEngine {

    /**
     * An example board to store the current game state.
     *
     * Note: depending on your game, you might want to change this from 'int' to String or something?
     */
    private CellType[][] map;
    private int len;

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new CellType[size][size];
        len = size;
    }

    /**
     * The size of the current game.
     *
     * @return this is both the width and the height.
     */
    public int getSize() {
        return map.length;
    }

    /**
     * Plays a text-based game
     */

    public int[] generateRandomCells(){
        int s = len*len;
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for(int i =0; i < s; i++){
            vals.add(i);
        }

        //Enterence and exit cannot overlap koalas, traps or fountains
        vals.remove(90);
        vals.remove(9);

        int [] positions = new int[15];
        //generate random positions
        Random rand = new Random();
        for(int i =0; i < 15; i++){
            int r = rand.nextInt(vals.size());
            int p = vals.get(r);
            positions[i] = p;
            vals.remove(r);
        }
        return positions;
    }

    public void initialize_map(int d){
        for(int i = 0; i < len; i++){
            for(int j =0; j < len; j++){
                CellType c = new CellType('_');
                map[i][j] = c;
            }
        }

        //Set player at start
        CellType c = new CellType('P');
        map[9][0] = c;

        //Set Koalas, Fountain and Trap randomly
        int []positions = generateRandomCells();
        for(int i =0; i < 15; i++){
            int y = positions[i]/10;
            int x = positions[i]%10;
            if(i < 5){
                CellType c1 = new CellType('K');
                map[y][x] = c1;
            }
            else if(i < 5 + d){
                CellType c1 = new CellType('T');
                map[y][x] = c1;
            }else{
                CellType c1 = new CellType('F');
                map[y][x] = c1;
            }

            
        }
    }

    public int gameOver(Player p, int time){
        //check if at exit
        int px = p.getX();
        int py = p.getY();
        if(px == 9 && py == 0){
            //check all koalas are saved
            for(int i =0; i < len; i++){
                for(int j =0; j < len; j++){
                    CellType c = map[i][j];
                    if(c.getLabel() == 'K'){
                        return -1000;
                    }
                }
            }
            return time - p.getSteps();
        }

        return -1000;


    }

    public CellType getCell(int x, int y){
        return map[y][x];
    }

    public void setCell(int x, int y, CellType c){
        map[y][x] = c;
    }

    public void display(){
        for(int i =0; i < len; i++){
            for(int j =0; j < len; j++){
                System.out.print(" " + map[i][j].getLabel() + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);
        int difficulty = 5;
        System.out.println("Enter difficulty level");
        int d = sc1.nextInt();
        if(d >= 0 && d <= 10){
            difficulty = d;
        }
        GameEngine engine = new GameEngine(10);
        engine.initialize_map(difficulty);

        engine.display();
        Player player = new Player(0,9);
        int time = 200;

        Scanner sc= new Scanner(System.in);
        while(time >0){
            System.out.println("\nEnter a move (u=Up, d=Down, l=Left, r=Right: ");  
            String str= sc.nextLine();
            if(!str.equals("u") && !str.equals("d") && !str.equals("l") && !str.equals("r")){
                System.out.println("Invalid move. Try again");
            }else{
                int px = player.getX();
                int py = player.getY();
                CellType c = engine.getCell(px, py);
                if(c.getValue() != 0 && c.getValue() != -1){
                    c.updateValue();
                    engine.setCell(px, py, c);
                    time = time - 1;
                    player.incrementSteps();
                }else{
                    if(player.checkMoveValid(str, engine.getSize())){
                        px = player.getX();
                        py = player.getY();
                        c = engine.getCell(px, py);
                        if(c.getValue() == -1){
                            CellType c1 = new CellType('T');
                            engine.setCell(px, py, c1);    
                        }else{
                            CellType c1 = new CellType('_');
                            engine.setCell(px, py, c1);
                        }
                        
                        player.move(str);
                        px = player.getX();
                        py = player.getY();
                        c = engine.getCell(px, py);
                        time += c.updateMove();
                        engine.setCell(px, py, c);
                        player.incrementSteps();

                    }else {
                        System.out.println("There is no place to move, try again");
                    }    
                }

                System.out.println("\n");
                engine.display();
                int score = engine.gameOver(player, time);
                if(score == -1000){
                    if(time <= 0){
                        System.out.println("\n===== GAME OVER =====");
                        System.out.println("Score: -1");
                        break;
                    }
                }else{
                    System.out.println("\n===== GAME OVER =====");
                    System.out.println("Score: " + score);
                    break;
                }


            }
            
        }


    }
}