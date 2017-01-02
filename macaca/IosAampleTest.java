package macaca.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import macaca.client.common.ElementSelector;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.containsString;

public class IosSampleTest {
	MacacaClient driver = new MacacaClient();

	@Before
	public void setUp() throws Exception {
		String platform = "ios";

		JSONObject porps = new JSONObject();
		porps.put("platformName", platform);
		porps.put("app", "ttps://npmcdn.com/ios-app-bootstrap@latest/build/ios-app-bootstrap.zip");
		porps.put("reuse", 1);

		porps.put("deviceName", "iPhone 6s");

		JSONObject desiredCapabilities = new JSONObject();
		desiredCapabilities.put("desiredCapabilities", porps);
		driver.initDriver(desiredCapabilities);
	}

	@Test
	public void test_case_1() throws Exception {
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();

		System.out.println("-----------#1 ligin test --------------");

		driver.elementByXPath("//XCUIElementTypeTextField[1]").sendKeys("中文+Test+12345678");
		driver.elementByXPath("//XCUIElementTypeSecureTextField[1]").sendKeys("111111");
		driver.elementByXPath("Login").click().sleep(1000);

		System.out.println("-----------#2 scroll tableview test --------------");

		driver.elementByName("HOME").click().elementByName("list").click().sleep(1000).swipe(200, 420, 200, 10, 50).sleep(5000);

		System.out.println("-----------#3 webview test --------------");

		driver.back().elementByName("webview").click().sleep(3000).saveScreenshoot(courseFile + "/webView.png");

		switchToWebView(driver).elementById("pushView").tap().sleep(5000);

		switchToWebView(driver).elementById("popView").tap().sleep(5000).saveScreenshoot(courseFile + "/baidu.png");

		String source = switchToWebView(driver).elementById("index-kw").sendKeys("中文+TesterHome").elementById("index-bn").tap().sleep(5000).source();

		Assert.assertThat(source, containsString("TesterHome"));



		System.out.println("------------#5 logout test-------------------");

		switchToNative(driver).elementByName("PERSONAL").click().sleep(1000).elementByName("Logout").click().sleep(1000);
	}

	public MacacaClient switchToWebView(MacacaClient driver) throws Exception {
		JSONArray contexts = driver.contexts;
		return driver.context(contexts.get(contexts.size()-1).toString());
	}


	public MacacaClient switchToNative(MacacaClient driver) throws Exception {
		JSONArray contexts = driver.contexts;
		return driver.context(contexts.get(contexts.size()-1).toString());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}