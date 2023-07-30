package logica;

public class Objeto {
	private final String objetoDe;
    private final String objetoA;
    private double valor;
    
    public Objeto(String objetoDe, String objetoA, double valor){
        this.objetoDe = objetoDe;
        this.objetoA = objetoA;
        this.valor = valor;
    }
    
    public String getObjetoDe(){
        return this.objetoDe;
    }
    
    public String getObjetoA(){
        return this.objetoA;
    }

    public double getValor() {
        return valor;
    }
	

}
