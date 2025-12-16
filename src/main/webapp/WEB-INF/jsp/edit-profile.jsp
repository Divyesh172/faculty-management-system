<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <style>
        body { font-family: sans-serif; background: #f4f7f6; display: flex; justify-content: center; align-items: center; height: 100vh; }
        .card { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); width: 400px; }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        /* Read-only field style */
        input[readonly] { background-color: #e9ecef; cursor: not-allowed; color: #6c757d; }
        button { width: 100%; padding: 10px; background: #667eea; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; margin-top: 10px;}
        button:hover { background: #5a6fd6; }
        .back-link { display: block; text-align: center; margin-top: 15px; color: #666; text-decoration: none; }
    </style>
</head>
<body>

<div class="card">
    <h2>Edit Profile</h2>
    <form action="/faculty/update" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${faculty.id}">
        
        <label>Email (Cannot change)</label>
        <input type="text" value="${faculty.email}" readonly>

        <label>Full Name</label>
        <input type="text" name="fullName" value="${faculty.fullName}" required>

        <label>Department</label>
        <input type="text" name="department" value="${faculty.department}" required>

        <label>Mobile Number</label>
        <input type="text" name="mobileNumber" value="${faculty.mobileNumber}" required>
		
		<label>Profile Picture</label>
		<input type="file" name="file" accept="image/*" style="background: white;">

        <button type="submit">Save Changes</button>
    </form>
    <a href="/faculty/dashboard" class="back-link">Cancel</a>
</div>
</body>
</html>