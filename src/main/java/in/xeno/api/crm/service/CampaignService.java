package in.xeno.api.crm.service;

import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.model.Customer;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired private RuleService ruleService;
    @Autowired private CustomerService customerService;
    @Autowired private Producer producer;
    @Autowired private CampaignRepo campaignRepo;

    public List<Campaign> getAllCampaigns() {
        return null;
    }

    public List<Customer> getCampaignCustomer(Long campaignId) {
        String rule = ruleService.getRule(campaignId);
        return customerService.getUsersByRule(rule);
    }

    public Campaign saveCampaign(Campaign campaign) {
        producer.saveCampaign(new ProxyRequest<>( ProxyAction.ADD, campaign));;
        return campaign;
    }

}
