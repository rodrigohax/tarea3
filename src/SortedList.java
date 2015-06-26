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
    
    public void delete(int key) {
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

    public Link find(int key){
        Link current = first;
        while (current != null && current.getKey().getCodigo() <= key){
            if (current.getKey().getCodigo() == key) 
            {
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
