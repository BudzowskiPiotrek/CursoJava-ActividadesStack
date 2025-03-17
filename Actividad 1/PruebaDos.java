import java.util.Stack;

public class PruebaDos {

	public static void main(String[] args) {

		String expresion = "(1+(2*3)+((8)/4)))+1";

		if (balanceada(expresion)) {
			System.out.println("Balanceado");
		} else {
			System.out.println("No balanceada");
		}

	}

	public static boolean balanceada(String e) {
		Stack<Character> pila = new Stack<>();
		for (int i = 0; i < e.length(); i++) {
			char c = e.charAt(i);
			if (c == '(') {
				pila.push(c);
			}
			if (c == ')') {
				if (pila.isEmpty()) {
					return false;
				}
				pila.pop();
			}
		}
		return pila.isEmpty();
	}
}
