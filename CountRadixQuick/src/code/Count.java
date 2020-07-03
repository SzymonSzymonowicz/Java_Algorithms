package code;

public class Count {
    void countsort(String[] A, String[] B, int k,int z,int[] strlen) {
        int [] C=new int[k];
        int [] coplen=new int[strlen.length];

        for(int i=0;i<k;i++)
            C[i]=0;

        for (int j=0;j<A.length;j++)
        {
            if(strlen[j]-1<z)
                C[0]++;
            else
                C[A[j].charAt(z)] = C[A[j].charAt(z)]+1;
        }
// teraz C[i] == ilość wartości równych "i" w tablicy A
        for(int i=1;i<k;i++)//moze <=k-1
            C[i]=C[i]+C[i-1];
// teraz C[i] == ilość wartości mniejszych lub równych "i" w A
        for(int j=A.length-1;j>=0;j--)// moze j>0
        {
            if(strlen[j]-1<z){
                B[C[0]-1] = A[j];//-1
                coplen[C[0]-1]=strlen[j];

                C[0]--;
            }
            else
            {
                B[C[A[j].charAt(z)]-1] = A[j];//-1
                coplen[C[A[j].charAt(z)]-1]=strlen[j];//do wyw

                C[A[j].charAt(z)] = C[A[j].charAt(z)]-1;
            }
        }

        for(int i=0;i<A.length;i++){
            A[i]=B[i];
        }

        for(int i=0;i<strlen.length;i++){
            strlen[i]=coplen[i];
        }
    }
}


/*package kod;

public class Count {
    void countsort(String[] A, String[] B, int k) {
        int [] C=new int[k];//(int)Math.pow(10,k)];

        for(int i=0;i<k;i++)
            C[i]=0;

        for (int j=0;j<A.length;j++)
            C[A[j].charAt(0)] = C[A[j].charAt(0)]+1;
// teraz C[i] == ilość wartości równych "i" w tablicy A
        for(int i=1;i<k;i++)//moze <=k-1
            C[i]=C[i]+C[i-1];
// teraz C[i] == ilość wartości mniejszych lub równych "i" w A
        for(int j=A.length-1;j>=0;j--)// moze j>0
        {
            B[C[A[j].charAt(0)]-1]=A[j];
            C[A[j].charAt(0)]=C[A[j].charAt(0)]-1;
        }

    }
}*/

/*package kod;


        import java.util.Arrays;

public class Count {
    void countsort(String[] A, String[] B, int k,int z) {
        int [] C=new int[k];

        for(int i=0;i<k;i++)
            C[i]=0;

        for (int j=0;j<A.length;j++)
            C[A[j].charAt(z)] = C[A[j].charAt(z)]+1;
// teraz C[i] == ilość wartości równych "i" w tablicy A
        for(int i=1;i<k;i++)//moze <=k-1
            C[i]=C[i]+C[i-1];
// teraz C[i] == ilość wartości mniejszych lub równych "i" w A
        for(int j=A.length-1;j>=0;j--)// moze j>0
        {
            B[C[A[j].charAt(z)]-1]=A[j];//-1
            C[A[j].charAt(z)]=C[A[j].charAt(z)]-1;
        }

        for(int i=0;i<A.length;i++){
            A[i]=B[i];
        }
    }
}*/
