package huffmanPac;
import java.io.*;
import java.util.*;

public class Input {
    // dwie funkcje pomocnicze generuj i wczytaj input
    List<String> read(int n) throws IOException {
        // n-co ile znakow
        // wczytaj jakie znaki i odpowiednia tablice ilosci wystapien i ile jest tych znakow
        // wejscie tj input.txt zawiera znaki zapisane w jednej lini BEZ ENTEROW!!
        File file=new File("./src/input.txt");

        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        List<String> ls = new ArrayList<String>();

        int val;

        while((val=br.read())!=-1) {//br.read przyjmuje wartosc -1 jesli spotka EOF
            String str = new String();
            char c = (char) val;
            str += c;

            for(int i=0;i<n-1 && (val=br.read())!=-1 ;i++) {//konkatynuj tworzac n-znakowe stringi petla dokleja n-1 bo pierwszy juz jest
                c = (char) val;
                str += c;
            }
            ls.add(str);
        }

        br.close();
        return ls;
    }

    public static void genInput(char[] c,int n) throws IOException {
        BufferedWriter input=new BufferedWriter(new FileWriter("./src/input.txt"));

        if(c.length==0)
        {
            System.out.println("Pusta tablica!");
            return;
        }

        for(int i=0;i<n;i++)
        {
            int random=(int)(Math.random()*c.length);
            input.write(c[random]);
        }
        input.close();
    }
}
