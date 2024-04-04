package org.eparedes.poointerfaces;

import org.eparedes.poointerfaces.modelo.Producto;
import org.eparedes.poointerfaces.repositorio.Direccion;
import org.eparedes.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.eparedes.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 50.52));
        repo.crear(new Producto("silla", 18));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 400.89));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("===== paginable =====");
        List<Producto> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenar =====");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
        for (Producto p: productosOrdenAsc){
            System.out.println(p);
        }

        System.out.println("===== editar =====");
        Producto lamparaActualizar = new Producto("lampara escritorio", 23);
        lamparaActualizar.setId(3);

        repo.editar(lamparaActualizar);
        Producto lampara = repo.porId(3);
        System.out.println(lampara);
        System.out.println("==================");
        repo.listar("precio", Direccion.ASC).forEach(System.out::println);

        System.out.println("===== eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("===== total =====");
        System.out.println("Total Registros: " + repo.total());
    }
}
