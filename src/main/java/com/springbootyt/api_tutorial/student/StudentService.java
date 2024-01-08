package com.springbootyt.api_tutorial.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

	public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        // If the email is already taken, raise a exception error
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean studentExists = studentRepository.existsById(id);

        if (!studentExists) {
            throw new IllegalStateException("student with id " + id + " does not exist yet.");
        }

        studentRepository.deleteById(id);
    }

    // Note: `Transactional` allows us to update the object by using the setters and getters of the class
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id: " + id + " does not exist"));

        boolean validName = name != null && name.length() > 0;
        boolean differentName = !Objects.equals(student.getName(), name);

        if (validName && differentName) {
            student.setName(name);
        }

        boolean validEmail = email != null && email.length() > 0;
        boolean differentEmail = !Objects.equals(student.getEmail(), email);

        if (validEmail && differentEmail) {
            Optional<Student> existingStudent = studentRepository.findStudentByEmail(email);

            if (existingStudent.isPresent()) {
                throw new IllegalStateException("The email: " + email + " is already in use");
            }

            student.setEmail(email);
        }
    }
}
