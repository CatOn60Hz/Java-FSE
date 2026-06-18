public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 101) {
            return "Praveen Kumar";
        } else if (id == 102) {
            return "Rahul Sharma";
        } else {
            return "Customer Not Found";
        }
    }
}
