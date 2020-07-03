import java.util.Arrays;

public class Kruskal {
    public void kruskalMST(Edge[] edges, int vertexCount){
        /***
         @graphEdges - tablica krawedzi grafu
         @vertexCount - ilosc wierzcholkow
         ***/
        Node[] V = new Node[vertexCount]; //zbior wierzcholko

        for(int i=0;i<vertexCount;i++)
        {
            V[i] = Node.makeSet(i);
        }

        Arrays.sort(edges);//sortowanie niemalejąco według wag krawędzi

        for(int i=0;i<edges.length;i++){
            Node ru = Node.findSet(V[edges[i].vertex1]);
            Node rv = Node.findSet(V[edges[i].vertex2]);
            if(ru != rv){
                // drukowanie nowej krawedzi spinajacej graf G
                System.out.println(edges[i].toString());
                Node.union(ru,rv);
            }
        }
    }
}
