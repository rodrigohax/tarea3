/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class test {
    public static void main(String[] args) {
        String palabra = "alo";
        toAscii(palabra);
    }
    
        public static void toAscii(String palabra){
        int aux=palabra.length()-1;
        int suma=0;
        for (int i = 0; i < palabra.length(); i++) {
            System.out.println((int)palabra.charAt(i)+"* 128^"+aux);
            //suma=(int)((int)palabra.charAt(i)*Math.pow(128,aux));
            aux--;
        }
    }
}
