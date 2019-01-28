package cc.aoeiuv020.panovel.api.site

import org.junit.Test

/**
 *
 * Created by AoEiuV020 on 2017.10.16-17:47:33.
 */
class QidianTest : BaseNovelContextText(Qidian::class) {
    @Test
    fun search() {
        search("都市")
        search("从前有座灵剑山", "国王陛下", "3347574")
        search("斗破苍穹", "天蚕土豆", "1209977")
        search("修真聊天群", "圣骑士的传说", "3602691")
    }

    @Test
    fun detail() {
        detail("3602691", "3602691", "修真聊天群", "圣骑士的传说",
                "https://bookcover.yuewen.com/qdbimg/349573/3602691/180",
                "某天，宋书航意外加入了一个仙侠中二病资深患者的交流群，里面的群友们都以‘道友’相称，群名片都是各种府主、洞主、真人、天师。" +
                        "连群主走失的宠物犬都称为大妖犬离家出走。整天聊的是炼丹、闯秘境、炼功经验啥的。\n" +
                        "突然有一天，潜水良久的他突然发现……群里每一个群员，竟然全部是修真者，能移山倒海、长生千年的那种！\n" +
                        "啊啊啊啊，世界观在一夜间彻底崩碎啦！\n" +
                        "书友群：九洲1号群:207572656\n" +
                        "九洲２号群:168114177\n" +
                        "九洲３号群:165210665（新）\n" +
                        "九洲一号群（VIP书友群，需验证）63769632",
                null)
        detail("1010436534", "1010436534", "我是女皇的随身铠甲", "一文倒",
                "https://bookcover.yuewen.com/qdbimg/349573/1010436534/180",
                "盖世修为和《周天全书》，张夜带着他们重生，却成为了冰雪美人的专属甲胄，过上了给她当老爷爷的日子。\n" +
                        "“什么？有大boss？，丫头给我撞死他！”\n" +
                        "“高手？丫头给我撕了他！”\n" +
                        "“六臂食人猿？丫头，给我活吞了她！”\n" +
                        "“皇宫秘宝？偷？抢就完事了！”\n" +
                        "“丫头，你最近是不是又发育了，感觉有点绷啊...”\n" +
                        "铠甲在身，敌我不分！生死看淡，不服就干！\n" +
                        "这个故事讲的是，张夜如何培养出一位史上最生猛的女皇。",
                "2017-12-08 19:17:10")
        // 小作者的小说详情页作者名不可点击，之前的规则不行，
        detail("1009711354", "1009711354", "超级惊悚直播", "宇文长弓",
                "https://bookcover.yuewen.com/qdbimg/349573/1009711354/180",
                "“欢迎大家来到超级惊悚直播间，在开启今天的直播之前，我必须要告诉你们，" +
                        "本直播只有三类人能够看到：身上阴气很重的人，七天之内将死之人，至于第三种，我不便细说，只能给你们一个忠告——小心身后！”",
                "2018-05-15 10:08:55")
    }

    @Test
    fun chapters() {
        chapters("3602691",
                "封推感言", "3602691/92831099", "2016-01-17 23:09:54",
                "第1941章 乱了，彻底乱了", "3602691/407005799", "2018-05-20 18:50:00",
                1952)
        chapters("1010436534",
                "读者重磅回馈：感恩节福利~", "1010436534/391332113", "2017-11-23 21:00:51",
                "第一百五十九章 幻境", "1010436534/392793365", "2017-12-08 19:17:10",
                163)
        // 这个章节列表体积大于默认1M，
        chapters("3357187",
                "第1章 撕心裂肺的背叛", "3357187/70794726", "2014-05-13 04:40:31",
                "五月份~~", "3357187/405405025", "2018-05-01 00:02:59",
                10303)
    }

    @Test
    fun content() {
        content("1005983537/357637902",
                "回到教室，陈乔山心里很是激动，就在回来的路上，突然想到上辈子他也是参加过高考的，只不过时间是三年后的2006年。",
                "话刚说完，却见严小沁回头小心翼翼的看了他一眼，娇憨脸庞上的剪水双瞳分明蕴含一丝探究的意味。",
                55)
    }
}
