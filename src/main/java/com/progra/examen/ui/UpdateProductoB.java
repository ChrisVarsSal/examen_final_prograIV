package com.progra.examen.ui;
import com.progra.examen.service.ServicioProducto;
import com.progra.examen.entities.Producto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UpdateProductoB", urlPatterns = {"/UpdateProductoB"})
public class UpdateProductoB extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom, descp;
        int id;
        int cant;
        double precio;
        nom = request.getParameter("txtNom");
        descp = request.getParameter("txtDescp");
        id = Integer.parseInt(request.getParameter("txtId"));
        cant = Integer.parseInt(request.getParameter("txtCan"));
        precio = Double.parseDouble(request.getParameter("txtPrecio"));
        Producto p = new Producto();
        p.setNombre(nom);
        p.setDescripcion(descp);
        p.setId(id);
        p.setPrecio(precio);
        p.setCantidad(cant);
        ServicioProducto ps = new ServicioProducto();
        boolean ingreso = ps.update(p);
        if(ingreso){
            request.setAttribute("resp", "El producto ha sido modificado con exito");
            request.getRequestDispatcher("Mostrar.jsp").forward( request, response);
        }else{
            request.setAttribute("respuesta", "Error");
            request.getRequestDispatcher("Mostrar.jsp").forward( request, response);
        }
    }
}
