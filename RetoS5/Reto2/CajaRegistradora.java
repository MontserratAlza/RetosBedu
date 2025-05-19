// Interfaz Autenticable
interface Autenticable {
    boolean autenticar();
}

// Clase abstracta MetodoPago
abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();

    public void mostrarResumen() {
        System.out.println("📄 Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + String.format("%.1f", monto));
    }
}

// Clase concreta PagoEfectivo
class PagoEfectivo extends MetodoPago implements Autenticable {
    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        System.out.println("✅ Autenticación exitosa.");
        return true; // El efectivo no requiere validación
    }

    @Override
    public void procesarPago() {
        System.out.println("💵 Procesando pago en efectivo por $" + String.format("%.1f", monto));
    }
}

// Clase concreta PagoTarjeta
class PagoTarjeta extends MetodoPago implements Autenticable {
    private double saldoDisponible;

    public PagoTarjeta(double monto, double saldoDisponible) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public boolean autenticar() {
        if (saldoDisponible >= monto) {
            System.out.println("✅ Autenticación exitosa.");
            return true;
        } else {
            System.out.println("❌ Fallo de autenticación. Saldo insuficiente en la tarjeta.");
            return false;
        }
    }

    @Override
    public void procesarPago() {
        System.out.println("💳 Procesando pago con tarjeta por $" + String.format("%.1f", monto));
        saldoDisponible -= monto; // Simulación de débito
    }
}

// Clase concreta PagoTransferencia
class PagoTransferencia extends MetodoPago implements Autenticable {
    public PagoTransferencia(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        // Simulación de validación bancaria externa (ej. verificar número de cuenta, etc.)
        Random random = new Random();
        boolean validacionExitosa = random.nextBoolean();
        if (validacionExitosa) {
            System.out.println("✅ Autenticación exitosa.");
            return true;
        } else {
            System.out.println("❌ Fallo de autenticación. Transferencia no válida.");
            return false;
        }
    }

    @Override
    public void procesarPago() {
        System.out.println("🏦 Procesando transferencia por $" + String.format("%.1f", monto));
        // Aquí iría la lógica para interactuar con el sistema bancario
    }
}

// Clase CajaRegistradora
class CajaRegistradora {
    public void procesarVenta(MetodoPago[] metodosPago) {
        for (MetodoPago metodo : metodosPago) {
            if (metodo instanceof Autenticable) {
                Autenticable autenticable = (Autenticable) metodo;
                if (autenticable.autenticar()) {
                    metodo.procesarPago();
                    metodo.mostrarResumen();
                    System.out.println();
                } else {
                    System.out.println();
                }
            } else {
                // Si el método de pago no requiere autenticación, se procesa directamente
                metodo.procesarPago();
                metodo.mostrarResumen();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Crear un arreglo de diferentes métodos de pago
        MetodoPago[] metodosPago = {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(500.0)
        };

        // Crear una instancia de la caja registradora
        CajaRegistradora caja = new CajaRegistradora();

        // Procesar la venta utilizando los diferentes métodos de pago
        caja.procesarVenta(metodosPago);
    }
}
