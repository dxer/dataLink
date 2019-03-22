package io.dxer.datalink.grok;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.regex.Matcher;

/**
 * @author linghf
 * @create 2017-09-26 15:25
 **/
public class MatchResult {

    public Map<String, String> capture = Maps.newHashMap();

    private Matcher match;

    public Map<String, String> getCapture() {
        return capture;
    }

    public void setCapture(Map<String, String> capture) {
        this.capture = capture;
    }

    public Matcher getMatch() {
        return match;
    }

    public void setMatch(Matcher match) {
        this.match = match;
    }

    public void printResults() {
        if (capture != null) {
            for (Map.Entry<String, String> entry : capture.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}
