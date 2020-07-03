import java.io.File;
import java.io.IOException;
import java.util.*;

public class Node {
    int nr;
    List<Node> adj = new ArrayList<Node>();
    boolean visited;
    Node p;

    Node(int nr) {
        this.nr = nr;
        this.visited = false;
        // p = null;
    }

    static void bfs(List <Node> V, Node s){
        s.visited = true;
        Queue<Node> Q = new LinkedList<>();

        StringBuilder stb = new StringBuilder();

        Q.add(s);

        while(!Q.isEmpty()){
            Node u = Q.poll();
            System.out.print(u.nr);
            //System.out.print(" -> ");
            for(Node v : u.adj){
                if(v.visited == false){
                    v.visited = true;
                    v.p = u;
                    stb.append("("+u.nr+","+v.nr+") ");
                    Q.add(v);
                }
            }
            if(!Q.isEmpty())
                System.out.print(" -> ");
        }
        System.out.println("\nKrawedzie lasu spinajacego: [ "+stb.toString()+" ]");
    }


    static void dfs(List<Node> V, Node u, StringBuilder stb, boolean first){
        // stringbuilder do wyswietlania drzewa spinajacego graf
        // first do wyswietlenia krawedzi tylko raz
        //StringBuilder stb = new StringBuilder();

        System.out.print(u.nr);

        u.visited = true;

        for(Node v : u.adj){
            if(v.visited == false){
                v.p = u;

                stb.append("("+u.nr+","+v.nr+") ");
                System.out.print(" -> ");
                dfs(V,v,stb,false);
            }
        }
        if(first)
            System.out.println("\nKrawedzie lasu spinajacego: [ "+stb.toString()+" ]");
    }


    static List<Node> getNodeList(int[][] matrix){
        List<Node> nodeList = new ArrayList<Node>();

        for(int i=0;i<matrix.length;i++)
        {
            Node node = new Node(i);
            nodeList.add(node);
        }

        //macierz n x n
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==1){
                    getNodeByNr(nodeList,i).adj.add(getNodeByNr(nodeList,j));
                }
            }
        }

        return nodeList;
    }

    static Node getNodeByNr(List<Node> nodeList,int nr){
        Node ret;
        for(Node node : nodeList){
            if(node.nr == nr) {
                ret = node;
                return ret;
            }
        }

        return null;
    }

    static void printNodeList(List<Node> nodeList){
        for (Node n:nodeList) {
            System.out.print(n.nr + " ; [");
            boolean first = true;
            for(Node n2:n.adj){
                if(first == true){
                    System.out.print(n2.nr);
                    first = false;
                }
                else{
                    System.out.print(", "+n2.nr);
                }
            }
            System.out.print("]\n");
        }
    }




    static int[][] load(String path) throws IOException{
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
