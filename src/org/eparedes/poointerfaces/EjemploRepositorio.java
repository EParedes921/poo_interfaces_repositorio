package org.eparedes.poointerfaces;

import org.eparedes.poointerfaces.modelo.Cliente;
import org.eparedes.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

//        CrudRepositorio repo = new ClienteListRepositorio();
        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "Gonzáles"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("===== paginable =====");
//        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1, 4);
        List<Cliente> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenar =====");
//        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.ASC);
        List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);
        for (Cliente c: clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);

        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        System.out.println("==================");
//        ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC).forEach(System.out::println);
        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);

        System.out.println("===== eliminar =====");
        repo.eliminar(3);
        repo.listar().forEach(System.out::println);

        System.out.println("===== total =====");
        System.out.println("Total Registros: " + repo.total());
    }
}
