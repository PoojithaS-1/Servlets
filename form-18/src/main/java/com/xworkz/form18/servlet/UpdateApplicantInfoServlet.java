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

@WebServlet(urlPatterns = "/updateApplicantInfo")
public class UpdateApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudIdDto dto=new StudIdDto();
        dto.setStudId(Integer.parseInt(req.getParameter("studId")));
        dto.setFullName(req.getParameter("fullName"));
        dto.setDob(req.getParameter("dob"));
        dto.setEmailId(req.getParameter("emailId"));
        dto.setMobileNumber(Long.parseLong(req.getParameter("mobileNumber")));
        dto.setAddress(req.getParameter("address"));
        dto.setCity(req.getParameter("city"));
        dto.setState(req.getParameter("state"));
        dto.setPinCode(Integer.parseInt(req.getParameter("pinCode")));
        dto.setCourseName(req.getParameter("courseName"));
        dto.setInstituteName(req.getParameter("instituteName"));
        dto.setAcademicYear(Integer.parseInt(req.getParameter("academicYear")));

        StudIdService studIdService =new StudIdServiceImpl();

        studIdService.updateApplicantInfo(dto);
        req.setAttribute("updateMsg","Applicant Info Updated Successfully");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);

    }
}
