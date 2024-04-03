package org.eparedes.poointerfaces.repositorio;

import org.eparedes.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
