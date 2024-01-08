// Data Access Layer

package com.springbootyt.api_tutorial.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Note: This `Query` is not required but an explanation of what the function is doing
    // Note: `Student` is the class itself, so we can access the class attributes
    // @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
