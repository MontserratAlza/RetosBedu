public class AnalizadorDeLogs {

    private static final String NOMBRE_ARCHIVO_LOGS = "errores.log";
    private static final String NOMBRE_ARCHIVO_FALLOS = "registro_fallos.txt";

    public static void main(String[] args) {
        Path rutaArchivoLogs = Paths.get(NOMBRE_ARCHIVO_LOGS);
        analizarArchivoLogs(rutaArchivoLogs);
    }

    private static void analizarArchivoLogs(Path rutaArchivoLogs) {
        int totalLineas = 0;
        int contadorErrores = 0;
        int contadorAdvertencias = 0;

        try (BufferedReader lector = Files.newBufferedReader(rutaArchivoLogs)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                if (linea.contains("ERROR")) {
                    contadorErrores++;
                } else if (linea.contains("WARNING")) {
                    contadorAdvertencias++;
                }
            }

            System.out.println("📊 Resumen del análisis de logs:");
            System.out.println("   Total de líneas leídas: " + totalLineas);
            System.out.println("   Cantidad de errores encontrados: " + contadorErrores);
            System.out.println("   Cantidad de advertencias encontradas: " + contadorAdvertencias);

            if (totalLineas > 0) {
                double porcentajeErrores = (double) contadorErrores / totalLineas * 100;
                double porcentajeAdvertencias = (double) contadorAdvertencias / totalLineas * 100;
                System.out.printf("   Porcentaje de líneas con errores: %.2f%%\n", porcentajeErrores);
                System.out.printf("   Porcentaje de líneas con advertencias: %.2f%%\n", porcentajeAdvertencias);
            } else {
                System.out.println("   No se encontraron líneas en el archivo.");
            }

        } catch (IOException e) {
            System.err.println("⚠️ ¡Ocurrió un problema al leer el archivo de logs!");
            registrarFallo(e.getMessage());
        }
    }

    private static void registrarFallo(String mensajeError) {
        Path rutaArchivoFallos = Paths.get(NOMBRE_ARCHIVO_FALLOS);
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivoFallos.toFile(), true))) {
            escritor.write("Error al analizar " + NOMBRE_ARCHIVO_LOGS + " el " + java.time.LocalDateTime.now() + ": " + mensajeError);
            escritor.newLine();
            System.err.println("   El error se ha registrado en: " + rutaArchivoFallos.toString());
        } catch (IOException ex) {
            System.err.println("   ¡No se pudo registrar el fallo en " + rutaArchivoFallos.toString() + "! Error: " + ex.getMessage());
        }
    }
}
