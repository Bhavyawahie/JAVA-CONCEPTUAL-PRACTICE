import static com.example.combinator.service.CustomerRegistrationValidator.isAdult;
import static com.example.combinator.service.CustomerRegistrationValidator.isEmailValid;
import static com.example.combinator.service.CustomerRegistrationValidator.isPhoneNumberValid;

import java.time.LocalDate;

import com.example.combinator.bean.Customer;
import com.example.combinator.service.CustomerRegistrationValidator.ValidationResult;
import com.example.combinator.service.CustomerService;


public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer(
            "Alice",
            "alice@example.in",
            "+919876543210",
            LocalDate.of(2008, 12, 12));

        // CustomerService service = new CustomerService();
        // boolean flag = service.isValid(customer);
        // if(flag) {
        //     System.out.println(flag);
        // } else {
        //     System.out.println("change the code, invalid");
        // }

        ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAdult()).apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
