<html>
<body>
    <h1>Admission Confirmed!</h1>
    <hr>
    <p>Student ID: ${st.id}</p>
    <p>Student Name: ${st.name}</p>
    <p>Enrolled Course: ${st.course}</p>

    <p>Selected Subjects:</p>
    <ul>
        <%-- JSP standard tag library (JSTL)--%>
        ${st.subjects}
    </ul>

    <br>
    <a href="admission">Go Back</a>
</body>
</html>
