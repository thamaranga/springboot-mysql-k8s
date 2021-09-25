package com.hasithat.springbootmysqlk8s.repository;

import com.hasithat.springbootmysqlk8s.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
