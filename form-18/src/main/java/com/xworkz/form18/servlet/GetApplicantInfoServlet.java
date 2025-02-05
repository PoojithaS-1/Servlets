package com.xworkz.form18.servlet;

import com.xworkz.form18.dto.StudIdDto;
import com.xworkz.form18.service.StudIdService;
import com.xworkz.form18.service.StudIdServiceImpl;

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
        String studId = req.getParameter("studId");
        StudIdService studIdService =new StudIdServiceImpl();
        StudIdDto studIdDto = studIdService.getApplicantById(Integer.parseInt(studId));
        System.out.println(studIdDto);
        req.setAttribute("studentInfo", studIdDto);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);

    }
}
