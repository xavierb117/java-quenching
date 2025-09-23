import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    public T data;
    public List<Vertex<T>> neighbors;

    public Vertex(T data, List<Vertex<T>> neighbors) {
        this.data = data;
        this.neighbors = neighbors;
    }

    public Vertex(T data) {
        this(data, new ArrayList<>());
    }
}
