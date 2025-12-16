<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; padding: 50px; background: #f8f9fa; }
        .card { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); max-width: 600px; margin: 0 auto; text-align: center; }
        h1 { color: #2c3e50; }
        p { color: #7f8c8d; font-size: 1.2em; }
        .btn { display: inline-block; padding: 10px 20px; margin: 10px; background: #667eea; color: white; text-decoration: none; border-radius: 5px; }
        .btn-secondary { background: #6c757d; }
    </style>
</head>
<body>
    <div class="card">
        <h1>👋 Welcome, ${loggedInUser.fullName}!</h1>
        <p>You have successfully logged into the Faculty Management System.</p>
        <hr>
        <div style="margin-top: 20px;">
            <p><strong>Department:</strong> ${loggedInUser.department}</p>
            <p><strong>Email:</strong> ${loggedInUser.email}</p>
        </div>
        <br>
        <a href="/faculty/all" class="btn">View All Faculty</a>
        <a href="/faculty/edit-profile" style="padding: 10px 20px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; margin-left: 10px;">Edit My Profile</a>
        <a href="/faculty/login" class="btn btn-secondary">Logout</a>
    </div>
    <div style="text-align: center; margin-bottom: 20px;">
    <c:if test="${not empty sessionScope.loggedInUser.profilePicture}">
        <img src="${sessionScope.loggedInUser.profilePicture}" 
             alt="Profile" 
             style="width: 150px; height: 150px; border-radius: 50%; object-fit: cover; border: 3px solid #667eea;">
    </c:if>
    
    <c:if test="${empty sessionScope.loggedInUser.profilePicture}">
        <div style="width: 150px; height: 150px; background: #ddd; border-radius: 50%; display: inline-flex; align-items: center; justify-content: center; font-size: 50px; color: #666;">
            ${sessionScope.loggedInUser.fullName.charAt(0)}
        </div>
    </c:if>
	</div>
</body>
</html>