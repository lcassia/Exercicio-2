import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private String url = "jdbc:postgresql://localhost:5432/biblioteca";
    private String user = "ti2cc";
    private String password = "ti@cc";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Livro> listarTodos() {
    	 
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livro";
        
        try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery()) {
        
	        while (rs.next()) {
	            Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano_publicacao"), rs.getBoolean("disponivel"));
	            livros.add(livro);
	        }
	        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return livros;
        
    } // Fim listarTodos

    public void inserir(Livro livro) {
    	
        String sql = "INSERT INTO livro(titulo, autor, ano_publicacao, disponivel) VALUES(?,?,?,?)";
        
        try (Connection conn = this.connect();
        		
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
        	pstmt.setString(1, livro.getTitulo());
			pstmt.setString(2, livro.getAutor());
			pstmt.setInt(3, livro.getAnoPublicacao());
			pstmt.setBoolean(4, livro.isDisponivel());
			
			pstmt.executeUpdate();
			
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    } // Fim inserir

    public void atualizar(Livro livro) {
    	
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ?, disponivel = ? WHERE id = ?";
        
        try (Connection conn = this.connect();
        		
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAnoPublicacao());
            pstmt.setBoolean(4, livro.isDisponivel());
            pstmt.setInt(5, livro.getId());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    } // Fim atualizar

    public void deletar(int id) {
    	
        String sql = "DELETE FROM livro WHERE id = ?";
        
        try (Connection conn = this.connect();
            
        	PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    } // Fim deletar
    
} // Fim DAO