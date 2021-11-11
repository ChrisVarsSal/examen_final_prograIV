package com.progra.examen.service;
import com.progra.examen.entities.Producto;
import com.progra.examen.dao.DAOProducto;
import java.util.ArrayList;

public class ServicioProducto implements ServicioAdmin{
    private DAOProducto p = new DAOProducto();
    public ServicioProducto() {}
    public boolean insert(Producto producto) {
        return p.insert(producto);
    }
    public boolean delete(Producto producto) {
        return p.delete(producto);
    }
    public boolean update(Producto producto) {
        return p.update(producto);
    }
    public ArrayList<Producto> consulta() {
        return p.listaProductos();
    }
}
