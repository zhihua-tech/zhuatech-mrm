# 架构说明

```text
Vue 3 管理端 / 响应式 H5
          │ HTTP / JSON
Spring Security → Controller → Service → Spring Data JPA → MySQL 8
                                  │
                     活动就绪度与运营风险规则
```

当前版本采用单体分层架构串联营销计划到上线执行。`CampaignReadinessService` 汇总简报、资产、预算、受众、法务与追踪准备度，`WorkItem` 支持跨品牌、内容、法务与增长团队协作。生产化建议增加预算占用、内容版本、数字版权、渠道回传、归因口径和审批审计。
