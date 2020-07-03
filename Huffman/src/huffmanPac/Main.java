package huffmanPac;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] c={'0','1','2','3','4','5','6','7'};
        boolean generate = false;
        // generate - czy generowac pseudolosowy input true - tak false - nie
        // pseudolosowy input jest bardzo zbalansowany dla wiekszej ilosci znakow,
        // mala roznica miedzy po 1 a po 2 znakach

        if(generate==true)
            Input.genInput(c,200);

        //parametr n - po ilu znakach kodujemy
        Huffman.huffmanTest(1);
        Huffman.huffmanTest(2);
    }
}
