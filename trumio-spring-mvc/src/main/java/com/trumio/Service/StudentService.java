package com.trumio.Service;


import com.trumio.DAO.StudentDAO;
import com.trumio.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void registerStudent(Student student) {
        // Business logic can go here
        studentDAO.saveStudent(student);
    }
}

