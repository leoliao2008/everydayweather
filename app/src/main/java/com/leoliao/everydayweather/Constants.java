package com.leoliao.everydayweather;

/**
 * 创建者     $Author$
 * 创建时间   2017/2/22 23:57
 * 描述	      ${TODO}
 * <p>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */

public interface Constants {

    public static final String REQUEST_DOMESTIC_ADDRESS="http://guolin.tech/api/china/";


    //{"HeWeather": [{"aqi":{"city":{"aqi":"139","co":"1","no2":"39","o3":"33","pm10":"0","pm25":"106","qlty":"轻度污染","so2":"15"}},"basic":{"city":"苏州","cnty":"中国","id":"CN101190401","lat":"31.309000","lon":"120.612000","update":{"loc":"2017-02-23 00:51","utc":"2017-02-22 16:51"}},"daily_forecast":[{"astro":{"mr":"03:53","ms":"14:41","sr":"06:30","ss":"17:51"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-02-23","hum":"67","pcpn":"0.0","pop":"3","pres":"1028","tmp":{"max":"8","min":"2"},"uv":"5","vis":"10","wind":{"deg":"340","dir":"东北风","sc":"微风","spd":"3"}},{"astro":{"mr":"04:39","ms":"15:37","sr":"06:29","ss":"17:51"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2017-02-24","hum":"57","pcpn":"0.0","pop":"0","pres":"1030","tmp":{"max":"10","min":"2"},"uv":"6","vis":"10","wind":{"deg":"322","dir":"东南风","sc":"微风","spd":"4"}},{"astro":{"mr":"05:23","ms":"16:35","sr":"06:28","ss":"17:52"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2017-02-25","hum":"61","pcpn":"0.0","pop":"0","pres":"1028","tmp":{"max":"12","min":"4"},"uv":"6","vis":"10","wind":{"deg":"255","dir":"南风","sc":"微风","spd":"7"}}],"hourly_forecast":[{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-02-23 01:00","hum":"83","pop":"6","pres":"1025","tmp":"3","wind":{"deg":"310","dir":"西北风","sc":"3-4","spd":"20"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-02-23 04:00","hum":"80","pop":"1","pres":"1026","tmp":"2","wind":{"deg":"311","dir":"西北风","sc":"3-4","spd":"21"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-02-23 07:00","hum":"74","pop":"0","pres":"1028","tmp":"3","wind":{"deg":"322","dir":"西北风","sc":"3-4","spd":"22"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-02-23 10:00","hum":"64","pop":"0","pres":"1029","tmp":"6","wind":{"deg":"338","dir":"西北风","sc":"3-4","spd":"20"}},{"cond":{"code":"101","txt":"多云"},"date":"2017-02-23 13:00","hum":"55","pop":"0","pres":"1028","tmp":"9","wind":{"deg":"341","dir":"西北风","sc":"3-4","spd":"19"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-02-23 16:00","hum":"56","pop":"0","pres":"1028","tmp":"9","wind":{"deg":"115","dir":"东南风","sc":"微风","spd":"15"}},{"cond":{"code":"104","txt":"阴"},"date":"2017-02-23 19:00","hum":"64","pop":"0","pres":"1029","tmp":"6","wind":{"deg":"30","dir":"东北风","sc":"微风","spd":"16"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-02-23 22:00","hum":"66","pop":"0","pres":"1031","tmp":"4","wind":{"deg":"37","dir":"东北风","sc":"微风","spd":"15"}}],"now":{"cond":{"code":"101","txt":"多云"},"fl":"-1","hum":"78","pcpn":"0","pres":"1025","tmp":"3","vis":"5","wind":{"deg":"309","dir":"西北风","sc":"5-6","spd":"28"}},"status":"ok","suggestion":{"air":{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。"},"comf":{"brf":"较舒适","txt":"白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。"},"cw":{"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"易发","txt":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。"},"sport":{"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"},"trav":{"brf":"一般","txt":"天气较好，风稍大，体感稍凉，旅游指数一般，外出请注意防风御寒。"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}}]}
    //http://docs.heweather.com/224270 for details
    public static final String REQUEST_WEATHER_DATA="http://guolin.tech/api/weather?key=dd71df46a4014272ab52ac22d37ce0dc&cityid=";

    public static final String REQUEST_WALL_PAPER="http://guolin.tech/api/bing_pic";
    public static final String BAIDU_LBS_KEY="5bpTc8K6n4BPRG6k3rXBZpnYg3iIznXi";

}
