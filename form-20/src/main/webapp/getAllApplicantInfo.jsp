<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="poo" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gym Applicant Info</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 40px auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #ddd;
        }

        .head {
            text-align: center;
            margin-bottom: 20px;
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
    <h1 class="head">GYM APPLICANT INFO</h1>
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
            <th>Membership Plan</th>
            <th>Action</th>
        </tr>
        <poo:forEach items="${ListOfApplicants}" var="memberInfo">
            <tr>
                <td>${memberInfo.id}</td>
                <td>${memberInfo.fullName}</td>
                <td>${memberInfo.dob}</td>
                <td>${memberInfo.emailId}</td>
                <td>${memberInfo.mobileNumber}</td>
                <td>${memberInfo.address}</td>
                <td>${memberInfo.city}</td>
                <td>${memberInfo.state}</td>
                <td>${memberInfo.pinCode}</td>
                <td>${memberInfo.membershipPlan}</td>
                <td><a href="delete?id=${memberInfo.id}"><i class="material-icons">delete</i></a>&nbsp;
                <a href="getApplicant?id=${memberInfo.id}"><i class="material-icons">edit</i></a></td>
            </tr>
        </poo:forEach>
    </table>
</body>
</html>