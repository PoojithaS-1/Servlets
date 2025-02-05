<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gym Membership Application</title>
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            background-color: #f7f7f7;
        }

        form {
            width: 40%;
            margin: 60px auto;
            padding: 40px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #666;
        }

        input[type="text"], input[type="email"], input[type="tel"], input[type="date"] {
            width: 100%;
            height: 40px;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        select {
            width: 100%;
            height: 40px;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            height: 40px;
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #3e8e41;
        }

        a {
            text-decoration: none;
            color: #337ab7;
        }

        a:hover {
            color: #23527c;
        }
    </style>
</head>
<body>
    <form action="updateApplicantInfo" method="post">
    		<input type="text" hidden placeholder="Enter ApplicantId" name="id" value="${ memberInfo.getId() }">

        <h1>Gym Membership Application Form</h1>
        <label>Enter Full Name:</label>
        <input type="text" name="fullName" value="${ memberInfo.getFullName() }"><br>
        <label>Enter Date of Birth:</label>
        <input type="date" name="dob"value="${ memberInfo.getDob() }"><br><br>
        <label>Enter Email ID:</label>
        <input type="email" name="emailId"value="${ memberInfo.getEmailId() }"><br>
        <label>Enter Mobile Number:</label>
        <input type="tel" name="mobileNumber"value="${ memberInfo.getMobileNumber() }"><br>
        <label>Enter Address:</label>
        <input type="text" name="address"value="${ memberInfo.getAddress() }"><br>
        <label>Enter City:</label>
        <input type="text" name="city"value="${ memberInfo.getCity() }"><br>
        <label>Enter State:</label>
        <input type="text" name="state"value="${ memberInfo.getState() }"><br>
        <label>Enter PIN Code:</label>
        <input type="text" name="pinCode"value="${ memberInfo.getPinCode() }"><br>
        <label>Choose Membership Plan:</label>
        <select name="membershipPlan"value="${ memberInfo.getMembershipPlan() }">
            <option value="monthly">Monthly Membership</option>
            <option value="quarterly">Quarterly Membership</option>
            <option value="yearly">Yearly Membership</option>
        </select><br>
        <input type="submit" value="Update Gym Membership" name="applyGymMembership">
        								<h2>${updateMsg}</h2>

    </form>
    <a href="getAllApplicantInfo">Get All Applicant Info</a>
</body>
</html>