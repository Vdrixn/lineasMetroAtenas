package lineasMetroAtenas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import es.upm.aedlib.graph.Graph;
import es.upm.aedlib.graph.UndirectedAdjacencyListGraph;
import es.upm.aedlib.graph.UndirectedGraph;
import es.upm.aedlib.graph.Vertex;

public class lineasMetroAtenas {
	
	public static ArrayList<estaciones> listaEstaciones = new ArrayList<estaciones>();

	public static String[] listaEstaciones() {
		String[] res=new String[84];
		File f=new File("Coord.txt");
		try {
			Scanner sc=new Scanner(f);
			int i=0;
			while (sc.hasNextLine()) {
		        String data = sc.nextLine();
		        String[] frase=data.split(";");
		        res[i]=frase[0];
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public static Recorrido ProcesaPeticion(String estacionOrigen, String estacionDestino) {
		
		return null;
	}

   public static void algoritmoAEstrella(estaciones estacionInicio, estaciones estacionDestino) {
	   
   }
   
   //Funcion auxiliar que devuelve el vertice al recibir la lista de vertices y el valor que se busca
   public static Vertex<String> get(Iterable<Vertex<String>> vertices, String element){
	   Iterator it=vertices.iterator();
	   while(it.hasNext()) {
		   Vertex<String> actual=(Vertex<String>) it.next();
		   if(actual.element()==element) {
			   return actual;
		   }
	   }
	   return null;
   }

	public static void main(String[] args) throws IOException {
		Interfaz pantalla = new Interfaz();
		pantalla.setVisible(true);
		UndirectedGraph<String,Integer> g = new UndirectedAdjacencyListGraph<String,Integer>();
		String[] estaciones=listaEstaciones();
		
		for(int i=0;i<estaciones.length;i++) {
			g.insertVertex(estaciones[i]);
		}
		
		File f=new File("Adyacencias.txt");
		try(Scanner sc=new Scanner(f)){
			while(sc.hasNextLine()) {
				String linea=sc.nextLine();
				String[] data=linea.split(";");
				String adyacente1=data[0]; String adyacente2=data[1]; int distanciaReal=Integer.parseInt(data[2]);
				g.insertUndirectedEdge(  get(g.vertices(),adyacente1),   get(g.vertices(),adyacente2),    distanciaReal);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
