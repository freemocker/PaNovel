package cc.aoeiuv020.panovel.api.site

import org.junit.Test

/**
 * Created by AoEiuV020 on 2018.06.03-21:46:43.
 */
class AilelebaTest : BaseNovelContextText(Aileleba::class) {
    @Test
    fun search() {
        search("都市")
        search("鹰掠九天", "仲渊2", "163459")
        search("最强榜单", "38大虾", "163455")
    }

    @Test
    fun detail() {
        detail("163455", "163455", "最强榜单", "38大虾",
                "https://www.ailelela.com/files/article/image/163/163455/163455s.jpg",
                "在遥远东方，有一个碾压福布斯，胡润富豪榜的草根综合榜单。\n" +
                        "这个榜单直接覆盖全球所有人。\n" +
                        "这个榜单更精确专业，被用户戏称刨祖坟好手。\n" +
                        "这个榜单包含诸多分榜单，财富、医术、武功。。。。娱乐美食美女等等，甚至乞丐要饭他都统计，被外界戏称为三百六十行，行行能上榜，榜榜能装逼。\n" +
                        "这个榜单主榜不接受任何买榜，哪怕你权势滔天。不管是谁，最多他只让你上副榜，还得排队看他脸色。即便这样无数财团趋之若鹜，只为上他的副榜。因为不被他的榜单认可，你根本不好意思自称精英，行业翘楚，自称有影响力。\n" +
                        "——《雷布斯全球峰会笔录》\n" +
                        "首创排行榜流，已有400万字、高定2万完本精品放心入坑。点击收藏，每天推送你的个人全球财富排名！",
                "2018-06-03 20:59:00")
    }

    @Test
    fun chapters() {
        chapters("163455", "第一章 我没忍，我动手了（求收藏求推荐）", "163455/zhangjie38921903", null,
                "第144章 大伯你看这个人！", "163455/zhangjie38969947", "2018-06-03 20:59:00",
                109)
    }

    @Test
    fun content() {
        content("163455/zhangjie38969947",
                "市府邀请自己！",
                "还真是老三的儿子！百度搜索乐安宣書網(乐安宣书网https://www.ailelela.com)",
                53)
    }

}