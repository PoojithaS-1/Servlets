package com.xworkz.form11.servlet;

import com.xworkz.form11.dto.BirthCertificateDto;
import com.xworkz.form11.service.BirthCertificateService;
import com.xworkz.form11.service.BirthCertificateServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyBirthCertificate")
public class BirthCertificateServlet extends HttpServlet {
    public BirthCertificateServlet(){
        System.out.println("BirthCertificateServlet cons invoked");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String childName = req.getParameter("childName");
        String dob = req.getParameter("dob");
        String placeOfBirth = req.getParameter("placeOfBirth");
        String fatherName = req.getParameter("fatherName");
        String motherName = req.getParameter("motherName");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String pinCode = req.getParameter("pinCode");

        BirthCertificateDto dto = new BirthCertificateDto();
        dto.setChildName(childName);
        dto.setDob(dob);
        dto.setPlaceOfBirth(placeOfBirth);
        dto.setFatherName(fatherName);
        dto.setMotherName(motherName);
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));

        BirthCertificateService birthCertificateService = new BirthCertificateServiceImpl();
        birthCertificateService.validateAndSave(dto);

        req.setAttribute("childName",childName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
        requestDispatcher.forward(req,resp);

//        PrintWriter writer = resp.getWriter();
//        writer.write("ThankYou for Applying Birth Certificate for " + childName + " !!!");
    }
}