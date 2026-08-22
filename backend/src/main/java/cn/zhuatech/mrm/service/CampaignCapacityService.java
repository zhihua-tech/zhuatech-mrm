/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.mrm.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class CampaignCapacityService {
 public Result evaluate(Request r){double utilization=Math.round((r.committedHours()+r.newCampaignHours())*1000.0/r.availableHours())/10.0;double gap=Math.max(0,r.committedHours()+r.newCampaignHours()-r.availableHours());List<String> actions=new ArrayList<>();if(gap>0)actions.add("补充 "+gap+" 小时产能或调整活动范围");if(!r.criticalSkillsAvailable())actions.add("落实关键技能人员或外部专家");if(!r.vendorsConfirmed())actions.add("确认外部供应商档期与交付承诺");String status=(gap>0||(!r.criticalSkillsAvailable()&&r.launchInDays()<=7))?"DEFER":utilization>90||!r.criticalSkillsAvailable()||!r.vendorsConfirmed()?"REBALANCE":"READY";if(actions.isEmpty())actions.add("资源满足活动交付要求，进入执行排期");return new Result(utilization,gap,status,actions);}
 public record Request(@Min(1) int plannedCampaigns,@DecimalMin("0.1") double availableHours,@DecimalMin("0") double committedHours,@DecimalMin("0") double newCampaignHours,@NotNull Boolean criticalSkillsAvailable,@NotNull Boolean vendorsConfirmed,@Min(0) int launchInDays){}
 public record Result(double projectedUtilization,double capacityGap,String status,List<String> actions){}
}
