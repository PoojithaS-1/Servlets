package com.xworkz.form20.servlet;

import com.xworkz.form20.dto.GymApplyDto;
import com.xworkz.form20.service.GymApplyService;
import com.xworkz.form20.service.GymApplyServiceImpl;

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
        GymApplyService gymApplyService =new GymApplyServiceImpl();
        List<GymApplyDto> dtoList= gymApplyService.getAllApplicantInfo();
        req.setAttribute("ListOfApplicants", dtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getAllApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);

    }
}
