import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MinHeapSortWithInRangeXY {
    public static int heapSize;// global variable

    public static void HeapifyMIN(int[] A,int i,int x) {// i- root/parent node
        int l = 2 * i + 1-x+1;// left child node moved to the left by (x-1), so -(x-1),then -x+1
        int r = 2 * i + 2-x+1;// right child -||-
        int smallest;// index of the smallest number from group of root and his children

        if (l<= heapSize && A[l] < A[i]) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= heapSize && A[r] < A[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = A[i];// swamp A[i] with A[smallest]
            A[i] = A[smallest];
            A[smallest] = temp;

            HeapifyMIN(A,smallest,x);// set heap for subheap
        }
    }

    public static void BuildHeap(int[] A,int x,int y)
    {
        heapSize=y-1;// index of the last element of the heap
        for(int i=(y-x+1)/2+(x-1)-1;i>=x-1;i--)// starting from the middle of the range to its begining [through roots]
        {
            HeapifyMIN(A,i,x);// i-root, x-beginning of the range
        }
    }

    public static void HeapSortMIN(int[] A,int x,int y)
    {
        BuildHeap(A,x,y);
        for(int i=y;i>=x;i--){
            int tmp=A[x-1];// swap values of the smallest value from heap to the end of the range
            A[x-1]=A[heapSize];
            A[heapSize]=tmp;

            heapSize--;// decrease range size, bcs we have one of the elements sorted already

            HeapifyMIN(A,x-1,x);// heapify reduced heap
        }
    }
    public static void printArray(int[] arr)// utility function to print arrays
    {
        System.out.print("{");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
            if (i<arr.length-1)
                System.out.print(", ");
        }
        System.out.print("}");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // get input from file, the first two numbers are the range, the rest is the array to sort
        // create input.txt and output.txt first
        File file=new File("./input.txt");
        Scanner numbers=new Scanner(file);

        int size=0;
        int x;// beginning of the range
        int y;// end of the range

        x=numbers.nextInt();//x=first int
        y=numbers.nextInt();//y=second int

        while(numbers.hasNextInt()) {//getting size of the array
            numbers.nextInt();
            size++;
        }
        numbers.close();

        int []tab=new int[size];
        numbers = new Scanner(file);
        numbers.nextInt();numbers.nextInt();// skip first two ints

        for(int i=0;numbers.hasNextInt();i++)
            tab[i]=numbers.nextInt();

        numbers.close();

        if(1<=x && x<=y && y<=size) {
            HeapSortMIN(tab, x, y);
            printArray(tab);

            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));//otworzenie pliku do zapisu
            for (int t = 0; t < tab.length; t++) {
                output.write(Integer.toString(tab[t]));
                output.newLine();
            }
            output.flush();
            output.close();
            System.out.println("Sorting successful.");
        }
        else {
            System.out.println("One or more of the conditions isn't met:\n1<=x<=y<=n");
        }
    }
}

/*Random Input Generator
int inputSize=(int)(Math.random()*20);
int a=(int)(Math.random()*inputSize);
int b=(int)(Math.random()*inputSize);
BufferedWriter input=new BufferedWriter(new FileWriter("input.txt"));
input.write(Integer.toString(a));
input.newLine();
input.write(Integer.toString(b));
input.newLine();

for(int t=0;t<inputSize;t++) {
    int random=(int)(Math.random()*20);
    input.write(Integer.toString(random));
    input.newLine();
}
input.close();
*/
