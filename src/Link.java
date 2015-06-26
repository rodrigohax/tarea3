//Clase Link de listas enlazadas
class Link {
    private Libro iData;
    public Link next;

    public Link(Libro iData) {
        this.iData = iData;
    }

    public Libro getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.println(iData.toString());
    }
}
