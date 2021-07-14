programa
{
	
	funcao inicio()
	{
		inteiro fatorContador, fatorEscolhido, limite, produto
		fatorContador =0
		fatorEscolhido=7
		limite = 10
		escreva("Digite o número que será multiplicado: ")
		leia(fatorEscolhido)
		faca{
			produto = fatorContador*fatorEscolhido
			escreva(fatorEscolhido+"x"+fatorContador+"="+produto+"\n")
			fatorContador++
		}enquanto(fatorContador<=limite)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 222; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */