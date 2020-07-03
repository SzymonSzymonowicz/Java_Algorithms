package pattern;

public class KMP {
    static int[] Prefix_Function(char[] P) {
        // P - wzorzec, tablica [1..m]
        int m = P.length - 1;
        int[] pi = new int[P.length];
        pi[0] = 0;
        int k = 0;
        for (int q = 1; q <= m; q++) {
            // mamy: P[1..k]==P[...q-1], k==pi[q-1]
            while (k > 0 && P[k] != P[q]) {
                k = pi[k - 1];
            }
            if (P[k] == P[q])
                k++;
            pi[q] = k;
        }
        return pi;
    }

    static void KMP(char[] P, char[] T, int showMode, NPos nPos) {
        // T - tekst, tablica [1..n]
        // P - wzorzec, tablica [1..m]
        // showMode - jak w Naiwnym
        // nPos - pozycje nowych linii

        int n = T.length - 1;
        int m = P.length - 1;
        int[] pi = Prefix_Function(P);

        int q = 0;

        int row = 1; // wiersz w pliku
        int mod = Integer.MAX_VALUE; // modulo, do wyliczenia ktory znak w wierszu

        for (int i = 0; i<=n; i++) {
            // mamy: P[1..q]==T[...i-1]
            while (q > 0 && (P[q+1] != T[i])) {
                q = pi[q];
            }

            if (P[q + 1] == T[i]) {
                q++;
            }
            if (q == m) {
                //wypisz
                if(showMode!=2) {
                    row = nPos.getRow(i-m)+1;
                    mod = nPos.positions.get(row-2)+1;
                }

                if (showMode==1 && row!=1)
                    System.out.println("Znaleziono w wierszu: "+row+" znak: " + ((i-m)%mod+1));
                else if (showMode==1)
                    System.out.println("Znaleziono w wierszu: " + row + " znak: " + (i-m+1));
                if (showMode==2) {
                    print(P,T,i-m);
                }
                q = pi[q];
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
