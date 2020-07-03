package huffmanPac;
import java.util.Comparator;

//Klasa pomocnicza comperator, sluzaca do porownywania
//wezlow na podstawie atrybutu data
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}