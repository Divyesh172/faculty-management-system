<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Faculty</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            overflow: hidden;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }
        .header h1 { font-size: 2em; }
        .message {
            padding: 15px;
            margin: 20px;
            border-radius: 5px;
            text-align: center;
            font-weight: bold;
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .content {
            padding: 30px;
        }
        .faculty-grid {
            display: grid;
            gap: 20px;
            margin-bottom: 20px;
        }
        .faculty-card {
            background: #f8f9fa;
            border-radius: 10px;
            padding: 20px;
            border-left: 5px solid #667eea;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .faculty-card:hover {
            transform: translateX(5px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        .faculty-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .faculty-type {
            display: inline-block;
            padding: 5px 15px;
            border-radius: 20px;
            font-size: 0.9em;
            font-weight: bold;
        }
        .type-regular {
            background: #d4edda;
            color: #155724;
        }
        .type-visiting {
            background: #d1ecf1;
            color: #0c5460;
        }
        .type-adhoc {
            background: #fff3cd;
            color: #856404;
        }
        .faculty-info {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin: 15px 0;
        }
        .info-item {
            display: flex;
            flex-direction: column;
        }
        .info-label {
            font-size: 0.85em;
            color: #666;
            margin-bottom: 5px;
        }
        .info-value {
            font-weight: 600;
            color: #333;
        }
        .salary-box {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 15px;
            border-radius: 5px;
            text-align: center;
            margin-top: 15px;
        }
        .salary-box h3 {
            font-size: 1.5em;
            margin-bottom: 5px;
        }
        .delete-btn {
            background: #dc3545;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            font-weight: 600;
            transition: background 0.3s;
        }
        .delete-btn:hover {
            background: #c82333;
        }
        .empty-state {
            text-align: center;
            padding: 60px 20px;
            color: #666;
        }
        .empty-state h2 {
            margin-bottom: 20px;
        }
        .back-link {
            display: block;
            text-align: center;
            margin: 20px;
            color: #667eea;
            text-decoration: none;
            font-weight: 600;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>📋 All Faculty Members</h1>
        </div>
        
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        
        <div class="content">
            <c:choose>
                <c:when test="${empty facultyList}">
                    <div class="empty-state">
                        <h2>No Faculty Members Found</h2>
                        <p>Start by adding faculty members to the system.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="faculty-grid">
                        <c:forEach var="faculty" items="${facultyList}">
                            <div class="faculty-card">
                                <div class="faculty-header">
                                    <h2>${faculty.name}</h2>
                                    <span class="faculty-type type-${faculty.facultyType == 'Regular Faculty' ? 'regular' : (faculty.facultyType == 'Visiting Faculty' ? 'visiting' : 'adhoc')}">
                                        ${faculty.facultyType}
                                    </span>
                                </div>
                                
                                <div class="faculty-info">
                                    <div class="info-item">
                                        <span class="info-label">Faculty ID</span>
                                        <span class="info-value">${faculty.id}</span>
                                    </div>
                                    <div class="info-item">
                                        <span class="info-label">Department</span>
                                        <span class="info-value">${faculty.department}</span>
                                    </div>
                                    <div class="info-item">
                                        <span class="info-label">Email</span>
                                        <span class="info-value">${faculty.email}</span>
                                    </div>
                                    <div class="info-item">
                                        <span class="info-label">Qualification</span>
                                        <span class="info-value">${faculty.qualification}</span>
                                    </div>
                                    
                                    <!-- Regular Faculty Specific -->
                                    <c:if test="${faculty.facultyType == 'Regular Faculty'}">
                                        <div class="info-item">
                                            <span class="info-label">Designation</span>
                                            <span class="info-value">${faculty.designation}</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Experience</span>
                                            <span class="info-value">${faculty.yearsOfExperience} years</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Basic Salary</span>
                                            <span class="info-value">₹${faculty.basicSalary}</span>
                                        </div>
                                    </c:if>
                                    
                                    <!-- Visiting Faculty Specific -->
                                    <c:if test="${faculty.facultyType == 'Visiting Faculty'}">
                                        <div class="info-item">
                                            <span class="info-label">Specialization</span>
                                            <span class="info-value">${faculty.specialization}</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Hours/Week</span>
                                            <span class="info-value">${faculty.hoursPerWeek} hours</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Hourly Rate</span>
                                            <span class="info-value">₹${faculty.hourlyRate}</span>
                                        </div>
                                    </c:if>
                                    
                                    <!-- Adhoc Faculty Specific -->
                                    <c:if test="${faculty.facultyType == 'Adhoc Faculty'}">
                                        <div class="info-item">
                                            <span class="info-label">Contract Duration</span>
                                            <span class="info-value">${faculty.contractDuration}</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Classes/Month</span>
                                            <span class="info-value">${faculty.numberOfClasses} classes</span>
                                        </div>
                                        <div class="info-item">
                                            <span class="info-label">Pay/Class</span>
                                            <span class="info-value">₹${faculty.payPerClass}</span>
                                        </div>
                                    </c:if>
                                </div>
                                
                                <div class="salary-box">
                                    <p>Monthly Salary</p>
                                    <h3>₹${String.format("%.2f", faculty.calculateSalary())}</h3>
                                </div>
                                
                                <div style="margin-top: 15px; text-align: right;">
                                    <a href="/faculty/delete/${faculty.id}" class="delete-btn" 
                                       onclick="return confirm('Are you sure you want to delete this faculty member?')">
                                        Delete
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        
        <a href="/faculty/" class="back-link">← Back to Home</a>
    </div>
</body>
</html>