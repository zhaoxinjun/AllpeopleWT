package zxj.com.allpeoplewt.bean;

import com.example.library.utils.netutils.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class WeChatBean extends ResponseBean{

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-02","title":"发财树也能开花，花朵还很漂亮！","description":"流意盆栽","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5hX4zhRicEEHxTdyFibfe1xrbcI1qaAs6yOnY31L6v02T96VxCR3GcZhEwS956NLAFpLLktN34R4baaBauWg4N5A/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/yficc0tDfgFIoKGxhJZMsg"},{"ctime":"2017-01-02","title":"很多事都是后知后觉，比如喝水、添衣和想你。","description":"我要WhatYouNeed","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/zynprs47B4RfDAH6Os3rIFOwzVHGR37yywpmwm7icwJ2q2OgylXt1v1c4pXv2GZl863Oh5tP5FMLubT5uQnxT8Q/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/psvCdmdncjAeYov_dzmQOQ"},{"ctime":"2017-01-02","title":"这个神奇的眼罩只需戴19分钟，比做大保健还舒服！","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/yZPTcMGWibvucibXtEFAYXic59vNKADwhjicATjicbIic68bZvGnPCXWicf7IkOPhLmYaBj8sJvHIBDbY3XNbDw2EQiaOQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/j9uTFY5Bw0wYWRBCmSssmA"},{"ctime":"2017-01-02","title":"从段首空两格说起","description":"小道消息","picUrl":"http://mmbiz.qpic.cn/mmbiz/ow5rEn8QGlEL46kJgQzicrPNevGzU1xtwjOeLwQDxm8s3RPs7XvNfOlz3qkhdv3hiaKUyCOrZZGU4saAfW9gK52w/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/V7hN40XyuSF7cIW8Og0SlA"},{"ctime":"2017-01-02","title":"罗振宇《时间的朋友》跨年演讲精华版：2017年的5大趋势与变化","description":"腾讯科技","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIHMrXsUsOOBxS3GibwyCicH9JxJrbQ1icaWEqqMPmybia7RuFJyicam8njlqgubeAlgr4Kw1icOucGXaOLQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/qyC9KS308xKhALR-dAyeWQ"},{"ctime":"2017-01-02","title":"王小川：让搜狗少犯错的，不是精通，而是不懂","description":"科技50","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/kfceBEgJM8ATns4R7iakibiazo3qJf31icILIcwQa8dBDRCYuLJnUibAGYcxWMYGjCbfN005MnUSFULRrLYYn2GjyRg/640?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/difkR5jVDKNODKVazfZLxQ"},{"ctime":"2017-01-02","title":"习近平首次点评\u201c95后\u201d大学生，他都说了啥？","description":"人民日报","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08Aaf9fxlw9NVicUXGjShBhBOqziakENm5d8hwB7PBs3XLpalIicz2RcFe14btT3Fpib9jhtotnSDkIctQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ApjXZK34Gvsi6pIZvJmNMA"},{"ctime":"2017-01-02","title":"2017年，你的格局决定了你的成就！","description":"格局决定一切","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/OLH0Uia2RD0yGxWM7B5dbgyC32sLPNDE4ibribnalc5c6Y8Yx4or7tYmuiboibbrkTtYp3QOrd5eica9xykoUQyL2Fcw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/CCVE1QPiwjXmlr-UOJU9tQ"},{"ctime":"2017-01-02","title":"首脑们撸起袖子加油干，唯独朝鲜要搞事情","description":"金十财经","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ECxVTy192TfWzk8gAvKp3N2JFx53MXXqmxSW5d4rCRK6OwGw7WwmadrtVXGQG72IYFNGicQPpG2gYRibwUvkGn1w/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/Smq6Ipxl1Pj6lMgy7I2amQ"},{"ctime":"2017-01-01","title":"2016年里最坑人的10大谣言！果壳已经看不下去了\u2026\u2026","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/icZklJrRfHgCZHdPNo83r3ibc61JAemOv6RJ8KRFCwSOprppRkUIE97GibqRjUxX9yibsnyteLJzr7TayLibia90OuQA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/oTFrFLz_jhR766TuLkuEYQ"}]
     */

    public int code;
    public String msg;
    /**
     * ctime : 2017-01-02
     * title : 发财树也能开花，花朵还很漂亮！
     * description : 流意盆栽
     * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/5hX4zhRicEEHxTdyFibfe1xrbcI1qaAs6yOnY31L6v02T96VxCR3GcZhEwS956NLAFpLLktN34R4baaBauWg4N5A/0?wx_fmt=jpeg
     * url : http://mp.weixin.qq.com/s/yficc0tDfgFIoKGxhJZMsg
     */

    public List<NewslistBean> newslist;

    public static class NewslistBean {
        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
