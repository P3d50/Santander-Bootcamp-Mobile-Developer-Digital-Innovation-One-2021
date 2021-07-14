programa
{

	 
	
	funcao inicio()
	{
		escreva(" 1 - Netflix, 2 - Amazon Prime, 3 - HBO Go, 4 - Sair")
		inteiro opcaoSelecionada = 4
		cadeia plataforma = ""
		escreva("\n Sua opção: ")
		leia(opcaoSelecionada)
		escolha(opcaoSelecionada){
			caso 1:plataforma = "Netflix" pare
			caso 2:plataforma = "Amazon Prime" pare
			caso 3:plataforma = "HBO Go" pare
			caso 4: pare
		}
		
		escreva("\nAbrindo "+plataforma+" Sr.Stark\n")
	}


}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 36; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */