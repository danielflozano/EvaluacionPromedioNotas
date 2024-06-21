import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Metodos {
	
	HashMap<String, Double> notasEstudiantes; // Mapa para almacenar las notas de los estudiantes.
	
	// Constructor para inicializar el mapa de notas de estudiantes.
	public Metodos() {
		notasEstudiantes = new HashMap<String, Double>();
	}
	
	// Método para inicializar y mostrar el menú.
	public void inicializarMenu() {		
		int menu = 0;
		do {
			// Mostrar el menú y obtener la opción seleccionada por el usuario.
			menu = Integer.parseInt(JOptionPane.showInputDialog("****************************** MENU PRINCIPAL ******************************\n\n"
					+ "1. Ingresar las notas de los estudiantes\n"
					+ "2. Imprimir la Cantidad total de estudiantes validados\n"
					+ "3. Imprimir la Cantidad total de notas ingresadas\n"
					+ "4. Imprimir la cantidad de estudiantes qué ganan la materia\n"
					+ "5. Imprimir la cantidad de estudiantes qué pierden la materia\n"
					+ "6. Imprimir la Cantidad de estudiantes qué pueden recuperar\n"
					+ "7. Imprimir la Cantidad de estudiantes qué pierden sin recuperación\n"
					+ "8. Imprimir el Promedio de las notas finales obtenidas\n"
					+ "9. Imprimir el listado total de estudiantes y sus notas finales\n"
					+ "10. Salir"));
			// Manejo de las opciones del menú.
			switch (menu) {
			case 1:
				solicitarNumEstudiantes(); // Solicitar y registrar las notas de los estudiantes.
				break;
			case 2:
				verificarHashMap(imprimirTotalEstudiantes()); // Imprimir la cantidad total de estudiantes.
				break;
			case 3:
				verificarHashMap(imprimirTotalNotas()); // Imprimir la cantidad total de notas.
				break;
			case 4:
				verificarHashMap(estudiantesGananMateria()); // Imprimir la cantidad total de estudiantes que ganan la materia.
				break;
			case 5:
				verificarHashMap(estudiantesPierdenMateria()); // Imprimir la cantidad total de estudiantes que pierden la materia.
				break;
			case 6:
				verificarHashMap(estudiantesPuedenRecuperar()); // Imprimir la cantidad total de estudiantes que pueden recuperar la materia.
				break;
			case 7:
				verificarHashMap(estudiantesNoPuedenRecuperar()); // Imprimir la cantidad total de estudiantes que no pueden recuperar la materia.
				break;
			case 8:
				verificarHashMap(promedioNotas()); // Imprimir el promedio de las notas finales.
				break;
			case 9:
				listadoNotasEstudiantes(); // Imprimir el listado total de estudiantes y sus notas finales.);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, "Fin del programa"); // Salir del programa.
				break;
			default:
				JOptionPane.showMessageDialog(null, "El valor ingresado no corresponde a ninguna opción, "
						+ "por favor digite un codigo valido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE); // Manejo de opción inválida.
				break;
			}			
		} while (menu != 10);	
	}
	
	// Método para solicitar el número de estudiantes y sus notas.
	private void solicitarNumEstudiantes() {
		System.out.println("\n***** Ingreso Estudiantes Y Notas *****\n");
		int numEstudiantes = 0;
		do {
			numEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de estudiantes que desea procesar"));
			for (int i = 0; i < numEstudiantes; i++) {
				alimentarHashMap(i); // Llenar el HashMap con las notas de los estudiantes.
			}
			if (numEstudiantes <= 0) {
				JOptionPane.showMessageDialog(null, "Ingrese un número de estudiantes valido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}			
		} while (numEstudiantes <= 0);
		System.out.println("Datos Ingresados Correctamente");
	}
	
	// Método para ingresar el nombre y las notas de un estudiante.
	private HashMap<String, Double> alimentarHashMap(int numEstudiante) {
		String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante N° " + (numEstudiante + 1));
		double sumatoriaNotas = 0;
		for (int i = 0; i < 3; i++) {
			double nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota N° " + (i+1)
					+ " del estudiante " + nombreEstudiante));
			if (nota >= 0 && nota <= 5) {
				sumatoriaNotas += nota;
			} else {
				JOptionPane.showMessageDialog(null, "La nota debe estar en un rango de 0 a 5", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				i--; // Decrementar i para repetir la entrada de nota inválida.
			}						
			}
		double notaFinal = sumatoriaNotas/3;
		notasEstudiantes.put(nombreEstudiante, notaFinal); // Almacenar la nota final del estudiante en el HashMap.
		return notasEstudiantes;
	}
	
	// Método para verificar si el HashMap esta vacio.
	private void verificarHashMap(String metodo) {
		if (notasEstudiantes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se ha ingresado ningun dato", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(metodo);
		}
	}
	
	// Método para imprimir la cantidad total de estudiantes.
	private String imprimirTotalEstudiantes() {
		System.out.println("\n***** Cantidad Total De Estudiantes Validados *****\n");
		int totalEstudiantes = notasEstudiantes.size();
		return "La cantidad total de estudiantes procesados es: " + totalEstudiantes;
	}
	
	// Método para imprimir la cantidad total de notas ingresadas.
	private String imprimirTotalNotas() {
		System.out.println("\n***** Cantidad Total De Notas Ingresadas *****\n");
		int totalNotas = notasEstudiantes.size() * 3;
		return "La cantidad total de notas ingresadas es: " + totalNotas;
	}
	
	// Método para imprimir la cantidad de estudiantes que ganan la materia.
	private String estudiantesGananMateria() {
		System.out.println("\n***** Cantidad De Estudiantes Que Ganan La Materia *****\n");
		int sumaEstudiantes = 0;
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			if (llave >= 3.5) {
				sumaEstudiantes ++;
			}			
		}
		return "La cantidad de estudiantes que ganan la materia es: " + sumaEstudiantes;
	}
	
	// Método para imprimir la cantidad de estudiantes que pierden la materia.
	private String estudiantesPierdenMateria() {
		System.out.println("\n***** Cantidad De Estudiantes Que Pierden La Materia *****\n");
		int sumaEstudiantes = 0;
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			if (llave < 3.5) {
				sumaEstudiantes ++;
			}			
		}
		return "La cantidad de estudiantes que pierden la materia es: " + sumaEstudiantes;
	}
	
	// Método para imprimir la cantidad de estudiantes que pueden recuperar la materia.
	private String estudiantesPuedenRecuperar() {
		System.out.println("\n***** Cantidad De Estudiantes Que Pueden Recuperar La Materia *****\n");
		int sumaEstudiantes = 0;
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			if (llave > 2 && llave < 3.5) {
				sumaEstudiantes ++;
			}			
		}
		return "La cantidad de estudiantes que pueden recuperar la materia es: " + sumaEstudiantes;
	}
	
	// Método para imprimir la cantidad de estudiantes que no pueden recuperar la materia.
	private String estudiantesNoPuedenRecuperar() {
		System.out.println("\n***** Cantidad De Estudiantes Que No Pueden Recuperar La Materia *****\n");
		int sumaEstudiantes = 0;
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			if (llave <= 2) {
				sumaEstudiantes ++;
			}			
		}
		return "La cantidad de estudiantes que no pueden recuperar la materia es: " + sumaEstudiantes;
	}
	
	// Método para imprimir el promedio de las notas finales.
	private String promedioNotas() {
		System.out.println("\n***** Promedio De Las Notas Finales *****\n");
		double sumaNotas = 0;
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			sumaNotas += llave;
		}
		double promedioNotas = sumaNotas / notasEstudiantes.size();
		return "El promedio de las notas finales es: " + promedioNotas;
	}
	
	// Método para imprimir el listado de estudiantes y sus notas
	private void listadoNotasEstudiantes() {
		System.out.println("\n***** Listado De Estudiantes Y Sus Notas *****\n");
		Iterator<String> iterador = notasEstudiantes.keySet().iterator();
		while (iterador.hasNext()) {
			String llave = iterador.next();
			System.out.println(llave + " - " + notasEstudiantes.get(llave));
		}
	}
}
