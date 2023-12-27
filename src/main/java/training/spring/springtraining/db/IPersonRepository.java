package training.spring.springtraining.db;

import org.springframework.data.jpa.repository.JpaRepository;
import training.spring.springtraining.Person;

public interface IPersonRepository extends JpaRepository<Person,Long> {
}
