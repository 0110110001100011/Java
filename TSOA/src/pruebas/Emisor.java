package pruebas;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
public class Emisor{
	public void main(String args[]){
		DatagramSocket socketEmision;
		DatagramPacket dp;
		String ip=args[0];
		String mensaje=args[1];
		//int puertoSalida=2002;
		byte[] buffer;
		//System.out.print("Iniciando socket emision en puerto "+puertoSalida+"...");
		try{
			socketEmision=new DatagramSocket();  //constructor sobrecargado para recibir o no un #puerto
			System.out.println("hecho");
			buffer=mensaje.getBytes();
			dp=new DatagramPacket(buffer,buffer.length,InetAddress.getByName(ip),2001);
			socketEmision.send(dp);
			System.out.print("Cerrando socket emision...");
			socketEmision.close();
			System.out.println("hecho");
		}catch(SocketException e){
			System.out.println("Error iniciando socket: "+e.getMessage());
		}catch(UnknownHostException e){
			System.out.println("UnknownHostException: "+e.getMessage());
		}catch(IOException e){
			System.out.println("IOException: "+e.getMessage());
		}
	}
}