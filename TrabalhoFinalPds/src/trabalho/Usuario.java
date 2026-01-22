package trabalho;

public class Usuario {
	private String usuario;
	private String senha;
	private String msg;
	
	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		this.msg = "Bem vindo(a)";
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getMsg() {
		return msg;
	}
}