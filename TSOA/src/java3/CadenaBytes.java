/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 3
 */
package java3;

public class CadenaBytes {
	String miCadena;
	short contador;
	byte[] array;

	CadenaBytes() {
		miCadena = "Cadena de prueba";
	}

	public static void main(String[] args) {
		CadenaBytes miObjeto = new CadenaBytes();
		System.out.println("Cadena Original:\n" + miObjeto.miCadena);
		miObjeto.covierteCadena();
		miObjeto.muestraBytes();
		miObjeto.muestraCadena();
	}

	public void covierteCadena() {
		miCadena += " ";
		array = miCadena.getBytes();
		contador = (short) array.length;
		for (int i = contador - 2; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = (byte) contador;
		System.out.println("Contador-array[0]: ");
		System.out.println(array[0]);
	}

	public void muestraBytes() {
		System.out.println("Cadena a bytes");
		for (int i = 1; i < array[0]; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public void muestraCadena() {
		System.out.println("\nBytes a caracteres");
		for (int i = 1; i < array[0]; i++) {
			System.out.print((char) array[i]);
		}
	}
}
