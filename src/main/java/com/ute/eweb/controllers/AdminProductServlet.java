package com.ute.eweb.controllers;

import com.ute.eweb.beans.Product;
import com.ute.eweb.models.ProductModel;
import com.ute.eweb.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductServlet", value = "/Admin/Product/*")
public class AdminProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Product> list = ProductModel.findAll();
                request.setAttribute("products", list);
                ServletUtils.forward("/views/vwProduct/Index.jsp", request, response);
                break;

            // case "/Add":
            //   ServletUtils.forward("/views/vwCategory/Add.jsp", request, response);
            //   break;
            //
            // case "/Edit":
            //   int id = 0;
            //   try {
            //     id = Integer.parseInt(request.getParameter("id"));
            //   } catch (NumberFormatException e) {
            //   }
            //
            //   Category c = CategoryModel.findById(id);
            //   if (c != null) {
            //     request.setAttribute("category", c);
            //     ServletUtils.forward("/views/vwCategory/Edit.jsp", request, response);
            //   } else {
            //     ServletUtils.redirect("/Admin/Category", request, response);
            //     // ServletUtils.forward("/views/204.jsp", request, response);
            //   }
            //   break;

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String path = request.getPathInfo();
        // switch (path) {
        //   case "/Add":
        //     addCategory(request, response);
        //     break;
        //
        //   case "/Delete":
        //     deleteCategory(request, response);
        //     break;
        //
        //   case "/Update":
        //     updateCategory(request, response);
        //     break;
        //
        //   default:
        //     ServletUtils.forward("/views/404.jsp", request, response);
        //     break;
        // }
    }

    // private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //   String name = request.getParameter("CatName");
    //   Category c = new Category(name);
    //   CategoryModel.add(c);
    //   ServletUtils.forward("/views/vwCategory/Add.jsp", request, response);
    // }
    //
    // private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //   int id = Integer.parseInt(request.getParameter("CatID"));
    //   String name = request.getParameter("CatName");
    //   Category c = new Category(id, name);
    //   CategoryModel.update(c);
    //   ServletUtils.redirect("/Admin/Category", request, response);
    // }
    //
    // private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //   int id = Integer.parseInt(request.getParameter("CatID"));
    //   CategoryModel.delete(id);
    //   ServletUtils.redirect("/Admin/Category", request, response);
    // }
}