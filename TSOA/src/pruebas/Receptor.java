package pruebas;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.io.IOException;
public class Receptor{
	public void main(String args[]){
		DatagramSocket socketRecepcion;
		DatagramPacket dp;
		int puertoEntrada=2001;
		byte[] buffer=new byte[1024];
		System.out.print("Iniciando socket recepcion en puerto "+puertoEntrada+"...");
		try{
			socketRecepcion=new DatagramSocket(puertoEntrada);
			System.out.println("hecho");
			dp=new DatagramPacket(buffer,buffer.length);
			while(true){//deseable validar con bandera
				socketRecepcion.receive(dp);
				System.out.print("IP emisora: "+dp.getAddress().toString()+":");
				System.out.println(new String(buffer,0,dp.getLength()));
			}
			//socketRecepcion.close();//código inalcanzable sin bandera
		}catch(SocketException e){
			System.out.println("Error iniciando socket: "+e.getMessage());
		}catch(IOException e){
			System.out.println("IOException: "+e.getMessage());
		}
		System.out.print("Cerrando socket recepcion...");
		System.out.println("hecho");
	}
}