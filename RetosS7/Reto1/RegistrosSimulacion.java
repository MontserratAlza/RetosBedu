public class RegistroSimulacion {

    private static final String NOMBRE_ARCHIVO = "parametros.txt";
    private static final String NOMBRE_CARPETA = "config";

    public static void main(String[] args) {
        Path rutaArchivo = Paths.get(NOMBRE_CARPETA, NOMBRE_ARCHIVO);

        guardarParametros(rutaArchivo);
        verificarArchivo(rutaArchivo);
        leerParametros(rutaArchivo);
    }

    private static void guardarParametros(Path rutaArchivo) {
        try {
            // Crear la carpeta config si no existe
            if (!Files.exists(rutaArchivo.getParent())) {
                Files.createDirectories(rutaArchivo.getParent());
                System.out.println("📁 Carpeta '" + NOMBRE_CARPETA + "' creada.");
            }

            // Definir los parámetros de simulación
            String parametros = "Tiempo de ciclo: 55.8 segundos\n" +
                                "Velocidad de línea: 1.2 m/s\n" +
                                "Número de estaciones: 8";

            // Guardar los parámetros en el archivo
            Files.writeString(rutaArchivo, parametros);
            System.out.println("💾 Parámetros de simulación guardados en: " + rutaArchivo.toString());

        } catch (IOException e) {
            System.err.println("❌ Error al guardar los parámetros en el archivo: " + e.getMessage());
        }
    }

    private static void verificarArchivo(Path rutaArchivo) {
        if (Files.exists(rutaArchivo)) {
            System.out.println("✅ El archivo de configuración existe en: " + rutaArchivo.toString());
        } else {
            System.out.println("⚠️ El archivo de configuración no se encontró en: " + rutaArchivo.toString());
        }
    }

    private static void leerParametros(Path rutaArchivo) {
        if (Files.exists(rutaArchivo)) {
            try {
                String contenido = Files.readString(rutaArchivo);
                System.out.println("\n📜 Contenido del archivo de configuración:");
                System.out.println(contenido);
            } catch (IOException e) {
                System.err.println("❌ Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ No se puede leer el archivo porque no existe.");
        }
    }
}
