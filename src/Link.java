/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
//Clase Link de listas enlazadas
class Link {
    private Libro iData;
    public Link next;

    public Link(Libro iData) {
        this.iData = iData;
    }

    public Libro getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.println(iData.toString());
    }
}
