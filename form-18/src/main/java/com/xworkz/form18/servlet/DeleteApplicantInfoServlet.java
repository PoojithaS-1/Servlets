package com.xworkz.form18.servlet;

import com.xworkz.form18.service.StudIdService;
import com.xworkz.form18.service.StudIdServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studId = req.getParameter("studId");
        StudIdService studIdService =new StudIdServiceImpl();
        studIdService.deleteById(Integer.parseInt(studId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllApplicantInfo");
        dispatcher.forward(req, resp);
    }
}
