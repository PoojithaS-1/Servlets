package com.xworkz.form19.servlet;

import com.xworkz.form19.dto.BankingApplyDto;
import com.xworkz.form19.service.BankingApplyService;
import com.xworkz.form19.service.BankingApplyServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getApplicant")
public class GetApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BankingApplyService bankingApplyService =new BankingApplyServiceImpl();
        BankingApplyDto bankingApplyDto = bankingApplyService.getApplicantById(Integer.parseInt(id));
        System.out.println(bankingApplyDto);
        req.setAttribute("accountInfo", bankingApplyDto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);
    }
}
