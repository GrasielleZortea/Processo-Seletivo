package Teste;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.CampanhaPages;
import pageObject.LoginPages;

public class CampanhaTest {
	static WebDriver navegador;
	static LoginPages LoginPages;
	static CampanhaPages CampanhaPage;

	@Before
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		LoginPages = new LoginPages(navegador);
		LoginPages.LoginComSucesso();
		CampanhaPage = new CampanhaPages(navegador);
	}

	@After
	public void tearDown() throws Exception {
		navegador.quit();
	}

	@Test
	public void testCampanha() throws AWTException, InterruptedException {
		CampanhaPage.CriarCampanha();
	}

	@Test
	public void testValidarCamposSemLimite() {
		CampanhaPage.ValidarCampoSemLimite();
	}

}
