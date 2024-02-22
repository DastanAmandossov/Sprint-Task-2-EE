package Servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Items;

import java.io.IOException;

@WebServlet(value = "/addItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Items item = new Items();
        item.setName(name);
        item.setDescription(desc);
        item.setPrice(price);
        DBManager.addItem(item);
        resp.sendRedirect("/home");
    }
}
