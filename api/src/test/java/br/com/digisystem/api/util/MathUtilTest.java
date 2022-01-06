package br.com.digisystem.api.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.springframework.web.bind.annotation.InitBinder;

class MathUtilTest {
	
	private MathUtil mathUtil;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	@BeforeEach // Roda esse antes de qualquer teste
	public void init( TestInfo testInfo, TestReporter testReporter ) {
		this.mathUtil = new MathUtil();
		this.testInfo = testInfo;
		this.testReporter = testReporter;
	}

	@Test
	@DisplayName("minhaSoma") // Para mudar o nome do teste que será mostrado
	@Tag("feature/cadastrar-cliente") // Serve para quando quisermos rodar só um conjunto de testes caracterizados por essa flag
	void testarSoma() {
		
		this.testReporter.publishEntry(this.testInfo.getTags().toString()); // Para pegar informações e o relatório sobre o teste
		
		int resultado = this.mathUtil.somar(1, 2);
		int esperado = 3;
		
		assertEquals(esperado, resultado);
	}

}
