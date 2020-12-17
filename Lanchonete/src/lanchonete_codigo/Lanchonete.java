package lanchonete_codigo;

import java.util.Scanner;

public class Lanchonete {

	public static void main(String[] args) {
		
Scanner leitor = new Scanner(System.in);
		
		// Variáveis iniciais
		int quantia_compra = 0;
		String codigo_digitado;
		boolean acabar = false;
		double total = 0;
		int qtdProdutos = 0;
		
		//Insere a quantidade de itens no estoque e define a variável qtdProdutosm, que é posteriormente utilizada por mais variáveis
		System.out.println("Para usar o programa, os dados dos produtos em estoque: ");
		System.out.println("Digite quantos produtos há em estoque: ");
		qtdProdutos = leitor.nextInt();
		
		//Demais variáveis
		String[][] itens = new String[qtdProdutos][qtdProdutos];
		double precos[] = new double[qtdProdutos];
		int quantidades[] = new int[qtdProdutos];
		int quantidade_vendida[] = new int[qtdProdutos];
		
		//Inserir o nome e o código do produto
		for(int colunas=0;colunas<itens.length;colunas++) {
			//Produto
			System.out.println("Digite o Produto: ");
			itens[colunas][0] = leitor.next();
			
			//Codigo
			System.out.println("Digite o Codigo: ");
			itens[colunas][1] = leitor.next();
			
			//Valor
			System.out.println("Digite o valor do produto digitado: ");
			precos[colunas] = leitor.nextDouble();
			
			//Quantidade
			System.out.println("Digite a quantidade do produto digitado: ");
			quantidades[colunas] = leitor.nextInt();
		}
		
		//Menu exibido ao usuário
		while(acabar == false) {
			System.out.println("ITENS   CODIGOS   PREÇOS   QUANTIDADES");
			for(int colunas=0;colunas<itens.length;colunas++) {
				for(int linhas=0;linhas<itens[0].length;linhas++) {
					if(itens[colunas][linhas] != null) {
						System.out.print(itens[colunas][linhas]+ "      ");
					}
				}
			System.out.print(precos[colunas] + "        ");
			System.out.println(quantidades[colunas] + "  ");
			System.out.println(" ");
			}
			
			//Pede o codigo do produto que será comprado
			System.out.println("Digite o código do item que você deseja comprar: ");
			codigo_digitado = leitor.next();
			if(codigo_digitado.equalsIgnoreCase("CP3O")) {
				acabar = true;
			}
			
			//coleta as informações sobre a compra
			 for(int colunas=0;colunas<itens.length;colunas++) {
					for(int linhas=0;linhas<itens[0].length;linhas++) {
						if(codigo_digitado.equals(itens[colunas][linhas])) {
							System.out.println("Digite a quantidade que você deseja comprar: ");
							quantia_compra = leitor.nextInt();
							if(quantia_compra <= quantidades[colunas]) {
								System.out.println("Compra realizada, adicionando o produto à esteira. O valor da compra é de: "+ precos[colunas]*quantia_compra);
								quantidade_vendida[colunas] = quantidade_vendida[colunas] + quantia_compra;
								quantidades[colunas] = quantidades[colunas] - quantia_compra;
								total = total + precos[colunas]*quantia_compra;
							}else {
								System.out.println("------- QUANTIDADE INDISPONIVEL -------");
							}	
						}
					}
			 }
		}
		
		//Relatorio final dos itens da lanchonete.
		System.out.println(" ");
		System.out.println("O PROGRAMA FOI ENCERRADO!");
		System.out.println("    ---------- RELATORIO -----------    ");
		System.out.println("ITENS   CODIGO   PREÇO   QTDE VENDIDA   QTDE RESTANTE");
		for(int colunas=0;colunas<itens.length;colunas++) {
			for(int linhas=0;linhas<itens[0].length;linhas++) {
				if(itens[colunas][linhas] != null) {
					System.out.print(itens[colunas][linhas]+ "      ");	
				}
			}
	
		//Imprime o total obtido no dia
		System.out.print(precos[colunas] + "           ");		
		System.out.print(quantidade_vendida[colunas]+ "         ");
		System.out.print(quantidades[colunas] + "     ");
		System.out.println(" ");
		}
		System.out.println("O Total obtido no dia foi de: "+ total );
	}
	
}
