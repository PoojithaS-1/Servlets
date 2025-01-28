package com.xworkz.form10.servlet;

import com.xworkz.form10.dto.RationCardDto;
import com.xworkz.form10.service.RationCardService;
import com.xworkz.form10.service.RationCardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyRationCard")
public class RationCardServlet extends HttpServlet {
    public RationCardServlet(){
        System.out.println("RationCardServlet cons invoked");
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

        RationCardDto dto = new RationCardDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));

        RationCardService rationCardService = new RationCardServiceImpl();
        rationCardService.validateAndSave(dto);

        PrintWriter writer = resp.getWriter();
        writer.write("ThankYou " + fullName + " for Applying Ration Card!!!");
    }
}