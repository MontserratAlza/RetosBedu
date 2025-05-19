public class Main {
    public static void main(String[] args) {
        // Crea el primer objeto de tipo Entrada
        Entrada entrada1 = new Entrada("Concierto de Kevin Kaarl", 750.50);

        // Crea el segundo objeto de tipo Entrada
        Entrada entrada2 = new Entrada("Exposición de Arte", 120.00);

        // Llama al método mostrarInformacion() para cada objeto
        System.out.println("--- Información de las Entradas ---");
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();
    }
}
