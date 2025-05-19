// Clase Factura
class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = Optional.ofNullable(rfc); // Usa Optional.ofNullable para manejar el null
    }

    public String getResumen() {
        String rfcTexto = rfc.map(r -> "RFC: " + r).orElse("RFC: [No proporcionado]");
        return "Descripción: " + descripcion + "\n" +
               "Monto: $" + String.format("%.2f", monto) + "\n" +
               rfcTexto;
    }

    // Getters (opcional, pero buena práctica si necesitas acceder a los atributos)
    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Optional<String> getRfc() {
        return rfc;
    }
}

// Clase Principal
public class Principal {
    public static void main(String[] args) {
        // Crear una factura con RFC
        Factura facturaConRfc = new Factura(2500.0, "Servicio de consultoría", "ABCC010101XYZ");

        // Crear una factura sin RFC (pasando null)
        Factura facturaSinRfc = new Factura(1800.0, "Reparación de equipo", null);

        // Imprimir el resumen de ambas facturas
        System.out.println("📄 Factura generada:");
        System.out.println(facturaConRfc.getResumen());
        System.out.println("\n📄 Factura generada:");
        System.out.println(facturaSinRfc.getResumen());
    }
}
