package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends JpaRepository<Order,String> {

}
