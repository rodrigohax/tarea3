import java.io.*;

public class Archivo {

    private HashTableC theHashTableA;
    private DoubleHashD theDoubleHashD;
    private DoubleHashE theDoubleHashE;
    private DoubleHashF theDoubleHashF;

    public Archivo() {
        this.theHashTableA = new HashTableC(131);
        this.theDoubleHashD = new DoubleHashD(131);
        this.theDoubleHashE = new DoubleHashE(131);
        this.theDoubleHashF = new DoubleHashF(131);
    }

    public void escribirLibro(Libro libro) {
        try {
            File file = new File("libros.txt");
            FileWriter fw;
            BufferedWriter bw;
            if (file.exists()) {
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(libro.getCodigo() + "\t" + libro.getIsbn() + "\t" + libro.getAutor() + "\t"
                        + libro.getTitulo() + "\t" + libro.getAnho() + "\t" + libro.getEditorial() + "\t"
                        + libro.getMateria() + "\t" + libro.getCopias() + "\t" + libro.isEstado());
            } else {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(libro.getCodigo() + "\t" + libro.getIsbn() + "\t" + libro.getAutor() + "\t"
                        + libro.getTitulo() + "\t" + libro.getAnho() + "\t" + libro.getEditorial() + "\t"
                        + libro.getMateria() + "\t" + libro.getCopias() + "\t" + libro.isEstado());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }

    public void imprimir() {
        try {
            File file = new File("libros.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                System.out.println("Codigo\tISBN\t\tAutor\t\tTitulo\t\t\t\t\t\t\tAño\tEditorial\tMateria\t\t"
                        + "Copias\tEstado");
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split("\t");
                    Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                            datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                            Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
                    System.out.println(libro.toString());;
                }
            } else {
                System.out.println("Sin libros");
            }
        } catch (Exception e) {
        }
    }

    // Tabla de hash con encadenamiento separado
    public void hashingAbierto() {
        try {
            File file = new File("libros.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split("\t");
                    Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                            datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                            Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
                    Link link = new Link(libro);
                    theHashTableA.insert(link);
                }
                theHashTableA.displayTable();
            } else {
                System.out.println("No hay libros");
            }
        } catch (Exception e) {
        }
    }
    // doble hashing 
    public void dobleHashD() {
        try {
            File file = new File("libros.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split("\t");
                    Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                            datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                            Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
                    theDoubleHashD.insert(libro.getCodigoToBase128(), libro);
                }
                theDoubleHashD.displayTable();
            } else {
                System.out.println("No hay libros");
            }
        } catch (Exception e) {
        }
    }
    
    public void dobleHashE() {
        try {
            File file = new File("libros.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split("\t");
                    Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                            datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                            Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
                    theDoubleHashE.insert(libro.getTrunk(), libro);
                }
                theDoubleHashE.displayTable();
            } else {
                System.out.println("No hay libros");
            }
        } catch (Exception e) {
        }
    }
    
        public void dobleHashF() {
        try {
            File file = new File("libros.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String datos[] = linea.split("\t");
                    Libro libro = new Libro(Integer.parseInt(datos[0]), datos[1], datos[2],
                            datos[3], Integer.parseInt(datos[4]), datos[5], datos[6],
                            Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]));
                    theDoubleHashF.insert(libro.getPleg(), libro);
                }
                theDoubleHashF.displayTable();
            } else {
                System.out.println("No hay libros");
            }
        } catch (Exception e) {
        }
    }
}
