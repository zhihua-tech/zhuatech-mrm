/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.controller;
import cn.zhuatech.mrm.common.ApiResponse;
import cn.zhuatech.mrm.service.CampaignReleaseGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/mrm")
public class CampaignReleaseGovernanceController {
    private final CampaignReleaseGovernanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CampaignReleaseGovernanceController(CampaignReleaseGovernanceService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/campaign-release")
    public ApiResponse<CampaignReleaseGovernanceService.Assessment> assess(@Valid @RequestBody CampaignReleaseGovernanceService.Request request){return ApiResponse.ok(service.assess(request));}
}
