/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class CampaignReleaseGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.briefApproved()) blockers.add("营销简报尚未批准");
        if (!request.budgetReserved()) blockers.add("活动预算尚未锁定");
        if (!request.brandReviewPassed()) blockers.add("品牌规范审核未通过");
        if (request.legalReviewRequired() && !request.legalApproved()) blockers.add("法务审核未通过");
        if (request.personalDataUsed() && !request.consentBasisVerified()) blockers.add("客户数据授权依据未核验");
        if (!blockers.isEmpty()) {
            actions.add("阻止上线并补齐预算、品牌、法务或隐私控制");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.assetsFinalized() || !request.trackingPlanVerified() || !request.rollbackPlanReady()) {
            if (!request.assetsFinalized()) actions.add("冻结最终创意资产和渠道版本");
            if (!request.trackingPlanVerified()) actions.add("验证转化事件、UTM 和归因口径");
            if (!request.rollbackPlanReady()) actions.add("准备暂停投放与素材回退方案");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("批准活动上线并保存审批、资产和追踪快照");
        return new Assessment(Decision.PUBLISH, blockers, actions);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String campaignCode, boolean briefApproved,
                          boolean budgetReserved, boolean brandReviewPassed,
                          boolean legalReviewRequired, boolean legalApproved,
                          boolean personalDataUsed, boolean consentBasisVerified,
                          boolean assetsFinalized, boolean trackingPlanVerified,
                          boolean rollbackPlanReady) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { PUBLISH, REVIEW, BLOCKED }
}
