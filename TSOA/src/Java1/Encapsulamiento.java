package Java1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 * @author Luis Carlos de la Torre Cortes
 * @Seccion D03
 * @Tarea Java 1
 */
public class Encapsulamiento {
	public static void main(String[] args) {
		miFecha objeto = new miFecha();
		String opcion = new String();
		while (true) {
			opcion = JOptionPane.showInputDialog("Fecha:" + objeto.dameDia()
					+ "/" + objeto.dameMes() + "/" + objeto.dameAnio() + "\n"
					+ "\n1. Cambia Dia\n2. Cambia Mes\n3. Cambia Anio"
					+ "\nQ. Salir");
			if (opcion == null) {
				JOptionPane.showMessageDialog(null,
						"No seleccionaste ninguna opcion");
			} else {
				switch (opcion) {
				case "1":
					objeto.fijaDia();
					break;
				case "2":
					objeto.fijaMes();
					break;
				case "3":
					objeto.fijaAnio();
					break;
				case "Q":
				case "q":
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion incorrecta!");
				}
			}
		}
	}

}

class miFecha {
	private int dia, mes, anio;
	private int nuevo = 0;

	miFecha() {
		Calendar fecha = new GregorianCalendar();
		dia = fecha.get(Calendar.DATE);
		mes = fecha.get(Calendar.MONTH) + 1;
		anio = fecha.get(Calendar.YEAR);
	}

	private boolean verifica(short tipoFecha) {
		switch (tipoFecha) {
		case 1:
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
					|| mes == 10 || mes == 12) {
				if (nuevo >= 1 && nuevo <= 31) {
					return true;
				}
			} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if (nuevo >= 1 && nuevo <= 30) {
					return true;
				}
			} else if (mes == 2) {
				if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
					if (nuevo >= 1 && nuevo <= 29) {
						return true;
					}
				} else {
					if (nuevo >= 1 && nuevo <= 28) {
						return true;
					}
				}
			}
			return false;
		case 2:
			if (nuevo == 1 || nuevo == 3 || nuevo == 5 || nuevo == 7
					|| nuevo == 8 || nuevo == 10 || nuevo == 12) {
				if (dia >= 1 && dia <= 31) {
					return true;
				}
			} else if (nuevo == 4 || nuevo == 6 || nuevo == 9 || nuevo == 11) {
				if (dia >= 1 && dia <= 30) {
					return true;
				}
			} else if (nuevo == 2) {
				if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
					if (dia >= 1 && dia <= 29) {
						return true;
					}
				} else {
					if (dia >= 1 && dia <= 28) {
						return true;
					}
				}
			}
			return false;
		case 3:
			if (mes == 2) {
				if ((nuevo % 4 == 0 && nuevo % 100 != 0) || nuevo % 400 == 0) {
					return true;
				} else {
					if (dia >= 1 && dia <= 28) {
						return true;
					}
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public int dameDia() {
		return dia;
	}

	public int dameMes() {
		return mes;
	}

	public int dameAnio() {
		return anio;
	}

	public int fijaDia() {
		nuevo = Integer.parseInt(JOptionPane.showInputDialog("nuevo dia: "));
		if (verifica((short) 1))
			dia = nuevo;
		else
			JOptionPane.showMessageDialog(null, "Dia no valido!");
		return dameDia();
	}

	public int fijaMes() {
		nuevo = Integer.parseInt(JOptionPane.showInputDialog("nuevo mes: "));
		if (verifica((short) 2))
			mes = nuevo;
		else
			JOptionPane.showMessageDialog(null, "Mes no valido!");
		return dameDia();
	}

	public int fijaAnio() {
		nuevo = Integer.parseInt(JOptionPane.showInputDialog("nuevo anio: "));
		if (verifica((short) 3))
			anio = nuevo;
		else
			JOptionPane.showMessageDialog(null, "Anio no valido!");
		return dameDia();
	}
}