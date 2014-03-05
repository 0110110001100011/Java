package java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 8
 */
public class ClaseAdministradora {
	private Hashtable<Integer, Materia> materias;
	private int idUnico = 1;

	public ClaseAdministradora() {
		materias = new Hashtable<Integer, Materia>();
	}

	public static void main(String[] args) {
		ClaseAdministradora ca = new ClaseAdministradora();
		ca.agrega(" CC317", "Compiladores");
		ca.agrega(" CC318", "Taller de Compiladores");
		ca.agrega(" CC319", "Sistemas Operativos Avanzados");
		ca.agrega(" CC320", "Taller de Sistemas Operativos Avanzados");
		while (true) {
			System.out.println("1.- registro de una materia"
					+ "\n2.- eliminar una materia"
					+ "\n3.- obtener los datos de una materia"
					+ "\n4.- imprimir materias" + "\n5.- salir.");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String opcion;
			try {
				opcion = br.readLine();
				switch (opcion) {
				case "1":
					System.out.println("Clave de la materia");
					String clave = br.readLine();
					System.out.println("Nombre de la materia");
					String nombre = br.readLine();
					ca.agrega(clave, nombre);
					break;
				case "2":
					System.out.println("Id de la materia a borrar");
					String id = br.readLine();
					try {
						ca.elimina(Integer.parseInt(id));
					} catch (NumberFormatException nfe) {
						System.out.println(id + " no es un numero!");
					}
					break;
				case "3":
					System.out.println("Id de la materia a buscar");
					String id2 = br.readLine();
					try {
						ca.busca(Integer.parseInt(id2));
					} catch (NumberFormatException nfe) {
						System.out.println(id2 + " no es un numero!");
					}
					break;
				case "4":
					ca.imprime();
					break;
				case "5":
					System.exit(0);
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void agrega(String clave, String nombre) {
		Materia m = new Materia(clave, nombre);
		materias.put(idUnico, m);
		idUnico++;
		imprime();
	}

	public void elimina(int key) {
		materias.remove(key);
		imprime();
	}

	public void busca(int key) {
		try{
			Materia m = materias.get(key);
			System.out.println(key + "\t|\t" + m.clave_materia
					+ "\t|\t" + m.nombre_materia);
		}
		catch(NullPointerException npe){
			System.out.println("No hay materia con el id "+key);
		}
		
	}

	public void imprime() {
		Enumeration<Integer> clave = materias.keys();
		while (clave.hasMoreElements()) {
			int key = clave.nextElement().intValue();
			System.out.println(key + "\t|\t" + materias.get(key).clave_materia
					+ "\t|\t" + materias.get(key).nombre_materia);
		}
	}

}

class Materia {
	String clave_materia, nombre_materia;

	Materia(String clave_materia, String nombre_materia) {
		this.clave_materia = clave_materia;
		this.nombre_materia = nombre_materia;
	}

	Materia() {

	}
}
