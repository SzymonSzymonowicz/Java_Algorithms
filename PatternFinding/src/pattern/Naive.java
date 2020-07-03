package pattern;

public class Naive {
    /**
     * @param   P         wzorzec, tablica [0..m]
     * @param   T         tekst, tablica [0..n]
     * @param   showMode  dla 0 = brak wyswietlania wyniku
     *                    dla 1 = sam komunikat
     *                    dla 2 = sam wynik (do sprawdzenia na malym przykladzie)
     * @param   nPos      pozycje nowych linii
     */
    static void Naive(char[] P, char[] T, int showMode, NPos nPos) {


        int row = 1; // wiersz w pliku
        int mod = Integer.MAX_VALUE; // modulo, do wyliczenia ktory znak w wierszu

        int n = T.length-1;
        int m = P.length-1;

        for (int s=0;s<=n-m;s++) {
            int j;
            for(j=0;j<=m;j++){   //petla po wzorcu
                if (P[j] != T[s+j])
                {
                    break;
                }
            }
            if(j-1==m) //wyswietlanie
            {
                if(showMode!=2) {
                    row = nPos.getRow(s)+1;
                    mod = nPos.positions.get(row-2)+1;
                }

                if (showMode==1 && row!=1)
                    System.out.println("Znaleziono w wierszu: "+row+" znak: " + (s%mod+1));
                else if (showMode==1)
                    System.out.println("Znaleziono w wierszu: " + row + " znak: " + (s+1));
                if (showMode==2) {
                    print(P,T,s);
                }
            }
        }
    }

    static void print(char[] P, char[] T, int pos){
        int m = P.length-1;
        for(int i=0;i<=m;i++){   //petla po wzorcu
            System.out.print(T[pos + i]);
        }
        System.out.println();
    }
}
