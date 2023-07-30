package logica;

public class Conversor {
	
	private Objeto convertirDe;               // recibe dos atributos de tipo Elemento que serán la unidad de partida y la unidad final
    private Objeto convertirA;
    private double cantidad;

	public Conversor(Objeto convertirDe, Objeto convertirA, double cantidad) {
		this.convertirDe = convertirDe;
        this.convertirA = convertirA;
        this.cantidad = cantidad;
	}

	public Object convertir() {
		return convertirAValorReferencia() * convertirA.getValor();
	}

	private double convertirAValorReferencia() {
		return cantidad/convertirDe.getValor();
	}

}
