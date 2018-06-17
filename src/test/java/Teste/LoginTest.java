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
	static WebDriver navegador;
	static LoginPages LoginPages;
	static pageObject.EnviarVideoPages EnviarVideoPages;
	static pageObject.ConteudoPages ConteudoPages;
	static pageObject.CampanhaPages CampanhaPages;
	

	@Before
	public void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cmarg\\eclipse\\java-oxygen\\eclipse\\plugins\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		LoginPages = new LoginPages(navegador);
		EnviarVideoPages = new EnviarVideoPages(navegador);
		ConteudoPages = new ConteudoPages(navegador);
		CampanhaPages = new pageObject.CampanhaPages(navegador);
		}

	@After

	public void tearDown() throws Exception {
		navegador.quit();
	}

	@Test
	public void testFazerLogin() {
	//LoginPages.PreencherCamposSemSucesso();
	}
	
	@Test
	public void testFazerLoginInvalido() {
	//LoginPages.PreencherCamposSucesso();
}
	@Test
	public void testEnviarVideo() {
	//EnviarVideoPages.UploadoSucesso();
}
	@Test
	public void testConteudo() {
	//ConteudoPages.EditarConteudo();
	//ConteudoPages.ExcluirConteudo();
}
	@Test
	public void testCampanha() {
	CampanhaPages.CriarCampanha();
	}
	
}
