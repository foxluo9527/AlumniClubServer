package cn.foxluo.alumni_club.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "community_sector")
public class CommunitySector {
    @Id
    @Column(name = "community_sector_id")
    private Integer communitySectorId;

    @Column(name = "community_id")
    private String communityId;

    /**
     * 板块名称
     */
    @Column(name = "community_sector_name")
    private String communitySectorName;

    /**
     * 0:固定板块,1:用户自定义板块
     */
    @Column(name = "community_sector_power")
    private Integer communitySectorPower;

    @Column(name = "use_count")
    private Integer useCount;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return community_sector_id
     */
    public Integer getCommunitySectorId() {
        return communitySectorId;
    }

    /**
     * @param communitySectorId
     */
    public void setCommunitySectorId(Integer communitySectorId) {
        this.communitySectorId = communitySectorId;
    }

    /**
     * @return community_id
     */
    public String getCommunityId() {
        return communityId;
    }

    /**
     * @param communityId
     */
    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    /**
     * 获取板块名称
     *
     * @return community_sector_name - 板块名称
     */
    public String getCommunitySectorName() {
        return communitySectorName;
    }

    /**
     * 设置板块名称
     *
     * @param communitySectorName 板块名称
     */
    public void setCommunitySectorName(String communitySectorName) {
        this.communitySectorName = communitySectorName;
    }

    /**
     * 获取0:固定板块,1:用户自定义板块
     *
     * @return community_sector_power - 0:固定板块,1:用户自定义板块
     */
    public Integer getCommunitySectorPower() {
        return communitySectorPower;
    }

    /**
     * 设置0:固定板块,1:用户自定义板块
     *
     * @param communitySectorPower 0:固定板块,1:用户自定义板块
     */
    public void setCommunitySectorPower(Integer communitySectorPower) {
        this.communitySectorPower = communitySectorPower;
    }

    /**
     * @return use_count
     */
    public Integer getUseCount() {
        return useCount;
    }

    /**
     * @param useCount
     */
    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}