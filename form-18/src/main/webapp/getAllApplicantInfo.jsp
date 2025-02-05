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
<h1 class="head">APPLICANT INFO</h1>
<table>
    <tr>
        <th>SL NO</th>
        <th>Full Name</th>
        <th>Date of Birth</th>
        <th>Email ID</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Pin Code</th>
        <th>Institute Name</th>
        <th>Course Name</th>
        <th>Academic Year</th>
        <th>Action</th>
    </tr>
    <poo:forEach items="${ListOfApplicants}" var="studentInfo">
        <tr>
            <td>${studentInfo.studId}</td>
            <td>${studentInfo.fullName}</td>
            <td>${studentInfo.dob}</td>
            <td>${studentInfo.emailId}</td>
            <td>${studentInfo.mobileNumber}</td>
            <td>${studentInfo.address}</td>
            <td>${studentInfo.city}</td>
            <td>${studentInfo.state}</td>
            <td>${studentInfo.pinCode}</td>
            <td>${studentInfo.instituteName}</td>
            <td>${studentInfo.courseName}</td>
            <td>${studentInfo.academicYear}</td>
            <td><a href="delete?studId=${studentInfo.studId}">DELETE</a>&nbsp;
            <a href="getApplicant?studId=${studentInfo.studId}">UPDATE</a></td>
        </tr>
    </poo:forEach>
</table></body></html>