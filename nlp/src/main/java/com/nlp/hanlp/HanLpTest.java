package com.nlp.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NotionalTokenizer;

import java.util.List;

/**
 * Created by mengtian on 2017/11/13
 */
public class HanLpTest {
    public static void main(String[] args) {
        String content = "东汉末期，汉廷因黄巾之乱而授权地方平乱，使得地方势力崛起。董卓乱政并与关东诸势力对抗后迁都长安，使得朝廷威信丧失，诸势力割据混战。其中曹操拥护逃回洛阳的汉献帝，迁都许昌。他击败多股势力，最后在200年的官渡之战击败北方最大势力袁绍，大致掌控中国北方。曹操以优势兵力南征荆州，但在208年冬天的赤壁之战被孙权和刘备联军击败，形成三国鼎立的雏型。220年曹操病逝，其子曹丕迫汉献帝禅让称帝，国号“魏”，史称曹魏，至此东汉灭亡，正式进入三国时期。隔年以益州为主的刘备也以汉室宗亲的身份称帝，国号续为“汉”，史称蜀汉。刘备与孙权在赤壁之战后积极拓展势力，为了荆州问题多次发生纠纷与战争，最后刘备在夷陵之战战败，孙权获得整个荆州南部。刘备病死后，辅佐其子刘禅的诸葛亮于同年再与孙权恢复同盟。据有扬州、荆州及交州等地的孙权迟至229年正式称帝，国号“吴”，史称孙吴[8]。此后三国局势主要为蜀吴同盟对抗曹魏，各国疆域变化不大。而曹魏朝廷渐渐的被司马氏掌控。263年司马昭为建立军功准备篡位，出兵伐蜀，蜀汉亡。两年后司马昭病死，其子司马炎废魏元帝自立，国号为“晋”，史称西晋，曹魏亡。西晋最后于280年发起晋灭吴之战，灭亡孙吴，统一中国。至此三国时期结束，进入晋朝[9]";

        System.out.println(HanLP.segment(content));
        System.out.println(NotionalTokenizer.segment(content));
        List<Term> terms = NotionalTokenizer.segment(content);
        System.out.println(terms);

        //关键词
        List<String> keyWord = HanLP.extractKeyword(content, 5);
        System.out.println(keyWord);

        //摘要
        List<String> summary = HanLP.extractSummary(content, 3);
        System.out.println(summary);

        //短语
        List<String> phrase = HanLP.extractPhrase(content, 3);
        System.out.println(phrase);
    }
}
