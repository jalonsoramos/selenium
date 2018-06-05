package webdriver.devacademy;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverTest {

	@Test
	public void remoteHubTest() throws MalformedURLException {
		FirefoxOptions capabilities = new FirefoxOptions();
		URL hubUrl = new URL("http://localhost:4444/wd/hub");

		WebDriver webDriver = new RemoteWebDriver(hubUrl, capabilities);
		webDriver.get("http://www.google.es");

		assertEquals("Google", webDriver.getTitle());
		webDriver.quit();
	}
}
