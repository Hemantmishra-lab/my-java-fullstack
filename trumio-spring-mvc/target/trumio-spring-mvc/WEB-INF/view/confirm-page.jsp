<html>

<!-- RegistrationController.java -> Model: Student.java -> View (Input): admission-form.jsp -> Controller: AdmissionController.java -> View (Output): confirm-page.jsp -->
<body>
    <h1>Admission Confirmed!</h1>
    <hr>
    <p>Student ID: ${st.id}</p>
    <p>Student Name: ${st.name}</p>
    <p>Enrolled Course: ${st.course}</p>

    <p>Selected Subjects:</p>
    <ul>
        <%-- You can use JSP standard tag library (JSTL) or simple expression --%>
        ${st.subjects}
    </ul>

    <br>
    <a href="admission">Go Back</a>
</body>
</html>