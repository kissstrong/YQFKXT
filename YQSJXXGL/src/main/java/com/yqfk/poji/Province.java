package com.yqfk.poji;

import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-28 20:07
 */
public class Province {
    public Province() {
    }

    public Province(Integer currentConfirmedCount, Integer confirmedCount, Integer curedCount, Integer deadCount, Integer suspectedCount, String provinceName, Map<String, City> cities) {
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.suspectedCount = suspectedCount;
        this.provinceName = provinceName;
        this.cities = cities;
    }

    /**
     * 当前确诊数
     */
    private Integer currentConfirmedCount;
    /**
     * 累计确诊数
     */
    private Integer confirmedCount;
    /**
     * 治愈数
     */
    private Integer curedCount;
    /**
     * 死亡数
     */
    private Integer deadCount;
    /**
     * 疑似病例
     */
    private Integer suspectedCount;
    /**
     * 省名
     */
    private String provinceName;

    /**
     *城市
     */

    private Map<String,City> cities;

    public Map<String, City> getCities() {
        return cities;
    }

    public void setCities(Map<String, City> cities) {
        this.cities = cities;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }

    public Integer getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(Integer deadCount) {
        this.deadCount = deadCount;
    }

    public Integer getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(Integer suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
                "currentConfirmedCount=" + currentConfirmedCount +
                ", confirmedCount=" + confirmedCount +
                ", curedCount=" + curedCount +
                ", deadCount=" + deadCount +
                ", suspectedCount=" + suspectedCount +
                ", provinceName='" + provinceName + '\'' +
                ", cities=" + cities +
                '}';
    }
}
