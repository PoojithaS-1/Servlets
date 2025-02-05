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
import java.util.List;

@WebServlet(urlPatterns = "/getAllApplicantInfo")
public class GetAllApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankingApplyService bankingApplyService =new BankingApplyServiceImpl();
        List<BankingApplyDto> dtoList= bankingApplyService.getAllApplicantInfo();
        req.setAttribute("ListOfApplicants", dtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getAllApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);

    }
}
