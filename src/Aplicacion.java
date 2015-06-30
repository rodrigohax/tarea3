import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Archivo archivo = new Archivo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige tu opción");
        System.out.println("1.-Ingresar datos\n2.-Imprimir Datos\n3.-Tabla de Hashing con encademaniento separado desde archivo de texto"
                + "\n4.-Tabla de hashing con doble hashing desde archivo de texto\n5.-Tabla de hashing con doble hashing utilizando la función trunk"
                + "\n6.-Tabla de hashing con doble hashing utilizando la función pleg");
        int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingresa el codigo");
                    int codigo = sc.nextInt();
                    System.out.println("Ingresa isbn");
                    String isbn = sc.next();
                    System.out.println("Ingrese autor");
                    String autor = sc.next();
                    System.out.println("Ingrese titulo");
                    String titulo = sc.next();
                    System.out.println("Ingrese año");
                    int anho = sc.nextInt();
                    System.out.println("Ingrese editorial");
                    String editorial = sc.next();
                    System.out.println("Ingrese Materia");
                    String materia = sc.next();
                    System.out.println("Ingrese copias");
                    int copias = sc.nextInt();
                    System.out.println("Ingrese estado true/false");
                    boolean estado = sc.nextBoolean();
                    archivo.escribirLibro(new Libro(codigo,isbn,autor,titulo,anho,editorial,materia,
                    copias,estado));
                    break;
                case 2:
                    archivo.imprimir();
                    break;
                case 3:
                    archivo.hashingAbierto();
                case 4:
                    archivo.dobleHashD();
                case 5:
                    archivo.dobleHashE();
                case 6:
                    archivo.dobleHashF();
                    break;
                default: System.out.println("Elige opción correcta");
                    break;
            }
    }
              
}
