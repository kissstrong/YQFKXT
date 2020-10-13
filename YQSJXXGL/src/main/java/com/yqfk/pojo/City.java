package com.yqfk.pojo;

/**
 * @author cyz
 * @date 2020-09-28 20:17
 */
public class City {
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
     * 市名
     */
    private String cityName;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(Integer currentConfirmedCount, Integer confirmedCount, Integer curedCount, Integer deadCount, Integer suspectedCount, String cityName) {
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.suspectedCount = suspectedCount;
        this.cityName = cityName;
    }

    public City() {

    }

    @Override
    public String toString() {
        return "City{" +
                "currentConfirmedCount=" + currentConfirmedCount +
                ", confirmedCount=" + confirmedCount +
                ", curedCount=" + curedCount +
                ", deadCount=" + deadCount +
                ", suspectedCount=" + suspectedCount +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
