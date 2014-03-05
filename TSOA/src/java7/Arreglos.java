package java7;
/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 7
 */
import java.util.Random;
public class Arreglos {
	public static void main(String[] args) {
		Random random = new Random();
		int limiteArreglo=random.nextInt(25)+5;
		char arreglo[] = new char[limiteArreglo];
		char arregloMod[] = new char[limiteArreglo];
		for(int i=0;i<limiteArreglo;i++){
			arreglo[i]=(char) (random.nextInt(26)+65);
		}
		Arreglos nuevo=new Arreglos();
		System.out.println("Arreglo Original: ");
		System.out.println(arreglo);
		nuevo.copiarArreglos(arreglo, arregloMod);
		int maxCeldasModif=nuevo.recibeArreglo(arregloMod,limiteArreglo);
		System.out.println("Arreglo Corregido: ");
		System.out.println(arregloMod);
		System.out.println("Celdas Modificadas: ");
		for(int i=0;i<maxCeldasModif;i++){
			if(arreglo[i]!=arregloMod[i])
				System.out.print(arregloMod[i]);
		}
	}
	int recibeArreglo(char arregloMod[],int limite){
		int i;
		int j;
		String cadenaX=new String("CADX");
		for(i=0,j=0;i+(cadenaX.length()-j)<=limite;i++,j++){		
			arregloMod[i]=cadenaX.charAt(j);
			if(j==3){
				j=-1;
			}
		}
		return i;
	}
	void copiarArreglos(char arreglo1[],char arreglo2[]){
		for(int i=0;i<arreglo1.length;i++){
			arreglo2[i]=arreglo1[i];
		}
	}
}