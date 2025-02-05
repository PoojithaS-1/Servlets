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
import java.util.List;

@WebServlet(urlPatterns = "/getAllApplicantInfo")
public class GetAllApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudIdService studIdService =new StudIdServiceImpl();
        List<StudIdDto> dtoList= studIdService.getAllApplicantInfo();
        req.setAttribute("ListOfApplicants", dtoList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getAllApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);

    }
}
