package java8.methodreferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import java8.lambdaexpression.Customer;
import java8.lambdaexpression.Invoice;

public class MethodReferences {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("C", "a", "A", "b");
		
		Collections.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		
		Collections.sort(strs, String::compareToIgnoreCase);
		methodReferenceToConstructor();
	}
	
	static public void methodReferenceToAStaticMethod() {
		Function<String, Integer> converter = Integer::parseInt;
		Integer number = converter.apply("10");
		System.out.println(number);
	}
	
	static public void methodReferenceToAnInstanceMethod() {
		Function<Invoice, Integer> invoiceToId = Invoice::getId;
		Integer invoiceId = invoiceToId.apply(new Invoice(1,Customer.ORACLE, 10));
		System.out.println(invoiceId);
	}
	
	public void methodReferenceToAnInstanceMethodOfAnExistingObject() {
		List<Invoice> invoices = Arrays.asList(
				new Invoice(1, Customer.ORACLE, 10)
				,new Invoice(2, Customer.AXON, 10));
		Predicate<Invoice> p = this::isCustomerOracle;
		
		for (Invoice invoice : invoices) {
			if (p.test(invoice)) {
				System.out.println("Invoice id " + invoice.getId() + " is Axon Customer");
			}
		}
	}
	
	private boolean isCustomerOracle(Invoice invoice) {
		return invoice.getCustomer().equals(Customer.ORACLE);
	}
	
	static public void methodReferenceToConstructor() {
		InvoiceEmpty invoiceEmpty = Invoice::new;
		InvoiceWithAmount invoiceWithAmount = Invoice::new;
		System.out.println("Constructor isn't called yet");
		System.out.println(invoiceEmpty.get());
		System.out.println(invoiceWithAmount.get(10));
	}
}

class MethodReferencesTest{
	public static void main(String[] args) {
		MethodReferences methodReferences = new MethodReferences();
		methodReferences.methodReferenceToAnInstanceMethodOfAnExistingObject();
	}
}

interface InvoiceEmpty {
	Invoice get();
}

interface InvoiceWithAmount {
	Invoice get(double amount);
}
