/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.service;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class CampaignReleaseGovernanceServiceTest {
    private final CampaignReleaseGovernanceService service=new CampaignReleaseGovernanceService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void publishesControlledCampaign(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C1",true,true,true,true,true,true,true,true,true,true));assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.PUBLISH);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksGovernanceFailures(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C2",false,false,false,true,false,true,false,true,true,true));assertThat(r.blockers()).hasSize(5);assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.BLOCKED);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsOperationalReadiness(){var r=service.assess(new CampaignReleaseGovernanceService.Request("C3",true,true,true,false,false,false,false,false,false,false));assertThat(r.actions()).hasSize(3);assertThat(r.decision()).isEqualTo(CampaignReleaseGovernanceService.Decision.REVIEW);}
}
