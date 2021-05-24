package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {

    public LeiloesPage(WebDriver browser) {
        super(browser);
    }

    public CadastroLeilaoPage carregarFormulario() {
        browser.navigate().to("http://localhost:8080/leiloes/new");
        return new CadastroLeilaoPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String dataAbertura) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorinicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)  && colunaDataAbertura.getText().equals(dataAbertura) && colunaValorinicial.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals("http://localhost:8080/leiloes");
    }
}
