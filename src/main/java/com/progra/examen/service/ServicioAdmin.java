package com.progra.examen.service;
import com.progra.examen.entities.Producto;
import java.util.ArrayList;

public interface ServicioAdmin extends Servicio{
    public boolean insert(Producto p);
    public boolean update(Producto p);
    public boolean delete(Producto p);
    public ArrayList<Producto> consulta();
}
