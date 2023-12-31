package testconnec2.connect2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
  private CustomerService customerService;
  /* ---------------- GET ALL CUSTOMER ------------------------ */
  @GetMapping("/customers")
  public ResponseEntity<ServiceResult> findAllCustomer() {
    return new ResponseEntity<ServiceResult>(customerService.findAll(), HttpStatus.OK);
  }
  /* ---------------- GET CUSTOMER BY ID ------------------------ */
  @GetMapping("/customers/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
    return new ResponseEntity<ServiceResult>(customerService.findById(id), HttpStatus.OK);
  }
  /* ---------------- CREATE NEW CUSTOMER ------------------------ */
  @PostMapping("/customers")
  public ResponseEntity<ServiceResult> create(@RequestBody Customer customer) {
    return new ResponseEntity<ServiceResult>(customerService.create(customer), HttpStatus.OK);
  }
  
  /* ---------------- UPDATE CUSTOMER ------------------------ */
  @PutMapping("/customers")
  public ResponseEntity<ServiceResult> update(@RequestBody Customer customer) {
    return new ResponseEntity<ServiceResult>(customerService.update(customer), HttpStatus.OK);
  }
  @DeleteMapping("/customers")
  public ResponseEntity<ServiceResult> delete(@RequestBody DeleteCustomerRequest request) {
    return new ResponseEntity<ServiceResult>(customerService.delete(request.getId()), HttpStatus.OK);
  }

}
