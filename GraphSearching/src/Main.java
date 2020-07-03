import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        // ZAD AL. 14.3
        int[][] mat = Node.load("input.txt");
        Node.printM(mat);
        System.out.println("===========================================");
        List<Node> nodeList = Node.getNodeList(mat);
        Node.printNodeList(nodeList);

        System.out.println("DFS: ");
        Node.dfs(nodeList, Node.getNodeByNr(nodeList,0), new StringBuilder(),true);
        System.out.println("===========================================");

        nodeList = Node.getNodeList(mat);// ponowne zaladownie, trzeba zresetowac visited
        System.out.println("BFS: ");
        Node.bfs(nodeList,Node.getNodeByNr(nodeList,0));

        // ZAD AL. 14.4 inne wczytywanie
        System.out.println("===========================================");
        System.out.println("\n!! ZAD AL. 14.4 !!\n");
        List<Pair> pairList = Pair.getPairList(mat);
        Pair.printNodeList(pairList);

        Pair.reset();
        System.out.println("DFS: ");
        Pair.dfs(pairList,0,new StringBuilder(),true);
        System.out.println("===========================================");

        Pair.reset(); // reset listy visited
        System.out.println("BFS: ");
        Pair.bfs(pairList,0);


    }
}

/*
0 1 0 0 1 0
1 0 1 0 1 0
0 1 0 1 0 1
0 0 1 0 1 1
1 1 0 1 0 1
0 0 1 1 1 0
===========================================
0 ; [1, 4]
1 ; [0, 2, 4]
2 ; [1, 3, 5]
3 ; [2, 4, 5]
4 ; [0, 1, 3, 5]
5 ; [2, 3, 4]
DFS:
0 -> 1 -> 2 -> 3 -> 4 -> 5
Krawedzie lasu spinajacego: [ (0,1) (1,2) (2,3) (3,4) (4,5)  ]
===========================================
BFS:
0 -> 1 -> 4 -> 2 -> 3 -> 5
Krawedzie lasu spinajacego: [ (0,1) (0,4) (1,2) (4,3) (4,5)  ]
===========================================

!! ZAD AL. 14.4 !!

0 ; [1, 4]
1 ; [0, 2, 4]
2 ; [1, 3, 5]
3 ; [2, 4, 5]
4 ; [0, 1, 3, 5]
5 ; [2, 3, 4]
DFS:
0 -> 1 -> 2 -> 3 -> 4 -> 5
Krawedzie lasu spinajacego: [ (0,1) (1,2) (2,3) (3,4) (4,5)  ]
===========================================
BFS:
0 -> 1 -> 4 -> 2 -> 3 -> 5
Krawedzie lasu spinajacego: [ (0,1) (0,4) (1,2) (4,3) (4,5)  ]

Process finished with exit code 0

 */