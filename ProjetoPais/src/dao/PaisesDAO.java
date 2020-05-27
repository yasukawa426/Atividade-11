package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Paises;

public class PaisesDAO {
	public int criar(Paises pais) {
		String sqlInsert = "INSERT INTO paises(Nome, Populacao, Area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getId();
	}
	

	
	public void atualizar(Paises pais) {
		String sqlUpdate = "UPDATE paises SET Nome=?, Populacao=?, Area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM paises WHERE id= ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Paises carregar(int id) {
		Paises pais = new Paises();
		pais.setId(id);
		String sqlSelect = "SELECT Nome, Populacao, Area FROM paises WHERE paises.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setNome(rs.getString("Nome"));
					pais.setPopulacao(rs.getLong("Populacao"));
					pais.setArea(rs.getDouble("Area"));					
				} else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}
	public Paises maiorPopulacao() {
		Paises pais= new Paises();
		String sqlSelect = "SELECT * FROM paises WHERE Populacao = (select max(Populacao) from paises)";
		// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							pais.setId(rs.getInt("id"));
							pais.setNome(rs.getString("Nome"));
							pais.setPopulacao(rs.getLong("Populacao"));
							pais.setArea(rs.getDouble("Area"));					
						} else {
							pais.setId(-1);
							pais.setNome(null);
							pais.setPopulacao(-1);
							pais.setArea(-1);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return pais;
	}
	public Paises menorArea() {
		Paises pais= new Paises();
		String sqlSelect = "SELECT * FROM paises WHERE Area = (select min(Area) from paises)";
		// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							pais.setId(rs.getInt("id"));
							pais.setNome(rs.getString("Nome"));
							pais.setPopulacao(rs.getLong("Populacao"));
							pais.setArea(rs.getDouble("Area"));					
						} else {
							pais.setId(-1);
							pais.setNome(null);
							pais.setPopulacao(-1);
							pais.setArea(-1);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return pais;
	}
	public Paises[] vetorPaises() {
		Paises[] paises =  new Paises[3];
		
		for(int idPais=1;idPais<=3;idPais++){	
			paises[idPais-1]=carregar(idPais);
		}
		return paises;
		
		
	}
	public List <Paises> listar(){
		String sql = "SELECT * FROM paises";
		List <Paises> paises = new ArrayList <>();
		//try with resources(Java 7). Com ele n precisa do finnaly, fechando a conexao e soltando recuso automaticamente.
		try (Connection conn = ConnectionFactory.obtemConexao(); 
				PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();) {
			while (rs.next())/*executa sempre q tenha outro cliente*/ {
				Paises pais = new Paises ();
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("Nome"));
				pais.setPopulacao(rs.getLong("Populacao"));
				pais.setArea(rs.getDouble("Area"));		
				paises.add(pais);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return paises;
		
	}
}
