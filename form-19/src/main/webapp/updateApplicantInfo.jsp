<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Banking Application</title>
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

		input[type="text"], input[type="email"], input[type="tel"], input[type="number"] {
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
		<h1>Banking Application Form</h1>
				<input type="text" hidden placeholder="Enter ApplicantId" name="id" value="${ accountInfo.getId() }">

		<label>Enter Full Name:</label>
		<input type="text" name="fullName" value="${ accountInfo.getFullName() }"><br>
		<label>Enter Date of Birth:</label>
		<input type="date" name="dob" value="${ accountInfo.getDob() }"><br><br>
		<label>Enter Email ID:</label>
		<input type="email" name="emailId" value="${ accountInfo.getEmailId() }"><br>
		<label>Enter Mobile Number:</label>
		<input type="tel" name="mobileNumber" value="${ accountInfo.getMobileNumber() }"><br>
		<label>Enter Address:</label>
		<input type="text" name="address"value="${ accountInfo.getAddress() }"><br>
		<label>Enter City:</label>
		<input type="text" name="city"value="${ accountInfo.getCity() }"><br>
		<label>Enter State:</label>
		<input type="text" name="state"value="${ accountInfo.getState() }"><br>
		<label>Enter PIN Code:</label>
		<input type="text" name="pinCode"value="${ accountInfo.getPinCode() }"><br>
		<label>Enter Account Type:</label>
		<select name="accountType"value="${ accountInfo.getAccountType() }">
			<option value="savings">Savings Account</option>
			<option value="current">Current Account</option>
		</select><br>
		<label>Enter Initial Deposit:</label>
		<input type="text" name="initialDeposit"value="${ accountInfo.getInitialDeposit() }"><br>

		<input type="submit" value="Update Banking" name="applyBanking">
										<h2>${updateMsg}</h2>

	</form>
			<a href="getAllApplicantInfo">Get All Applicant Info</a>

</body>
</html>
