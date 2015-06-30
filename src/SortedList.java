//clase de lista enlazada, donde insertamos el link
public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    //insertamos en la lista enlazada respecto su codigo en base 128
    public void insert(Link theLink) {
        long key = theLink.getKey().getCodigoToBase128();
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getKey().getCodigoToBase128()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete(int val) {
        Operaciones operaciones = new Operaciones(val);
        long key = operaciones.toBase128();
        Link previous = null;
        Link current = first;
        while (current != null && key != current.getKey().getCodigoToBase128()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find(int val) {
        Operaciones operaciones = new Operaciones(val);
        long key = operaciones.toBase128();
        Link current = first;
        while (current != null && current.getKey().getCodigoToBase128() <= key) {
            if (current.getKey().getCodigoToBase128() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
