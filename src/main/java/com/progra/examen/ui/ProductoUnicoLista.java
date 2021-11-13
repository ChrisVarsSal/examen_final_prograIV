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

@WebServlet(name = "ProductoUnicoLista", urlPatterns = ("/ProductoUnicoLista"))
public class ProductoUnicoLista extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error="";
        try {
            HttpSession session = request.getSession();
            ServicioProducto ps = new ServicioProducto();
            ArrayList<Producto> p = ps.consulta();
            request.setAttribute("p", p);
            session.setAttribute("p", p);
            request.getRequestDispatcher("ListarProductosSolo.jsp").forward( request, response);
        }catch(Exception e){
            System.out.print(e.getMessage());
            error += e.getMessage();
            request.setAttribute("error",error);
            request.getRequestDispatcher("error.jsp").forward( request, response);
        }
    }
}
