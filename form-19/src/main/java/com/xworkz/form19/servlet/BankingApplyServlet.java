package com.xworkz.form19.servlet;

import com.xworkz.form19.dto.BankingApplyDto;
import com.xworkz.form19.service.BankingApplyService;
import com.xworkz.form19.service.BankingApplyServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/applyBanking")
public class BankingApplyServlet extends HttpServlet {
    public BankingApplyServlet(){
        System.out.println("BankingApplyServlet cons invoked");
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
        String accountType = req.getParameter("accountType");
        String initialDeposit = req.getParameter("initialDeposit");

        BankingApplyDto dto = new BankingApplyDto();
        dto.setFullName(fullName);
        dto.setDob(dob);
        dto.setEmailId(emailId);
        dto.setMobileNumber(Long.parseLong(mobileNumber));
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPinCode(Integer.parseInt(pinCode));
        dto.setAccountType(accountType);
        dto.setInitialDeposit(Double.parseDouble(initialDeposit));

        BankingApplyService bankingApplyService = new BankingApplyServiceImpl();
        bankingApplyService.validateAndSave(dto);

        req.setAttribute("fullName",fullName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("response.jsp");
requestDispatcher.forward(req,resp);
//        PrintWriter writer = resp.getWriter();
//        writer.write("ThankYou " + fullName + " for Applying Banking!!!");
    }
}
