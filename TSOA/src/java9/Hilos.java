package java9;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Hilos {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Ventana frame = new Ventana();
					frame.getTextArea_1().setEditable(false);
					frame.getTextArea().setEditable(false);
					frame.setVisible(true);

					frame.nuevo("Hilo 1: ", 2,frame.getTextArea());
					frame.nuevo("Hilo 2: ", 2,frame.getTextArea_1());


				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}
}

class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JLabel lblHilo;
	private JScrollPane scrollPane;
	private JTextArea textArea_1;
	private JLabel lblHilo_1;
	private JButton btnPausarreanudar;
	private boolean pausa;

	public Ventana() {
		pausa = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);

		setTextArea(new JTextArea());
		scrollPane_1.setViewportView(getTextArea());

		lblHilo = new JLabel("Hilo 1");
		lblHilo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblHilo);

		scrollPane = new JScrollPane();
		panel.add(scrollPane);

		setTextArea_1(new JTextArea());
		scrollPane.setViewportView(getTextArea_1());

		lblHilo_1 = new JLabel("Hilo 2");
		lblHilo_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblHilo_1);

		btnPausarreanudar = new JButton("Pausar/Reanudar");
		btnPausarreanudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pausa){
					
				}
				else{
					
				}
			}
		});
		
		contentPane.add(btnPausarreanudar, BorderLayout.SOUTH);


	}

	void imprime(JTextArea area, String mensaje) {
		area.append(mensaje + "\n");
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JTextArea getTextArea_1() {
		return textArea_1;
	}

	public void setTextArea_1(JTextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}
	public void nuevo(final String string, final int seg, final JTextArea textArea) {
		Runnable r = new Runnable() {
			public void run() {
				for (long contador = 0; true; contador++) {
					imprime(textArea, string+contador);
					try {
						Thread.sleep(seg*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread hilo = new Thread(r);
		hilo.start();
	}
	public void nuevoPausa(final String string, final int seg, final JTextArea textArea) {
		Runnable r = new Runnable() {
			public void run() {
				for (long contador = 0; true; contador++) {
					try {
						wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imprime(textArea, string+contador);
					try {
						Thread.sleep(seg*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		Thread hilo = new Thread(r);
		hilo.start();
	}

}
