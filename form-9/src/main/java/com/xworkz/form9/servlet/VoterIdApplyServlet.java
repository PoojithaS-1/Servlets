package com.xworkz.form9.servlet;

import com.xworkz.form9.dto.VoterIdApplyDto;
import com.xworkz.form9.service.VoterIdApplyService;
import com.xworkz.form9.service.VoterIdApplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyVoterID")
public class VoterIdApplyServlet extends HttpServlet {
    public VoterIdApplyServlet(){
        System.out.println("VoterIdApplyServlet cons invoked");
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

        VoterIdApplyDto dto = new VoterIdApplyDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));

        VoterIdApplyService voterIdApplyService = new VoterIdApplyServiceImpl();
        voterIdApplyService.validateAndSave(dto);

        PrintWriter writer = resp.getWriter();
        writer.write("ThankYou " + fullName + " for Applying Voter ID!!!");
    }
}