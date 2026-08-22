/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.controller;
import cn.zhuatech.mrm.common.ApiResponse;import cn.zhuatech.mrm.service.CampaignCapacityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/mrm/insights/campaign-capacity") public class CampaignCapacityController {private final CampaignCapacityService service;public CampaignCapacityController(CampaignCapacityService service){this.service=service;}@PostMapping ApiResponse<CampaignCapacityService.Result> evaluate(@Valid @RequestBody CampaignCapacityService.Request request){return ApiResponse.ok(service.evaluate(request));}}
