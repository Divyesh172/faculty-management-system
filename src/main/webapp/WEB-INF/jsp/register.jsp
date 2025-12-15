<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register Faculty</title>
    <style>
        body { font-family: sans-serif; background: #f4f7f6; display: flex; justify-content: center; align-items: center; height: 100vh; }
        .container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); width: 400px; }
        h2 { text-align: center; color: #333; }
        input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background: #667eea; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background: #5a6fd6; }
        a { display: block; text-align: center; margin-top: 15px; color: #667eea; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>📝 Faculty Registration</h2>
        <form action="/faculty/register" method="POST">
            <input type="text" name="fullName" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email Address" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="department" placeholder="Department" required>
            <input type="text" name="mobileNumber" placeholder="Mobile Number" required>
            <button type="submit">Register</button>
        </form>
        <a href="/faculty/login">Already have an account? Login here</a>
    </div>
</body>
</html>