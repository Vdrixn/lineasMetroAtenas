package lineasMetroAtenas;

public class estaciones {
	public final String estacion;
	public double gValor;
	public final double hValorMin;
	public double fValor = 0;
	public trayecto[] adjacencies;
	public estaciones parent;
	public int linea;
	public int CoorX, CoorY;
	
	public estaciones (String nombreEstacion, int linea, double hMin, int CoorX, int CoorY){
		estacion = nombreEstacion;
		this.linea = linea;
		hValorMin = hMin;
		this.CoorX = CoorX;
		this.CoorY = CoorY;
	}

	public String getEstacion(){
		return this.estacion;
	}

	public double getDistancia(){
		return this.hValorMin;
	}
	
	public int getLinea(){
		return this.linea;
	}
	
	public int getCoorX(){
		return  this.CoorX;
	}
	
	public int getCoorY(){
		return  this.CoorY;
	}
}
