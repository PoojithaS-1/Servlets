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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyStudentIDCard")
public class StudIdServlet extends HttpServlet {
    public StudIdServlet(){
        System.out.println("StudIdServlet cons invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("fullName");
        String dob = req.getParameter("dob");
        String emailId = req.getParameter("emailId");
        String mobileNumber = req.getParameter("mobileNumber");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String pinCode = req.getParameter("pinCode");
        String instituteName = req.getParameter("instituteName");
        String courseName = req.getParameter("courseName");
        String academicYear = req.getParameter("academicYear");

        StudIdDto dto = new StudIdDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));
        dto.setInstituteName(instituteName);
        dto.setCourseName(courseName);
        dto.setAcademicYear(Integer.parseInt(academicYear));

        StudIdService studIdService = new StudIdServiceImpl();
        studIdService.validateAndSave(dto);

        req.setAttribute("fullName",fullName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
requestDispatcher.forward(req,resp);
//        PrintWriter writer = resp.getWriter();
//        writer.write("ThankYou " + fullName + " for Applying Student ID!!!");
    }
}
