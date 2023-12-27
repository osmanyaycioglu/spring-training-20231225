package training.spring.springtraining.db;

import org.springframework.data.jpa.repository.JpaRepository;
import training.spring.springtraining.Address;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
