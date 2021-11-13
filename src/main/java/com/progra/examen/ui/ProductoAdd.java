package com.progra.examen.ui;
import com.progra.examen.entities.Producto;
import com.progra.examen.service.ServicioProducto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductoAdd")
public class ProductoAdd {
    private static final long serialVersionUID = 1L;
    public ProductoAdd() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom, descp;
        int cant;
        double precio;
        nom = request.getParameter("txtNom");
        descp = request.getParameter("txtDescp");
        cant = Integer.parseInt(request.getParameter("txtCant"));
        precio = Double.parseDouble(request.getParameter("txtPrecio"));
        Producto p = new Producto();
        p.setNombre(nom);
        p.setCantidad(cant);
        p.setPrecio(precio);
        p.setDescripcion(descp);
        ServicioProducto ps = new ServicioProducto();
        boolean ingreso = ps.insert(p);
        if(ingreso){
            request.setAttribute("respuesta", "Producto ingresado con exito");
            request.getRequestDispatcher("Mostrar.jsp").forward( request, response);
        }else{
            request.setAttribute("respuesta", "Error");
            request.getRequestDispatcher("Mostrar.jsp").forward( request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
