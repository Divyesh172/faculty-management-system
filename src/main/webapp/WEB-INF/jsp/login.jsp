<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Login</title>
    <style>
        body { font-family: sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); width: 350px; }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        input { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background: #764ba2; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; font-weight: bold; }
        button:hover { background: #5e3c85; }
        .error { color: #dc3545; text-align: center; margin-bottom: 15px; font-size: 0.9em; }
        a { display: block; text-align: center; margin-top: 15px; color: #667eea; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🔐 Login</h2>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="/faculty/login" method="POST">
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <a href="/faculty/register">New Faculty? Register Here</a>
    </div>
</body>
</html>