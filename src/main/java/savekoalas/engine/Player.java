
public class Player{


    int x;
    int y;
    int steps;
    public Player(int xloc, int yloc){
        x = xloc;
        y = yloc;
        steps = 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSteps(){
        return steps;
    }

    public void incrementSteps(){
        steps = steps + 1;
    }
    public Boolean checkMoveValid(String move, int size){

        if(move.equals("u")){
            if(y-1 < 0){
                return false;
            }
        }
        if(move.equals("d")){
            if(y+1 >= size){
                return false;
            }
        }
        if(move.equals("r")){
            if(x+1 >= size){
                return false;
            }
        }
        if(move.equals("l")){
            if(x-1 < 0){
                return false;
            }
        }
        return true;
    }

    public void move(String m) {
        if(m.equals("u")){
            y = y -1;
        }
        if(m.equals("d")){
            y = y + 1;
        }
        if(m.equals("l")){
            x = x - 1;
        }
        if(m.equals("r")){
            x = x + 1;
        }


    }


}