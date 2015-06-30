//ejercicio e
public class DoubleHashE {
    private Libro[] hashArray;
    private int arraySize;
    private Libro nonItem;

    public DoubleHashE(int size) {
        arraySize = size;
        hashArray = new Libro[arraySize];
        nonItem = new Libro(-1);
    }

    // se imprimen solo los datos no nulos y que su codigo sea distinto de -1 ya que se toma que es nulo

    public void displayTable() {
        System.out.println("Tabla: ");
        for (int j = 0; j < arraySize; j++) {
            System.out.print((j + 1) + " ");
            if (hashArray[j] != null && hashArray[j].getCodigo() != -1) {
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
    
// se utiliza el n°127 ya que es primo
    public long hashFunc2(long key) {
        return 127 - key % 127;
    }

//insert a Libro, si se realiza un sondeo se le suma +1,de ahí +2 y asdf
    public void insert(long key, Libro item) {
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int) hashVal] != null && hashArray[(int) hashVal].getTrunk() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[(int) hashVal] = item;
    }
//-------------------------------------------------------------

    public Libro delete(int val) {
        Operaciones operaciones = new Operaciones(val);
        long key = operaciones.trunk();
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int) hashVal] != null) {
            if (hashArray[(int) hashVal].getTrunk() == key) {
                Libro temp = hashArray[(int) hashVal];
                hashArray[(int) hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
//-------------------------------------------------------------

    public Libro find(int val) {
        Operaciones operaciones = new Operaciones(val);
        long key = operaciones.trunk();
        long hashVal = hashFunc1(key);
        long stepSize = hashFunc2(key);
        while (hashArray[(int) hashVal] != null) {
            if (hashArray[(int) hashVal].getTrunk() == key) {
                return hashArray[(int) hashVal];
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}
