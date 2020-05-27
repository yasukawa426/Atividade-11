package command;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crypto.CryptoAES;
import model.Usuario;
import service.UsuarioService;

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cNome = request.getParameter("nome");
		String cEmail = request.getParameter("email");
		String cSenha = request.getParameter("senha");	
		String cFone = request.getParameter("fone");
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
		
		System.out.println("Mensagem Decifrada (Hexadecimal):");
        //instanciar o javabean
        Usuario usuario = new Usuario();
        usuario.setNome(cNome);
        usuario.setEmail(cEmail);
        usuario.setPassword(sMsgCifrada);
        usuario.setFone(cFone);
                
        //instanciar o service
        UsuarioService cs = new UsuarioService();
        
        cs.criar(usuario);
        
        request.getRequestDispatcher("Login.jsp").
		forward(request, response);
        
	}

}
