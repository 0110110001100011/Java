/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 2
 */
package java2;


public class Conversor {
	public void imprimeBits(byte b){
		byte test=(byte)0x80;
		System.out.print("byte: "+b+"\n");
		System.out.print("| ");
		for(int i=0;i<8;i++){
			if ((b&test)!=0){
				System.out.print("1");
			}
			else{
				System.out.print("0");
			}
			test=(byte)((test>>1)&0x7F);
		}
		System.out.println(" |");
	}
	
	public void imprimeBits(short s){
		short test=(short)0x8000;
		System.out.print("short: "+s+"\n");
		System.out.print("| ");
		for(int i=0;i<16;i++){
			if ((s&test)!=0){
				System.out.print("1");
			}
			else{
				System.out.print("0");
			}
			if(i==7)
				System.out.print(" | ");
			test=(short)((test>>1)&0x7FFF);
		}
		System.out.println(" |");
	}
	
	public void imprimeBits(int e){
		int test=0x80007FFF;
		System.out.print("int: "+e+"\n");
		System.out.print("| ");
		for(int i=0;i<32;i++){
			if ((e&test)!=0){
				System.out.print("1");
			}
			else{
				System.out.print("0");
			}
			if(i==7 || i==15 || i==23)
				System.out.print(" | ");
			test=((test>>1)&0x7FFFFFFF);
		}
		System.out.println(" |");
	}
	
	public void imprimeBits(long l){
		long test=(long)0x7FFFFFFFFFFFFFFFL;
		System.out.print("long: "+l+"\n");
		System.out.print("| ");
		for(int i=0;i<64;i++){
			if ((l&test)!=0){
				System.out.print("1");
			}
			else{
				System.out.print("0");
			}
			if(i==7 || i==15 || i==23 || i==31 || i==39 || i==47 || i== 55)
				System.out.print(" | ");
			test=(long)((test>>1)&0x7FFFFFFFFFFFFFFFL);
		}
		System.out.println(" |");
	}
	
	public static void main(String[] args) {
		Conversor miObjeto = new Conversor();
		byte miByte=(byte) 0x7F;
		short miShort=(short) 0x7F08;
		int miInt = 0x7F0F0F80;
		long miLong = 0x7000000000000001L;
		
		
		miObjeto.imprimeBits(miByte);
		miObjeto.imprimeBits(miShort);
		miObjeto.imprimeBits(miInt);
		miObjeto.imprimeBits(miLong);
		
		
	}
}
