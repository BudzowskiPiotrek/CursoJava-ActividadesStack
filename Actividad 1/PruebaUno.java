import java.util.Stack;

public class PruebaUno {

	public static void main(String[] args) {

		// ESTE ES UN CÓDIGO FUE ELABORADO EN PLAN BROMA, NO TE LO TOMES EN SERIO
		// SOLO VERIFICAMOS SI LOS PARÉNTESIS EN UNA EXPRESIÓN ESTÁN BALANCEADOS

		String expresion = "(1+(2*3)+((8)/4))+1";

		// LLAMAMOS A LA FUNCIÓN QUE VERIFICA SI LOS PARÉNTESIS ESTÁN BALANCEADOS
		if (balanceado(expresion) == 0) {
			System.out.println("Esta Balanceado"); // IMPRIME SI LA EXPRESIÓN ESTÁ BALANCEADA
		} else {
			System.out.println("No esta balanceado"); // IMPRIME SI NO ESTÁ BALANCEADA
		}
	}

	private static int balanceado(String expresion) {
		// CREAMOS UNA PILA PARA ALMACENAR LOS PARÉNTESIS
		Stack<Character> pila = new Stack<>();

		// RECORREMOS LA EXPRESIÓN Y METEMOS SOLO LOS PARÉNTESIS EN LA PILA
		for (int i = 0; i < expresion.length(); i++) {
			if (expresion.charAt(i) == '(' || expresion.charAt(i) == ')')
				pila.push(expresion.charAt(i));
		}

		// VARIABLES PARA CONTAR PARÉNTESIS DE APERTURA Y CIERRE
		int comienzo = 0, fina = 0, balanceado = 0;

		// RECORREMOS LA PILA Y CONTAMOS LOS PARÉNTESIS
		for (char p : pila) {
			if (p == '(') {
				comienzo += 1; // INCREMENTAMOS CUANDO ES PARÉNTESIS DE APERTURA
			} else {
				fina += 1; // INCREMENTAMOS CUANDO ES PARÉNTESIS DE CIERRE
			}
			// SI HAY MÁS PARÉNTESIS DE CIERRE QUE DE APERTURA, ESTÁ MAL BALANCEADO
			if (fina > comienzo) {
				balanceado = -1;
			}
		}
		// SI EL NÚMERO DE PARÉNTESIS DE APERTURA Y CIERRE NO COINCIDE, NO ESTÁ
		// BALANCEADO
		if (comienzo != fina) {
			balanceado = -1;
		}
		// DEVOLVEMOS EL RESULTADO: 0 SI ESTÁ BALANCEADO, -1 SI NO LO ESTÁ
		return balanceado;
	}
}