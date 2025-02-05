package com.xworkz.form19.servlet;

import com.xworkz.form19.service.BankingApplyService;
import com.xworkz.form19.service.BankingApplyServiceImpl;

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
        BankingApplyService bankingApplyService =new BankingApplyServiceImpl();
        bankingApplyService.deleteById(Integer.parseInt(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllApplicantInfo");
        dispatcher.forward(req, resp);
    }
}
