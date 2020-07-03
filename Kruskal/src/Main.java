public class Main {
    public static void main(String[] args) {
        int vertCount = 8;
        int edgeCount = 15;

        Edge[] graphEdges = new Edge[edgeCount];    // tablica krawedzi

        graphEdges[0]=(new Edge(2, 4, 2));
        graphEdges[1]=(new Edge(5, 6, 5));
        graphEdges[2]=(new Edge(2, 3, 6));
        graphEdges[3]=(new Edge(3, 7, 7));
        graphEdges[4]=(new Edge(0, 1, 9));
        graphEdges[5]=(new Edge(3, 4, 11));
        graphEdges[6]=(new Edge(0, 5, 14));
        graphEdges[7]=(new Edge(0, 6, 15));
        graphEdges[8]=(new Edge(4, 7, 16));
        graphEdges[9]=(new Edge(2, 5, 18));
        graphEdges[10]=(new Edge(2, 7, 19));
        graphEdges[11]=(new Edge(6, 4, 20));
        graphEdges[12]=(new Edge(1, 2, 24));
        graphEdges[13]=(new Edge(6, 7, 44));
        graphEdges[14]=(new Edge(5, 4, 30));

        Kruskal graph = new Kruskal();
        System.out.println();
        System.out.println("Wierzcholek----(Waga)----Wierzcholek");
        graph.kruskalMST(graphEdges, vertCount);
    }
}
