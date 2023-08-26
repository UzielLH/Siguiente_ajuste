/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simumemoria2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Uziel
 */
public class Simumemoria2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada= new Scanner (System.in);
        int memoriaTotal=1000;
        List<Particion> particiones=new ArrayList<>();
        List<Proceso> procesos =new ArrayList<>();
        int cantipar;
        int cantiproc;
        int cantisobrante=0;
        int part;
        int tam;
        int tamproc;
            particiones.add(new Particion(1,100));
            procesos.add(new Proceso("Windows",100));

        System.out.print("Digite el numero de particiones: ");
        cantipar=entrada.nextInt();
        for (int i=0;i<cantipar;i++){
            System.out.print("Digite el tamano: ");
            tam=entrada.nextInt();
                    particiones.add(new Particion(i+2,tam));

        }
        System.out.print("Digite el numero de procesos: ");
        cantiproc=entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < cantiproc; i++) {
        System.out.print("Digite el nombre: ");
        String nombreproc = entrada.nextLine();
    
         System.out.print("Digite el tamano: ");
        tamproc = entrada.nextInt();

        // Consumir el carácter de nueva línea
        entrada.nextLine();
    
         procesos.add(new Proceso(nombreproc, tamproc));
}

 int ultimaParticion = 0; 
for(int i = 0; i < procesos.size(); i++) {
    Proceso proceso=procesos.get(i);
    boolean asignado=false;
    for(int j=ultimaParticion;j<particiones.size();j++) {
        Particion particion=particiones.get(j);
        if (!particion.ocupada && particion.tamano >= proceso.tamano) {
            particion.ocupada=true;
            particion.nombreProceso=proceso.nombre;
            asignado=true;
            ultimaParticion=j; 
            System.out.println(proceso.nombre+" asignado a la particion "+particion.id);
                     memoriaTotal=memoriaTotal-particion.tamano;

            cantisobrante=cantisobrante+(particion.tamano-proceso.tamano);
            break;
        }
    }
    if (!asignado) {
        for(int j=0;j<ultimaParticion;j++) {
            Particion particion=particiones.get(j);
            
            if (!particion.ocupada && particion.tamano>=proceso.tamano) {
                particion.ocupada=true;
                particion.nombreProceso=proceso.nombre;
                asignado=true;
                ultimaParticion=j;
                System.out.println(proceso.nombre+" asignado a la particion "+particion.id);
                         memoriaTotal=memoriaTotal-particion.tamano;

                cantisobrante=cantisobrante+(particion.tamano-proceso.tamano);

                break;
            }
        }
        
        if (!asignado) {
            System.out.println(proceso.nombre+" No fue asignado a memoria");
        }
    }
}

        System.out.println("El sistema operativo ocupa 100 de espacio");
        System.out.println("El espacio de memoria sobrante es de si se considera particiones:"+memoriaTotal);
        if(cantisobrante!=0){
                 particiones.add(new Particion(cantipar+2,cantisobrante+memoriaTotal));
         System.out.println("Se creo la particion "+(cantipar+2)+" con el tamano sobrante de "+(cantisobrante+memoriaTotal));
        }
    }
    }
    

