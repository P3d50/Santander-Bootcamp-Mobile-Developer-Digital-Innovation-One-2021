programa
{

	real nota1,nota2,nota3,nota4,media
	cadeia nomeDoAluno
	funcao inicio()
	{
		escreva("Digite o nome do aluno: ")
		leia(nomeDoAluno)
		escreva("Digite a nota1: ")
		leia(nota1)
		escreva("Digite a nota2: ")
		leia(nota2)
		escreva("Digite a nota3: ")
		leia(nota3)
		escreva("Digite a nota4: ")
		leia(nota4)
		media=(nota1+nota2+nota3+nota4)/4

		se(media>=7){
			escreva("Aluno  "+nomeDoAluno+" aprovado com média "+media)	
		}senao{
			escreva("Aluno  "+nomeDoAluno+" reprovado com média "+media)	
		}
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 123; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */