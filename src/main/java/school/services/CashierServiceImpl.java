package school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.domain.Cashier;
import school.domain.Staff;
import school.repositories.CashierRepository;

@Service
public class CashierServiceImpl implements CashierService{
	
	@Autowired
	StaffService staffService;
	CashierRepository cashierRepo;
	
	@Autowired
	public CashierServiceImpl(CashierRepository cashierRepo) {
		this.cashierRepo = cashierRepo;
	}

	@Override
	public void saveCashier(Staff staff) {
		Cashier cashier = new Cashier();
		cashier.setUsername(staff.getUsername());
		cashier.setName(staff.getName() + " " + staff.getLastname());
		cashierRepo.save(cashier);	
		staffService.saveStaff(staff);
	}

	@Override
	public Cashier findCashierByUsername(String username) {
		return cashierRepo.findByUsername(username);
	}

}
