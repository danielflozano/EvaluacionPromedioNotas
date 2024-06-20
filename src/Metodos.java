import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Metodos {
	
	int numEstudiantes = 0;
	HashMap<String, Double> notasEstudiantes = new HashMap<String, Double>();
		
	public void iniciar() {
		
		int menu = 0;
		
		do {
			
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
			
			switch (menu) {
			case 1:
				ingresarNotas();
				break;
			case 2:
				imprimirTotalEstudiantes();
				break;
			case 3:
				imprimirTotalNotas();
				break;
			case 4:
				estudiantesGananMateria();
				break;
			case 5:
				estudiantesPierdenMateria();
				break;
			case 6:
				estudiantesPuedenRecuperarMateria();
				break;
			case 7:
				estudiantesNoPuedenRecuperarMateria();
				break;
			case 8:
				promedioNotas();
				break;
			case 9:
				imprimirLista();
				break;
			case 10:
				JOptionPane.showMessageDialog(null, "Fin del programa");
				break;
			default:
				JOptionPane.showMessageDialog(null, "El valor que ha seleccionado no pertenece a ninguna opción, "
						+ "Intente nuevamente");
				break;
			}					
			
		} while (menu != 10);
		
	}
	
	private void ingresarNotas() {
		
		System.out.println("\n*****Ingreso De Notas*****");
		
		do {
			
			numEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de estudiantes a procesar"));
			
		} while (numEstudiantes <= 0);
				
		for (int i = 0; i < numEstudiantes; i++) {
			
			alimentarHashMap();		
			
		}
	}
	
	private void alimentarHashMap() {
		
		String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
		double sumatoriaNotas = 0;
		double notaFinal = 0;
		double nota = 0;			
							
		for (int i = 0; i < 3; i++) {
			
			nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (i + 1)
					+ " del estudiante " + nombreEstudiante));
			
			if (nota >= 0 && nota <= 5) {
				
				sumatoriaNotas += nota;				
				
			} else {
				
				System.out.println("La nota debe estar en un rango de 0 a 5");
				
				i--;
				
			}
			
		}
		
		notaFinal = sumatoriaNotas / 3;
		
		notasEstudiantes.put(nombreEstudiante, notaFinal);
		
	}
	
	private void imprimirTotalEstudiantes() {
		
		System.out.println("\n*****Total Estudiantes*****\n");
		
		System.out.println("El total de estudiantes procesados es: " + notasEstudiantes.size());
		
	}
	
	private void imprimirTotalNotas() {
		
		System.out.println("\n*****Total Notas*****\n");
		
		int totalNotas = notasEstudiantes.size() * 3;
		
		System.out.println("El total de notas procesadas es : " + totalNotas);
		
	}
	
	private void estudiantesGananMateria() {
		
		System.out.println("\n*****Total De Estudiantes Que Ganaron La Materia*****\n");
		
		int contadorEstudiantes = 0;
		
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			
			if (llave >= 3.5) {
				contadorEstudiantes += 1;
			}
		}
		
		System.out.println("La cantidad de estudiantes que ganaron la materia son: " + contadorEstudiantes);
		
	}
	
	private void estudiantesPierdenMateria() {
		
		System.out.println("\n*****Total De Estudiantes Que Perdieron La Materia*****\n");
		
		int contadorEstudiantes = 0;
		
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			
			if (llave < 3.5) {
				contadorEstudiantes += 1;
			}
		}
		
		System.out.println("La cantidad de estudiantes que perdieron la materia son: " + contadorEstudiantes);
		
	}
	
	private void estudiantesPuedenRecuperarMateria() {
		
		System.out.println("\n*****Total De Estudiantes Que Pueden Recuperar La Materia*****\n");
		
		int contadorEstudiantes = 0;
		
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			
			if (llave < 3.5 && llave >= 2) {
				contadorEstudiantes += 1;
			}
		}
		
		System.out.println("La cantidad de estudiantes que pueden recuperar la materia son: " + contadorEstudiantes);
		
	}
	
	private void estudiantesNoPuedenRecuperarMateria() {
		
		System.out.println("\n*****Total De Estudiantes Que No Pueden Recuperar La Materia*****\n");
		
		int contadorEstudiantes = 0;
		
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			
			if (llave < 2) {
				contadorEstudiantes += 1;
			}
		}
		
		System.out.println("La cantidad de estudiantes que no pueden recuperar la materia son: " + contadorEstudiantes);
		
	}
	
	private void promedioNotas() {
		
		System.out.println("\n*****Promedio Notas*****\n");
		
		double notas = 0;
		
		Iterator<Double> iterador = notasEstudiantes.values().iterator();
		
		while (iterador.hasNext()) {
			Double llave = iterador.next();
			notas += llave;
		}
		
		double promedioNotas = notas / notasEstudiantes.size();
		
		System.out.println("El promedio de todas las notas es: " + promedioNotas);
		
	}
	
	private void imprimirLista() {
		
		System.out.println("\n*****Lista Estudiantes*****\n");
		
		Iterator<String> iterador = notasEstudiantes.keySet().iterator();
		
		while (iterador.hasNext()) {
			String llave = iterador.next();
			System.out.println(llave + " - " + notasEstudiantes.get(llave));
		}
		
	}
		
}
