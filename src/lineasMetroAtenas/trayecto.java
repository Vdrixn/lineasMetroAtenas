package lineasMetroAtenas;

public class trayecto {
	public final double coste;
	public final estaciones destino;
	// Linea 1 verde: 0 , linea 2 roja: 1 , linea 3 verde: 2
	public int linea;

	public trayecto(estaciones estacionDestino, double peso, int linea){
		destino = estacionDestino;
		coste = peso;
		this.linea = linea;
	}	
	
	public double getPeso(){
		return coste;
	}
	
	public int getLinea(){
		return linea;
	}
}
