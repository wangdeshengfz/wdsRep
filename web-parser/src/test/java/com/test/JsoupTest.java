package com.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
/*        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p><div id='333'>王德胜</div></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.getElementsMatchingText(pattern));*/
        Document doc = Jsoup.connect("http://shenbai.iteye.com/blog/1985844").get();
        System.out.println(doc.html());
    }

}
