package com.yqfk.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class News {

    /**
     * code : 200
     * msg : success
     * newslist : [{"news":[{"id":87900,"pubDate":1601445443000,"pubDateStr":"1小时前","title":"香港特区政府：到港人士强制检疫令暂定延长至12月31日","summary":"香港特区政府29日宣布系列防疫新举措，其中包括到港人士强制检疫令暂定再延长至12月31日。据介绍，特区政府将把《若干到港人士强制检疫规例》（第599C章）及《预防及控制疾病（规管跨境交通工具及到港者）规例》（第599H章）的有效期各延长两个多月至2020年12月31日。特区政府发言人指出，延长有关规例的有效期，并不代表该规例现行施加的限制会持续不变直至有效期完结，相反有关法律框架已加入弹性条款。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=Arti57yZFh1bBT8JcCkZ92oU200930&isfromapp=1","provinceId":""},{"id":87898,"pubDate":1601444725000,"pubDateStr":"1小时前","title":"陕西29日新增2例境外输入确诊病例","summary":"据陕西省卫健委通报：9月29日0\u201424时，无新增报告本地确诊病例、疑似病例、无症状感染者。截至9月29日24时，累计报告本地确诊病例245例，出院242例，死亡3例。9月29日0\u201424时，新增报告境外输入确诊病例2例，确诊病例治愈出院3例，无症状感染者解除医学观察2例。截至9月29日24时，累计报告境外输入确诊病例163例，出院139例，在院24例。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiCYfaQZsiMshYf8EqrBiY200930&isfromapp=1","provinceId":""},{"id":87886,"pubDate":1601441765000,"pubDateStr":"2小时前","title":"北京按75%限流开放公园、旅游景区 暂不恢复出入境旅游业务","summary":"9月30日上午，在北京市新型冠状病毒肺炎疫情防控工作第167场新闻发布会上，北京市卫生健康委员会一级巡视员、新闻发言人高小俊介绍，国庆、中秋\u201c两节\u201d期间，北京市将落实限量、预约、错峰要求，有序开放旅游场所。落实旅游场所限流措施，按75%限流开放公园、旅游景区。严格落实谁组织、谁管理、谁负责要求，指导旅行社和相关企业履行主体责任，合理调控进京旅游团队规模，不接收14天内来自国内中高风险地区人员、入境人员入住酒店和乡村民宿或进入景区游览。暂不恢复出入境旅游业务。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiYB5GZfH7x1xgn88lz6QI200930&isfromapp=1","provinceId":""},{"id":87871,"pubDate":1601436189000,"pubDateStr":"3小时前","title":"上海9月29日新增境外输入2例  治愈出院3例","summary":"9月29日0\u201424时，通过口岸联防联控机制，报告2例境外输入性新冠肺炎确诊病例，均为中国籍，从菲律宾回国。新增治愈出院3例，其中来自菲律宾1例，来自美国1例，来自俄罗斯1例。","infoSource":"上海卫健委","sourceUrl":"http://wsjkw.sh.gov.cn/xwfb/20200930/b346836470a449359e6999ff7244f8ce.html","provinceId":""},{"id":87861,"pubDate":1601431890000,"pubDateStr":"5小时前","title":"\u200b墨西哥新冠肺炎确诊病例累计达738163例","summary":"当地时间9月29日，墨西哥卫生部宣布，截止到9月29日晚7时，墨西哥全国确诊738163例新冠肺炎病例，较前一天新增了4446例，墨西哥全国确诊死亡病例较前一天新增560例，总数已经上升到77163例。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArticYgxjVux25VOTZyiWEY3200930&isfromapp=1","provinceId":""}],"desc":{"id":1,"createTime":1579537899000,"modifyTime":1601447944000,"summary":"","deleted":false,"countRemark":"","currentConfirmedCount":382,"confirmedCount":91041,"suspectedCount":2854,"curedCount":85913,"deadCount":4746,"seriousCount":375,"suspectedIncr":19,"currentConfirmedIncr":-6,"confirmedIncr":23,"curedIncr":29,"deadIncr":0,"seriousIncr":-1,"remark1":"易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病","remark2":"潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见","remark3":"宿主：野生动物，可能为中华菊头蝠","remark4":"","remark5":"","note1":"病毒：SARS-CoV-2，其导致疾病命名 COVID-19","note2":"传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。","note3":"传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。","generalRemark":"1. 3 月 12 日国家卫健委确诊补订遗漏 12 例确诊病例（非 12 日新增），暂无具体省份信息。 2. 浙江省 12 例外省治愈暂无具体省份信息。","abroadRemark":"","foreignStatistics":{"currentConfirmedCount":10057818,"confirmedCount":33611961,"suspectedCount":4,"curedCount":22549940,"deadCount":1004203,"suspectedIncr":0,"currentConfirmedIncr":-40737,"confirmedIncr":151196,"curedIncr":188638,"deadIncr":3295},"globalStatistics":{"currentConfirmedCount":10058200,"confirmedCount":33703002,"curedCount":22635853,"deadCount":1008949,"currentConfirmedIncr":-40743,"confirmedIncr":151219,"curedIncr":188667,"deadIncr":3295}}}]
     */

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("newslist")
    private List<NewslistDTO> newslist;

    @NoArgsConstructor
    @Data
    public static class NewslistDTO {
        /**
         * news : [{"id":87900,"pubDate":1601445443000,"pubDateStr":"1小时前","title":"香港特区政府：到港人士强制检疫令暂定延长至12月31日","summary":"香港特区政府29日宣布系列防疫新举措，其中包括到港人士强制检疫令暂定再延长至12月31日。据介绍，特区政府将把《若干到港人士强制检疫规例》（第599C章）及《预防及控制疾病（规管跨境交通工具及到港者）规例》（第599H章）的有效期各延长两个多月至2020年12月31日。特区政府发言人指出，延长有关规例的有效期，并不代表该规例现行施加的限制会持续不变直至有效期完结，相反有关法律框架已加入弹性条款。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=Arti57yZFh1bBT8JcCkZ92oU200930&isfromapp=1","provinceId":""},{"id":87898,"pubDate":1601444725000,"pubDateStr":"1小时前","title":"陕西29日新增2例境外输入确诊病例","summary":"据陕西省卫健委通报：9月29日0\u201424时，无新增报告本地确诊病例、疑似病例、无症状感染者。截至9月29日24时，累计报告本地确诊病例245例，出院242例，死亡3例。9月29日0\u201424时，新增报告境外输入确诊病例2例，确诊病例治愈出院3例，无症状感染者解除医学观察2例。截至9月29日24时，累计报告境外输入确诊病例163例，出院139例，在院24例。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiCYfaQZsiMshYf8EqrBiY200930&isfromapp=1","provinceId":""},{"id":87886,"pubDate":1601441765000,"pubDateStr":"2小时前","title":"北京按75%限流开放公园、旅游景区 暂不恢复出入境旅游业务","summary":"9月30日上午，在北京市新型冠状病毒肺炎疫情防控工作第167场新闻发布会上，北京市卫生健康委员会一级巡视员、新闻发言人高小俊介绍，国庆、中秋\u201c两节\u201d期间，北京市将落实限量、预约、错峰要求，有序开放旅游场所。落实旅游场所限流措施，按75%限流开放公园、旅游景区。严格落实谁组织、谁管理、谁负责要求，指导旅行社和相关企业履行主体责任，合理调控进京旅游团队规模，不接收14天内来自国内中高风险地区人员、入境人员入住酒店和乡村民宿或进入景区游览。暂不恢复出入境旅游业务。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiYB5GZfH7x1xgn88lz6QI200930&isfromapp=1","provinceId":""},{"id":87871,"pubDate":1601436189000,"pubDateStr":"3小时前","title":"上海9月29日新增境外输入2例  治愈出院3例","summary":"9月29日0\u201424时，通过口岸联防联控机制，报告2例境外输入性新冠肺炎确诊病例，均为中国籍，从菲律宾回国。新增治愈出院3例，其中来自菲律宾1例，来自美国1例，来自俄罗斯1例。","infoSource":"上海卫健委","sourceUrl":"http://wsjkw.sh.gov.cn/xwfb/20200930/b346836470a449359e6999ff7244f8ce.html","provinceId":""},{"id":87861,"pubDate":1601431890000,"pubDateStr":"5小时前","title":"\u200b墨西哥新冠肺炎确诊病例累计达738163例","summary":"当地时间9月29日，墨西哥卫生部宣布，截止到9月29日晚7时，墨西哥全国确诊738163例新冠肺炎病例，较前一天新增了4446例，墨西哥全国确诊死亡病例较前一天新增560例，总数已经上升到77163例。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArticYgxjVux25VOTZyiWEY3200930&isfromapp=1","provinceId":""}]
         * desc : {"id":1,"createTime":1579537899000,"modifyTime":1601447944000,"summary":"","deleted":false,"countRemark":"","currentConfirmedCount":382,"confirmedCount":91041,"suspectedCount":2854,"curedCount":85913,"deadCount":4746,"seriousCount":375,"suspectedIncr":19,"currentConfirmedIncr":-6,"confirmedIncr":23,"curedIncr":29,"deadIncr":0,"seriousIncr":-1,"remark1":"易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病","remark2":"潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见","remark3":"宿主：野生动物，可能为中华菊头蝠","remark4":"","remark5":"","note1":"病毒：SARS-CoV-2，其导致疾病命名 COVID-19","note2":"传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。","note3":"传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。","generalRemark":"1. 3 月 12 日国家卫健委确诊补订遗漏 12 例确诊病例（非 12 日新增），暂无具体省份信息。 2. 浙江省 12 例外省治愈暂无具体省份信息。","abroadRemark":"","foreignStatistics":{"currentConfirmedCount":10057818,"confirmedCount":33611961,"suspectedCount":4,"curedCount":22549940,"deadCount":1004203,"suspectedIncr":0,"currentConfirmedIncr":-40737,"confirmedIncr":151196,"curedIncr":188638,"deadIncr":3295},"globalStatistics":{"currentConfirmedCount":10058200,"confirmedCount":33703002,"curedCount":22635853,"deadCount":1008949,"currentConfirmedIncr":-40743,"confirmedIncr":151219,"curedIncr":188667,"deadIncr":3295}}
         */

        @JsonProperty("desc")
        private DescDTO desc;
        @JsonProperty("news")
        private List<NewsDTO> news;

        @NoArgsConstructor
        @Data
        public static class DescDTO {
            /**
             * id : 1
             * createTime : 1579537899000
             * modifyTime : 1601447944000
             * summary :
             * deleted : false
             * countRemark :
             * currentConfirmedCount : 382
             * confirmedCount : 91041
             * suspectedCount : 2854
             * curedCount : 85913
             * deadCount : 4746
             * seriousCount : 375
             * suspectedIncr : 19
             * currentConfirmedIncr : -6
             * confirmedIncr : 23
             * curedIncr : 29
             * deadIncr : 0
             * seriousIncr : -1
             * remark1 : 易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病
             * remark2 : 潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见
             * remark3 : 宿主：野生动物，可能为中华菊头蝠
             * remark4 :
             * remark5 :
             * note1 : 病毒：SARS-CoV-2，其导致疾病命名 COVID-19
             * note2 : 传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。
             * note3 : 传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。
             * generalRemark : 1. 3 月 12 日国家卫健委确诊补订遗漏 12 例确诊病例（非 12 日新增），暂无具体省份信息。 2. 浙江省 12 例外省治愈暂无具体省份信息。
             * abroadRemark :
             * foreignStatistics : {"currentConfirmedCount":10057818,"confirmedCount":33611961,"suspectedCount":4,"curedCount":22549940,"deadCount":1004203,"suspectedIncr":0,"currentConfirmedIncr":-40737,"confirmedIncr":151196,"curedIncr":188638,"deadIncr":3295}
             * globalStatistics : {"currentConfirmedCount":10058200,"confirmedCount":33703002,"curedCount":22635853,"deadCount":1008949,"currentConfirmedIncr":-40743,"confirmedIncr":151219,"curedIncr":188667,"deadIncr":3295}
             */

            @JsonProperty("id")
            private Integer id;
            @JsonProperty("createTime")
            private Long createTime;
            @JsonProperty("modifyTime")
            private Long modifyTime;
            @JsonProperty("summary")
            private String summary;
            @JsonProperty("deleted")
            private Boolean deleted;
            @JsonProperty("countRemark")
            private String countRemark;
            @JsonProperty("currentConfirmedCount")
            private Integer currentConfirmedCount;
            @JsonProperty("confirmedCount")
            private Integer confirmedCount;
            @JsonProperty("suspectedCount")
            private Integer suspectedCount;
            @JsonProperty("curedCount")
            private Integer curedCount;
            @JsonProperty("deadCount")
            private Integer deadCount;
            @JsonProperty("seriousCount")
            private Integer seriousCount;
            @JsonProperty("suspectedIncr")
            private Integer suspectedIncr;
            @JsonProperty("currentConfirmedIncr")
            private Integer currentConfirmedIncr;
            @JsonProperty("confirmedIncr")
            private Integer confirmedIncr;
            @JsonProperty("curedIncr")
            private Integer curedIncr;
            @JsonProperty("deadIncr")
            private Integer deadIncr;
            @JsonProperty("seriousIncr")
            private Integer seriousIncr;
            @JsonProperty("remark1")
            private String remark1;
            @JsonProperty("remark2")
            private String remark2;
            @JsonProperty("remark3")
            private String remark3;
            @JsonProperty("remark4")
            private String remark4;
            @JsonProperty("remark5")
            private String remark5;
            @JsonProperty("note1")
            private String note1;
            @JsonProperty("note2")
            private String note2;
            @JsonProperty("note3")
            private String note3;
            @JsonProperty("generalRemark")
            private String generalRemark;
            @JsonProperty("abroadRemark")
            private String abroadRemark;
            @JsonProperty("foreignStatistics")
            private ForeignStatisticsDTO foreignStatistics;
            @JsonProperty("globalStatistics")
            private GlobalStatisticsDTO globalStatistics;

            @NoArgsConstructor
            @Data
            public static class ForeignStatisticsDTO {
                /**
                 * currentConfirmedCount : 10057818
                 * confirmedCount : 33611961
                 * suspectedCount : 4
                 * curedCount : 22549940
                 * deadCount : 1004203
                 * suspectedIncr : 0
                 * currentConfirmedIncr : -40737
                 * confirmedIncr : 151196
                 * curedIncr : 188638
                 * deadIncr : 3295
                 */

                @JsonProperty("currentConfirmedCount")
                private Integer currentConfirmedCount;
                @JsonProperty("confirmedCount")
                private Integer confirmedCount;
                @JsonProperty("suspectedCount")
                private Integer suspectedCount;
                @JsonProperty("curedCount")
                private Integer curedCount;
                @JsonProperty("deadCount")
                private Integer deadCount;
                @JsonProperty("suspectedIncr")
                private Integer suspectedIncr;
                @JsonProperty("currentConfirmedIncr")
                private Integer currentConfirmedIncr;
                @JsonProperty("confirmedIncr")
                private Integer confirmedIncr;
                @JsonProperty("curedIncr")
                private Integer curedIncr;
                @JsonProperty("deadIncr")
                private Integer deadIncr;
            }

            @NoArgsConstructor
            @Data
            public static class GlobalStatisticsDTO {
                /**
                 * currentConfirmedCount : 10058200
                 * confirmedCount : 33703002
                 * curedCount : 22635853
                 * deadCount : 1008949
                 * currentConfirmedIncr : -40743
                 * confirmedIncr : 151219
                 * curedIncr : 188667
                 * deadIncr : 3295
                 */

                @JsonProperty("currentConfirmedCount")
                private Integer currentConfirmedCount;
                @JsonProperty("confirmedCount")
                private Integer confirmedCount;
                @JsonProperty("curedCount")
                private Integer curedCount;
                @JsonProperty("deadCount")
                private Integer deadCount;
                @JsonProperty("currentConfirmedIncr")
                private Integer currentConfirmedIncr;
                @JsonProperty("confirmedIncr")
                private Integer confirmedIncr;
                @JsonProperty("curedIncr")
                private Integer curedIncr;
                @JsonProperty("deadIncr")
                private Integer deadIncr;
            }
        }

        @NoArgsConstructor
        @Data
        public static class NewsDTO {
            /**
             * id : 87900
             * pubDate : 1601445443000
             * pubDateStr : 1小时前
             * title : 香港特区政府：到港人士强制检疫令暂定延长至12月31日
             * summary : 香港特区政府29日宣布系列防疫新举措，其中包括到港人士强制检疫令暂定再延长至12月31日。据介绍，特区政府将把《若干到港人士强制检疫规例》（第599C章）及《预防及控制疾病（规管跨境交通工具及到港者）规例》（第599H章）的有效期各延长两个多月至2020年12月31日。特区政府发言人指出，延长有关规例的有效期，并不代表该规例现行施加的限制会持续不变直至有效期完结，相反有关法律框架已加入弹性条款。
             * infoSource : 央视新闻app
             * sourceUrl : http://app.cctv.com/special/cportal/detail/arti/index.html?id=Arti57yZFh1bBT8JcCkZ92oU200930&isfromapp=1
             * provinceId :
             */

            @JsonProperty("id")
            private Integer id;
            @JsonProperty("pubDate")
            private Long pubDate;
            @JsonProperty("pubDateStr")
            private String pubDateStr;
            @JsonProperty("title")
            private String title;
            @JsonProperty("summary")
            private String summary;
            @JsonProperty("infoSource")
            private String infoSource;
            @JsonProperty("sourceUrl")
            private String sourceUrl;
            @JsonProperty("provinceId")
            private String provinceId;
        }
    }
}
