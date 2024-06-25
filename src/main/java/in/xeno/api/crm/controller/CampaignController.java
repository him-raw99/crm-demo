package in.xeno.api.crm.controller;

import in.xeno.api.crm.model.Campaign;
import in.xeno.api.crm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/campaign")
public class CampaignController {

    @Autowired private CampaignService campaignService;

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @PostMapping
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return campaignService.saveCampaign(campaign);
    }


}
