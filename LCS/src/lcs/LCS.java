package lcs;

import java.util.HashSet;
import java.util.Set;

public class LCS {
    /**
     * Funkcja wykonuje algorytm szukajacy najdluzszego wspolengo podciagu tzw. LCS
     *
     * @param x tablica znakow nr1
     * @param y tablica znakow nr2
     * @return obiekt lcs.IntCharO jest to obiekt, ktory zawiera wynikowe tablice po szukaniu najdluzszego wspolnego podciagu
     * LCS, czyli tablice char[][] i int[][]
     */
    IntCharO length(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        IntCharO ico = new IntCharO(m,n);

        char b[][]= new char[m+1][n+1];
        int c[][]= new int[m+1][n+1];

        for (int i = 0;i < m;i++)
            c[i][0] =0;
        for (int j = 0; j < n;j++)
            c[0][j] =0;
        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                if (x[i-1] == y[j-1]){
                    c[i][j] =c[i-1][j-1]+1;
                    b[i][j] ='\\';
                }
                else if (c[i - 1][ j] >= c[i][j - 1]){
                    c[i][j] =c[i - 1][j];
                    b[i][j] ='|';
                }
                else{
                    c[i][j] =c[i][j - 1];
                    b[i][j] ='-';
                }
            }
        }

        ico.setCharArr(b);
        ico.setIntArr(c);

        return ico;
    }

    void printLCS(char[] x,char[] y,char[][] b,int i,int j) {

        if (i == 0 || j==0)
            return;
        if (b[i][j] == '\\')
        {
            printLCS(x, y, b, i - 1, j - 1);
            System.out.print(x[i-1]);
        }
        else if (b[i][j] =='|')
            printLCS(x, y, b, i - 1, j);
        else
            printLCS(x, y, b, i, j - 1);
    }

    /* Funkcja zwraca maxa z 2 intow */
    int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    /**
     * Funkcja sluzy do uzyskania wszystkich najdluzszych wspolnych podciagow dla danych dwoch wyrazow
     * korzystajac z funkcji lcs.LCS.lenght
     *
     * @param X wyraz nr1
     * @param Y wyraz nr2
     * @param m dlugosc wyrazu nr1
     * @param n dlugosc wyrazu nr2
     * @param L dwuwymiarowa tablica liczb calkowitych(intow) dlugosci lcs.LCS [z funkcji lcs.LCS.lenght]
     * @return  zbior wszystkich najdluzszych wspolnych podciagow wyrazow x i y
     */
    static Set<String> findAllLCS(String X, String Y, int m, int n,int[][]L)
    {
        // stworz zbior przetrzymujacay wszystkie podciagi
        Set<String> zbior = new HashSet<>();

        // jesli dotrzemy do konca jednego ze Stringow,
        // zwroc pusty zbior
        if (m == 0 || n == 0)
        {
            zbior.add("");
            return zbior;
        }

        // jesli ostatnie znaki X i Y sa takie same
        if (X.charAt(m - 1) == Y.charAt(n - 1))
        {
            // rekurencja dla X[0...m-2] i Y[0...n-2] w macierzy
            Set<String> tmp = findAllLCS(X, Y, m - 1, n - 1,L);

            // dolacz bierzacy znak(char) do wszystkich mozliwych podciagow
            // z podwyrazu X[0...m-2] i Y[0...m-2]
            for (String str : tmp)
                zbior.add(str + X.charAt(m - 1));
        }
        // jesli ostatnie znaki X i Y nie sa takie same
        else
        {
            // jesli najdluzszy podciag(lcs.LCS) moze byc skonstruowany z gornej czesci
            // macierzy, rekurencja dla X[0...m-2] i Y[0...n-1]
            if (L[m - 1][n] >= L[m][n - 1])
                zbior = findAllLCS(X, Y, m - 1, n,L);

            // jesli lcs.LCS moze byc skonstruowany z lewej strony
            // macierzy, rekurencja dla X[0...m-1] i Y[0...n-2]
            if (L[m][n - 1] >= L[m - 1][n])
            {
                Set<String> tmp = findAllLCS(X, Y, m, n - 1,L);

                // polacz oba zbiory jesli L[m-1][n] == L[m][n-1]
                // uwaga: s bedzie pusty jesli L[m-1][n] != L[m][n-1]
                zbior.addAll(tmp);
            }
        }
        return zbior;
    }
}
