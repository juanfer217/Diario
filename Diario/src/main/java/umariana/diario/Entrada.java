/*
@ Juan Jaramillo - Samuel Betancourth
*/

package umariana.diario;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Entrada {

    ArrayList<Entrada> misEntradas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private int idEntrada;
    private String descripcion;
    private Date fecha;

    public Entrada(int idEntrada, String descripcion, Date fecha) {
        this.idEntrada = idEntrada;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Entrada() {

    }

   
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void mostrarMenu() {

        boolean activo = true;

        do {
            System.out.println("  _________________________");
            System.out.println("()     DIARIO PERSONAL     |");
            System.out.println("()                         |");
            System.out.println("() 1. Agregar Entrada      |");
            System.out.println("() 2. Consultar Entrada    |");
            System.out.println("() 3. Modificar Entrada    |");
            System.out.println("() 4. Eliminar Entrada     |");
            System.out.println("() 5. Salir                |");
            System.out.println("()_________________________|");

            int opcion = sc.nextInt();
            switch (opcion) {

                case 1:
                    agregarEntrada();
                    break;
                case 2:
                    consultarEntrada();
                    break;
                case 3:
                    modificarEntrada();
                    break;
                case 4:
                    eliminarEntrada();
                    break;
                case 5:
                    activo = false;
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (activo);
    }

    public void agregarEntrada() {
        int tamanoLista = misEntradas.size();
        int nuevoIdEntrada = 1; 

        if (tamanoLista > 0) {
            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
            nuevoIdEntrada = ultimaEntrada.getIdEntrada() + 1;
        }

        System.out.println("Nueva entrada con id:  " + nuevoIdEntrada);

        System.out.println("Ingrese una descripcion:");
        sc.nextLine(); 
        String descripcion = sc.nextLine();

        Date fecha = new Date();
        DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Fecha de entrada ");
        System.out.println(formateadorFechaLarga.format(fecha));
      

        Entrada nuevaEntrada = new Entrada(nuevoIdEntrada, descripcion, fecha);
        misEntradas.add(nuevaEntrada);
        System.out.println("-----ENTRADA AGREGADA-----");
    }

    public void consultarEntrada() {
        System.out.println("Lista de entradas:");
        for (Entrada entrada : misEntradas) {
            System.out.println("ID: " + entrada.getIdEntrada());
            System.out.println("Descripción: " + entrada.getDescripcion());
            System.out.println("Fecha: " + entrada.getFecha());
            System.out.println("-----------------------------");
        }
    }

  public void eliminarEntrada() {
        System.out.println(" Digite el id de la entrada que quiere eliminar");
        int id = sc.nextInt();
        Iterator<Entrada> it = misEntradas.iterator();

        while (it.hasNext()) {
            Entrada e = it.next();
            if (e.getIdEntrada() == id) {
                  it.remove();
                System.out.println("Entrada con id " + id + " ha sido eliminada");
            } else {
                System.out.println("NO EXISTE LA ID");
              
            }
            
        }
    }

    public void modificarEntrada() {
    System.out.println("Digite el id de la entrada que desea modificar:");
    int id = sc.nextInt();
    sc.nextLine(); 

    Entrada entradaModificada = null;

    for (Entrada entrada : misEntradas) {
        if (entrada.getIdEntrada() == id) {
            entradaModificada = entrada;
            break;
        }
    }

    if (entradaModificada != null) {
        System.out.println("Ingrese la nueva descripcion:");
        String nuevaDescripcion = sc.nextLine();
        entradaModificada.setDescripcion(nuevaDescripcion);
        System.out.println("Descripcion Actualizada");
    } else {
        System.out.println("No hay ninguna entrada con el id ingresado");
    }
}
}