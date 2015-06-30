//ejercicio c
public class HashTableC {

    private SortedList[] hashArray;
    private int arraySize;

    public HashTableC(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++){
            System.out.print((j+1) + " "); 
            hashArray[j].displayList();
        }
    }

    public long hashFunc(long key) {
        return key % arraySize;
    }
    //Le entregamos un un link , de este obtemeos su key y luego su codigo en base 128
    //llamamos a la funcion hashFunc y le pasamos la key
    //lo insertamos en el hashArray
    public void insert(Link theLink) {
        long key = theLink.getKey().getCodigoToBase128();
        int hashVal = (int)hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = (int) hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = (int) hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
