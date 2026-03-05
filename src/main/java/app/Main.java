package app;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import dao.ProdutoDAO;
import dao.VendaDAO;
import model.Produto;
import model.Venda;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		VendaDAO vendaDAO = new VendaDAO();
		
		int opcao;
		
		while(true) {
			System.out.println("======== MENU =======\n1 - Cadastrar Produto\n2 - Excluir Produto\n3 - Listar Produtos\n4 - Vender\n5 - Listar Vendas\n6 - Sair");
			System.out.println("OPÇÃO: ");
			opcao = scanner.nextInt();
			
			
			
			if(opcao == 1) {
				
				System.out.println("Nome do produto: ");
				String nome = scanner.next();
				
				System.out.println("Preco: ");
				double preco = scanner.nextDouble();
				
				System.out.println("Quantidade: ");
				int quantidade = scanner.nextInt();
				
				Produto p = new Produto();
				p.setNome(nome);
				p.setPreco(preco);
				p.setQtdEstoque(quantidade);
				
				produtoDAO.inserir(p);
				
				System.out.println("Produto cadastrado com sucesso!");
				
				
			}
			
			else if(opcao == 2) {
				
				System.out.println("Digite o ID: ");
				int id = scanner.nextInt();
				
				produtoDAO.deletar(id);
				
				
			}
			
			else if(opcao == 3) {
				
				List<Produto> produto = produtoDAO.listarTodos();
				
				System.out.println("====================== ESTOQUE ===========================");
				
				for(Produto p: produto) {
					
					System.out.println("ID: " + p.getId() + " | Produto: " + p.getNome() + " | Preco: " + p.getPreco() + " | Quantidade: " + p.getQtdEstoque());
				}
				
				System.out.println("==========================================================");
				
			}
			else if (opcao == 4) {
				Venda venda = new Venda();
				venda.setData(LocalDateTime.now());
				
				System.out.println("Valor total: ");
				double valorTotal = scanner.nextDouble();
				venda.setValorTotal(valorTotal);
				
				vendaDAO.inserir(venda);
				
			}
			else if (opcao == 5) {
				
				List<Venda> venda = vendaDAO.listarTodas();
				
				for (Venda v : venda) {
					System.out.println("ID : " +v.getId()+ " | Data: " +v.getData()+ " | Valor Total: " +v.getValorTotal());
				}
				
			}
			
			else if (opcao == 6) {
				System.out.println("Programa encerrado");
				break;
			}
			else {
				System.out.println("Digite uma das opcoes acima");
				continue;
			}
		}
		
		

	}
}

