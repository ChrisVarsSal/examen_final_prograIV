package com.progra.examen.service;
import com.progra.examen.entities.Producto;
import java.util.ArrayList;

interface Servicio {
    boolean insert(Producto p);
    boolean update(Producto p);
    boolean delete(Producto p);
    ArrayList<Producto> consulta();
}
