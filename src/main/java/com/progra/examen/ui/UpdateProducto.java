package com.progra.examen.ui;
import com.progra.examen.entities.Producto;
import com.progra.examen.service.ServicioProducto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateProducto")
public class UpdateProducto extends HttpServlet{
    private static final long version = 1L;
    public UpdateProducto() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Producto> productos;
            String nombre;
            nombre = request.getParameter("nombre");
            HttpSession session = request.getSession();
            productos = (ArrayList<Producto>)
                    session.getAttribute("productos");
            for (int i=0; i<productos.size(); i++){
                Producto producto;
                producto = productos.get(i);
                if(producto.getNombre().equals(nombre)){
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("ActualizarProducto2.jsp")
                            .forward(request, response);
                }
            }
        }catch(Exception e){
            request.getRequestDispatcher("error.jsp")
                    .forward( request, response);
            System.out.print(e.getMessage());
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
