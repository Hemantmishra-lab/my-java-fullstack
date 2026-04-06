<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: #f4f7f6; margin: 40px; }
        .card { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); max-width: 600px; }
        .header { border-bottom: 2px solid #007bff; padding-bottom: 10px; margin-bottom: 20px; color: #007bff; }
        .subject-tag { display: inline-block; background: #e2e3e5; padding: 5px 10px; border-radius: 5px; margin: 5px; font-size: 0.9em; }
        .status-online { color: green; font-weight: bold; }
    </style>
</head>
<body>

    <div class="card">
        <div class="header">
            <h2>🎓 Student Portal</h2>
        </div>

        <p><strong>ID:</strong> ${student.id}</p>
        <p><strong>Name:</strong> ${student.name}</p>
        <p><strong>Course:</strong> ${student.course}</p>
        <p><strong>Account Status:</strong> <span class="status-online">${status}</span></p>

        <h3>Registered Subjects:</h3>
        <div>
            <c:forEach var="sub" items="${student.subjects}">
                <span class="subject-tag">${sub}</span>
            </c:forEach>
        </div>
    </div>

</body>
</html>