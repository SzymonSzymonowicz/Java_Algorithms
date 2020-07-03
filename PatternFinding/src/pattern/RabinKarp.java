package pattern;

public class RabinKarp {
    /**
     * @param P - wzorzec, tablica [1..m]
     * @param T- tekst, tablica [1..n],
     * @param d - rozmiar alfabetu (np. 128)
     * @param q - liczba pierwsza (np. 27077)
     * @param showMode - jak w Naiwnym
     * @param nPos - pozycje nowych linii
     */
    static void Rabin_Karp(char[] P,char[] T,int d,int q, int showMode, NPos nPos){

        int n = T.length-1;
        int m = P.length-1;
        int p=0; // wartość p "kodująca" (haszowanie) P
        int t=0; // wartość t "kodująca" (haszowanie) T
        int h=1;

        int row = 1; // wiersz w pliku
        int mod = Integer.MAX_VALUE; // modulo, do wyliczenia ktory znak w wierszu

        for (int i=0;i<= m-1;i++){
            h = (h*d) % q;
        }// wyliczy h = (d do potęgi m-1) modulo q

        for (int i=0;i<=m;i++){
            p = (d * p + P[i]) % q;
            t = (d * t + T[i]) % q;
        }

        // wyliczone: wartość p "kodująca" P oraz wartość t "kodująca" T
        // kodowanie niejednoznaczne! (haszowanie)
        for (int s=0;s <= n-m;s++) {
            if (p == t) {
                // tu porównujemy m znaków (w pętli)
                int j;
                for(j=0;j<=m;j++){   //petla po wzorcu
                    if (P[j] != T[s+j])
                        break;
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
            if (s < n-m) {                                // czy tekst sie nie skonczyl?
                int t1 = (T[s] * h) % q;
                if (t < t1) {
                    t = t + q;
                }

                t = (d * (t - t1) + T[s +m+ 1]) % q;

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
