package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.CommunicationLogs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationLogRepo extends JpaRepository<CommunicationLogs,Long> {
}
