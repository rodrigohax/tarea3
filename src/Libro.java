import java.math.BigInteger;

public class Libro {
    private int codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private int anho;
    private String editorial;
    private String materia;
    private int copias;
    private boolean estado;

    public Libro() {
        this.codigo = -1;
    }

    public Libro(int codigo, String isbn, String autor, String titulo, int anho, String editorial, String materia, int copias, boolean estado) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.anho = anho;
        this.editorial = editorial;
        this.materia = materia;
        this.copias = copias;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String toString() {
        return codigo + "\t" + isbn + "\t" + autor + "\t" + titulo + "\t" + anho + "\t"
                + editorial + "\t" + materia + "\t" + copias + "\t" + estado;
    }

    //transformación del codigo del libro a base 128
    public long getCodigoToBase128() {
        String cadena = Integer.toString(codigo);//transformamos de int a string
        int aux = cadena.length() - 1;
        long suma = 0;
        for (int i = 0; i < cadena.length(); i++) {
            suma = suma + (int) ((int) cadena.charAt(i) * Math.pow(128, aux));
            aux--;
        }
        return suma;
    }

    public int trunk() {
        BigInteger valor = BigInteger.valueOf(getCodigoToBase128()*getCodigoToBase128());
        String aux="";
        for (int i = 0; i < 2; i++) {
          aux=aux+valor.toString().charAt(i);
        }
        return Integer.parseInt(aux);
    }
    
    public int pleg(){
        BigInteger valor = BigInteger.valueOf(getCodigoToBase128()*getCodigoToBase128());
        String str = valor.toString();
        int suma=0;
        for (int i = 0; i < str.length(); i++) {
            suma=suma+Character.getNumericValue(str.charAt(i));
        }
        return suma;
    }
    public static void main(String[] args) {
        String cadena = "123455	9789500731607	King	Carrie	1974	Doubleday	Terror	12	true";
        String datos[] = cadena.split("\t");
        Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
 
        System.out.println(libro.getCodigoToBase128());
        System.out.println(libro.getCodigoToBase128()*libro.getCodigoToBase128());
        System.out.println(libro.trunk());
        libro.pleg();
    }
}