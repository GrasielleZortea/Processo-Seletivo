package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {

	WebDriver navegador;
	By email = By.name("j_username");
	By senha = By.name("j_password");
	By botaoLogin = By.id("login");

	public LoginPages(WebDriver navegador) {

		this.navegador = navegador;

	}

	public void LoginComSucesso() {
		// Verificacao de Login valido
		navegador.findElement(email).sendKeys("avaliacao_qa_samba@sambatech.com.br");
		navegador.findElement(senha).sendKeys("123456789");
		navegador.findElement(botaoLogin).click();
		String autentifica = navegador.findElement(By.id("navbar-client-name")).getText();
		assertEquals("Processo Seletivo", autentifica);

	}

	public void LoginSemSucesso() {
		// Verificacao de login invalido
		navegador.findElement(email).sendKeys("avaliacao_qa_samba@sambatech.com");
		navegador.findElement(senha).sendKeys("123456789");
		navegador.findElement(botaoLogin).click();
		navegador.findElement(By.id("password_incorrect"));

	}
}
