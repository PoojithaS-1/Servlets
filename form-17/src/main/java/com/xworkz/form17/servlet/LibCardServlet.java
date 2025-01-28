package com.xworkz.form17.servlet;

import com.xworkz.form17.dto.LibCardDto;
import com.xworkz.form17.service.LibCardService;
import com.xworkz.form17.service.LibCardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyLibraryCard")
public class LibCardServlet extends HttpServlet {
    public LibCardServlet(){
        System.out.println("LibCardServlet cons invoked");
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

        LibCardDto dto = new LibCardDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));

        LibCardService libCardService = new LibCardServiceImpl();
        libCardService.validateAndSave(dto);

        PrintWriter writer = resp.getWriter();
        writer.write("ThankYou " + fullName + " for Applying Library Card!!!");
    }
}