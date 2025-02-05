package com.xworkz.form20.servlet;

import com.xworkz.form20.service.GymApplyService;
import com.xworkz.form20.service.GymApplyServiceImpl;

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
        String id = req.getParameter("id");
        GymApplyService gymApplyService =new GymApplyServiceImpl();
        gymApplyService.deleteById(Integer.parseInt(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllApplicantInfo");
        dispatcher.forward(req, resp);
    }
}
