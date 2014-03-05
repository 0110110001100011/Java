/**
 * @author Luis Carlos de la Torre Cortes
 *	Seccion: D05
 *	Tarea A
 */
package pruebas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IP;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblMensaje;
	private JPanel panel_1;
	private JLabel lblIp;
	private JPanel panel_2;
	private JButton btnEnviar;
	private Thread hilo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Chat() {
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setVerticalAlignment(SwingConstants.TOP);
		scrollPane.setRowHeaderView(lblMensaje);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblIp = new JLabel("IP:");
		panel_1.add(lblIp);
		
		textField_IP = new JTextField();
		panel_1.add(textField_IP);
		textField_IP.setColumns(10);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Emisor em = new Emisor();
				String[] str=new String[2];
				str[0]=textField_IP.getText();
				str[1]=textArea.getText();
				em.main(str);
			}
		});
		panel_2.add(btnEnviar, BorderLayout.EAST);
		
		Runnable runnable = new Runnable(){
            public void run(){
            	Receptor rec = new Receptor();
            	rec.main(null);
            }
        };
		hilo = new Thread(runnable);
		hilo.start();
	}
	
}
