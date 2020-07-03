package code;

public class QuickString {
    public static void Swap(String[] A, int x, int y,int[] strlen)
    {
        int tempint=strlen[x];
        strlen[x]=strlen[y];
        strlen[y]=tempint;

        String temp=A[x];
        A[x]=A[y];
        A[y]=temp;
    }

    public static int Partition(String[]A,int p,int r,int idx,int[]strlen){//idx- badana kolumna strlen-tablica dlugosci wyrazow
        char x,y;
        //int j;

        if(strlen[r]-1<idx)
            x=0;
        else
            x = A[r].charAt(idx);

        int i=p-1;

        for (int j=p;j<=r;j++){
            if(strlen[j]-1<idx)//jesli wyraz jest krotszy od badanej kolumny
            {
                y=0;
            }
            else{
                y=A[j].charAt(idx);
            }
            if(y<=x){
                i++;
                Swap(A,i,j,strlen);
                for(int a=j;a>i+1;a--)//przesun wszystko o 1 w lewo,bo pojedynczy swap niszczy porzadek
                    Swap(A,a,a-1,strlen);
            }
        }

        if (i<r)
            return i;
        else
            return (i - 1);
    }

    public static void Quicksort(String[] A, int p, int r,int idx,int[]strlen){
        /*if(p<r){
            int q = Partition(A,p,r,idx,strlen);
            Quicksort(A,p,q,idx,strlen);
            Quicksort(A,q+1,r,idx,strlen);
        }*/
       while(p<r){// iteracyjnie zeby zmniejszyc ilosc wywolan
            int q = Partition(A,p,r,idx,strlen);

            if(q-p<r-q)//pierw posortuj mniejsza czesc
            {
                Quicksort(A,p,q-1,idx,strlen);
                p=q+1;
            }
            else// potem wieksza
            {
                Quicksort(A,q+1,r,idx,strlen);
                r=q-1;
            }
       }
    }

    public static void QuickStr(String[] A, int p, int r){
        QuickString x=new QuickString();
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
            x.Quicksort(A,0,r,i,strlen);
        }
    }
}