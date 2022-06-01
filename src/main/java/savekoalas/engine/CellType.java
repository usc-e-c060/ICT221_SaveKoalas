import java.util.Random;

public class CellType {


    //1 = empyt, 2= Koala, 3 = Player, 4 = Fountain, 5 = Trap
    int value;
    int x;
    int y;
    char label;

    public CellType(char l){
        label = l;
        if(label == '_' || label == 'K' || label == 'P'){
            value = 0;
        }
        if(label == 'T'){
            value = -10;
        }
        if(label == 'F'){
            value = 6;
        }
    }

    public char getLabel(){
        return label;
    }

    public int getValue(){
        return value;
    }

    public void updateValue(){
        value = value + 1;
    }

    public int updateMove(){
        int val = -1;
        if(label == 'F'){
            val = 6;
            value = 0;
        }
        label = 'P';
        return val;
    }


}
