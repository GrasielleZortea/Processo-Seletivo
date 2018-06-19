package Teste;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.ConteudoPages;
import pageObject.LoginPages;

public class ConteudoTest {
	static WebDriver navegador;
	static LoginPages LoginPages;
	static pageObject.ConteudoPages ConteudoPages;

	@Before
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		LoginPages = new LoginPages(navegador);
		LoginPages.LoginComSucesso();
		ConteudoPages = new ConteudoPages(navegador);
	}

	@After
	public void tearDown() throws Exception {
		navegador.quit();
	}

	@Test
	public void testConteudoEditar() throws InterruptedException {
		ConteudoPages.EditarConteudo();
	}

	@Test
	public void testConteudoExcluir() throws InterruptedException, AWTException {
		ConteudoPages.ExcluirConteudo();
	}

}
