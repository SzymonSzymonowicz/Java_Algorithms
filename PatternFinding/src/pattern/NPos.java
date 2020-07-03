package pattern;

import java.util.ArrayList;
import java.util.List;

public class NPos {
    // klasa przechowuje liste pozycji znakow nowej linii
    List<Integer> positions = new ArrayList<>();

    int getRow(int x){
        int row=0;
        for(Integer i : positions){
            if(i>x){
                row = positions.indexOf(i);
                break;
            }
        }

        return row;
    }

    int getMod(int x){
        if(positions.contains(x))
            return positions.get(x);
        else
            return -1;
    }

}
