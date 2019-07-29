package java8.lambdaexpression;

import java.util.ArrayList;
import java.util.List;

public class LamdaExpression {
	public static void main(String[] args) {
		List<Invoice> invoices = null;

		List<Invoice> expensiveInvoicesFromOracle = findInvoices(invoices, new InvoicePredicate() {
			public boolean test(Invoice inv) {
				return inv.getAmount() > 10_000 && inv.getCustomer() == Customer.ORACLE;
			}
		});

		List<Invoice> expensiveInvoicesFromOracle1 = findInvoices(invoices,
				inv -> inv.getAmount() > 10_000 && inv.getCustomer() == Customer.ORACLE);
	}

	void aFirstGlance() {
		// Before Java 8
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi");
			}
		};
		new Thread(runnable).start();

		// Java 8
		new Thread(() -> System.out.println("Hi")).start();
	}

	List<Invoice> findInvoicesGreaterThanAmount(List<Invoice> invoices, double amount) {
		List<Invoice> result = new ArrayList<>();
		for (Invoice inv : invoices) {
			if (inv.getAmount() > amount) {
				result.add(inv);
			}
		}
		return result;
	}
	
	interface InvoicePredicate {
		boolean test(Invoice inv);
	}
	
	static List<Invoice> findInvoices(List<Invoice> invoices, InvoicePredicate p) {
		List<Invoice> result = new ArrayList<>();
		for (Invoice inv : invoices) {
			if (p.test(inv)) {
				result.add(inv);
			}
		}
		return result;
	}

}


