package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Merchant,Long> {
}
