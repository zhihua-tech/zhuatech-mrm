/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.mrm.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 MRM 营销资源管理平台";}
    public String sceneName(){return "营销计划、预算、内容资产、渠道执行、合规与效果协同";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("MRM-20260801-001","秋季新品整合营销上线准备","处理中","品牌营销组","高"),
        new SeedItem("MRM-20260801-002","短视频素材法务复核","待处理","内容运营组","紧急"),
        new SeedItem("MRM-20260801-003","渠道预算消耗偏差复盘","已完成","营销分析组","中"),
        new SeedItem("MRM-20260801-004","活动追踪参数完整性检查","处理中","增长运营组","高"));}
    public List<String> recommendedActions(){return List.of("优先补齐法务审批和渠道追踪配置","核查预算、受众与内容资产是否一致","在活动上线前完成全链路发布演练");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
