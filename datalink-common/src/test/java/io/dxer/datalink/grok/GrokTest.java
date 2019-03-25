package io.dxer.datalink.grok;

import org.junit.Test;

public class GrokTest {

    Grok grok = new Grok();

    @Test
    public void test() {
        grok.addPattern("TEST", "\\d+");
        grok.compile(";%{TEST:a};%{TEST:b}");
        MatchResult result = grok.match(";123456;223456");
        assert (result.getCapture().size() == 2);
        assert (result.getCapture().get("a").equals("123456"));
        assert result.getCapture().get("b").equals("223456");
    }

    @Test
    public void test1() {
        String str = "2019-03-18 00:00:02\t[INFO]\t{\"id\":\"201903152337561762476640518225508\",\"adslot\":{\"id\":\"A1000000112\",\"w\":480,\"h\":320},\"app\":{\"id\":\"10002\",\"bundle\":\"com.baidu.yuedu\",\"version\":\"5.9.9.1\"},\"device\":{\"ua\":\"Mozilla%2F5.0+%28Linux%3B+Android+6.0.1%3B+OPPO+R9sk+Build%2FMMB29M%3B+wv%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Version%2F4.0+Chrome%2F55.0.2883.91+Mobile+Safari%2F537.36+YUEDU-NA_1080_1920_6.0.1_5.9.9.1_OPPO+R9sk\",\"geo\":{\"type\":\"1\"},\"ip\":\"43.242.152.216\",\"devicetype\":\"2\",\"make\":\"OPPO\",\"model\":\"OPPO%20R9sk\",\"os\":\"Android\",\"osv\":\"6.0.1\",\"h\":1080,\"w\":1920,\"connectiontype\":\"4\",\"carrier\":\"1\",\"did\":\"863182036537274\",\"didmd5\":\"951425bce8de6af2d31edea7bb213e04\",\"dpid\":\"a1ce6b885e4b852d\",\"dpidmd5\":\"1c8c61f1d3da673015db29b118d525de\"},\"user\":{\"id\":\"cMoHFPij\"}}";
        grok.compile("%{GREEDYDATA:a}%{SPACE}\\[INFO\\]%{SPACE}%{GREEDYDATA:b}");

        MatchResult result = grok.match(str);
        assert result.getCapture().size() == 2;
        assert result.getCapture().get("a").equals("2019-03-18 00:00:02\t");
    }

    @Test
    public void test2(){
        grok.addPattern("TEST", ".*");
        grok.addPattern("Num", "\\d+");

        String str = "zhangsan;12";
        grok.compile("%{TEST:a};%{Num:b}");

        MatchResult result = grok.match(str);
        result.printResults();
    }

}
