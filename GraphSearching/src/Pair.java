import java.io.File;
import java.io.IOException;
import java.util.*;

public class Pair {
    int nr;
    List<Integer> adj;
    //boolean visited;
    //Node p;

    Pair(int nr){
        this.nr = nr;
        adj = new ArrayList<Integer>();
    }

    static List<Integer> visited1= new ArrayList<Integer>();

    static void bfs(List <Pair> V, int s){
        visited1.add(s);
        Pair p = getPairByNr(V,s);
        Queue<Pair> Q = new LinkedList<>();

        StringBuilder stb = new StringBuilder();

        Q.add(p);

        while(!Q.isEmpty()){
            Pair u = Q.poll();
            System.out.print(u.nr);
            //System.out.print(" -> ");
            for(int v : u.adj){
                if(visited1.contains(v) == false){
                    visited1.add(v);
                    stb.append("("+u.nr+","+v+") ");
                    Pair p2 = getPairByNr(V,v);
                    Q.add(p2);
                }
            }
            if(!Q.isEmpty())
                System.out.print(" -> ");
        }
        System.out.println("\nKrawedzie lasu spinajacego: [ "+stb.toString()+" ]");
    }

    static List<Integer> visited2= new ArrayList<Integer>();

    static void dfs(List<Pair> V, int x, StringBuilder stb, boolean first){
        // stringbuilder do wyswietlania drzewa spinajacego graf
        // first do wyswietlenia krawedzi tylko raz
        //StringBuilder stb = new StringBuilder();
        Pair u = getPairByNr(V,x);

        System.out.print(u.nr);

        visited2.add(u.nr);

        for(int v : u.adj){
            if(visited2.contains(v) == false){
               // v.p = u;

                stb.append("("+u.nr+","+v+") ");
                System.out.print(" -> ");
                dfs(V,v,stb,false);
            }
        }
        if(first)
            System.out.println("\nKrawedzie lasu spinajacego: [ "+stb.toString()+" ]");
    }

    static void reset(){
        visited1.clear();
        visited2.clear();
    }

    static List<Pair> getPairList(int[][] matrix){
        List<Pair> nodeList = new ArrayList<>();

        for(int i=0;i<matrix.length;i++)
        {
            Pair p = new Pair(i);
            nodeList.add(p);
        }

        //macierz n x n
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==1){
                    getPairByNr(nodeList,i).adj.add(j);
                }
            }
        }

        return nodeList;
    }

    static Pair getPairByNr(List<Pair> nodeList,int nr){
        Pair ret;
        for(Pair p : nodeList){
            if(p.nr == nr) {
                ret = p;
                return ret;
            }
        }

        return null;
    }

    static void printNodeList(List<Pair> nodeList){
        for (Pair p:nodeList) {
            System.out.print(p.nr + " ; [");
            boolean first = true;
            for(Integer i:p.adj){
                if(first == true){
                    System.out.print(i);
                    first = false;
                }
                else{
                    System.out.print(", "+i);
                }
            }
            System.out.print("]\n");
        }
    }




    static int[][] load(String path) throws IOException {
        File f = new File(path);
        Scanner scr = new Scanner(f);

        int size = scr.nextInt();

        int[][] matrix = new int [size][size];

        int i = 0, j = 0;

        while(i<size && scr.hasNextInt())
        {
            while(j<size && scr.hasNextInt()) {
                matrix[i][j] = scr.nextInt();
                j++;
            }
            j = 0;
            i++;
        }

        return matrix;
    }

    static void printM (int [][] matrix){
        // macierz n x n

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }






}
