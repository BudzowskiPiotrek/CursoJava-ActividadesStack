import java.util.Stack;

public class PruebaDos {

	public static void main(String[] args) {

		// DEFINIMOS UNA EXPRESIÓN MATEMÁTICA CON PARÉNTESIS (ESTA VEZ MAL BALANCEADA)
		String expresion = "(1+(2*3)+((8)/4)))+1";

		// LLAMAMOS A LA FUNCIÓN QUE VERIFICA SI LA EXPRESIÓN ESTÁ BALANCEADA
		if (balanceada(expresion)) {
			System.out.println("Balanceado"); // SI ESTÁ BALANCEADO, IMPRIME ESTE MENSAJE
		} else {
			System.out.println("No balanceada"); // SI NO ESTÁ BALANCEADO, IMPRIME ESTE MENSAJE
		}

	}

	public static boolean balanceada(String e) {
		// CREAMOS UNA PILA PARA ALMACENAR LOS PARÉNTESIS DE APERTURA
		Stack<Character> pila = new Stack<>();

		// RECORREMOS LA EXPRESIÓN CARÁCTER POR CARÁCTER
		for (int i = 0; i < e.length(); i++) {
			char c = e.charAt(i);

			// SI ENCONTRAMOS UN PARÉNTESIS DE APERTURA, LO METEMOS EN LA PILA
			if (c == '(') {
				pila.push(c);
			}

			// SI ENCONTRAMOS UN PARÉNTESIS DE CIERRE, VERIFICAMOS SI HAY ALGUNO PARA
			// CERRARLO
			if (c == ')') {
				// SI LA PILA ESTÁ VACÍA, SIGNIFICA QUE HAY UN PARÉNTESIS DE CIERRE SIN APERTURA
				if (pila.isEmpty()) {
					return false; // DEVOLVEMOS FALSO PORQUE NO ESTÁ BALANCEADO
				}
				// SI HAY UN PARÉNTESIS DE APERTURA, LO SACAMOS DE LA PILA (SE FORMA UN PAR)
				pila.pop();
			}
		}
		// AL FINALIZAR, SI LA PILA ESTÁ VACÍA, SIGNIFICA QUE TODOS LOS PARÉNTESIS SE
		// CERRARON CORRECTAMENTE
		return pila.isEmpty();
	}
}
