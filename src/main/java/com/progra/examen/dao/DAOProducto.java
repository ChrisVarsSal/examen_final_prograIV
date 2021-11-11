package com.progra.examen.dao;
import com.progra.examen.entities.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOProducto {
    private final Connection connection;

    public DAOProducto() {
        connection = new Conexion().getConnection();
    }

    public boolean insert(Producto producto) {
        try {
            CallableStatement statement = connection.prepareCall("{call insertarProducto (?,?,?,?)}");
            statement.setString("nombre_p", producto.getNombre());
            statement.setInt("cantidad_p", producto.getCantidad());
            statement.setString("descripcion_p", producto.getDescripcion());
            statement.setDouble("precio_p", producto.getPrecio());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(Producto p) {
        try {
            CallableStatement statement = connection.prepareCall("{call eliminaProducto (?)}");
            statement.setInt("id_", p.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Producto p) {
        try {
            CallableStatement statement = connection.prepareCall("{call modificaProducto (?,?,?,?,?)}");
            statement.setString("nom_p", p.getNombre());
            statement.setString("des_p", p.getDescripcion());
            statement.setInt("id_p", p.getId());
            statement.setDouble("pre_p", p.getPrecio());
            statement.setInt("cant_p", p.getCantidad());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Producto> listaProductos() {
        ArrayList<Producto> p = new ArrayList<Producto>();
        try {
            CallableStatement statement = connection.prepareCall("{call listaProductos }");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Producto pro = new Producto();
                pro.setNombre(resultSet.getString("nombre"));
                pro.setDescripcion(resultSet.getString("descripcion"));
                pro.setId(resultSet.getInt("id"));
                pro.setPrecio(resultSet.getDouble("precio"));
                pro.setCantidad(resultSet.getInt("cantidad"));
                p.add(pro);
            }
            return p;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
