
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Archivo {

    public Archivo() {
    }
    
    public void escribirLibro(Libro libro){
        try {
            File file = new File("libros.txt");
            FileWriter fw;
            BufferedWriter bw;
            if(file.exists()){
                fw = new FileWriter(file,true);
                bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(libro.getCodigo() + "%" + libro.getIsbn() + "%" + libro.getAutor() + "%" +
                libro.getTitulo() + "%" + libro.getAnho() + "%" + libro.getEditorial() + "%" + 
                        libro.getMateria() + "%" + libro.getCopias() + "%" + libro.isEstado());
            }else{
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(libro.getCodigo() + "%" + libro.getIsbn() + "%" + libro.getAutor() + "%" +
                libro.getTitulo() + "%" + libro.getAnho() + "%" + libro.getEditorial() + "%" + 
                        libro.getMateria() + "%" + libro.getCopias() + "%" + libro.isEstado());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
    public void imprimir(){
        try {
            File file = new File("libros.txt");
            if(file.exists()){
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea = br.readLine())!=null){
                    String datos[] = linea.split("%");
                    Libro l = new Libro(Integer.parseInt(datos[0]),datos[1],datos[2],
                            datos[3],Integer.parseInt(datos[4]),datos[5],datos[6],
                            Integer.parseInt(datos[7]),Boolean.parseBoolean(datos[8]));
                }
            }else{
                System.out.println("Sin libros");
            }
        } catch (Exception e) {
        }
    }
}
