package in.xeno.api.crm.dao;

import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.constants.ProxyContext;
import in.xeno.api.crm.lib.ProxyRequest;
import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.pubSub.Producer;
import in.xeno.api.crm.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignDAO {

    @Autowired private Producer producer;
    @Autowired private CampaignRepo campaignRepo;

    public Campaign saveCampaign(Campaign campaign) {
        try {
            producer.sendMessage(new ProxyRequest<>(ProxyContext.CAMPAIGN, ProxyAction.ADD, campaign));
            return campaign;
        } catch (Exception e) {
            return campaignRepo.save(campaign);
        }
    }
}
