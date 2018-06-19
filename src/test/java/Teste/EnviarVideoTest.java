package Teste;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.EnviarVideoPages;
import pageObject.LoginPages;

public class EnviarVideoTest {
	static WebDriver navegador;
	static LoginPages LoginPages;
	static EnviarVideoPages enviarVideosPage;

	@Before
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		LoginPages = new LoginPages(navegador);
		LoginPages.LoginComSucesso();
		enviarVideosPage = new EnviarVideoPages(navegador);
	}

	@After
	public void tearDown() throws Exception {
		navegador.quit();
	}

	@Test
	public void testEnviarVideo() throws AWTException, InterruptedException {
		enviarVideosPage.UploadoSucesso();
	}

}
