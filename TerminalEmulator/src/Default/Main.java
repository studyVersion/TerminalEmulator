package Default;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int paso = 0; // navegar los comandos 1 para ls ; 2 para ls -l ; 3 para Mkdir ; 4 para cat ; 5 para rm
	

	public static String extractoRuta(String valor) {
		String[] valorSplit = valor.toLowerCase().split("\\s");
		String ruta = "C:\\Users\\Administrateur\\Desktop\\";

		if (valorSplit[0].equals("ls")) {
			paso = 1;

			if (valorSplit.length > 1) {
				if (valorSplit[1].equals("-l")) {
					paso = 2;
					if (valorSplit.length > 2) {
						ruta = valorSplit[2];
					}
				} else {
					ruta = valorSplit[1];
				}
			}
		} else if (valorSplit[0].equals("mkdir")) {
			paso = 3;
			ruta = valorSplit[1];

		} else if (valorSplit[0].equals("cat")) {
			paso = 4;
			ruta = valorSplit[1];

		} else if (valorSplit[0].equals("rm")) {
			paso = 5;
			ruta = valorSplit[1];
		}

		return ruta;

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Terminal badre = null;
		String option = "";
		String ruta = "";
		int mensajeConsola = 0;

		while (true) {
			System.out.println("root@root:~/Desktop$");
			option = sc.nextLine();
			String[] optionSplit = option.split("\\s");
			
			ruta = extractoRuta(option);
			
            // para si el usuario no escribe la ruta
			if (!ruta.equals("C:\\Users\\Administrateur\\Desktop\\")) {
				if (!ruta.contains("\\")) {
					ruta = "C:\\Users\\Administrateur\\Desktop\\" + optionSplit[optionSplit.length - 1];
				}
			}

			badre = new Terminal(ruta); 
		
			if (paso == 1) {
				System.out.println(badre.lsCommando());
			} else if (paso == 2) {
				System.out.println(badre.lsDetallesCommando());
			} else if (paso == 3) {
				mensajeConsola = badre.mkdirComando();
				if (mensajeConsola == -1) {
					System.out.println("Bash " + ruta + ": No hay tal archivo o directorio");
				}
			} else if (paso == 4) {
				mensajeConsola = badre.catComando();
				if (mensajeConsola == -1) {
					System.out.println("Bash " + ruta + ": No hay tal archivo o directorio");
				}
			} else if (paso == 5) {
				mensajeConsola = badre.rmComando();
				if (mensajeConsola == -1) {
					System.out.println("Bash " + ruta + ": No hay tal archivo o directorio");
				}
			} else {
				System.out.println("Comando '" + optionSplit[0] + "' no encontrado, intente sudo apt install <"
						+ optionSplit[0] + ">");
			}

		}
	}

}
