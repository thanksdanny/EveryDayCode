package demo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.node.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupDemo {
	public static void main(String[] args) {
		String url = "http://www.oschina.net/news/list";
		Document document = Jsoup.conect(url)
								 .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
								 .get();

		Elements elements = document.select("#RecentNewsList .List > li");
		for (Element element : elements) {
			Elements titleElement = element.select(h2 a);
			String title = titleElement.text();
			String link = titleElement.attr("href").trim();

			Elements dataElement = element.select(".date");
			Elements autherElement = dataElement.select("a");
			String auther = autherElement.text();
			autherElement.remove();
			String date = dataElement.text();
			String detail = element.select(".detail").text();

			System.out.println("链接：    " + "http://www.oschina.net" + link);
			System.out.println("标题：    " + title);
			System.out.println("作者：    " + auther);
			System.out.println("发布时间： " + date);
			System.out.println("详细信息： " + detail);
			System.out.println();
			System.out.println();
		}							 

	}
}