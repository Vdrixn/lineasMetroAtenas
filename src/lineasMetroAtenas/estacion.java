package lineasMetroAtenas;

public class estacion{
	public final String estacion;
	public double gValor;
	public double hValorMin;
	public double fValor = 0;
	public estacion parent;
	public int linea;
	public int CoorX, CoorY;
	
	public estacion (String nombreEstacion, int linea, double hMin, int CoorX, int CoorY){
		estacion = nombreEstacion;
		this.linea = linea;
		hValorMin = hMin;
		this.CoorX = CoorX;
		this.CoorY = CoorY;
	}

	public void sethMin(double hMin){
		hValorMin = hMin;
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
