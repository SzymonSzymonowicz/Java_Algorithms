package QuickSortImp;
import java.util.Arrays;

public class HybridTest {
    public static final int TEST =200;//number of tests
    public static final double convert = 1000000;//convertion rate right now from nanosecs to millisecs

    public static void main(String[] args) {
        Quick a=new Quick();
        Hybrid b=new Hybrid();

        /*int[] tablica = {17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -10, -11, -12};
        int[] tab_2=Arrays.copyOf(tablica, tablica.length);
        a.Quicksort(tablica, 0, tablica.length - 1);
        PrintArray(tablica);
        b.Hybridsort(tab_2, 0, tab_2.length - 1);
        PrintArray(tab_2);*/

        //===RANDOM DATA===
        System.out.println("RANDOM DATA");
        System.out.println("\t|\tSize N\t| Quicksort | Hybridsort |");
        for(int n=2000;n<20001;n+=2000)// through sizes
        {
            long sumt1=0, sumt2=0;
            long start,end;
            long t1,t2;

            for(int j = 0; j< TEST; j++)
            {
                int[] tab= new int[n];
                for (int i = 0; i < tab.length; i++)
                    tab[i] = (int) (Math.random() * 1000);// fill with random values

                int[] tab2 = Arrays.copyOf(tab, n);// copy of original array

                start=System.nanoTime();
                a.Quicksort(tab,0,tab.length-1);
                end=System.nanoTime();
                t1=end-start;
                sumt1+=t1;

                start=System.nanoTime();
                b.Hybridsort(tab2,0,tab2.length-1);
                end=System.nanoTime();
                t2=end-start;
                sumt2+=t2;
            }

            double T1 = sumt1 / (convert * TEST);// average
            double T2 = sumt2 / (convert * TEST);

            System.out.format("\t|\t %d"+"\t|\t%.4f"+"\t|\t%.4f"+"\t |\n",n,T1,T2);
        }
        System.out.println();


        //===ADVERSE DATA===
        System.out.println("ADVERSE DATA");
        System.out.println("\t|\tSize N\t| Quicksort | Hybridsort |");
        for(int n=2000;n<10001;n+=2000) {
            int lastVal = n;// previous value
            long sumt1=0, sumt2=0;// sum of time

            for (int j = 0; j< TEST; j++)
            {
                int[] desc = new int[n];
                for (int i = 0; i < desc.length; i++) { //descending order
                    desc[i] = lastVal - 1 - (int) (Math.random() * 3);
                    lastVal = desc[i];
                }

                int[] desc2 = Arrays.copyOf(desc, desc.length);// copy of original array

                long start = System.nanoTime();
                a.Quicksort(desc, 0, desc.length - 1);
                long end = System.nanoTime();
                long t1 = end - start;
                sumt1+=t1;

                long start2 = System.nanoTime();
                b.Hybridsort(desc2,0,desc2.length-1);
                long end2 = System.nanoTime();
                long t2 = end2 - start2;
                sumt2+=t2;
            }

            double T1 = sumt1 / (convert * TEST);// average
            double T2 = sumt2 / (convert * TEST);

            System.out.format("\t|\t %d"+"\t|\t%.4f"+"\t|\t%.4f"+"\t |\n",n,T1,T2);
        }
        System.out.println("Unit of time --> millisecond");
        System.out.println("Number of tests --> "+TEST);
    }

    public static void PrintArray(int[] arr){// utility function for test
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
}
