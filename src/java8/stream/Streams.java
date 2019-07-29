package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import java8.lambdaexpression.Customer;
import java8.lambdaexpression.Invoice;

public class Streams {

	List<Invoice> invoices = Arrays.asList(new Invoice(1, Customer.ORACLE, 10), new Invoice(2, Customer.AXON, 10));

	public static void main(String[] args) {

	}

	void oldJavaCode() {
		List<Invoice> oracleAndTrainingInvoices = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		List<Integer> firstFiveIds = new ArrayList<>();
		for (Invoice inv : invoices) {
			if (inv.getCustomer() == Customer.ORACLE) {
				if (inv.getTitle().contains("Training")) {
					oracleAndTrainingInvoices.add(inv);
				}
			}
		}
		Collections.sort(oracleAndTrainingInvoices, new Comparator<Invoice>() {
			@Override
			public int compare(Invoice inv1, Invoice inv2) {
				return Double.compare(inv1.getAmount(), inv2.getAmount());
			}
		});
		for (Invoice inv : oracleAndTrainingInvoices) {
			ids.add(inv.getId());
		}
		for (int i = 0; i < 5; i++) {
			firstFiveIds.add(ids.get(i));
		}
	}

	void java8() {
		Stream<Invoice> oracleAndTrainingInvoices = invoices.stream()
				.filter(inv -> inv.getCustomer() == Customer.ORACLE).filter(inv -> inv.getTitle().contains("Training"))
				.sorted(comparingDouble(Invoice::getAmount)).map(Invoice::getId).limit(5).collect(Collectors.toList());
	}
}
