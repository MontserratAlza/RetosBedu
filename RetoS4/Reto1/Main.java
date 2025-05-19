// Clase Factura
class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor con parámetros
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Implementación del método toString()
    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + String.format("%.1f", total) + "]";
    }

    // Implementación del método equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Factura otraFactura = (Factura) obj;
        return folio.equals(otraFactura.folio);
    }

    // Implementación del método hashCode() basado en el folio
    @Override
    public int hashCode() {
        return folio.hashCode();
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crea dos facturas con el mismo folio pero diferentes clientes y/o totales
        Factura factura1 = new Factura("FAC001", "Juan Pérez", 1450.0);
        Factura factura2 = new Factura("FAC001", "Comercial XYZ", 1600.50); // Diferente cliente y total

        // Muestra ambas facturas con toString()
        System.out.println(factura1.toString());
        System.out.println(factura2.toString());

        // Compara si son iguales con equals()
        boolean sonIguales = factura1.equals(factura2);
        System.out.println("¿Las facturas son iguales?: " + sonIguales);
    }
}
