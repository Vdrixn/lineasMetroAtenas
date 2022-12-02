package lineasMetroAtenas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import es.upm.aedlib.graph.UndirectedAdjacencyListGraph;
import es.upm.aedlib.graph.UndirectedGraph;
import es.upm.aedlib.graph.Vertex;

public class lineasMetroAtenas {

	public static ArrayList<Estacion> listaEstaciones = new ArrayList<Estacion>();

	public static Estacion[] listaEstaciones() throws FileNotFoundException, IOException {
		Estacion[] res = new Estacion[54];
		String linea;
		FileReader f = new FileReader(new File("src/lineasMetroAtenas/Data/Estaciones.txt")); 
        BufferedReader b = new BufferedReader(f);
		int i = 0;
		while((linea = b.readLine()) != null){
			String[] atributos = linea.split(";");
			res[i] = new Estacion(atributos[0], Integer.parseInt(atributos[1]), 0, Integer.parseInt(atributos[2]), Integer.parseInt(atributos[3]));
			i++;
		}
		b.close();
		return res;
	}

	public static void ordenarEstacionesAlfabeticamente(String lista[]){
		for (int i = 0; i < (lista.length - 1); i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i].compareToIgnoreCase(lista[j]) > 0) {
					String aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;

				}
			}
		}
    }
	public static String[] nombreEstaciones(Estacion[] listaEstaciones) {
		String[] estaciones = new String[54];
		for (int i = 0; i < listaEstaciones.length; i++) {
			estaciones[i] = listaEstaciones[i].getEstacion();
		}
		ordenarEstacionesAlfabeticamente(estaciones);
		return estaciones;
	}
	
	public static Recorrido ProcesaPeticion(String EstacionOrigen, String EstacionDestino) {

		return null;
	}

	public static void algoritmoAEstrella(Estacion EstacionInicio, Estacion EstacionDestino) {

	}

	// Funcion auxiliar que devuelve el vertice al recibir la lista de vertices y el
	// valor que se busca
	public static Vertex<Estacion> get(Iterable<Vertex<Estacion>> vertices, String element) {
		Iterator<Vertex<Estacion>> it = vertices.iterator();
		while (it.hasNext()) {
			Vertex<Estacion> actual = (Vertex<Estacion>) it.next();
			if (actual.element().getEstacion() == element) {
				return actual;
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		Interfaz pantalla = new Interfaz();
		pantalla.setVisible(true);
		System.out.println(listaEstaciones);
		UndirectedGraph<Estacion, Integer> g = new UndirectedAdjacencyListGraph<Estacion, Integer>();
		Estacion[] estaciones = listaEstaciones();
		for (int i = 0; i < estaciones.length; i++) {
			g.insertVertex(estaciones[i]);
		}

		FileReader f = new FileReader(new File("src/lineasMetroAtenas/Data/Adyacencias.txt")); 
		try (BufferedReader b = new BufferedReader(f);) {
			String linea;
			while ((linea = b.readLine())!=null) {
				String[] data = linea.split(";");
				String adyacente1 = data[0];
				String adyacente2 = data[1];
				int distanciaReal = Integer.parseInt(data[2]);
				g.insertUndirectedEdge(get(g.vertices(), adyacente1), get(g.vertices(), adyacente2), distanciaReal);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
