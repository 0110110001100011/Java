package javaB;
/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java B
 */
public class Parametros {
	private short corto=2815;
	private int entero=0x7F0F0AFF;
	private byte[] arregloCorto=new byte[2]; 
	private byte[] arregloEntero=new byte[4];
	
	public static void main(String[] args) {
		Parametros p=new Parametros();
		p.arregloCorto=p.recibeCorto(p.corto);
		p.recibeByteS(p.arregloCorto);
		p.arregloEntero=p.recibeEntero(p.entero);
		p.recibeByteE(p.arregloEntero);
	}
	public byte[] recibeCorto(short s){
		byte[] parDeBytes=new byte[2];
		System.out.println("Corto = "+s);
		System.out.print("Corto a Bytes = ");
		for(int i=parDeBytes.length-1,j=0;i>=0;i--,j+=8){
			parDeBytes[i]=(byte)(s>>j);
			System.out.print("|"+parDeBytes[i]+"| ");
		}
	    return  parDeBytes;
	}
	public byte[] recibeEntero(int e){
		byte[] parDeBytes=new byte[4];
		System.out.println("Entero = "+e);
		System.out.print("Entero a Bytes  = ");
		for(int i=parDeBytes.length-1,j=0;i>=0;i--,j+=8){
			parDeBytes[i]=(byte)(e>>j);
			System.out.print("|"+parDeBytes[i]+"| ");
		}
	    return  parDeBytes;
	}

	public void recibeByteS(byte[] arreglo){
		short s = 0;
		for(int i=0,j=8;i<arreglo.length;i++){
			if(arreglo[i]<0){
				s+=(short) ((short)(arreglo[i])+(short)((Byte.MAX_VALUE+1)*2));
			}
			else{
				s+=(short)arreglo[i];
			} 
			if(i!=arreglo.length-1)
				s<<=j;
		}
		System.out.println("\nBytes a Corto = "+s);
	}
	
	public void recibeByteE(byte[] arreglo){
		int e = 0;
		for(int i=0,j=8;i<arreglo.length;i++){
			if(arreglo[i]<0){
				e+=(int) ((int)(arreglo[i])+(int)((Byte.MAX_VALUE+1)*2));
			}
			else{
				e+=(int)arreglo[i];
			} 
			if(i!=arreglo.length-1)
				e<<=j;
		}
		System.out.println("\nBytes a Entero = "+e);
	}
}
