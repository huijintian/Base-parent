import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.junit.Test;

/**
 * Created by mengtian on 2018/1/21
 */
public class HashTest {

    @Test
    public void hashTest() {
        long startTime = System.currentTimeMillis();
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                .putString("<div id=\"content\" class=\"borderH\">\n" +
                        "    <div class=\"bookname\">\n" +
                        "      <h2>第一千零一十七章 分支能力</h2>\n" +
                        "<p><script type=\"text/javascript\" src=\"/gaogao/style1.js\"></script></p>\n" +
                        "      <em>作者：二目</em></div>\n" +
                        "<center><script type=\"text/javascript\" src=\"/gaogao/style2.js\"></script></center>\n" +
                        "    <div class=\"hr101\"></div>\n" +
                        "<div id=\"txtright\"><script type=\"text/javascript\" src=\"/gaogao/style0.js\"></script></div>\n" +
                        "   &nbsp;&nbsp;&nbsp;&nbsp;和露西亚的成年日一样，闪电的晋升固然令人欣喜，却也给罗兰带来了些许麻烦。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“昨晚小区里有人受伤了？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;次日，听完巴罗夫的汇报后，他不由得挑了挑眉毛。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“是啊，陛下……”电话筒那头传来了对方的诉苦声，“一个倒霉鬼正打算去上厕所，结果被爆炸声吓得摔折了腿，还有两个家伙从床上滚下来磕破了头，大早上市政厅就来了一大帮惊慌未定的领民，询问无冬城是不是被魔鬼或邪兽攻击了，下面的人费了好大力气才把他们劝走。陛下，以后发生这种事情之前，您能先跟我说一声吗？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;即使隔着听筒，他也能想象出对方哀怨的样子。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;大概老总管本人也被吓得不轻，一夜未眠的苦苦等到天亮。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“伤者现在如何？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“都送到医疗院去了，保住性命倒是没什么问题，不过领民仍在议论纷纷，中央广场上还有人守着宣传板等公告——这一定又是女巫的能力造成的吧？您若是提前通知我的话，我也不至于在善后这种小事上打扰您。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“我知道了，但跟魔力有关的事情，本身就是难以预估的，这并非是不信任你。”罗兰安抚道，“公告上就说我正在研究新武器好了，今后还会有类似现象，让大家不要惊慌。真遇到敌袭时，以警报为准。对了，那几位受伤者，医疗费用就由市政厅代付吧。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“遵命……陛下。”巴罗夫委屈道。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;罗兰无奈地摇摇头，随后挂断了电话。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;不知为何，老总管最近总有种越来越粘人的感觉，虽然政务都处理得不错，但这种“陛下，臣为您奉献了全部的光和热，您不能辜负臣啊”的语调仍让他有些起鸡皮疙瘩。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;相反与北地珍珠的交谈则爽利得多。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;也不知道她现在到了哪里。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;收回杂念，他望向站在办公桌前，耷拉着脑袋的闪电，似笑非笑地问道，“刚才的话，你应该也听到了吧？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“呜……”小姑娘沮丧道，“陛下，我错了，请罚我做两套习题吧。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;罗兰又将目光移向她头顶的麦茜，而后者艰难地偏开了视线，装出事不关己的模样，“咕——”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;虽然探险团成员亲密无间，但在综合习题这座大山面前，麦茜毅然选择了沉默。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;他终于忍不住笑出声来，“哈哈……好了，把头抬起来，这不能算是你的错——毕竟是我同意你去飞的，责任也应该由我来负才是。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“真、真的？”闪电猛地抬起头，眼睛闪闪道。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“当然，你并不知道那样做会造成破坏，加上损失也不大，习题什么的就免了。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;由于当时的飞行路线是朝着绝境山脉方向前进，因此她对住宅区产生的影响十分有限——除了城堡和外交大楼的窗户玻璃有部分开裂外，其他建筑基本完好。而经过炉窑区上方时，闪电已经爬升到了一定的高度，其影响进一步减小，很难再造成破坏了。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“陛下，您真是……太好了！”她仿佛瞬间恢复了所有活力，麦茜也如释重负地张开了翅膀。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;眼看着一人一鸟有扑上来的架势，罗兰连忙抬手止住了她们的行动，“不过高速飞行真的那么耗费魔力？你昨天才飞了一刻钟不到吧？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;一说到这个，闪电顿时有些不好意思道，“我也十分意外，那时候本想留下一部分魔力来做测试，但稍微试着加速了下，想看看极限在哪里，没料到魔力很快就被消耗一空，差点从天上掉下来。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“还能更快？”一旁记录的温蒂立刻抓到了关键点。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“能，”闪电自信满满道，“只要魔力足够的话——当时连耳边的风声都消失了，我甚至觉得，没有什么可以阻止我继续冲刺下去。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“麦茜呢？她当时一直蹲在你的头顶？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“咕！”还未等闪电回答，麦茜已经转起圈来，“太快，头晕，怀里咕！”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;这是在说飞得太快难受，所以被抱进了怀里么？罗兰发现自己对鸽子语的理解能力大有提升，已经能自动补全中间空白的语句了。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“只是头晕？”另一名负责能力测试的女巫爱葛莎开口道，“没有感受到气流的变化？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“唔……”闪电思索了会儿，“虽然我当时戴着防风镜，但飞到一半时，风就好像突然消失了一样。”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“你们怎么看？”罗兰望向冰女巫，“这样的分支能力，在联合会里有记录吗？”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;尽管闪电因意外耗光了大部分魔力，导致能力实测部分暂告搁置，不过如今的女巫联盟已建立起了一套系统的评估程序，加上继承了联合会的经验，即使不施展能力，通过询问和平衡魔石的检测，也能得出一个大致的判断。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;按照闪电的说法，她仅用三分钟左右便越过绝境群山、飞进了蛮荒之地，而这一段距离平时差不多需要半个小时。夜空中的那声惊雷也能印证这点——进化后的能力令她拥有了追逐声音的资格。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;关于音障的概念，罗兰倒没有多费唇舌——爱葛莎的学习能力素来是女巫中的佼佼者，稍加解释便明白了雷鸣到底是因何而起。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;虽说自然界中不乏一些生物能在短时间内达到音速，人类也在特殊情况下以血肉之躯直面过音速的挑战，但不代表这个过程可以很轻松的实现。毫无疑问，闪电丝毫不受影响的原因必然跟新觉醒的分支能力有关。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“我想应该是「魔力同调」。”爱葛莎沉吟片刻道，“这种分支能力多出现于主能力会给自身带来危险的女巫身上，因此留下的记录也不少。它通常会扩展成一个茧，将女巫包裹其中，同时令茧内的环境保持在常态下。只是维持它需要耗费极大的魔力，而且内外环境差异越大，魔力消耗速度就越高，换句话说……”<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“闪电在短时间内耗空魔力并不是因为飞行，而是分支能力的缘故？”温蒂接道。<br>\n" +
                        "<br>\n" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;“没错，”爱葛莎点点头，“大多数分支能力都是为了协助主能力而诞生的，例如书卷的魔力之书，以及露西亚的色块视界——如果没有它们，主能力的效果将大打折扣，甚至会难以发挥。魔力同调也是如此，比起身受重伤，少飞一点已经是折中之选了。”<span id=\"endtips\"></span>\n" +
                        "<center><script type=\"text/javascript\" src=\"/gaogao/style3.js\"></script></center>\n" +
                        "    <div class=\"hr101\"></div>\n" +
                        "    <div class=\"pageTools\">\n" +
                        "      <p>\n" +
                        "<script type=\"text/javascript\">\n" +
                        "<!--\n" +
                        "var str = \"http://www.lwtxt.net/modules/article/reader.php?aid=10785&cid=23915142\";\n" +
                        "if(str.getQuery(\"cid\"))\n" +
                        "{\n" +
                        "document.write(\"<a href=/html/10785_\"+str.getQuery(\"cid\")+\".html>上一章</a>\");上一章\n" +
                        "}\n" +
                        "else\n" +
                        "{\n" +
                        "document.write(\"<a href=/book/10/10785/ title='返回放开那个女巫介绍'>返回放开那个女巫介绍</a>\");上一章\n" +
                        "}\n" +
                        "//--> </script><a href=\"/html/10785_23915142.html\">上一章</a> \n" +
                        "（<font color=\"red\">←</font>）\n" +
                        "| <a href=\"/book/10/10785/\">返回目录</a> \n" +
                        "| （<font color=\"red\">→</font>）<script type=\"text/javascript\">\n" +
                        "<!--\n" +
                        "var str = \"http://www.lwtxt.net/modules/article/lastchapter.php?aid=10785&dynamic=1\";\n" +
                        "if(str.getQuery(\"cid\"))\n" +
                        "{\n" +
                        "document.write(\"<a href=/html/10785_\"+str.getQuery(\"cid\")+\".html>下一章</a>\");下一章\n" +
                        "}\n" +
                        "else\n" +
                        "{\n" +
                        "document.write(\"<a href=/book/10/10785/ title='返回放开那个女巫介绍'>已经是最后一章</a>\");\n" +
                        "}\n" +
                        "//--> </script><a href=\"/book/10/10785/\" title=\"返回放开那个女巫介绍\">已经是最后一章</a></p>\n" +
                        "<script type=\"text/javascript\" src=\"/gaogao/style4.js\"></script>\n" +
                        "<p></p><div class=\"c\"><a href=\"/modules/article/addbookcase.php?bid=10785&amp;cid=23927852\" rel=\"nofollow\" target=\"_blank\">先看到这(加入书签)</a> | <a href=\"/modules/article/uservote.php?id=10785\" rel=\"nofollow\" target=\"_blank\">推荐本书</a> | <a href=\"/newmessage.php?tosys=1&amp;title=放开那个女巫这本书的第一千零一十七章 分支能力章节出错啦!|更新慢啦!&amp;content=错误章节：第一千零一十七章 分支能力 ++++ 举报原因如下（请您告诉我们哪本书更新慢了或者哪个章节错了！）： \" target=\"_blank\" style=\"color:red\">点此报错/更新慢了</a> | <a href=\"#\">返回顶部</a><p></p><p></p>\n" +
                        "<script type=\"text/javascript\" src=\"/gaogao/style5.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"/gaogao/styletan.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"/gaogao/stylefumeiti.js\"></script>\n" +
                        "<div class=\"hr10\"></div>\n" +
                        "  <div class=\"footer\">\n" +
                        "    <p>乐文小说网-无弹窗，无广告,更新快!本站提供各位热门好看玄幻小说,言情小说,穿越小说,武侠小说, 历史小说,军事小说,网游小说,以及各类TXT小说下载<br>由于所有小说均为网友上传及来自于网络，如侵犯了您的权益，请通知我们，我们会及时处理！<br>\n" +
                        "Copyright © 2012-2018 <a href=\"/\">乐文小说网</a>All Rights Reserved.<br>\n" +
                        "    </p>\n" +
                        "   <script type=\"text/javascript\" src=\"/gaogao/tongji.js\"></script><script src=\"http://s95.cnzz.com/stat.php?id=1258564487&amp;web_id=1258564487\" language=\"JavaScript\"></script><script src=\"http://c.cnzz.com/core.php?web_id=1258564487&amp;t=z\" charset=\"utf-8\" type=\"text/javascript\"></script><a href=\"http://www.cnzz.com/stat/website.php?web_id=1258564487\" target=\"_blank\" title=\"站长统计\">站长统计</a>\n" +
                        "<script type=\"text/javascript\" src=\"http://www.lwtxt.net/style/js/gb.js\"></script></div>\n" +
                        "</div>\n" +
                        "\n" +
                        "</div></div>\"<div id=\\\"content\\\" class=\\\"borderH\\\">\\n\" +\n" +
                        "                        \"    <div class=\\\"bookname\\\">\\n\" +\n" +
                        "                        \"      <h2>第一千零一十七章 分支能力</h2>\\n\" +\n" +
                        "                        \"<p><script type=\\\"text/javascript\\\" src=\\\"/gaogao/style1.js\\\"></script></p>\\n\" +\n" +
                        "                        \"      <em>作者：二目</em></div>\\n\" +\n" +
                        "                        \"<center><script type=\\\"text/javascript\\\" src=\\\"/gaogao/style2.js\\\"></script></center>\\n\" +\n" +
                        "                        \"    <div class=\\\"hr101\\\"></div>\\n\" +\n" +
                        "                        \"<div id=\\\"txtright\\\"><script type=\\\"text/javascript\\\" src=\\\"/gaogao/style0.js\\\"></script></div>\\n\" +\n" +
                        "                        \"   &nbsp;&nbsp;&nbsp;&nbsp;和露西亚的成年日一样，闪电的晋升固然令人欣喜，却也给罗兰带来了些许麻烦。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“昨晚小区里有人受伤了？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;次日，听完巴罗夫的汇报后，他不由得挑了挑眉毛。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“是啊，陛下……”电话筒那头传来了对方的诉苦声，“一个倒霉鬼正打算去上厕所，结果被爆炸声吓得摔折了腿，还有两个家伙从床上滚下来磕破了头，大早上市政厅就来了一大帮惊慌未定的领民，询问无冬城是不是被魔鬼或邪兽攻击了，下面的人费了好大力气才把他们劝走。陛下，以后发生这种事情之前，您能先跟我说一声吗？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;即使隔着听筒，他也能想象出对方哀怨的样子。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;大概老总管本人也被吓得不轻，一夜未眠的苦苦等到天亮。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“伤者现在如何？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“都送到医疗院去了，保住性命倒是没什么问题，不过领民仍在议论纷纷，中央广场上还有人守着宣传板等公告——这一定又是女巫的能力造成的吧？您若是提前通知我的话，我也不至于在善后这种小事上打扰您。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“我知道了，但跟魔力有关的事情，本身就是难以预估的，这并非是不信任你。”罗兰安抚道，“公告上就说我正在研究新武器好了，今后还会有类似现象，让大家不要惊慌。真遇到敌袭时，以警报为准。对了，那几位受伤者，医疗费用就由市政厅代付吧。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“遵命……陛下。”巴罗夫委屈道。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;罗兰无奈地摇摇头，随后挂断了电话。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;不知为何，老总管最近总有种越来越粘人的感觉，虽然政务都处理得不错，但这种“陛下，臣为您奉献了全部的光和热，您不能辜负臣啊”的语调仍让他有些起鸡皮疙瘩。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;相反与北地珍珠的交谈则爽利得多。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;也不知道她现在到了哪里。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;收回杂念，他望向站在办公桌前，耷拉着脑袋的闪电，似笑非笑地问道，“刚才的话，你应该也听到了吧？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“呜……”小姑娘沮丧道，“陛下，我错了，请罚我做两套习题吧。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;罗兰又将目光移向她头顶的麦茜，而后者艰难地偏开了视线，装出事不关己的模样，“咕——”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;虽然探险团成员亲密无间，但在综合习题这座大山面前，麦茜毅然选择了沉默。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;他终于忍不住笑出声来，“哈哈……好了，把头抬起来，这不能算是你的错——毕竟是我同意你去飞的，责任也应该由我来负才是。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“真、真的？”闪电猛地抬起头，眼睛闪闪道。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“当然，你并不知道那样做会造成破坏，加上损失也不大，习题什么的就免了。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;由于当时的飞行路线是朝着绝境山脉方向前进，因此她对住宅区产生的影响十分有限——除了城堡和外交大楼的窗户玻璃有部分开裂外，其他建筑基本完好。而经过炉窑区上方时，闪电已经爬升到了一定的高度，其影响进一步减小，很难再造成破坏了。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“陛下，您真是……太好了！”她仿佛瞬间恢复了所有活力，麦茜也如释重负地张开了翅膀。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;眼看着一人一鸟有扑上来的架势，罗兰连忙抬手止住了她们的行动，“不过高速飞行真的那么耗费魔力？你昨天才飞了一刻钟不到吧？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;一说到这个，闪电顿时有些不好意思道，“我也十分意外，那时候本想留下一部分魔力来做测试，但稍微试着加速了下，想看看极限在哪里，没料到魔力很快就被消耗一空，差点从天上掉下来。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“还能更快？”一旁记录的温蒂立刻抓到了关键点。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“能，”闪电自信满满道，“只要魔力足够的话——当时连耳边的风声都消失了，我甚至觉得，没有什么可以阻止我继续冲刺下去。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“麦茜呢？她当时一直蹲在你的头顶？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“咕！”还未等闪电回答，麦茜已经转起圈来，“太快，头晕，怀里咕！”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;这是在说飞得太快难受，所以被抱进了怀里么？罗兰发现自己对鸽子语的理解能力大有提升，已经能自动补全中间空白的语句了。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“只是头晕？”另一名负责能力测试的女巫爱葛莎开口道，“没有感受到气流的变化？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“唔……”闪电思索了会儿，“虽然我当时戴着防风镜，但飞到一半时，风就好像突然消失了一样。”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“你们怎么看？”罗兰望向冰女巫，“这样的分支能力，在联合会里有记录吗？”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;尽管闪电因意外耗光了大部分魔力，导致能力实测部分暂告搁置，不过如今的女巫联盟已建立起了一套系统的评估程序，加上继承了联合会的经验，即使不施展能力，通过询问和平衡魔石的检测，也能得出一个大致的判断。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;按照闪电的说法，她仅用三分钟左右便越过绝境群山、飞进了蛮荒之地，而这一段距离平时差不多需要半个小时。夜空中的那声惊雷也能印证这点——进化后的能力令她拥有了追逐声音的资格。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;关于音障的概念，罗兰倒没有多费唇舌——爱葛莎的学习能力素来是女巫中的佼佼者，稍加解释便明白了雷鸣到底是因何而起。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;虽说自然界中不乏一些生物能在短时间内达到音速，人类也在特殊情况下以血肉之躯直面过音速的挑战，但不代表这个过程可以很轻松的实现。毫无疑问，闪电丝毫不受影响的原因必然跟新觉醒的分支能力有关。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“我想应该是「魔力同调」。”爱葛莎沉吟片刻道，“这种分支能力多出现于主能力会给自身带来危险的女巫身上，因此留下的记录也不少。它通常会扩展成一个茧，将女巫包裹其中，同时令茧内的环境保持在常态下。只是维持它需要耗费极大的魔力，而且内外环境差异越大，魔力消耗速度就越高，换句话说……”<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“闪电在短时间内耗空魔力并不是因为飞行，而是分支能力的缘故？”温蒂接道。<br>\\n\" +\n" +
                        "                        \"<br>\\n\" +\n" +
                        "                        \"&nbsp;&nbsp;&nbsp;&nbsp;“没错，”爱葛莎点点头，“大多数分支能力都是为了协助主能力而诞生的，例如书卷的魔力之书，以及露西亚的色块视界——如果没有它们，主能力的效果将大打折扣，甚至会难以发挥。魔力同调也是如此，比起身受重伤，少飞一点已经是折中之选了。”<span id=\\\"endtips\\\"></span>\\n\" +\n" +
                        "                        \"<center><script type=\\\"text/javascript\\\" src=\\\"/gaogao/style3.js\\\"></script></center>\\n\" +\n" +
                        "                        \"    <div class=\\\"hr101\\\"></div>\\n\" +\n" +
                        "                        \"    <div class=\\\"pageTools\\\">\\n\" +\n" +
                        "                        \"      <p>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\">\\n\" +\n" +
                        "                        \"<!--\\n\" +\n" +
                        "                        \"var str = \\\"http://www.lwtxt.net/modules/article/reader.php?aid=10785&cid=23915142\\\";\\n\" +\n" +
                        "                        \"if(str.getQuery(\\\"cid\\\"))\\n\" +\n" +
                        "                        \"{\\n\" +\n" +
                        "                        \"document.write(\\\"<a href=/html/10785_\\\"+str.getQuery(\\\"cid\\\")+\\\".html>上一章</a>\\\");上一章\\n\" +\n" +
                        "                        \"}\\n\" +\n" +
                        "                        \"else\\n\" +\n" +
                        "                        \"{\\n\" +\n" +
                        "                        \"document.write(\\\"<a href=/book/10/10785/ title='返回放开那个女巫介绍'>返回放开那个女巫介绍</a>\\\");上一章\\n\" +\n" +
                        "                        \"}\\n\" +\n" +
                        "                        \"//--> </script><a href=\\\"/html/10785_23915142.html\\\">上一章</a> \\n\" +\n" +
                        "                        \"（<font color=\\\"red\\\">←</font>）\\n\" +\n" +
                        "                        \"| <a href=\\\"/book/10/10785/\\\">返回目录</a> \\n\" +\n" +
                        "                        \"| （<font color=\\\"red\\\">→</font>）<script type=\\\"text/javascript\\\">\\n\" +\n" +
                        "                        \"<!--\\n\" +\n" +
                        "                        \"var str = \\\"http://www.lwtxt.net/modules/article/lastchapter.php?aid=10785&dynamic=1\\\";\\n\" +\n" +
                        "                        \"if(str.getQuery(\\\"cid\\\"))\\n\" +\n" +
                        "                        \"{\\n\" +\n" +
                        "                        \"document.write(\\\"<a href=/html/10785_\\\"+str.getQuery(\\\"cid\\\")+\\\".html>下一章</a>\\\");下一章\\n\" +\n" +
                        "                        \"}\\n\" +\n" +
                        "                        \"else\\n\" +\n" +
                        "                        \"{\\n\" +\n" +
                        "                        \"document.write(\\\"<a href=/book/10/10785/ title='返回放开那个女巫介绍'>已经是最后一章</a>\\\");\\n\" +\n" +
                        "                        \"}\\n\" +\n" +
                        "                        \"//--> </script><a href=\\\"/book/10/10785/\\\" title=\\\"返回放开那个女巫介绍\\\">已经是最后一章</a></p>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\" src=\\\"/gaogao/style4.js\\\"></script>\\n\" +\n" +
                        "                        \"<p></p><div class=\\\"c\\\"><a href=\\\"/modules/article/addbookcase.php?bid=10785&amp;cid=23927852\\\" rel=\\\"nofollow\\\" target=\\\"_blank\\\">先看到这(加入书签)</a> | <a href=\\\"/modules/article/uservote.php?id=10785\\\" rel=\\\"nofollow\\\" target=\\\"_blank\\\">推荐本书</a> | <a href=\\\"/newmessage.php?tosys=1&amp;title=放开那个女巫这本书的第一千零一十七章 分支能力章节出错啦!|更新慢啦!&amp;content=错误章节：第一千零一十七章 分支能力 ++++ 举报原因如下（请您告诉我们哪本书更新慢了或者哪个章节错了！）： \\\" target=\\\"_blank\\\" style=\\\"color:red\\\">点此报错/更新慢了</a> | <a href=\\\"#\\\">返回顶部</a><p></p><p></p>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\" src=\\\"/gaogao/style5.js\\\"></script>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\" src=\\\"/gaogao/styletan.js\\\"></script>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\" src=\\\"/gaogao/stylefumeiti.js\\\"></script>\\n\" +\n" +
                        "                        \"<div class=\\\"hr10\\\"></div>\\n\" +\n" +
                        "                        \"  <div class=\\\"footer\\\">\\n\" +\n" +
                        "                        \"    <p>乐文小说网-无弹窗，无广告,更新快!本站提供各位热门好看玄幻小说,言情小说,穿越小说,武侠小说, 历史小说,军事小说,网游小说,以及各类TXT小说下载<br>由于所有小说均为网友上传及来自于网络，如侵犯了您的权益，请通知我们，我们会及时处理！<br>\\n\" +\n" +
                        "                        \"Copyright © 2012-2018 <a href=\\\"/\\\">乐文小说网</a>All Rights Reserved.<br>\\n\" +\n" +
                        "                        \"    </p>\\n\" +\n" +
                        "                        \"   <script type=\\\"text/javascript\\\" src=\\\"/gaogao/tongji.js\\\"></script><script src=\\\"http://s95.cnzz.com/stat.php?id=1258564487&amp;web_id=1258564487\\\" language=\\\"JavaScript\\\"></script><script src=\\\"http://c.cnzz.com/core.php?web_id=1258564487&amp;t=z\\\" charset=\\\"utf-8\\\" type=\\\"text/javascript\\\"></script><a href=\\\"http://www.cnzz.com/stat/website.php?web_id=1258564487\\\" target=\\\"_blank\\\" title=\\\"站长统计\\\">站长统计</a>\\n\" +\n" +
                        "                        \"<script type=\\\"text/javascript\\\" src=\\\"http://www.lwtxt.net/style/js/gb.js\\\"></script></div>\\n\" +\n" +
                        "                        \"</div>\\n\" +\n" +
                        "                        \"\\n\" +\n" +
                        "                        \"</div></div>", Charsets.UTF_8)
                .hash();

        System.out.println((System.currentTimeMillis() - startTime) );
    }
}
