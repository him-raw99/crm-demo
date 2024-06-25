package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor,Long> {
}
