package org.eparedes.poointerfaces.repositorio;

import org.eparedes.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
