package QuickSortImp;

public class Quick {
    public static void Swap(int[] A, int x, int y)
    {
        int temp=A[x];
        A[x]=A[y];
        A[y]=temp;
    }

    public static int Partition(int[]A,int p,int r){
        int x=A[r];
        int i=p-1;
        for (int j=p;j<=r;j++){
            if(A[j]<=x){
                i++;
                Swap(A,i,j);
            }
        }
        if (i<r)
            return i;
        else
            return (i - 1);
    }

    public static void Quicksort(int[] A, int p, int r){
        if(p<r){
            int q = Partition(A,p,r);
            Quicksort(A,p,q);
            Quicksort(A,q+1,r);
        }
    }
}
