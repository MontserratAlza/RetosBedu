// Interfaz para definir cómo se pasa de una escena a otra
interface TransicionHistoria {
    void transicionar(String siguienteEscena);
}

// Interfaz para imprimir o manejar diálogos
interface GestorDialogo {
    void mostrarDialogo(String dialogo);
}

// Interfaz para tomar decisiones según la acción del jugador
interface LogicaDecision {
    String tomarDecision(String accionJugador);
}

// Implementación concreta para transiciones simples
class TransicionSimple implements TransicionHistoria {
    @Override
    public void transicionar(String siguienteEscena) {
        System.out.println("\n--- Transicionando a: " + siguienteEscena + " ---");
    }
}

// Implementación concreta para mostrar diálogos en texto plano
class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String dialogo) {
        System.out.println("🗣️ Personaje dice: \"" + dialogo + "\"");
    }
}

// Implementación concreta para una decisión binaria (sí/no)
class DecisionBinaria implements LogicaDecision {
    @Override
    public String tomarDecision(String accionJugador) {
        if (accionJugador.equalsIgnoreCase("sí")) {
            return "opcion_si";
        } else if (accionJugador.equalsIgnoreCase("no")) {
            return "opcion_no";
        } else {
            return "accion_invalida";
        }
    }
}

// Clase principal que orquesta la narrativa
class Narrador {
    private final TransicionHistoria transicionHistoria;
    private final GestorDialogo gestorDialogo;
    private final LogicaDecision logicaDecision;

    // Inyección de dependencias a través del constructor
    public Narrador(TransicionHistoria transicionHistoria, GestorDialogo gestorDialogo, LogicaDecision logicaDecision) {
        this.transicionHistoria = transicionHistoria;
        this.gestorDialogo = gestorDialogo;
        this.logicaDecision = logicaDecision;
    }

    public void iniciarEscena(String nombreEscena) {
        System.out.println("\n🎬 Iniciando escena: " + nombreEscena);
        gestorDialogo.mostrarDialogo("¡Elige sabiamente, aventurero!");
    }

    public void procesarAccion(String accionJugador) {
        String resultadoDecision = logicaDecision.tomarDecision(accionJugador);

        switch (resultadoDecision) {
            case "opcion_si":
                gestorDialogo.mostrarDialogo("Has elegido seguir adelante.");
                transicionHistoria.transicionar("Bosque Encantado");
                break;
            case "opcion_no":
                gestorDialogo.mostrarDialogo("Decides quedarte en este lugar.");
                transicionHistoria.transicionar("Claro del Reposo");
                break;
            case "accion_invalida":
                gestorDialogo.mostrarDialogo("Esa no es una opción válida. Intenta de nuevo.");
                break;
            default:
                gestorDialogo.mostrarDialogo("Algo inesperado ha ocurrido...");
                transicionHistoria.transicionar("Lo Desconocido");
                break;
        }
    }
}

public class MainNarrativa {
    public static void main(String[] args) {
        // Configuración de las implementaciones concretas
        TransicionHistoria transicionSimple = new TransicionSimple();
        GestorDialogo dialogoTexto = new DialogoTexto();
        LogicaDecision decisionBinaria = new DecisionBinaria();

        // Inyección de dependencias en el Narrador
        Narrador narrador = new Narrador(transicionSimple, dialogoTexto, decisionBinaria);

        // Simulación de una escena narrativa
        narrador.iniciarEscena("Encrucijada");

        // Simulación de la acción del jugador
        String accionJugador = "sí";
        System.out.println("\n👤 El jugador elige: " + accionJugador);
        narrador.procesarAccion(accionJugador);

        // Otra simulación con otra decisión
        System.out.println("\n--- Nueva Decisión ---");
        narrador.iniciarEscena("Encrucijada");
        accionJugador = "no";
        System.out.println("\n👤 El jugador elige: " + accionJugador);
        narrador.procesarAccion(accionJugador);

        // Simulación de una acción inválida
        System.out.println("\n--- Acción Inválida ---");
        narrador.iniciarEscena("Encrucijada");
        accionJugador = "quizás";
        System.out.println("\n👤 El jugador elige: " + accionJugador);
        narrador.procesarAccion(accionJugador);
    }
}
