package dao;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crypto.CryptoAES;
import model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, fone, email, senha) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getFone());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getPassword());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getFone());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getPassword());
			stm.setInt(6, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario Usuario = new Usuario();
		Usuario.setId(id);
		String sqlSelect = "SELECT nome, fone, email, senha FROM Usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, Usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Usuario.setNome(rs.getString("nome"));
					Usuario.setEmail(rs.getString("email"));
					Usuario.setPassword(rs.getString("senha"));
					Usuario.setFone(rs.getString("fone"));
				} else {
					Usuario.setId(-1);
					Usuario.setNome(null);
					Usuario.setEmail(null);
					Usuario.setPassword(null);
					Usuario.setFone(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return Usuario;
	}
	
	
	
	/*
	 * public boolean validar(Usuario usuario) {
	 * 
	 * String sqlSelect = "select email, senha from usuario where email = ?"; try {
	 * CryptoAES caes = new CryptoAES(); Connection conn =
	 * ConnectionFactory.obtemConexao(); try(PreparedStatement stm =
	 * conn.prepareStatement(sqlSelect);) { stm.setString(1, usuario.getEmail());
	 * try (ResultSet rs = stm.executeQuery();){ if(rs.next()) { byte[]
	 * bMsgDecifrada = null;
	 * 
	 * String senha = rs.getString("senha"); byte[] bMsgCifrada = senha.getBytes();
	 * caes.geraDecifra(bMsgCifrada, new File("chave.simetrica")); bMsgDecifrada =
	 * caes.getTextoDecifrado(); // Converte o texto byte[] no equivalente String
	 * senha = (new String(bMsgDecifrada, "UTF-8"));
	 * if(senha.contentEquals(usuario.getPassword())) { return true; } else {
	 * System.out.
	 * println("---------------\nSenha errada\n--------------------------"); return
	 * false; } }else { System.out.
	 * println("---------------\nEmail n encontrado\n--------------------------");
	 * return false; } }catch (Exception e) { e.printStackTrace(); } }catch
	 * (SQLException e1) { System.out.println(e1.getStackTrace()); }
	 * }catch(SQLException e2) { e2.getStackTrace(); } return false; }
	 */
public boolean validar(Usuario usuario) {
	
	String sqlSelect = "select email, senha from usuario where email = ? and senha = ?";
	try {
		Connection conn = ConnectionFactory.obtemConexao();
		try(PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getPassword());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					
					return true;
				}else {
					
					return false;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
	}catch(SQLException e2) {
		e2.getStackTrace();
	}
	return false;
}
}
