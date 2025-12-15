<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Faculty</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        .container {
            max-width: 700px;
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
        }
        .message.success {
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .message.error {
            background: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
        form {
            padding: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: 600;
        }
        input, select {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 5px;
            font-size: 1em;
            transition: border-color 0.3s;
        }
        input:focus, select:focus {
            outline: none;
            border-color: #667eea;
        }
        .type-specific {
            display: none;
            background: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            margin: 20px 0;
        }
        .type-specific.active {
            display: block;
        }
        button {
            width: 100%;
            padding: 15px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            font-weight: bold;
            cursor: pointer;
            transition: transform 0.3s;
        }
        button:hover {
            transform: translateY(-2px);
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
    <script>
        function showTypeFields() {
            const type = document.getElementById('facultyType').value;
            document.querySelectorAll('.type-specific').forEach(el => {
                el.classList.remove('active');
            });
            if (type) {
                document.getElementById(type + '-fields').classList.add('active');
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>➕ Add New Faculty</h1>
        </div>
        
        <c:if test="${not empty message}">
            <div class="message ${messageType}">${message}</div>
        </c:if>
        
        <form method="post" action="/faculty/add">
            <div class="form-group">
                <label>Faculty Type *</label>
                <select name="type" id="facultyType" required onchange="showTypeFields()">
                    <option value="">Select Type</option>
                    <option value="regular">Regular Faculty</option>
                    <option value="visiting">Visiting Faculty</option>
                    <option value="adhoc">Adhoc Faculty</option>
                </select>
            </div>
            
            <div class="form-group">
                <label>Faculty ID *</label>
                <input type="text" name="id" required placeholder="e.g., FAC001">
            </div>
            
            <div class="form-group">
                <label>Name *</label>
                <input type="text" name="name" required placeholder="Full Name">
            </div>
            
            <div class="form-group">
                <label>Department *</label>
                <input type="text" name="department" required placeholder="e.g., Computer Science">
            </div>
            
            <div class="form-group">
                <label>Email *</label>
                <input type="email" name="email" required placeholder="email@example.com">
            </div>
            
            <div class="form-group">
                <label>Qualification *</label>
                <input type="text" name="qualification" required placeholder="e.g., Ph.D., M.Tech">
            </div>
            
            <!-- Regular Faculty Fields -->
            <div id="regular-fields" class="type-specific">
                <h3>Regular Faculty Details</h3>
                <div class="form-group">
                    <label>Basic Salary</label>
                    <input type="number" name="basicSalary" step="0.01" placeholder="e.g., 50000">
                </div>
                <div class="form-group">
                    <label>Years of Experience</label>
                    <input type="number" name="yearsOfExperience" placeholder="e.g., 5">
                </div>
                <div class="form-group">
                    <label>Designation</label>
                    <input type="text" name="designation" placeholder="e.g., Professor, Associate Professor">
                </div>
            </div>
            
            <!-- Visiting Faculty Fields -->
            <div id="visiting-fields" class="type-specific">
                <h3>Visiting Faculty Details</h3>
                <div class="form-group">
                    <label>Hours Per Week</label>
                    <input type="number" name="hoursPerWeek" placeholder="e.g., 10">
                </div>
                <div class="form-group">
                    <label>Hourly Rate</label>
                    <input type="number" name="hourlyRate" step="0.01" placeholder="e.g., 500">
                </div>
                <div class="form-group">
                    <label>Specialization</label>
                    <input type="text" name="specialization" placeholder="e.g., Machine Learning">
                </div>
            </div>
            
            <!-- Adhoc Faculty Fields -->
            <div id="adhoc-fields" class="type-specific">
                <h3>Adhoc Faculty Details</h3>
                <div class="form-group">
                    <label>Number of Classes</label>
                    <input type="number" name="numberOfClasses" placeholder="e.g., 20">
                </div>
                <div class="form-group">
                    <label>Pay Per Class</label>
                    <input type="number" name="payPerClass" step="0.01" placeholder="e.g., 1000">
                </div>
                <div class="form-group">
                    <label>Contract Duration</label>
                    <input type="text" name="contractDuration" placeholder="e.g., 6 months">
                </div>
            </div>
            
            <button type="submit">Add Faculty</button>
        </form>
        
        <a href="/faculty/" class="back-link">← Back to Home</a>
    </div>
</body>
</html>