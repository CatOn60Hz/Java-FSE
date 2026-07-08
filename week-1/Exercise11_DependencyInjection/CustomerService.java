public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Name: " + customer);
    }
}
