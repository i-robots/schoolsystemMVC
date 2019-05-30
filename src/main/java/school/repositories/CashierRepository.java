package school.repositories;

import org.springframework.data.repository.CrudRepository;

import school.domain.Cashier;

public interface CashierRepository extends CrudRepository<Cashier,Long> {
	Cashier findByUsername(String username);
}
