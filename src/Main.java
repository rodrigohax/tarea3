
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Main {
    public static void main(String[] args) {
        Archivo archivo = new Archivo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige tu opción kenita");
        System.out.println("1.-Ingresar datos\n2.-Imprimir Datos\n3.-Hashing Abierto desde archivo de texto");
        int opcion = sc.nextInt();
        do {
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
                default: System.out.println("Kenita tonta");
            }
        } while (opcion==4);
    }
              
}
