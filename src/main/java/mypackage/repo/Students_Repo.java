package mypackage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mypackage.model.Student;
@Repository
public interface Students_Repo extends JpaRepository<Student, Integer> {

}
