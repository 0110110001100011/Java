package java6;
/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 6
 */
public class Proceso {
	public static void main(String[] args){
		Proceso p=new Proceso();
		int a=8;
		int ar[]=new int[1];
		ar[0]=a;
		p.valor(a, a);
		System.out.println("a: "+a);
		p.referencia(ar,ar);
		System.out.println("ar: "+ar[0]);
	}
	void valor(int a1,int a2){
		a1+=a1;
		System.out.println("a1: "+a1);
		a2-=a2;
		System.out.println("a2: "+a2);
	}
	void referencia(int ar1[],int ar2[]){
		ar1[0]+=ar1[0];
		System.out.println("a1: "+ar1[0]);
		ar2[0]-=ar2[0];
		System.out.println("a2: "+ar2[0]);
	}
}