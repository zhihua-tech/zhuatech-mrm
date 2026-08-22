/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm;
import cn.zhuatech.mrm.service.CampaignCapacityService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class CampaignCapacityServiceTests {private final CampaignCapacityService service=new CampaignCapacityService();
 @Test void defersOverCapacityCampaign(){var r=service.evaluate(new CampaignCapacityService.Request(5,1000,800,350,true,true,10));assertEquals("DEFER",r.status());assertEquals(150.0,r.capacityGap());}
 @Test void approvesBalancedCampaign(){var r=service.evaluate(new CampaignCapacityService.Request(3,1000,500,200,true,true,20));assertEquals("READY",r.status());assertEquals(70.0,r.projectedUtilization());}}
