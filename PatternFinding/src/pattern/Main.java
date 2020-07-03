package pattern;

import java.io.IOException;

public class Main {
    static NPos nPos = new NPos(); // obiekt z pozycjami nowych linii
    public static final double convert = 1000000;//z nanosekund na milisekundy
    public static final int TEST =200;//liczba testow

    public static void main(String[] args) throws IOException {
        char[] P = "abab".toCharArray();
        char[] T = "abababab".toCharArray();

        System.out.println("Wzorzec: abab, Tekst: abababab");
        System.out.println("===Naiwny===");
        Naive.Naive(P,T,2,nPos);
        System.out.println("\n===Rabin-Karp===");
        RabinKarp.Rabin_Karp(P,T,128,27077,2,nPos);//27077
        System.out.println("\n===KMP===");
        KMP.KMP(P,T,2,nPos);


        char[] P1 = FileToCharArray.getCharArr("wzorzec.txt",nPos,true);
        char[] T1 = FileToCharArray.getCharArr("tekst.txt",nPos, false);

        System.out.println("\nwzorzec.txt i tekst.txt :");
        System.out.println("===Naiwny===");
        Naive.Naive(P1,T1,1,nPos);
        System.out.println("\n===Rabin-Karp===");
        RabinKarp.Rabin_Karp(P1,T1,128,27077,1,nPos);//27077
        System.out.println("\n===KMP===");
        KMP.KMP(P1,T1,1,nPos);

        //=======================================================================================================
        // OBLICZANIE CZASU DLA wzorzec.txt, tekst.txt
        long sumt1=0, sumt2=0, sumt3=0;
        long start,end;
        long t1,t2,t3;

        for(int j = 0; j< TEST; j++) {
            start = System.nanoTime();
            Naive.Naive(P1, T1, 0,nPos);
            end = System.nanoTime();
            t1 = end - start;
            sumt1 += t1;

            start = System.nanoTime();
            RabinKarp.Rabin_Karp(P1, T1, 128, 27077, 0,nPos);//27077
            end = System.nanoTime();
            t2 = end - start;
            sumt2 += t2;

            start = System.nanoTime();
            KMP.KMP(P1, T1, 0,nPos);
            end = System.nanoTime();
            t3 = end - start;
            sumt3 += t3;
        }
        double Time1 = sumt1 / (convert*TEST); // srednia
        double Time2 = sumt2 / (convert*TEST);
        double Time3 = sumt3 / (convert*TEST);

        System.out.println("Test czasowy dla algorytmow szukania wzorca dla "+TEST+" testow.");
        System.out.println("Testowane pliki: wzorzec.txt, tekst.txt.");

        System.out.println("\t_____________________________________");
        System.out.println("\t|\tNaiwny\t|Rabin--Karp|\t  KMP\t|");
        System.out.format("\t|\t%.4f\t|"+"\t%.4f\t"+"|\t%.4f\t|\n",Time1,Time2,Time3);
        System.out.println("\t￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        //=======================================================================================================

        // Zaladowanie wzorzec1.txt i tekst1.txt
        char[] P2 = FileToCharArray.getCharArr("wzorzec1.txt",nPos,true);
        char[] T2 = FileToCharArray.getCharArr("tekst1.txt",nPos,false);
        //=======================================================================================================
        // OBLICZANIE CZASU DLA wzorzec1.txt, tekst1.txt
        sumt1=0; sumt2=0; sumt3=0;

        for(int j = 0; j< TEST; j++) {
            start = System.nanoTime();
            Naive.Naive(P2, T2, 0,nPos);
            end = System.nanoTime();
            t1 = end - start;
            sumt1 += t1;

            start = System.nanoTime();
            RabinKarp.Rabin_Karp(P2, T2, 128, 27077, 0,nPos);//27077
            end = System.nanoTime();
            t2 = end - start;
            sumt2 += t2;

            start = System.nanoTime();
            KMP.KMP(P2, T2, 0,nPos);
            end = System.nanoTime();
            t3 = end - start;
            sumt3 += t3;
        }
        Time1 = sumt1 / (convert*TEST); // srednia
        Time2 = sumt2 / (convert*TEST);
        Time3 = sumt3 / (convert*TEST);

        System.out.println("Test czasowy dla algorytmow szukania wzorca dla "+TEST+" testow.");
        System.out.println("Testowane pliki: wzorzec1.txt, tekst1.txt.");

        System.out.println("\t_____________________________________");
        System.out.println("\t|\tNaiwny\t|Rabin--Karp|\t  KMP\t|");
        System.out.format("\t|\t%.4f\t|"+"\t%.4f\t"+"|\t%.4f\t|\n",Time1,Time2,Time3);
        System.out.println("\t￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");


        System.out.println("\nwzorzec1.txt i tekst1.txt :");
        System.out.println("===Naiwny===");
        Naive.Naive(P2,T2,1,nPos);
        System.out.println("\n===Rabin-Karp===");
        RabinKarp.Rabin_Karp(P2,T2,128,27077,1,nPos);//27077
        System.out.println("\n===KMP===");
        KMP.KMP(P2,T2,1,nPos);

    }
}
/*  CZASY DZIALANIA ALGORYTMOW
    Test czasowy dla algorytmow szukania wzorca dla 200 testow.
    Testowane pliki: wzorzec.txt, tekst.txt.
        _____________________________________
        |	Naiwny	|Rabin--Karp|	  KMP	|
        |	1,6353	|	4,8982	|	1,4357	|
        ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
    Test czasowy dla algorytmow szukania wzorca dla 200 testow.
    Testowane pliki: wzorzec1.txt, tekst1.txt.
        _____________________________________
        |	Naiwny	|Rabin--Karp|	  KMP	|
        |	16,0700	|	3,0954	|	1,3561	|
        ￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣

    Process finished with exit code 0

*/
/*
    WYNIKI PRZESZUKIWAN

    Wzorzec: abab, Tekst: abababab
    ===Naiwny===
    abab
    abab
    abab

    ===Rabin-Karp===
    abab
    abab
    abab

    ===KMP===
    abab
    abab
    abab

    wzorzec.txt i tekst.txt :
    ===Naiwny===
    Znaleziono w wierszu: 5 znak: 21
    Znaleziono w wierszu: 333 znak: 1
    Znaleziono w wierszu: 1213 znak: 29
    Znaleziono w wierszu: 1411 znak: 1
    Znaleziono w wierszu: 1995 znak: 15
    Znaleziono w wierszu: 2310 znak: 1
    Znaleziono w wierszu: 3068 znak: 41
    Znaleziono w wierszu: 3381 znak: 1

    ===Rabin-Karp===
    Znaleziono w wierszu: 5 znak: 21
    Znaleziono w wierszu: 333 znak: 1
    Znaleziono w wierszu: 1213 znak: 29
    Znaleziono w wierszu: 1411 znak: 1
    Znaleziono w wierszu: 1995 znak: 15
    Znaleziono w wierszu: 2310 znak: 1
    Znaleziono w wierszu: 3068 znak: 41
    Znaleziono w wierszu: 3381 znak: 1

    ===KMP===
    Znaleziono w wierszu: 5 znak: 21
    Znaleziono w wierszu: 333 znak: 1
    Znaleziono w wierszu: 1213 znak: 29
    Znaleziono w wierszu: 1411 znak: 1
    Znaleziono w wierszu: 1995 znak: 15
    Znaleziono w wierszu: 2310 znak: 1
    Znaleziono w wierszu: 3068 znak: 41
    Znaleziono w wierszu: 3381 znak: 1

    wzorzec1.txt i tekst1.txt :
    ===Naiwny===
    Znaleziono w wierszu: 22 znak: 10
    Znaleziono w wierszu: 62 znak: 10
    Znaleziono w wierszu: 102 znak: 10
    Znaleziono w wierszu: 122 znak: 10
    Znaleziono w wierszu: 132 znak: 12
    Znaleziono w wierszu: 217 znak: 8
    Znaleziono w wierszu: 232 znak: 10
    Znaleziono w wierszu: 242 znak: 12
    Znaleziono w wierszu: 252 znak: 12
    Znaleziono w wierszu: 272 znak: 14
    Znaleziono w wierszu: 282 znak: 14
    Znaleziono w wierszu: 312 znak: 14
    Znaleziono w wierszu: 322 znak: 14
    Znaleziono w wierszu: 372 znak: 12
    Znaleziono w wierszu: 382 znak: 12
    Znaleziono w wierszu: 417 znak: 12
    Znaleziono w wierszu: 437 znak: 12
    Znaleziono w wierszu: 462 znak: 12
    Znaleziono w wierszu: 497 znak: 10
    Znaleziono w wierszu: 512 znak: 10
    Znaleziono w wierszu: 537 znak: 12
    Znaleziono w wierszu: 567 znak: 12
    Znaleziono w wierszu: 597 znak: 14
    Znaleziono w wierszu: 627 znak: 12
    Znaleziono w wierszu: 637 znak: 12
    Znaleziono w wierszu: 677 znak: 10
    Znaleziono w wierszu: 692 znak: 12
    Znaleziono w wierszu: 717 znak: 14
    Znaleziono w wierszu: 727 znak: 14
    Znaleziono w wierszu: 767 znak: 12
    Znaleziono w wierszu: 782 znak: 14
    Znaleziono w wierszu: 797 znak: 14
    Znaleziono w wierszu: 812 znak: 16
    Znaleziono w wierszu: 827 znak: 18
    Znaleziono w wierszu: 867 znak: 20
    Znaleziono w wierszu: 912 znak: 20
    Znaleziono w wierszu: 927 znak: 22
    Znaleziono w wierszu: 942 znak: 22
    Znaleziono w wierszu: 977 znak: 24
    Znaleziono w wierszu: 1022 znak: 22
    Znaleziono w wierszu: 1032 znak: 24
    Znaleziono w wierszu: 1097 znak: 20
    Znaleziono w wierszu: 1107 znak: 22
    Znaleziono w wierszu: 1137 znak: 24
    Znaleziono w wierszu: 1192 znak: 24
    Znaleziono w wierszu: 1202 znak: 26
    Znaleziono w wierszu: 1212 znak: 26
    Znaleziono w wierszu: 1227 znak: 26
    Znaleziono w wierszu: 1277 znak: 26
    Znaleziono w wierszu: 1287 znak: 26
    Znaleziono w wierszu: 1312 znak: 26
    Znaleziono w wierszu: 1327 znak: 26
    Znaleziono w wierszu: 1347 znak: 26
    Znaleziono w wierszu: 1367 znak: 26
    Znaleziono w wierszu: 1382 znak: 26
    Znaleziono w wierszu: 1442 znak: 28
    Znaleziono w wierszu: 1472 znak: 26
    Znaleziono w wierszu: 1487 znak: 28
    Znaleziono w wierszu: 1552 znak: 24
    Znaleziono w wierszu: 1582 znak: 24
    Znaleziono w wierszu: 1662 znak: 24
    Znaleziono w wierszu: 1672 znak: 26
    Znaleziono w wierszu: 1682 znak: 26
    Znaleziono w wierszu: 1717 znak: 26
    Znaleziono w wierszu: 1757 znak: 28
    Znaleziono w wierszu: 1772 znak: 28
    Znaleziono w wierszu: 1792 znak: 30
    Znaleziono w wierszu: 1802 znak: 32
    Znaleziono w wierszu: 1822 znak: 34
    Znaleziono w wierszu: 1852 znak: 32
    Znaleziono w wierszu: 1867 znak: 34
    Znaleziono w wierszu: 1877 znak: 34
    Znaleziono w wierszu: 1902 znak: 34
    Znaleziono w wierszu: 1932 znak: 36
    Znaleziono w wierszu: 1977 znak: 36
    Znaleziono w wierszu: 2047 znak: 30
    Znaleziono w wierszu: 2067 znak: 30
    Znaleziono w wierszu: 2092 znak: 28
    Znaleziono w wierszu: 2102 znak: 28
    Znaleziono w wierszu: 2122 znak: 28
    Znaleziono w wierszu: 2147 znak: 28
    Znaleziono w wierszu: 2172 znak: 28
    Znaleziono w wierszu: 2227 znak: 26
    Znaleziono w wierszu: 2242 znak: 28
    Znaleziono w wierszu: 2257 znak: 30
    Znaleziono w wierszu: 2287 znak: 32
    Znaleziono w wierszu: 2307 znak: 32
    Znaleziono w wierszu: 2332 znak: 34
    Znaleziono w wierszu: 2347 znak: 36
    Znaleziono w wierszu: 2367 znak: 34
    Znaleziono w wierszu: 2382 znak: 34
    Znaleziono w wierszu: 2422 znak: 36
    Znaleziono w wierszu: 2432 znak: 36
    Znaleziono w wierszu: 2447 znak: 36
    Znaleziono w wierszu: 2492 znak: 34

    ===Rabin-Karp===
    Znaleziono w wierszu: 22 znak: 10
    Znaleziono w wierszu: 62 znak: 10
    Znaleziono w wierszu: 102 znak: 10
    Znaleziono w wierszu: 122 znak: 10
    Znaleziono w wierszu: 132 znak: 12
    Znaleziono w wierszu: 217 znak: 8
    Znaleziono w wierszu: 232 znak: 10
    Znaleziono w wierszu: 242 znak: 12
    Znaleziono w wierszu: 252 znak: 12
    Znaleziono w wierszu: 272 znak: 14
    Znaleziono w wierszu: 282 znak: 14
    Znaleziono w wierszu: 312 znak: 14
    Znaleziono w wierszu: 322 znak: 14
    Znaleziono w wierszu: 372 znak: 12
    Znaleziono w wierszu: 382 znak: 12
    Znaleziono w wierszu: 417 znak: 12
    Znaleziono w wierszu: 437 znak: 12
    Znaleziono w wierszu: 462 znak: 12
    Znaleziono w wierszu: 497 znak: 10
    Znaleziono w wierszu: 512 znak: 10
    Znaleziono w wierszu: 537 znak: 12
    Znaleziono w wierszu: 567 znak: 12
    Znaleziono w wierszu: 597 znak: 14
    Znaleziono w wierszu: 627 znak: 12
    Znaleziono w wierszu: 637 znak: 12
    Znaleziono w wierszu: 677 znak: 10
    Znaleziono w wierszu: 692 znak: 12
    Znaleziono w wierszu: 717 znak: 14
    Znaleziono w wierszu: 727 znak: 14
    Znaleziono w wierszu: 767 znak: 12
    Znaleziono w wierszu: 782 znak: 14
    Znaleziono w wierszu: 797 znak: 14
    Znaleziono w wierszu: 812 znak: 16
    Znaleziono w wierszu: 827 znak: 18
    Znaleziono w wierszu: 867 znak: 20
    Znaleziono w wierszu: 912 znak: 20
    Znaleziono w wierszu: 927 znak: 22
    Znaleziono w wierszu: 942 znak: 22
    Znaleziono w wierszu: 977 znak: 24
    Znaleziono w wierszu: 1022 znak: 22
    Znaleziono w wierszu: 1032 znak: 24
    Znaleziono w wierszu: 1097 znak: 20
    Znaleziono w wierszu: 1107 znak: 22
    Znaleziono w wierszu: 1137 znak: 24
    Znaleziono w wierszu: 1192 znak: 24
    Znaleziono w wierszu: 1202 znak: 26
    Znaleziono w wierszu: 1212 znak: 26
    Znaleziono w wierszu: 1227 znak: 26
    Znaleziono w wierszu: 1277 znak: 26
    Znaleziono w wierszu: 1287 znak: 26
    Znaleziono w wierszu: 1312 znak: 26
    Znaleziono w wierszu: 1327 znak: 26
    Znaleziono w wierszu: 1347 znak: 26
    Znaleziono w wierszu: 1367 znak: 26
    Znaleziono w wierszu: 1382 znak: 26
    Znaleziono w wierszu: 1442 znak: 28
    Znaleziono w wierszu: 1472 znak: 26
    Znaleziono w wierszu: 1487 znak: 28
    Znaleziono w wierszu: 1552 znak: 24
    Znaleziono w wierszu: 1582 znak: 24
    Znaleziono w wierszu: 1662 znak: 24
    Znaleziono w wierszu: 1672 znak: 26
    Znaleziono w wierszu: 1682 znak: 26
    Znaleziono w wierszu: 1717 znak: 26
    Znaleziono w wierszu: 1757 znak: 28
    Znaleziono w wierszu: 1772 znak: 28
    Znaleziono w wierszu: 1792 znak: 30
    Znaleziono w wierszu: 1802 znak: 32
    Znaleziono w wierszu: 1822 znak: 34
    Znaleziono w wierszu: 1852 znak: 32
    Znaleziono w wierszu: 1867 znak: 34
    Znaleziono w wierszu: 1877 znak: 34
    Znaleziono w wierszu: 1902 znak: 34
    Znaleziono w wierszu: 1932 znak: 36
    Znaleziono w wierszu: 1977 znak: 36
    Znaleziono w wierszu: 2047 znak: 30
    Znaleziono w wierszu: 2067 znak: 30
    Znaleziono w wierszu: 2092 znak: 28
    Znaleziono w wierszu: 2102 znak: 28
    Znaleziono w wierszu: 2122 znak: 28
    Znaleziono w wierszu: 2147 znak: 28
    Znaleziono w wierszu: 2172 znak: 28
    Znaleziono w wierszu: 2227 znak: 26
    Znaleziono w wierszu: 2242 znak: 28
    Znaleziono w wierszu: 2257 znak: 30
    Znaleziono w wierszu: 2287 znak: 32
    Znaleziono w wierszu: 2307 znak: 32
    Znaleziono w wierszu: 2332 znak: 34
    Znaleziono w wierszu: 2347 znak: 36
    Znaleziono w wierszu: 2367 znak: 34
    Znaleziono w wierszu: 2382 znak: 34
    Znaleziono w wierszu: 2422 znak: 36
    Znaleziono w wierszu: 2432 znak: 36
    Znaleziono w wierszu: 2447 znak: 36
    Znaleziono w wierszu: 2492 znak: 34

    ===KMP===
    Znaleziono w wierszu: 2 znak: 1
    Znaleziono w wierszu: 22 znak: 10
    Znaleziono w wierszu: 32 znak: 10
    Znaleziono w wierszu: 47 znak: 8
    Znaleziono w wierszu: 62 znak: 10
    Znaleziono w wierszu: 102 znak: 10
    Znaleziono w wierszu: 122 znak: 10
    Znaleziono w wierszu: 132 znak: 12
    Znaleziono w wierszu: 142 znak: 12
    Znaleziono w wierszu: 182 znak: 10
    Znaleziono w wierszu: 192 znak: 10
    Znaleziono w wierszu: 217 znak: 8
    Znaleziono w wierszu: 232 znak: 10
    Znaleziono w wierszu: 242 znak: 12
    Znaleziono w wierszu: 252 znak: 12
    Znaleziono w wierszu: 262 znak: 12
    Znaleziono w wierszu: 272 znak: 14
    Znaleziono w wierszu: 282 znak: 14
    Znaleziono w wierszu: 312 znak: 14
    Znaleziono w wierszu: 322 znak: 14
    Znaleziono w wierszu: 342 znak: 14
    Znaleziono w wierszu: 372 znak: 12
    Znaleziono w wierszu: 382 znak: 12
    Znaleziono w wierszu: 417 znak: 12
    Znaleziono w wierszu: 437 znak: 12
    Znaleziono w wierszu: 462 znak: 12
    Znaleziono w wierszu: 497 znak: 10
    Znaleziono w wierszu: 512 znak: 10
    Znaleziono w wierszu: 537 znak: 12
    Znaleziono w wierszu: 552 znak: 10
    Znaleziono w wierszu: 567 znak: 12
    Znaleziono w wierszu: 597 znak: 14
    Znaleziono w wierszu: 617 znak: 12
    Znaleziono w wierszu: 627 znak: 12
    Znaleziono w wierszu: 637 znak: 12
    Znaleziono w wierszu: 657 znak: 10
    Znaleziono w wierszu: 677 znak: 10
    Znaleziono w wierszu: 692 znak: 12
    Znaleziono w wierszu: 717 znak: 14
    Znaleziono w wierszu: 727 znak: 14
    Znaleziono w wierszu: 742 znak: 12
    Znaleziono w wierszu: 767 znak: 12
    Znaleziono w wierszu: 782 znak: 14
    Znaleziono w wierszu: 797 znak: 14
    Znaleziono w wierszu: 812 znak: 16
    Znaleziono w wierszu: 827 znak: 18
    Znaleziono w wierszu: 837 znak: 18
    Znaleziono w wierszu: 857 znak: 18
    Znaleziono w wierszu: 867 znak: 20
    Znaleziono w wierszu: 897 znak: 18
    Znaleziono w wierszu: 912 znak: 20
    Znaleziono w wierszu: 927 znak: 22
    Znaleziono w wierszu: 942 znak: 22
    Znaleziono w wierszu: 967 znak: 22
    Znaleziono w wierszu: 977 znak: 24
    Znaleziono w wierszu: 1022 znak: 22
    Znaleziono w wierszu: 1032 znak: 24
    Znaleziono w wierszu: 1042 znak: 24
    Znaleziono w wierszu: 1097 znak: 20
    Znaleziono w wierszu: 1107 znak: 22
    Znaleziono w wierszu: 1137 znak: 24
    Znaleziono w wierszu: 1192 znak: 24
    Znaleziono w wierszu: 1202 znak: 26
    Znaleziono w wierszu: 1212 znak: 26
    Znaleziono w wierszu: 1227 znak: 26
    Znaleziono w wierszu: 1237 znak: 26
    Znaleziono w wierszu: 1257 znak: 26
    Znaleziono w wierszu: 1277 znak: 26
    Znaleziono w wierszu: 1287 znak: 26
    Znaleziono w wierszu: 1312 znak: 26
    Znaleziono w wierszu: 1327 znak: 26
    Znaleziono w wierszu: 1347 znak: 26
    Znaleziono w wierszu: 1367 znak: 26
    Znaleziono w wierszu: 1382 znak: 26
    Znaleziono w wierszu: 1407 znak: 26
    Znaleziono w wierszu: 1432 znak: 26
    Znaleziono w wierszu: 1442 znak: 28
    Znaleziono w wierszu: 1462 znak: 26
    Znaleziono w wierszu: 1472 znak: 26
    Znaleziono w wierszu: 1487 znak: 28
    Znaleziono w wierszu: 1502 znak: 28
    Znaleziono w wierszu: 1527 znak: 26
    Znaleziono w wierszu: 1542 znak: 24
    Znaleziono w wierszu: 1552 znak: 24
    Znaleziono w wierszu: 1582 znak: 24
    Znaleziono w wierszu: 1622 znak: 22
    Znaleziono w wierszu: 1662 znak: 24
    Znaleziono w wierszu: 1672 znak: 26
    Znaleziono w wierszu: 1682 znak: 26
    Znaleziono w wierszu: 1697 znak: 26
    Znaleziono w wierszu: 1717 znak: 26
    Znaleziono w wierszu: 1757 znak: 28
    Znaleziono w wierszu: 1772 znak: 28
    Znaleziono w wierszu: 1782 znak: 28
    Znaleziono w wierszu: 1792 znak: 30
    Znaleziono w wierszu: 1802 znak: 32
    Znaleziono w wierszu: 1822 znak: 34
    Znaleziono w wierszu: 1837 znak: 32
    Znaleziono w wierszu: 1852 znak: 32
    Znaleziono w wierszu: 1867 znak: 34
    Znaleziono w wierszu: 1877 znak: 34
    Znaleziono w wierszu: 1902 znak: 34
    Znaleziono w wierszu: 1912 znak: 34
    Znaleziono w wierszu: 1932 znak: 36
    Znaleziono w wierszu: 1942 znak: 36
    Znaleziono w wierszu: 1977 znak: 36
    Znaleziono w wierszu: 2007 znak: 34
    Znaleziono w wierszu: 2047 znak: 30
    Znaleziono w wierszu: 2067 znak: 30
    Znaleziono w wierszu: 2082 znak: 28
    Znaleziono w wierszu: 2092 znak: 28
    Znaleziono w wierszu: 2102 znak: 28
    Znaleziono w wierszu: 2122 znak: 28
    Znaleziono w wierszu: 2132 znak: 28
    Znaleziono w wierszu: 2147 znak: 28
    Znaleziono w wierszu: 2172 znak: 28
    Znaleziono w wierszu: 2182 znak: 28
    Znaleziono w wierszu: 2227 znak: 26
    Znaleziono w wierszu: 2242 znak: 28
    Znaleziono w wierszu: 2257 znak: 30
    Znaleziono w wierszu: 2272 znak: 30
    Znaleziono w wierszu: 2287 znak: 32
    Znaleziono w wierszu: 2307 znak: 32
    Znaleziono w wierszu: 2322 znak: 32
    Znaleziono w wierszu: 2332 znak: 34
    Znaleziono w wierszu: 2347 znak: 36
    Znaleziono w wierszu: 2367 znak: 34
    Znaleziono w wierszu: 2382 znak: 34
    Znaleziono w wierszu: 2407 znak: 34
    Znaleziono w wierszu: 2422 znak: 36
    Znaleziono w wierszu: 2432 znak: 36
    Znaleziono w wierszu: 2447 znak: 36
    Znaleziono w wierszu: 2492 znak: 34

    Process finished with exit code 0
 */