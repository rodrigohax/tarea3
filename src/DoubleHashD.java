public class DoubleHashD {
    private Libro[] hashArray;
    private int arraySize;
    private Libro nonItem;
    public DoubleHashD(int size){
        arraySize = size;
        hashArray = new Libro[arraySize];
        nonItem = new Libro();
    }
    
    public void displayTable() {
        System.out.println("Tabla: ");
        for (int j = 0; j < arraySize; j++) {
            System.out.print((j+1)+" ");
            if (hashArray[j] != null && hashArray[j].getCodigo()!=-1) {
                System.out.println(hashArray[j].toString() + " ");
            } else {
                System.out.println("** ");
            }
        }
        System.out.println("");
    }

    public long hashFunc1(long key) {
        return key % arraySize;
    }

    public long hashFunc2(long key) {
        return 127 - key % 127;
    }

//insert a Libro
    public void insert(long key, Libro item){
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int)hashVal] != null && hashArray[(int)hashVal].getCodigoToBase128() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[(int)hashVal] = item;
    }
//-------------------------------------------------------------

    public Libro delete(int key){
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int)hashVal] != null){
            if (hashArray[(int)hashVal].getCodigo() == key) {
                Libro temp = hashArray[(int)hashVal];
                hashArray[(int)hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    } 
//-------------------------------------------------------------

    public Libro find(int key){
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int)hashVal] != null){
            if (hashArray[(int)hashVal].getCodigo() == key) {
                return hashArray[(int)hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize; 
        }
        return null;
    }
}
