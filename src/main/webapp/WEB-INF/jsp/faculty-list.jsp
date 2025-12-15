<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Faculty</title>
    <style>
        body { font-family: sans-serif; padding: 30px; background: #f4f7f6; }
        h1 { text-align: center; color: #333; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1); border-radius: 8px; overflow: hidden; }
        th, td { padding: 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #667eea; color: white; }
        tr:hover { background-color: #f1f1f1; }
        .back-btn { display: inline-block; margin-bottom: 20px; padding: 10px 15px; background: #333; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <a href="/faculty/dashboard" class="back-btn">← Back to Dashboard</a>
    <h1>📋 Faculty Directory</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Mobile</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="faculty" items="${facultyList}">
                <tr>
                    <td>${faculty.id}</td>
                    <td>${faculty.fullName}</td>
                    <td>${faculty.email}</td>
                    <td>${faculty.department}</td>
                    <td>${faculty.mobileNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>