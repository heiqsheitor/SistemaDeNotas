package trabalho;

public class AlunoNotas {
	private String nome;
	private String periodo;
	private double n1;
	private double n2;
	private double n3;
	
	public AlunoNotas(String nome, String periodo, double n1, double n2, double n3) {
	    this.nome = nome;
	    this.periodo = periodo;
	    this.n1 = n1;
	    this.n2 = n2;
	    this.n3 = n3;
	}
	
	public String getNome() {
		return nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public double getN1() {
		return n1;
	}
	public double getN2() {
		return n2;
	}
	public double getN3() {
		return n3;
	}
	
	public double calcularMedia() {
	    return (n1 + n2 + n3) / 3;
	}
	
	public String verificarSituacao() {
	    double media = calcularMedia();

	    if (media >= 6) {
	        return "Aprovado";
	    } else {
	        return "Recuperação";
	    }
	}		
}