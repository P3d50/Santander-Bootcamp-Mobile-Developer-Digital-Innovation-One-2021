programa
{

	cadeia vendedor
	real vendaJaneiro, vendaFevereiro, vendaMarco, vendaAbril, media,total
		
	funcao inicio()
	{
		escreva("Digite o nome do vendedor: ")
		leia(vendedor)
		escreva("Digite o total de vendas de Janeiro: ")
		leia(vendaJaneiro)
		escreva("Digite o total de vendas de Fevereiro: ")
		leia(vendaFevereiro)
		escreva("Digite o total de vendas de Marco: ")
		leia(vendaMarco)
		escreva("Digite o total de vendas de Abril: ")
		leia(vendaAbril)
		total = vendaJaneiro+vendaFevereiro+vendaMarco+vendaAbril
		media = total/4

		
		
		escreva("Vendedor: "+vendedor+"\n"
		+"Total de vendas em R$: "+total+"\n"
		+"Média de vendas no período: "+media)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 170; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */