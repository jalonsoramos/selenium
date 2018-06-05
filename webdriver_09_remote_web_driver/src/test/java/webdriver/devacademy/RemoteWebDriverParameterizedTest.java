package webdriver.devacademy;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parameterized.class)
public class RemoteWebDriverParameterizedTest {

	private MutableCapabilities browser;

	public RemoteWebDriverParameterizedTest(MutableCapabilities browser) {
		this.browser = browser;
	}

	@Parameters
	public static Collection<MutableCapabilities> getParameters() {
		return Arrays.asList(new MutableCapabilities[] { new FirefoxOptions(), new ChromeOptions() });
	}

	@Test
	public void remoteHubTest() throws MalformedURLException {
		WebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), browser);
		webDriver.get("http://www.google.es");

		assertEquals("Google", webDriver.getTitle());
		webDriver.quit();
	}
}
