package QuickSortImp;

public class Hybrid {
    public static final int c=10;

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

    public static void Hybridsort(int[] A, int p, int r){
        if ((r-p+1<c)&&(p<r)) {
            Bubblesort(A, p, r);
            return;
        } else if(p<r){
            int q = Partition(A, p, r);
            Hybridsort(A, p, q);
            Hybridsort(A, q + 1, r);
        }
    }

    public static void Bubblesort(int[] arr, int x, int y)
    {
        for(int i=0;i<y-x;i++)
        {
            for(int j=x;j<y-i;j++){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                }
            }
        }
    }
}