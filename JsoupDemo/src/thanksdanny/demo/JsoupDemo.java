package thanksdanny.demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by thanksdanny on 05/01/2017.
 */
public class JsoupDemo {

    public static void mian(String[] args) throws IOException {
        String url = "http://www.oschina.net/news/list";
        Document document  = Jsoup.connect(url)
                                  .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
                                  .get();

        Elements elements = document.select("#RecentNewsList .List > li");
        // #为id选择器  .为class选择器 >只能选择子标签， 注意空格隔开

        for (Element element : elements) {
            Elements titleElement = element.select("h2 a");
            String title = titleElement.text();
            String link = titleElement.attr("href").trim();
            // .attr() : Set an attribute on all matched elements.
            // .trim() : Returns a string whose value is this string, with any leading and trailing whitespace removed.

            Elements dataElement = element.select(".data");
            Elements autherElement = dataElement.select("a");

            String auther = autherElement.text();
            autherElement.remove(); // Remove each matched element from the DOM.

            String date = dataElement.text();
            String detail = element.select(".detail").text();

            System.out.println("链接：        " + "http://www.oschina.net"+link);
            System.out.println("标题：        " + title);
            System.out.println("作者：        " + auther);
            System.out.println("发布时间： " + date);
            System.out.println("详细信息： " + detail);
            System.out.println();
            System.out.println();
        }
    }
}
