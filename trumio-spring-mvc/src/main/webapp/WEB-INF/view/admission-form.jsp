<html>
<body>
    <h2>Student Admission Form (@RequestParam Example)</h2>
    <form action="processAdmission" method="POST">
        ID: <input type="number" name="sId" required><br><br>
        Name: <input type="text" name="sName" required><br><br>
        Course: <input type="text" name="sCourse" required><br><br>

        <label>Select Subjects:</label><br>
        <input type="checkbox" name="sSubjects" value="Java"> Java
        <input type="checkbox" name="sSubjects" value="Spring"> Spring
        <input type="checkbox" name="sSubjects" value="Hibernate"> Hibernate
        <input type="checkbox" name="sSubjects" value="Microservices"> Microservices
        <br><br>

        <button type="submit">Submit</button>
    </form>
</body>
</html>