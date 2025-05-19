// Excepción personalizada para consumo crítico de CPU
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {

    public static void main(String[] args) {
        Scanner scanner = null;
        Set<Double> registrosCPU = new HashSet<>();

        try {
            scanner = new Scanner(System.in);
            System.out.println("🚀 Iniciando monitor de consumo de CPU. Ingrese los valores (en porcentaje) por servidor (ingrese un valor no numérico para finalizar):");

            while (true) {
                System.out.print("Ingrese consumo de CPU: ");
                try {
                    double consumo = scanner.nextDouble();

                    // Validaciones
                    if (consumo < 0 || consumo > 100) {
                        System.out.println("⚠️ Error: El valor debe estar entre 0 y 100.");
                    } else if (!registrosCPU.add(consumo)) {
                        System.out.println("⚠️ Error: Valor duplicado. Ya se registró este consumo.");
                    } else if (consumo > 95) {
                        throw new ConsumoCriticoException("🔥 ¡Alerta! Consumo de CPU crítico detectado: " + consumo + "%");
                    } else {
                        System.out.println("✅ Registro de consumo exitoso: " + consumo + "%");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("🛑 Finalizando entrada de datos.");
                    break; // Salir del bucle si la entrada no es numérica
                } catch (ConsumoCriticoException e) {
                    System.err.println(e.getMessage());
                }
            }

            System.out.println("\n📊 Resumen de registros de consumo de CPU:");
            if (registrosCPU.isEmpty()) {
                System.out.println("   No se ingresaron registros.");
            } else {
                System.out.println("   Total de registros únicos: " + registrosCPU.size());
                System.out.println("   Registros: " + registrosCPU);
            }

        } finally {
            if (scanner != null) {
                scanner.close(); // Cerrar el Scanner en el bloque finally para asegurar la liberación de recursos
            }
            System.out.println("🚪 Finalizando el monitor de consumo de CPU.");
        }
    }
}
