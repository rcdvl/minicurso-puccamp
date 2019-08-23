package br.org.sidi.puccamp.minicurso.repository;

import br.org.sidi.puccamp.minicurso.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByOrderByFullNameAsc();
}
