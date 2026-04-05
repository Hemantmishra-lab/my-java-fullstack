<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trumio Spring MVC</title>
    <!-- Google Fonts: Poppins -->
    <link href="https://googleapis.com" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            /* Beautiful Gradient Background */
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }

        .container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px); /* Glass effect */
            padding: 50px;
            border-radius: 20px;
            border: 1px solid rgba(255, 255, 255, 0.2);
            box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);
            text-align: center;
            max-width: 500px;
            width: 90%;
        }

        h1 {
            font-size: 3rem;
            margin-bottom: 10px;
            font-weight: 600;
            letter-spacing: 1px;
        }

        p {
            font-size: 1.1rem;
            opacity: 0.9;
            margin-bottom: 30px;
        }

        .btn {
            display: inline-block;
            padding: 12px 30px;
            background: #fff;
            color: #764ba2;
            text-decoration: none;
            border-radius: 30px;
            font-weight: 600;
            transition: 0.3s ease;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        .btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(0,0,0,0.3);
            background: #f0f0f0;
        }

        .badge {
            display: inline-block;
            padding: 5px 15px;
            background: #43e97b;
            color: #1a5c31;
            border-radius: 20px;
            font-size: 0.8rem;
            font-weight: 600;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="badge">Spring MVC is Running 🚀</div>
        <h1>Hello, World!</h1>
        <p>Welcome to your first professional Spring MVC page on Tomcat 11.</p>

        <!-- You can change this message from your Controller later -->
        <h3 style="margin-bottom: 20px; color: #ffeb3b;">${serverMessage}</h3>

        <a href="#" class="btn">Explore My Project</a>
    </div>

</body>
</html>
