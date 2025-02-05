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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyGymMembership")
public class GymApplyServlet extends HttpServlet {
    public GymApplyServlet(){
        System.out.println("GymApplyServlet cons invoked");
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
        String membershipPlan = req.getParameter("membershipPlan");

        GymApplyDto dto = new GymApplyDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));
        dto.setMembershipPlan(membershipPlan);

        GymApplyService gymApplyService = new GymApplyServiceImpl();
        gymApplyService.validateAndSave(dto);

         req.setAttribute("fName",fullName);//scope
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");//servlet chaining
        requestDispatcher.forward(req,resp);

//        PrintWriter writer = resp.getWriter();
//        writer.write("ThankYou " + fullName + " for Applying Gym Membership!!!");

    }
}