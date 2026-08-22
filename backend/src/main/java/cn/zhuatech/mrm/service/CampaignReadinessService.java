/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.service;
import jakarta.validation.constraints.*; import org.springframework.stereotype.Service; import java.util.*;
@Service public class CampaignReadinessService {
    public ReadinessResult evaluate(ReadinessRequest request){
        int score=(int)Math.round((request.briefCompleteness()+request.assetCompleteness()+(request.budgetApproved()?100:0)+request.audienceReadiness()+(request.legalApproved()?100:0)+request.trackingReadiness())/6.0);
        List<String> blockers=new ArrayList<>(); if(request.briefCompleteness()<90)blockers.add("营销简报和目标定义不完整"); if(request.assetCompleteness()<90)blockers.add("渠道内容资产尚未全部就绪"); if(!request.budgetApproved())blockers.add("活动预算尚未审批"); if(request.audienceReadiness()<90)blockers.add("目标受众和触达名单准备不足"); if(!request.legalApproved())blockers.add("活动内容尚未通过法务合规审批"); if(request.trackingReadiness()<90)blockers.add("转化追踪与渠道参数配置不完整");
        String status=!request.legalApproved()||!request.budgetApproved()?"BLOCKED":score>=90&&blockers.isEmpty()?"READY":"REVIEW"; if(blockers.isEmpty())blockers.add("活动满足上线条件，可进入发布审批"); return new ReadinessResult(score,status,blockers);
    }
    public record ReadinessRequest(@NotNull @Min(0) @Max(100) Integer briefCompleteness,@NotNull @Min(0) @Max(100) Integer assetCompleteness,@NotNull Boolean budgetApproved,@NotNull @Min(0) @Max(100) Integer audienceReadiness,@NotNull Boolean legalApproved,@NotNull @Min(0) @Max(100) Integer trackingReadiness){}
    public record ReadinessResult(int readinessScore,String status,List<String> blockers){}
}
