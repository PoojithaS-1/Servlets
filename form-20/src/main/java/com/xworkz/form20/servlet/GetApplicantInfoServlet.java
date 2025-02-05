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

@WebServlet(urlPatterns = "/getApplicant")
public class GetApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GymApplyService gymApplyService =new GymApplyServiceImpl();
        GymApplyDto gymApplyDto = gymApplyService.getApplicantById(Integer.parseInt(id));
        System.out.println(gymApplyDto);
        req.setAttribute("memberInfo", gymApplyDto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);
    }
}
