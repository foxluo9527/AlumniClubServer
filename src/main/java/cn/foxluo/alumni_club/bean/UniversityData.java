package cn.foxluo.alumni_club.bean;

import cn.foxluo.alumni_club.model.University;
import cn.foxluo.alumni_club.model.Zone;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class UniversityData {
    /**
     * id : bj
     * name : 北京
     * sort : 1
     */
    @ApiModelProperty(value = "所有地区集合",required = true)
    private List<Zone> zone;

    /**
     * id : 1
     * name : 华中科技大学
     * short : 华中大
     * zone : wh
     * order : 1
     */
    @ApiModelProperty(value = "所有学校集合",required = true)
    private List<University> university;

    public List<Zone> getZone() {
        return zone;
    }

    public void setZone(List<Zone> zone) {
        this.zone = zone;
    }

    public List<University> getUniversity() {
        return university;
    }

    public void setUniversity(List<University> university) {
        this.university = university;
    }

}
