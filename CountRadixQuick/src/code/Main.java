package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;//wczytanie

public class Main {
    public static void main (String[] args) throws Exception {
        Radix x=new Radix();
        QuickString y=new QuickString();
        int k=256;// zakres ASCII
        long start,end;
        long time1,time2;
        double nan=1000000.0;
        int N=20000;


        File file=new File("./nazwiska.txt");//zaladowanie plik
        Scanner ilosc=new Scanner(file);

        int size=0;//ilosc linii w pliku/rozmiar tabeli
        while(ilosc.hasNextLine()) {//zliczenie
            ilosc.nextLine();
            size++;
        }
        ilosc.close();

        Scanner linia=new Scanner(file);//wczytanie pliku
        String[] t1=new String[size];
        String REGEX = " ";//wzorzec oddzielajacy wyrazy
        Pattern pat=Pattern.compile(REGEX);

        for(int i=0;linia.hasNextLine();i++){//wczytanie nazwisk z pliku
            t1[i]=pat.split(linia.nextLine())[1];//rozdziel tam gdzie znajdziesz wzorzec, [0] popularnosc [1] naziwsko
        }
        linia.close();


        //String[] t3={"aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","tu","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aba","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaz","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa"};//,"c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaz","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak","aaa","c","alangng","farba","ab","am","wincyj","cs","cos","zeta","zi","atak"};
        //String[] t1={"21","1301","13","021"};
        //"ara","alangng","arb","alb"
        String[] t2=new String[t1.length];
        String[] t4=new String[t1.length];
        String[] t5=new String[t1.length];

        t4= Arrays.copyOf(t1, N);
        String[] t4k=new String[t4.length];

        t5= Arrays.copyOf(t1,N);

        //printArray(t1);
        //x.radixsort(t1,t2,k);
        //y.QuickStr(t3,0,t3.length-1);
        //printArray(t3);

        start=System.nanoTime();
        x.radixsort(t4,t4k,k);
        end=System.nanoTime();
        time1=end-start;


        start=System.nanoTime();
        y.QuickStr(t5,0,t5.length-1);
        end=System.nanoTime();
        time2=end-start;

        System.out.println("|\tRadix\t|\tQuick");
        System.out.println("|\t"+time1/nan+"\t|\t"+time2/nan);


        BufferedWriter output=new BufferedWriter(new FileWriter("./wynik.txt"));
        for(int i=0;i<t4.length;i++) {
            output.write(t4k[i]);
            output.newLine();
        }
        output.close();

        BufferedWriter output2=new BufferedWriter(new FileWriter("./wynik2.txt"));
        for(int i=0;i<t5.length;i++) {
            output2.write(t5[i]);
            output2.newLine();
        }
        output2.close();
    }

    static void printArray(String[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.println(i+". "+arr[i]);
        System.out.println();
    }
}
