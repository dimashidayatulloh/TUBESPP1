package TUBESPP1;

public class Vertex<T> {
    private T data;
    private boolean wasVisited;

    public Vertex(T data) {
        this.data = data;
        this.wasVisited = false;
    }

    // Setter & Getter
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /* tidak digunakan
    public boolean isWasVisited() {
        return wasVisited;
    }
    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

     */
}
