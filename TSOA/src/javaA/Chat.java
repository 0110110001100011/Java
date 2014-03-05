package javaA;
/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java A
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.SwingConstants;

public class Chat {
	private int puerto;
	private Thread hilo;

	Chat(int puerto) {
		this.puerto = puerto;
	}

	public void Emisor(String ip, String mensaje) {
		DatagramSocket socketEmisor;
		DatagramPacket packetEmisor;
		byte[] buffer = mensaje.getBytes();

		try {
			socketEmisor = new DatagramSocket();
			packetEmisor = new DatagramPacket(buffer, buffer.length,
					InetAddress.getByName(ip), puerto);
			socketEmisor.send(packetEmisor);
			socketEmisor.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Receptor() {
		DatagramSocket socketReceptor;
		DatagramPacket packetReceptor;
		byte[] buffer = new byte[1024];
		Ventana frame = new Ventana(puerto);
		frame.setVisible(true);
		try {
			socketReceptor = new DatagramSocket(puerto);
			packetReceptor = new DatagramPacket(buffer, buffer.length);
			while (true) {
				socketReceptor.receive(packetReceptor);
				String mensaje = new String(buffer, 0,
						packetReceptor.getLength());
				frame.getTextArea_Chat().append(
						"IP " + packetReceptor.getAddress().getHostAddress()
								+ " dice: " + mensaje + "\n");
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				final Chat chat = new Chat(2014);
				Runnable r = new Runnable() {
					public void run() {
						chat.Receptor();
					}
				};
				chat.hilo = new Thread(r);
				chat.hilo.start();
			}
		});
	}
}

class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_IP;
	private JLabel lblIp;
	private JTextField textField_IP;
	private JPanel panel_Chat;
	private JScrollPane scrollPane_Chat;
	private JTextArea textArea_Chat;
	private JPanel panel_Mensaje;
	private JButton btnEnviar;
	private JScrollPane scrollPane_Mensaje;
	private JTextArea textArea_Mensaje;

	public Ventana(final int puerto) {
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_IP = new JPanel();
		contentPane.add(panel_IP, BorderLayout.NORTH);
		panel_IP.setLayout(new BorderLayout(0, 0));

		lblIp = new JLabel("IP: ");
		lblIp.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_IP.add(lblIp);

		textField_IP = new JTextField();
		panel_IP.add(textField_IP, BorderLayout.EAST);
		textField_IP.setColumns(10);

		panel_Chat = new JPanel();
		contentPane.add(panel_Chat, BorderLayout.CENTER);
		panel_Chat.setLayout(new BorderLayout(0, 0));

		scrollPane_Chat = new JScrollPane();
		panel_Chat.add(scrollPane_Chat, BorderLayout.CENTER);

		setTextArea_Chat(new JTextArea());
		getTextArea_Chat().setEditable(false);
		scrollPane_Chat.setViewportView(getTextArea_Chat());

		panel_Mensaje = new JPanel();
		contentPane.add(panel_Mensaje, BorderLayout.SOUTH);
		panel_Mensaje.setLayout(new BorderLayout(0, 0));

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chat envia = new Chat(puerto);
				envia.Emisor(textField_IP.getText(), textArea_Mensaje.getText());
				getTextArea_Chat().append(
						"Tu: " + textArea_Mensaje.getText() + "\n");
			}
		});
		panel_Mensaje.add(btnEnviar, BorderLayout.EAST);

		scrollPane_Mensaje = new JScrollPane();
		panel_Mensaje.add(scrollPane_Mensaje, BorderLayout.CENTER);

		textArea_Mensaje = new JTextArea();
		scrollPane_Mensaje.setViewportView(textArea_Mensaje);
	}

	public JTextArea getTextArea_Chat() {
		return textArea_Chat;
	}

	public void setTextArea_Chat(JTextArea textArea_Chat) {
		this.textArea_Chat = textArea_Chat;
	}
}