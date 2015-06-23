public class HashTable {

    private Libro hashArray[];
    private int arraySize;
    private Libro nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new Libro[arraySize];
        nonItem = new Libro();//constructor sin argumentos ya que es nulo
    }

    public void displayTable() {
        System.out.println("Tabla");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getCodigo());
            } else {
                System.out.print("** ");
            }
            System.out.println("");
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Libro item) {
        int key = item.getCodigo();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getCodigo() == -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public Libro delete(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null){
            if (hashArray[hashVal].getCodigo() == key){
                Libro temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
    
    public Libro find(int key){
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getCodigo() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}
