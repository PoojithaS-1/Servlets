package com.xworkz.form11.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyBirthCertificate")
public class BirthCertificateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String childName = req.getParameter("childName");
        PrintWriter writer = resp.getWriter();
        writer.write("ThankYou "+childName+" for Applying!!!");
    }
}
