import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<String> historial = new Stack<>();
    public static Stack<String> adelantadas = new Stack<>();
    public static Scanner sn = new Scanner(System.in);
    public static Scanner st = new Scanner(System.in);

    public static void main(String[] args) {
        libreriaEjemplo();
        menu();
    }

    // MÉTODO PARA CARGAR UN HISTORIAL DE PÁGINAS EJEMPLO AL INICIAR EL PROGRAMA
    private static void libreriaEjemplo() {
        historial.push("www.facebook.com");
        historial.push("www.marca.com");
        historial.push("www.google.com");
        historial.push("www.PorqueLosPinguinosLlevanTraje.com");
    }

    // MÉTODO QUE MUESTRA EL MENÚ PRINCIPAL Y PERMITE AL USUARIO ELEGIR UNA OPCIÓN
    private static void menu() {
        while (true) {
            System.out.println("----Menu----");
            System.out.println("1. Entrar en pagina");
            System.out.println("2. Ir Atras");
            System.out.println("3. Volver adelante");
            System.out.println("4. Mostrar historial");
            int opcion = sn.nextInt();
            menuDos(opcion);
        }
    }

    // MÉTODO QUE EJECUTA LA ACCIÓN SELECCIONADA EN EL MENÚ
    private static void menuDos(int opcion) {
        switch (opcion) {
            case 1:
                nuevaPagina();
                break;
            case 2:
                marchaAtras();
                break;
            case 3:
                marchaAdelante();
                break;
            case 4:
                mostrarHistorial();
                break;
            default:
                System.err.println("Error, intente nuevamente.");
        }
    }

    // MÉTODO QUE PERMITE INGRESAR UNA NUEVA PÁGINA AL HISTORIAL
    private static void nuevaPagina() {
        System.out.println("Escribe enlace de pagina que queires visitar: ");
        String pagina = st.nextLine().toLowerCase();

        if (historial.isEmpty() || !historial.peek().equals(pagina)) { // COMPRUEBA SI USUARIO QUIERE CAMBIAR A MISMA
            historial.push(pagina);
            adelantadas.clear(); // AL INGRESAR PAGINA NUEVA SE BORRA HISTORIAL ADELANTADO
            System.out.println("Cargando enlace https://" + historial.peek()); // INFORMAR DE PAGINA ACTUAL
        } else {
            System.err.println("Ya se encuentra en esta pagina");
        }
    }

    // MÉTODO QUE PERMITE VOLVER A LA PÁGINA ANTERIOR EN EL HISTORIAL
    private static void marchaAtras() {
        if (historial.size() > 1) { // ASEGURA QUE NO PUEDES VOLVER MAS ADELANTE QUE PRIEMRA PAGINA
            String paginaAuxiliar = historial.pop(); // AL BORRAR CREO UNA AUX PARA DESPUES
            adelantadas.push(paginaAuxiliar); // AGREGARLA A LISTA DE ADELANTADOS
            System.out.println("Cargando enlace https://" + historial.peek()); // INFORMAR DE PAGINA ACTUAL
        } else {
            System.err.println("No se puede ir mas atras");
        }
    }

    // MÉTODO QUE PERMITE VOLVER ADELANTE EN EL HISTORIAL SI SE HA IDO ATRÁS
    private static void marchaAdelante() {
        if (!adelantadas.isEmpty()) { // COMPRUEBA SI HAY ALGUN REGISTRO DE PAGINAS ADELANTADAS
            String paginaAuxiliar = adelantadas.pop(); //// AL BORRAR CREO UNA AUX PARA DESPUES
            historial.push(paginaAuxiliar); // AGREGARLA A LISTA DE HISTORIAL
            System.out.println("Cargando enlace https://" + historial.peek()); //// INFORMAR DE PAGINA ACTUAL
        } else {
            System.err.println("No se puede ir mas adelante");
        }
    }
    // MÉTODO QUE IMPRIME CONTENIDO DE HISTORIAL
    private static void mostrarHistorial() {
        if (!historial.isEmpty()) {     // COMPRUEBO SI NO ESTA VACIA
            for (String s : historial) {    // EL FOR BONITO RECORIENDO
                System.out.println("https://" + s);
            }
        } else {
            System.err.println("No hay historial");
        }
    }
}