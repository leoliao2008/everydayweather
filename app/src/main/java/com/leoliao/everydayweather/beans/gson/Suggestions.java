package com.leoliao.everydayweather.beans.gson;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/24 0:59
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class Suggestions {

    /**
     * comf : {"brf":"较不舒适","txt":"白天天气多云，同时会感到有些热，不很舒适。"}
     * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * drsg : {"brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"}
     * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
     * sport : {"brf":"较适宜","txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"}
     * trav : {"brf":"较适宜","txt":"天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！"}
     * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
     */

    public ComfEntity comf;
    public CwEntity cw;
    public DrsgEntity drsg;
    public FluEntity flu;
    public SportEntity sport;
    public TravEntity trav;
    public UvEntity uv;

    public class ComfEntity {
        /**
         * brf : 较不舒适
         * txt : 白天天气多云，同时会感到有些热，不很舒适。
         */

        public String brf;
        public String txt;
    }

    public class CwEntity {
        /**
         * brf : 较适宜
         * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
         */

        public String brf;
        public String txt;
    }

    public class DrsgEntity {
        /**
         * brf : 炎热
         * txt : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
         */

        public String brf;
        public String txt;
    }

    public class FluEntity {
        /**
         * brf : 少发
         * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
         */

        public String brf;
        public String txt;
    }

    public class SportEntity {
        /**
         * brf : 较适宜
         * txt : 天气较好，户外运动请注意防晒。推荐您进行室内运动。
         */

        public String brf;
        public String txt;
    }

    public class TravEntity {
        /**
         * brf : 较适宜
         * txt : 天气较好，温度较高，天气较热，但有微风相伴，还是比较适宜旅游的，不过外出时要注意防暑防晒哦！
         */

        public String brf;
        public String txt;
    }

    public class UvEntity {
        /**
         * brf : 中等
         * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
         */

        public String brf;
        public String txt;
    }
}
