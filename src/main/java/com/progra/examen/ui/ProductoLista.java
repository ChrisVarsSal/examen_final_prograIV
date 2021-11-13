package com.progra.examen.ui;
import com.progra.examen.entities.Producto;
import com.progra.examen.service.ServicioProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductoLLista")
public class ProductoLista extends HttpServlet{
    public ProductoLista(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Productos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr><th>Nombre</th> " +
                "<th>Descripcion</th> " +
                "<th>Cantidad</th> " +
                "<th>Precio</th>    " +
                "</tr>");
        ServicioProducto ps = new ServicioProducto();
        ArrayList<Producto> p = ps.consulta();
        for(int i=0; i<p.size(); i++){
            if(i%2==0){
                out.println("<tr bgcolor=\"#FFFFFF\">");
                out.println("<td>" + p.get(i).getNombre() + "</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getDescripcion()+"</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getCantidad() +"</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getPrecio() +"</td>");
                out.println("</tr>");
            }else{
                out.println("<tr>");
                out.println("<td>" + p.get(i).getNombre() + "</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getDescripcion()+"</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getCantidad() +"</td>");
                out.println("<td align=\"center\" valign=\"top\">"+ p.get(i).getPrecio() +"</td>");
                out.println("</tr>");
            }
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
