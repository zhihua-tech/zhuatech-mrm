# 企业级营销活动发布治理

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 MRM 开源版增加活动上线门禁。

`POST /api/enterprise/mrm/campaign-release` 检查简报、预算、品牌、法务、个人信息授权、最终素材、追踪方案和回退计划，返回 `PUBLISH / REVIEW / BLOCKED`。

生产系统应将审批、素材版本、渠道配置和归因口径保存为可审计的发布快照。
