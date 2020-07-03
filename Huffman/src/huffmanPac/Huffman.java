package huffmanPac;
import java.io.IOException;
import java.util.*;

public class Huffman {
    // rekurencyjna funkcja sluzaca do drukowania
    // kodu huffmana (tutaj s) przez przejscie drzewa
    public static void printCode(HuffmanNode root, String s)
    {

        // przypadek bazowy:
        // jesli lewe i prawe sa nullem to jest to lisc drzewa
        // kod huffmana s jest generowany przez przejscie drzewa
        if (root.left == null && root.right == null
                && !root.c.equals("-")) {
            // c string(znak) biezacego wezla, data ilosc wystapien
            System.out.format("  %6s  |  %11d  |  %s\n",root.c,root.data,s);

            return;
        }

        // jak idziemy w lewo dodaj "0" do kodu
        // jak idziemy w prawo dodaj "1" do kodu
        // rekurencyjnie przejdz drzewo dla lewego i
        // prawego poddrzewa
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }


    public static int lengthCode(HuffmanNode root,int depth)
    {
        int sumAll=0;
        // przypadek bazowy:
        // jesli biezacy wezel (root) jest lisciem
        // zwroc ilosc jego wystapien przemnozona przez dlugosc sciezki
        // od korzenia do tego liscia

        if (root.left == null && root.right == null
                && !root.c.equals("-")) {
            // depth - dlugosc sciezki; data - ilosc wystapien
            int nodeVal=(depth*root.data);
            return nodeVal;
        }

        // rekurencyjnie dodawaj ilosci wystapien poszczegolnych lisci przechodzac pierw
        // lewe poddrzewo, nastepnie prawe
        // kazde przejscie ktore nie zwraca sumy(nie jest lisciem) zwieksza glebokosc o 1
        sumAll+=lengthCode(root.left,depth+1);
        sumAll+=lengthCode(root.right,depth+1);

        return sumAll;
    }

    public static void huffmanTest(int n){
        // n - po ilu znakach kodoujemy

        Input inp = new Input();
        List<String> strList=null;
        Set<String> strSet=null;

        try {
            strList= inp.read(n);
            strSet= new HashSet<String>(strList);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Blad wczytania pliku! Prawdopodbonie zla lokalizacja!");
        }

        int uniqSize=strSet.size();// ilosc unikalnych stringow (jesli jest pojedynczy znak to i tak traktuje go jako string)

        String[] strArr = strSet.toArray(new String[strSet.size()]);

        int[] strFreq = new int[uniqSize];
        for (String s:strList) {// obliczanie ilosci wystapien
            int i=0;
            for(int j=0;j<uniqSize;j++)// szukanie pozycji w tablicy unikalnych stringow do kodowania
            {
                if(s.equals(strArr[j])) {
                    i = j;
                    break;
                }
            }
            strFreq[i]++;
        }

        // tworzenie kolejki priorytetowej q
        // tworzy (wersja min) kolejke priorytetowa (kopiec, wejsa min)
        PriorityQueue<HuffmanNode> pq
                = new PriorityQueue<HuffmanNode>(uniqSize, new MyComparator());

        for (int i = 0; i < uniqSize; i++) {
            // tworzenie wezla i dodanie do kolejki piorytetowej
            HuffmanNode hn = new HuffmanNode();

            hn.c = strArr[i];
            hn.data = strFreq[i];

            hn.left = null;
            hn.right = null;

            // dodawanie wezla do kolejki
            pq.add(hn);
        }

        // tworzenie roota
        HuffmanNode root = null;

        // ekstraktujemy dwie najmniejsze wartosci
        // z kopca za kazdym razem do momentu, gdy jego rozmiar zredukuje sie do 1,
        // ekstraktujemy do poki wszystkie wezly sa wyekstraktowane
        while (pq.size() > 1) {

            // pierwszy min extract
            HuffmanNode x = pq.peek();
            pq.poll();

            // drugi min extarct
            HuffmanNode y = pq.peek();
            pq.poll();

            // nowy wezel z
            HuffmanNode z = new HuffmanNode();

            // ilosc wystapien nowego wezla to suma lewego i prawego dziecka
            z.data = x.data + y.data;
            z.c = "-";

            // pierwszy min jako lewe dziecko
            z.left = x;

            // drugi min jako prawe dziecko
            z.right = y;

            // ustawienie wezla z jako root
            root = z;

            // dodanie wezla z do kolejki priorytetowanej
            pq.add(z);
        }

        // drukowanie kodow przez przejscie drzewa
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.format("   ZNAK   |  WYSTAPIENIA  |  KOD HUFFMANA\n");
        System.out.println("---------------------------------------------");
        printCode(root, "");
        System.out.println("---------------------------------------------");

        System.out.println("Dlugosc zakodowanego tekstu w bitach po "+n+" znaku/ach wynosi: "+lengthCode(root,0)+"\n");
    }
}