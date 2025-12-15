<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Management System</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            overflow: hidden;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 40px;
            text-align: center;
        }
        .header h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
        }
        .header p {
            font-size: 1.1em;
            opacity: 0.9;
        }
        .stats {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            padding: 30px;
            background: #f8f9fa;
        }
        .stat-card {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .stat-card h3 {
            color: #667eea;
            font-size: 2em;
            margin-bottom: 10px;
        }
        .stat-card p {
            color: #666;
            font-size: 1.1em;
        }
        .navigation {
            padding: 30px;
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }
        .nav-button {
            display: block;
            padding: 20px;
            text-align: center;
            text-decoration: none;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-radius: 10px;
            font-size: 1.2em;
            font-weight: bold;
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .nav-button:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.4);
        }
        .di-info {
            padding: 30px;
            background: #fff3cd;
            border-left: 5px solid #ffc107;
            margin: 30px;
            border-radius: 5px;
        }
        .di-info h3 {
            color: #856404;
            margin-bottom: 15px;
        }
        .di-info ul {
            color: #856404;
            padding-left: 20px;
        }
        .di-info li {
            margin: 8px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>🎓 Faculty Management System</h1>
            <p>Spring Boot with Dependency Injection Demo</p>
        </div>
        
        <div class="stats">
            <div class="stat-card">
                <h3>${totalFaculty}</h3>
                <p>Total Faculty Members</p>
            </div>
            <div class="stat-card">
                <h3>₹${String.format("%.2f", totalSalary)}</h3>
                <p>Total Salary Expenditure</p>
            </div>
        </div>
        
        <div class="navigation">
            <a href="/faculty/add" class="nav-button">➕ Add New Faculty</a>
            <a href="/faculty/view" class="nav-button">📋 View All Faculty</a>
        </div>
        
        <div class="di-info">
            <h3>🔧 Dependency Injection Features Demonstrated:</h3>
            <ul>
                <li><strong>@Autowired</strong> - Constructor injection in FacultyServiceImpl</li>
                <li><strong>@Autowired</strong> - Field injection in FacultyController</li>
                <li><strong>@Component/@Service/@Repository</strong> - Spring-managed beans</li>
                <li><strong>Inheritance</strong> - Faculty superclass with three subclasses</li>
                <li><strong>Polymorphism</strong> - Different salary calculation strategies</li>
            </ul>
        </div>
    </div>
</body>
</html>