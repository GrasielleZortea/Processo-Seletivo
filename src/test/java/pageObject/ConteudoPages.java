package pageObject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConteudoPages {

	 WebDriver navegador;
	 By conteudo = By.id("mn-content");
	 By item = By.className("edit-media-link");
	 By titulo = By.xpath("//*[@id=\"media-meta-form\"]/div[1]/input");
	 By descricao = By.id("description");
	 By gravar = By.name("save");
	 By selecionar = By.id("check-all");
	 By acao = By.id("bash-action");
	 By excluir = By.xpath("//*[@id=\"bash-action\"]/option[8]");
	 By confirmaExcluir = By.xpath("//*[@id=\"modalContainer\"]/div/div[3]/button");
	 By enviar = By.id("mn-upload");
	 private String descricaoTexto="Lorem ipsum ligula vestibulum potenti enim et quam, commodo ornare aaaaaptent asasassodales nunc maecenas consectetur, platea feugiat hac diam curae conubia. sed tincidunt sem quam phasellus hac conubia praesent scelerisque, velit magna convallis donec mattis risus tellus, accumsan integer class sit class eu aptent. ad tincidunt varius a facilisis ultrices elit senectus curae egestas ante ornare nec, tellus suspendisse cubilia quis sapien taciti curabitur commodo integer dapibus neque dapibus a, urna sagittis eleifend mauris per mollis donec vehicula class tincidunt luctus. ornare potenti senectus eu dolor placerat at, curabitur litora id proin dui torquent praesent, consequat cubilia etiam ullamcorper curabitur.as velit nisi potenti est, malesuada enim cubilia enim orci curabitur morbi risus et est, dictum dui nec fames felis egestas molestie venenatis. vulputate enim dictumst a nostra at varius viverra ultrices ipsum tincidunt, inceptos ante fringilla etiam nostra rutrum lacus lobortis lu";
	 	
	public ConteudoPages(WebDriver navegador) {

		this.navegador = navegador;
	}

	public void EditarConteudo() {
		//Editar o Conteudo para testar a melhoria de limite de campo		

		
		navegador.findElement(conteudo).click();
		navegador.findElement(item).click();
		navegador.findElement(titulo).clear();
		navegador.findElement(titulo).sendKeys("01");
		navegador.findElement(descricao).clear();
		navegador.findElement(descricao).sendKeys(
				descricaoTexto);
		navegador.findElement(gravar).click();
		assertEquals("01 foi editado com sucesso!", 
				navegador.findElement(By.className("alert alert-success hide")).getText());
			}

	public void ExcluirConteudo() {
    //Automacao do bug Excluir conteudo e o mesmo permanecer no Enviar
		navegador.findElement(conteudo).click();
		navegador.findElement(selecionar).click();
		navegador.findElement(acao).click();
		navegador.findElement(excluir).click();
		navegador.findElement(confirmaExcluir).click();
		navegador.findElement(enviar).click();
		String ArqExc = navegador.findElement(By.className("edit-media")).getText();
		assertEquals("Editar informações", ArqExc);		
	}

}
