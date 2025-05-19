// Record DeclaracionImpuestos
record DeclaracionImpuestos(String rfcContribuyente, double montoDeclarado) {}

// Clase CuentaFiscal
class CuentaFiscal {
    private final String rfc;
    private double saldoDisponible;

    public CuentaFiscal(String rfc, double saldoDisponible) {
        this.rfc = rfc;
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.saldoDisponible = saldoDisponible;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public boolean validarRFC(DeclaracionImpuestos d) {
        return Objects.equals(this.rfc, d.rfcContribuyente());
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crea una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("ABC123456XYZ", 15000.75);
        System.out.println("📄 Declaración de Impuestos:");
        System.out.println("   RFC Contribuyente: " + declaracion.rfcContribuyente());
        System.out.println("   Monto Declarado: $" + declaracion.montoDeclarado());

        // Crea una cuenta fiscal
        CuentaFiscal cuenta = new CuentaFiscal("ABC123456XYZ", 100000.50);
        System.out.println("\n💼 Cuenta Fiscal:");
        System.out.println("   RFC: " + cuenta.getRfc());
        System.out.println("   Saldo Disponible: $" + cuenta.getSaldoDisponible());

        // Valida si el RFC coincide
        boolean rfcCoincide = cuenta.validarRFC(declaracion);
        System.out.println("\n¿El RFC de la cuenta coincide con el de la declaración?: " + rfcCoincide);

        // Ejemplo con RFC diferente
        DeclaracionImpuestos otraDeclaracion = new DeclaracionImpuestos("DEF789012UVW", 20000.00);
        boolean otroRfcCoincide = cuenta.validarRFC(otraDeclaracion);
        System.out.println("\n¿El RFC de la cuenta coincide con el de otra declaración?: " + otroRfcCoincide);
    }
}
