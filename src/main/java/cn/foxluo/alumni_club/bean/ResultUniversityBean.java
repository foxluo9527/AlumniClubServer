package cn.foxluo.alumni_club.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
@Data
public class ResultUniversityBean {
    private ArrayList<ZoneBean> zoneBeans;
    @Data
    public static class ZoneBean{
        @ApiModelProperty(value = "地区id（首字母缩写）",required = true)
        private String id;
        @ApiModelProperty(value = "地区名称",required = true)
        private String name;
        @ApiModelProperty("学校列表")
        private ArrayList<UniversityBean> universityBean;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<UniversityBean> getUniversityBean() {
            return universityBean;
        }

        public void setUniversityBean(ArrayList<UniversityBean> universityBean) {
            this.universityBean = universityBean;
        }
    }
    @Data
    public static class UniversityBean{
        @ApiModelProperty(value = "学校id",required = true,dataType = "int")
        private int id;
        @ApiModelProperty(value = "学校名称",required = true)
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public ArrayList<ZoneBean> getZoneBeans() {
        return zoneBeans;
    }

    public void setZoneBeans(ArrayList<ZoneBean> zoneBeans) {
        this.zoneBeans = zoneBeans;
    }
}
