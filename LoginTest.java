package Teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	@Test
	public void testFazerLogin() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cmarg\\eclipse\\java-oxygen\\eclipse\\plugins\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		navegador.findElement(By.name("j_username")).sendKeys("avaliacao_qa_samba@sambatech.com.br");
		navegador.findElement(By.name("j_password")).sendKeys("123456789");
		navegador.findElement(By.id("login")).click();
		String autentifica = navegador.findElement(By.id("navbar-client-name")).getText();
		// Nao consegui comparar com nome do usuario
		assertEquals("Processo Seletivo", autentifica);
		navegador.quit();
	}

	@Test
	public void testFazerLoginInvalido() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cmarg\\eclipse\\java-oxygen\\eclipse\\plugins\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		navegador.get("http://web1.qa.sambatech.com:10000/auth/login?redirect=dashboard");
		navegador.findElement(By.name("j_username")).sendKeys("avaliacao_qa_samba@sambatech.com");
		navegador.findElement(By.name("j_password")).sendKeys("123456789");
		navegador.findElement(By.id("login")).click();
		navegador.findElement(By.id("password_incorrect"));
		navegador.quit();
	}

}
