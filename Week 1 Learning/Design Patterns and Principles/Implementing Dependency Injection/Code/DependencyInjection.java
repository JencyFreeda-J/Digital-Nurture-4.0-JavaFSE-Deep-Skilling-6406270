// Filename: DependencyInjection.java

// Step 2: Repository Interface
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// A simple Customer class to hold customer data
class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Step 3: Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    // Simulated database using a simple map
    private java.util.Map<Integer, Customer> customerData = new java.util.HashMap<>();

    public CustomerRepositoryImpl() {
        // Populate with some dummy data
        customerData.put(1, new Customer(1, "Alice"));
        customerData.put(2, new Customer(2, "Bob"));
        customerData.put(3, new Customer(3, "Charlie"));
    }

    public Customer findCustomerById(int id) {
        return customerData.get(id);
    }
}

// Step 4: Service Class
class CustomerService {
    private CustomerRepository repository;

    // Step 5: Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(int id) {
        return repository.findCustomerById(id);
    }
}

// Step 6: Test Class
public class DependencyInjection {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Fetching Customers ---");
        Customer customer = service.getCustomerById(2);
        if (customer != null) {
            System.out.println("Found Customer: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
