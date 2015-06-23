
public class HashDouble {

    private Libro hashArray[];
    private int arraySize;
    private Libro nonItem;

    public HashDouble(int size) {
        arraySize = size;
        hashArray = new Libro[arraySize];
        nonItem = new Libro();
    }

    public void displayTable() {
        System.out.println("Tabla");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].toString());
            } else {
                System.out.print("** ");
            }
            System.out.println("");
        }
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, Libro item) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getCodigo() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public Libro delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getCodigo() == key) {
                Libro temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public Libro find(int key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null){
            if (hashArray[hashVal].getCodigo() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
