package io.dxer.datalink.grok;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linghf
 * @create 2017-09-26 15:37
 **/
public class GrokDic {

    private static Map<String, String> patterns = new HashMap<String, String>();
    private static List<String> defaultFileList = Lists.newArrayList();

    static {
        defaultFileList.add("/patterns/aws");
        defaultFileList.add("/patterns/bacula");
        defaultFileList.add("/patterns/bind");
        defaultFileList.add("/patterns/bro");
        defaultFileList.add("/patterns/exim");
        defaultFileList.add("/patterns/firewalls");
        defaultFileList.add("/patterns/grok-patterns");
        defaultFileList.add("/patterns/haproxy");
        defaultFileList.add("/patterns/httpd");
        defaultFileList.add("/patterns/java");
        defaultFileList.add("/patterns/junos");
        defaultFileList.add("/patterns/linux-syslog");
        defaultFileList.add("/patterns/maven");
        defaultFileList.add("/patterns/mcollective");
        defaultFileList.add("/patterns/mcollective-patterns");
        defaultFileList.add("/patterns/mongodb");
        defaultFileList.add("/patterns/nagios");
        defaultFileList.add("/patterns/postgresql");
        defaultFileList.add("/patterns/rails");
        defaultFileList.add("/patterns/redis");
        defaultFileList.add("/patterns/ruby");
        defaultFileList.add("/patterns/squid");


        for (String filePath : defaultFileList) {
            try {
                InputStream istream = GrokDic.class.getClassLoader().getResourceAsStream(filePath);

                if (istream == null) {
                    istream = GrokDic.class.getResourceAsStream(filePath);
                }
                loadDefaultPatterns(new InputStreamReader(istream, "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected static void loadDefaultPatterns(Reader reader) throws Exception {
        for (String line : CharStreams.readLines(reader)) {
            if (!Strings.isNullOrEmpty(line) && line.trim().startsWith("#")) {
                continue;
            }

            String[] strs = line.split(" ", 2);
            if (null == strs || strs.length < 2) {
                continue;
            } else if (!Strings.isNullOrEmpty(strs[0].trim()) && !Strings.isNullOrEmpty(strs[1].trim())) {
                String key = strs[0].trim();
                String regex = strs[1].trim();
                patterns.put(key, regex);
            }
        }
    }

    public static Map<String, String> getPatterns() {
        return patterns;
    }

    public static void setPatterns(Map<String, String> patterns) {
        GrokDic.patterns = patterns;
    }


    public static void addPattern(String key, String regex) {
        patterns.put(key, regex);
    }


}
