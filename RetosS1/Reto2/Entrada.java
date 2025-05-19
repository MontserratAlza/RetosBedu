public class Entrada {
    private String nombreEvento;
    private double precioEntrada;

    // Constructor
    public Entrada(String nombreEvento, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEntrada = precioEntrada;
    }

    // Método para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento + " | Precio: $" + String.format("%.2f", precioEntrada));
    }

}
