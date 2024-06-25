package in.xeno.api.crm.repository;

import in.xeno.api.crm.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepo extends JpaRepository<Rule,Long> {
}
