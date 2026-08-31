/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.service;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class CampaignReleaseGovernanceServiceTest {
    private final CampaignReleaseGovernanceService service=new CampaignReleaseGovernanceService();
    @Test void publishesControlledCampaign(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C1",true,true,true,true,true,true,true,true,true,true));assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.PUBLISH);}
    @Test void blocksGovernanceFailures(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C2",false,false,false,true,false,true,false,true,true,true));assertThat(r.blockers()).hasSize(5);assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.BLOCKED);}
    @Test void reviewsOperationalReadiness(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C3",true,true,true,false,false,false,false,false,false,false));assertThat(r.actions()).hasSize(3);assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.REVIEW);}
}
