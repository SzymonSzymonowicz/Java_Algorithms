public class Edge implements Comparable<Edge> {
    // klasa krawedz implementuje interfejs porownywalnosci,
    // ulatwia to sortowanie krawedzi za pomoca metody sort
    int vertex1; // wierzcholek 1,2
    int vertex2;
    int weight; // waga krawedzi

    // konstruktor krawedzi, tworzy dla kazdego wierzcholka
    // zbior rozlaczny funkcja makeSet
    Edge(int vertex1, int vertex2, int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    // nadpisuje metode porownywania, ustawiajac wlasna zasade porownawcza
    // czyli w naszym przypadku na podstawie wag krawedzi
    @Override
    public int compareTo(Edge otherEdge){
        return this.weight - otherEdge.weight;
    }

    // nadpisuje metode konwersji do napisu, przydatne do drukowania
    @Override
    public String toString() {
        return vertex1 + "----("+weight+")----"+vertex2;
    }
}
