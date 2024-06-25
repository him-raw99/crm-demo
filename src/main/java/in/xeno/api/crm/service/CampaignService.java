package in.xeno.api.crm.service;

import in.xeno.api.crm.dao.CampaignDAO;
import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired private RuleService ruleService;
    @Autowired private CustomerService customerService;
    @Autowired private CampaignDAO campaignDAO;

    public List<Campaign> getAllCampaigns() {
        return null;
    }

    public List<Customer> getCampaignCustomer(Long campaignId) {
        String rule = ruleService.getRule(campaignId);
        return customerService.getUsersByRule(rule);
    }

    public Campaign saveCampaign(Campaign campaign) {
        return campaignDAO.saveCampaign(campaign);
    }

}
