<%@ page language="java" contentType="text/html; charset=US-ASCII"
pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>

        table {
            border-collapse: collapse;
            width: 70%;
            margin-left:15%

        }
        .head{
        text-align:center;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f0f0f0;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<h1 class="head">INCOME CERTIFICATE APPLICANT INFO</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Account Type</th>
        <th>Initial Deposit</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfApplicants}" var="accountInfo">
        <tr>
            <td>${accountInfo.id}</td>
            <td>${accountInfo.fullName}</td>
            <td>${accountInfo.dob}</td>
            <td>${accountInfo.emailId}</td>
            <td>${accountInfo.mobileNumber}</td>
            <td>${accountInfo.address}</td>
            <td>${accountInfo.city}</td>
            <td>${accountInfo.state}</td>
            <td>${accountInfo.pinCode}</td>
            <td>${accountInfo.accountType}</td>
            <td>${accountInfo.initialDeposit}</td>
            <td><a href="delete?id=${accountInfo.id}">DELETE</a>&nbsp;
            <a href="getApplicant?id=${accountInfo.id}">UPDATE</a></td>
        </tr>
    </poo:forEach>
</table>
</body>
</html>