package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Items;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idshka");
        Items item = DBManager.getItemById(Long.parseLong(id));
        System.out.println(item.getName());
        if(item != null){
            req.setAttribute("detailsItem", item);
            req.getRequestDispatcher("details.jsp").forward(req,resp);
        }
    }
}
