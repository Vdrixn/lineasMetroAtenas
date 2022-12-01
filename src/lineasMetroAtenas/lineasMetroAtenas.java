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
	
	public static ArrayList<Estacion> listaEstaciones = new ArrayList<Estacion>();

	public static Estacion[] listaEstaciones() {
		Estacion[] res=new Estacion[84];
		File f=new File("Estaciones.txt");					// ESTE FICHERO TENDRIA INFORMACION ESTILO "Estacion1;2 /n Estacion2;1 /n Estacion3;0" 
		try {												//SI TIENE 0 EN LINEA ES QUE TIENE MAS DE UNA LINEA
			Scanner sc=new Scanner(f);
			int i=0;
			while (sc.hasNextLine()) {
		        String data = sc.nextLine();
		        String[] frase=data.split(";");
		        res[i]=new Estacion(frase[0], Integer.parseInt(frase[1]), 0, Integer.parseInt(frase[2]), Integer.parseInt(frase[1]));
		    }
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public static Recorrido ProcesaPeticion(String EstacionOrigen, String EstacionDestino) {
		
		return null;
	}

   public static void algoritmoAEstrella(Estacion EstacionInicio, Estacion EstacionDestino) {
	   
   }
   
   //Funcion auxiliar que devuelve el vertice al recibir la lista de vertices y el valor que se busca
   public static Vertex<Estacion> get(Iterable<Vertex<Estacion>> vertices, String element){
	   Iterator<Vertex<Estacion>> it=vertices.iterator();
	   while(it.hasNext()) {
		   Vertex<Estacion> actual=(Vertex<Estacion>) it.next();
		   if(actual.element().getEstacion()==element) {
			   return actual;
		   }
	   }
	   return null;
   }

	public static void main(String[] args) throws IOException {
		Interfaz pantalla = new Interfaz();
		pantalla.setVisible(true);
		UndirectedGraph<Estacion,Integer> g = new UndirectedAdjacencyListGraph<Estacion,Integer>();
		Estacion[] Estaciones=listaEstaciones();
		
		for(int i=0;i<Estaciones.length;i++) {
			g.insertVertex(Estaciones[i]);
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
