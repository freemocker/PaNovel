package cc.aoeiuv020.panovel.api.site

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 *
 * Created by AoEiuV020 on 2018.03.07-03:24:15.
 */
class SnwxTest {
    init {
        System.setProperty("org.slf4j.simpleLogger.log.Snwx", "trace")
    }

    private lateinit var context: Snwx
    @Before
    fun setUp() {
        context = Snwx()
    }

    @Test
    fun searchNovelName() {
        context.searchNovelName("祖魔").let {
            it.forEach { novelItem ->
                println(novelItem)
            }
            assertTrue(it.any { novelItem ->
                novelItem.name == "祖魔"
            })
        }
    }

    @Test
    fun getNovelDetail() {
        context.getNovelDetail("https://www.snwx8.com/book/66/66076/").let {
            assertEquals("祖魔", it.novel.name)
            assertEquals("一夜风云起", it.novel.author)
            assertEquals("祖魔的简介：一个超级世家大家族少爷，却天生丹田堵塞，难以修真！本有着疼爱自己的父母，却一夜之间家族没落，自此身负血海深仇！恋人的背叛，父母的离去，最终让他指天怒骂！天道不公，以万物为刍狗！既然天已无道，我愿舍身成魔！以血染天，以杀破道！", it.introduction)
            assertEquals("https://www.snwx8.com/files/article/image/66/66076/66076s.jpg", it.bigImg)
            println(it.update)
        }
        // TODO: 获取不到封面，麻烦，是图片有地址但下载不到，要加上onError,
        context.getNovelDetail("https://www.snwx8.com/book/257/257710/").let {
            assertEquals("都市超级神尊", it.novel.name)
            assertEquals("小萌靓", it.novel.author)
            assertEquals("https://www.snwx8.com/files/article/image/257/257710/257710s.jpg", it.bigImg)
            println(it.introduction)
            println(it.update)
        }
        // 之前的有可能获取不到简介，
        context.getNovelDetail("https://www.snwx8.com/book/28/28152/").let {
            assertEquals("大道独行", it.novel.name)
            assertEquals("雾外江山", it.novel.author)
            assertEquals("https://www.snwx8.com/files/article/image/28/28152/28152s.jpg", it.bigImg)
            assertEquals("各位书友要是觉得《大道独行》还不错的话请不要忘记向您QQ群和微博里的朋友推荐哦！", it.introduction)
            println(it.update)
        }
    }

    @Test
    fun getNovelChaptersAsc() {
        context.getNovelChaptersAsc("https://www.snwx8.com/book/0/20/").let { list ->
            list.forEach {
                println(it)
            }
            assertEquals("第一章 狠角色", list.first().name)
        }
    }

    @Test
    fun getNovelText() {
        context.getNovelText("https://www.snwx8.com/book/0/20/9888.html").textList.let {
            assertEquals(40, it.size)
            assertEquals("(新书上传期间，求会员点击、推荐、收藏……拜谢！)", it.first())
            assertEquals("张卫东微微皱了皱眉头，却是没有回头，继续走他的路。", it.last())
        }
    }
}
