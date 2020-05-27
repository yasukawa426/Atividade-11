package command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crypto.CryptoAES;
import model.Usuario;
import service.UsuarioService;

public class FazerLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cEmail = request.getParameter("email");
		String cSenha = request.getParameter("senha");
		
		String sMsgCifrada = null;
		byte[] bMsgClara = cSenha.getBytes();
		byte[] bMsgCifrada = null;
		//CRiptografia
		// Imprime Texto
		System.out.println(">>> Cifrando com o algoritmo AES...");
		System.out.println("");
		// Instancia um objeto da classe CryptoAES
		CryptoAES caes = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde
		// seraÌ� armazenada
		try {
			caes.geraChave(new File("chave.simetrica"));
			// Gera a cifra AES da mensagem dada, com a chave simetrica dada
			caes.geraCifra(bMsgClara, new File("chave.simetrica")); // Recebe o
																	// texto cifrado
			bMsgCifrada = caes.getTextoCifrado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "UTF-8")); 
		
		Usuario usuario = new Usuario();
		usuario.setEmail(cEmail);
		usuario.setPassword(sMsgCifrada);
		
		UsuarioService cs = new UsuarioService();
		if(cs.validar(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou " + usuario.getEmail() + "-" +  usuario.getPassword());
		}else {
			System.out.println("Não Logou, usuario/senha incorreto " + usuario);
			throw new ServletException("Usuário/Senha inválidos");
		}
		
		response.sendRedirect("index.jsp");

	}

}
