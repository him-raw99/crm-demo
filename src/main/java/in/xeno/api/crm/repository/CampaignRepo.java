package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepo extends JpaRepository<Campaign,Long> {
}
