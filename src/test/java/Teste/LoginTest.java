package Teste;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pageObject.ConteudoPages;
import pageObject.EnviarVideoPages;
import pageObject.LoginPages;

public class LoginTest {
	private static WebDriver navegador;
	private static LoginPages LoginPages;
	

	@Before
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"src\\test\\java\\drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		LoginPages = new LoginPages(navegador);
		}

	@After

	public void tearDown() throws Exception {
		navegador.quit();
	}

	@Test
	public void testFazerLoginComSucesso() {
	LoginPages.LoginComSucesso();
	}
	
	@Test
	public void testFazerLoginSemSucesso() {
	LoginPages.LoginSemSucesso();
}


	
	
}
