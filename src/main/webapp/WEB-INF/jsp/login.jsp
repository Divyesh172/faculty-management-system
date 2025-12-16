<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="description" content="Faculty Management System Login Portal for VESIT">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
    <title>Faculty Login</title>
    <style>
        body { font-family: sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); width: 350px; }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        input { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background: #764ba2; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; font-weight: bold; }
        button:hover { background: #5e3c85; }
        .error { color: #dc3545; text-align: center; margin-bottom: 15px; font-size: 0.9em; }
        a { display: block; text-align: center; margin-top: 15px; color: white; text-decoration: none; }
    </style>
</head>
<body>
	<main>
    <div class="container">
        <h2>🔐 Login</h2>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="/faculty/login" method="POST">
            <input type="email" name="email" placeholder="Email" aria-label="Email" required>
            <input type="password" name="password" placeholder="Password" aria-label="Password" required>
            <button type="submit">Login</button>
        </form>
        <a href="/faculty/register">New Faculty? Register Here</a>
    </div>
    </main>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

	<script>
    // Get the message from Spring Boot (JSP renders this as a string)
    	var msg = "${message}";
    	var type = "${messageType}";

    	if (msg && msg.trim() !== "") {
        	Toastify({
            	text: msg,
            	duration: 3000,
            	close: true,
            	gravity: "bottom", // `top` or `bottom`
            	position: "right", // `left`, `center` or `right`
            	// Change color based on success or error
            	style: {
               		background: type === 'error' ? "linear-gradient(to right, #ff5f6d, #ffc371)" : "linear-gradient(to right, #00b09b, #96c93d)",
            	}
        	}).showToast();
    	}
	</script>
</body>
</html>