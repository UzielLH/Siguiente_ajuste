/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simumemoria2;

/**
 *
 * @author Uziel
 */
public class Particion {
    int id;
    int tamano;
    boolean ocupada;
    String nombreProceso;
    public Particion(int id,int tamano){
        this.id=id;
        this.tamano=tamano;
        this.ocupada=false;
        this.nombreProceso="";
}
}