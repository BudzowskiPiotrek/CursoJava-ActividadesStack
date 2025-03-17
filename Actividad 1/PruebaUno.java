import java.util.Stack;

public class PruebaUno {

	public static void main(String[] args) {

		String expresion = "(1+(2*3)+((8)/4))+1";

		if (balanceado(expresion) == 0) {
			System.out.println("Esta Balanceado");
		} else {
			System.out.println("No esta balanceado");
		}
	}

	private static int balanceado(String expresion) {
		Stack<Character> pila = new Stack<>();

		for (int i = 0; i < expresion.length(); i++) {
			if (expresion.charAt(i) == '(' || expresion.charAt(i) == ')')
				pila.push(expresion.charAt(i));
		}

		int comienzo = 0, fina = 0, balanceado = 0;

		for (char p : pila) {
			if (p == '(') {
				comienzo += 1;
			} else {
				fina += 1;
			}
			if (fina > comienzo) {
				balanceado = -1;
			}
		}
		if (comienzo != fina) {
			balanceado = -1;
		}
		return balanceado;
	}

}
