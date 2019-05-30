package school.services;

import school.domain.Cashier;
import school.domain.Staff;

public interface CashierService {	
	void saveCashier(Staff staff);
	Cashier findCashierByUsername(String username);
}
