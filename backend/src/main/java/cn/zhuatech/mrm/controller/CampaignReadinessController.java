/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.mrm.controller;
import cn.zhuatech.mrm.common.ApiResponse; import cn.zhuatech.mrm.service.CampaignReadinessService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin/campaign-readiness") public class CampaignReadinessController {
    private final CampaignReadinessService service; public CampaignReadinessController(CampaignReadinessService service){this.service=service;}
    @PostMapping ApiResponse<CampaignReadinessService.ReadinessResult> evaluate(@Valid @RequestBody CampaignReadinessService.ReadinessRequest request){return ApiResponse.ok(service.evaluate(request));}
}
