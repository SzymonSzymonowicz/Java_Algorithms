package code;

public class Radix {
    void radixsort(String[] A, String[] B, int k)
    {
        Count x=new Count();
        int[] strlen=new int[A.length];

        for(int j=0;j<A.length;j++)//oblicz dlugosci napisow
        {
            strlen[j]=A[j].length();
        }

        int max=strlen[0];
        for(int i=0;i<strlen.length;i++)//szukanie najdluzszego wyrazu
        {
            if(strlen[i]>max)
                max=strlen[i];
        }


        for(int i=max-1;i>=0;i--){
            x.countsort(A,B,k,i,strlen);
        }
    }
}

