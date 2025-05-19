// Componente: SistemaGPS
class SistemaGPS {
    public void localizar() {
        System.out.println("📍 GPS: Ubicación actual detectada.");
    }
}

// Componente: Sirena
class Sirena {
    public void activarSirena() {
        System.out.println("🔊 Sirena: Activada.");
    }
}

// Componente: Operador
class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("👷 Operador " + nombre + " reportándose.");
    }
}

// Clase abstracta: UnidadEmergencia
abstract class UnidadEmergencia {
    protected String nombre;
    protected SistemaGPS gps;
    protected Sirena sirena;
    protected Operador operador;

    public UnidadEmergencia(String nombre, Operador operador) {
        this.nombre = nombre;
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = operador;
    }

    public void activarUnidad() {
        System.out.println("🚨 Activando unidad: " + nombre);
    }

    public abstract void responder();

    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }
}

// Subclase: Ambulancia
class Ambulancia extends UnidadEmergencia {
    public Ambulancia(Operador operador) {
        super("Ambulancia", operador);
    }

    @Override
    public void responder() {
        System.out.println("🩺 Ambulancia en camino al hospital más cercano.");
    }
}

// Subclase: Patrulla
class Patrulla extends UnidadEmergencia {
    public Patrulla(Operador operador) {
        super("Patrulla", operador);
    }

    @Override
    public void responder() {
        System.out.println("🚓 Patrulla atendiendo situación de seguridad ciudadana.");
    }
}

// Subclase: UnidadBomberos
class UnidadBomberos extends UnidadEmergencia {
    public UnidadBomberos(Operador operador) {
        super("UnidadBomberos", operador);
    }

    @Override
    public void responder() {
        System.out.println("🔥 Unidad de bomberos respondiendo a incendio estructural.");
    }
}


public class CentralEmergencias {
    public static void main(String[] args) {
        // Crear operadores
        Operador operadorAmbulancia = new Operador("Juan");
        Operador operadorPatrulla = new Operador("Laura");
        Operador operadorBomberos = new Operador("Marco");

        // Crear instancias de cada tipo de unidad
        Ambulancia ambulancia = new Ambulancia(operadorAmbulancia);
        Patrulla patrulla = new Patrulla(operadorPatrulla);
        UnidadBomberos bomberos = new UnidadBomberos(operadorBomberos);

        // Llamar al método iniciarOperacion() en cada unidad
        System.out.println();
        ambulancia.iniciarOperacion();

        System.out.println();
        patrulla.iniciarOperacion();

        System.out.println();
        bomberos.iniciarOperacion();
    }
}
