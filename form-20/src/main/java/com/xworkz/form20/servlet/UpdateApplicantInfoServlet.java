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

@WebServlet(urlPatterns = "/updateApplicantInfo")
public class UpdateApplicantInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GymApplyDto dto=new GymApplyDto();
        dto.setId(Integer.parseInt(req.getParameter("id")));
        dto.setFullName(req.getParameter("fullName"));
        dto.setDob(req.getParameter("dob"));
        dto.setEmailId(req.getParameter("emailId"));
        dto.setMobileNumber(Long.parseLong(req.getParameter("mobileNumber")));
        dto.setAddress(req.getParameter("address"));
        dto.setCity(req.getParameter("city"));
        dto.setState(req.getParameter("state"));
        dto.setPinCode(Integer.parseInt(req.getParameter("pinCode")));
        dto.setMembershipPlan(req.getParameter("membershipPlan"));
        GymApplyService gymApplyService =new GymApplyServiceImpl();

        gymApplyService.updateApplicantInfo(dto);
        req.setAttribute("updateMsg","Applicant Info Updated Successfully");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateApplicantInfo.jsp");
        requestDispatcher.forward(req,resp);
    }
}
