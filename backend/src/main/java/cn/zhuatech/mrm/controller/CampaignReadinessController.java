/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.controller;
import cn.zhuatech.mrm.common.ApiResponse; import cn.zhuatech.mrm.service.CampaignReadinessService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin/campaign-readiness") public class CampaignReadinessController {
    private final CampaignReadinessService service; /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public CampaignReadinessController(CampaignReadinessService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping ApiResponse<CampaignReadinessService.ReadinessResult> evaluate(@Valid @RequestBody CampaignReadinessService.ReadinessRequest request){return ApiResponse.ok(service.evaluate(request));}
}
