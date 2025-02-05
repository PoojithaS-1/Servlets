<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="poo" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Student ID Card Application</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}

		form {
			width: 50%;
			margin: 40px auto;
			padding: 20px;
			background-color: #fff;
			border: 1px solid #ddd;
			border-radius: 10px;
		}

		h1 {
			text-align: center;
		}

		label {
			display: block;
			margin-bottom: 10px;
		}

		input[type="text"], input[type="email"], input[type="tel"] {
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
		}

	</style>
</head>
<body>
	<form action="updateApplicantInfo" method="post">
		<h1>Student ID Card Application Form</h1>
		<input type="text" hidden placeholder="Enter ApplicantId" name="studId" value="${ studentInfo.getStudId() }">
                		<label>Enter Full Name:</label>
                                <input type="text" name="fullName" value="${ studentInfo.getFullName() }"><br>

                                <label>Enter Date of Birth:</label>
                                <input type="text" name="dob" value="${ studentInfo.getDob() }"><br>

                                <label>Enter Email ID:</label>
                                <input type="email" name="emailId" value="${ studentInfo.getEmailId() }"><br>

                                <label>Enter Mobile Number:</label>
                                <input type="tel" name="mobileNumber" value="${ studentInfo.getMobileNumber() }"><br>

                                <label>Enter Address:</label>
                                <input type="text" name="address" value="${ studentInfo.getAddress() }"><br>

                                <label>Enter City:</label>
                                <input type="text" name="city" value="${ studentInfo.getCity() }"><br>

                                <label>Enter State:</label>
                                <input type="text" name="state" value="${ studentInfo.getState() }"><br>

                                <label>Enter PIN Code:</label>
                                <input type="text" name="pinCode" value="${ studentInfo.getPinCode() }"><br>
		<label>Enter Institute Name:</label>
		<input type="text" name="instituteName" value="${ studentInfo.getInstituteName() }"><br>
		<label>Enter Course Name:</label>
		<input type="text" name="courseName" value="${ studentInfo.getCourseName() }"><br>
		<label>Enter Academic Year:</label>
		<input type="text" name="academicYear"value="${ studentInfo.getAcademicYear() }"><br>

		<input type="submit" value="Update Student ID Card" name="applyStudentIDCard">
										<h2>${updateMsg}</h2>

	</form>
		<a href="getAllApplicantInfo">Get All Applicant Info</a>

</body>
</html>