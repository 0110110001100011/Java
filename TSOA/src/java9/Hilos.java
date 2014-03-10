package java9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hilos extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_izq;
	private JPanel panel_principal;
	private JScrollPane scrollPane_izq;
	private JTextArea textArea_izq;
	private JPanel panel_der;
	private JScrollPane scrollPane_der;
	private JTextArea textArea_der;
	private JLabel lblHilo;
	private JLabel lblHilo_1;
	private JButton btnPausa;
	private MiHilo hilo1, hilo2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hilos frame = new Hilos();
					frame.setVisible(true);
					frame.hilo1 = new MiHilo(frame.textArea_izq, 2);
					frame.hilo2 = new MiHilo(frame.textArea_der, 1);
					frame.hilo1.start();
					frame.hilo2.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Hilos() {
		setTitle("TSOAD03 - Java 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_principal = new JPanel();
		contentPane.add(panel_principal);
		panel_principal.setLayout(new BoxLayout(panel_principal,
				BoxLayout.X_AXIS));

		panel_izq = new JPanel();
		panel_principal.add(panel_izq);
		panel_izq.setLayout(new BorderLayout(0, 0));

		scrollPane_izq = new JScrollPane();
		panel_izq.add(scrollPane_izq, BorderLayout.CENTER);

		textArea_izq = new JTextArea();
		textArea_izq.setEditable(false);
		scrollPane_izq.setViewportView(textArea_izq);

		lblHilo = new JLabel("Hilo 1");
		lblHilo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_izq.setColumnHeaderView(lblHilo);

		panel_der = new JPanel();
		panel_principal.add(panel_der);
		panel_der.setLayout(new BorderLayout(0, 0));

		scrollPane_der = new JScrollPane();
		panel_der.add(scrollPane_der, BorderLayout.CENTER);

		textArea_der = new JTextArea();
		textArea_der.setEditable(false);
		scrollPane_der.setViewportView(textArea_der);

		lblHilo_1 = new JLabel("Hilo 2");
		lblHilo_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_der.setColumnHeaderView(lblHilo_1);

		btnPausa = new JButton("Pausa");
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hilo2.isA()){
					hilo2.setA();
				}
				else{
					hilo2.espera();
				}
			}

		});
		contentPane.add(btnPausa, BorderLayout.SOUTH);
	}
}

class MiHilo extends Thread {
	JTextArea area;
	int segundos;
	private boolean a,b;
	
	public MiHilo(JTextArea area, int segundos) {
		this.area=area;
		this.segundos=segundos;
		a=true;
		b=true;
	}

	public synchronized void espera() {
		if(b){
			b=false;
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			a=true;
			b=a;
			this.notify();
		}
		
	}

	public boolean isA() {
		return a;
	}

	public void setA() {
		a = false;
	}

	public void run() {
		for (int i = 0;; i++) {
			if(!a){
				espera();
			}
			area.append(" " + i + "\n");
			try {
				Thread.sleep(segundos * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
}