import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        DAO dao = new DAO();

        while(true) {
        	
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar todos os livros");
            System.out.println("2 - Inserir novo livro");
            System.out.println("3 - Atualizar livro");
            System.out.println("4 - Deletar livro");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("Listando todos os livros...");
                    dao.listarTodos();
                    
                    break;
                   
                case 2:
					System.out.println("Inserir novo livro...");
					Livro novoLivro = new Livro();
					scanner.nextLine(); 
					
					System.out.print("Título: ");
					novoLivro.setTitulo(scanner.nextLine());
					System.out.print("Autor: ");
					novoLivro.setAutor(scanner.nextLine());
					System.out.print("Ano de Publicação: ");
					novoLivro.setAnoPublicacao(scanner.nextInt());
					System.out.print("Disponível (true/false): ");
					
					novoLivro.setDisponivel(scanner.nextBoolean());
					dao.inserir(novoLivro);

                	    break;
                    
                case 3:
                	System.out.println("Atualizar livro...");
                    System.out.print("Informe o ID do livro a ser atualizado: ");
                    
                    int idAtualizacao = scanner.nextInt();
                    scanner.nextLine(); 
                    Livro livroAtualizado = new Livro();
                    
                    livroAtualizado.setId(idAtualizacao); 
                    System.out.print("Título: ");
                    livroAtualizado.setTitulo(scanner.nextLine());
                    System.out.print("Autor: ");
                    livroAtualizado.setAutor(scanner.nextLine());
                    System.out.print("Ano de Publicação: ");
                    livroAtualizado.setAnoPublicacao(scanner.nextInt());
                    System.out.print("Disponível (true/false): ");
                    
                    livroAtualizado.setDisponivel(scanner.nextBoolean());
                    dao.atualizar(livroAtualizado);
                    
                    break;

                case 4:
                    System.out.println("Deletar livro...");
                    System.out.print("Informe o ID do livro a ser deletado: ");
                    
                    int idDelecao = scanner.nextInt();
                    dao.deletar(idDelecao);
                    
                    break;
                
                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;

            } // Fim switch
            
        } 
        
    } // Fim da main
    
} // Fim Principal