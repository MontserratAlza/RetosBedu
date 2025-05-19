public class RegistroMuestras {

    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        ArrayList<String> ordenLlegadaMuestras = new ArrayList<>();
        ordenLlegadaMuestras.add("Homo sapiens");
        ordenLlegadaMuestras.add("Mus musculus");
        ordenLlegadaMuestras.add("Arabidopsis thaliana");
        ordenLlegadaMuestras.add("Homo sapiens");
        ordenLlegadaMuestras.add("Escherichia coli");
        ordenLlegadaMuestras.add("Mus musculus");

        System.out.println("🔬 Lista completa de muestras (orden de llegada):");
        for (String muestra : ordenLlegadaMuestras) {
            System.out.println("- " + muestra);
        }

        System.out.println("\n--------------------------------------------------");

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(ordenLlegadaMuestras);

        System.out.println("🧬 Especies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        System.out.println("\n--------------------------------------------------");

        // Paso 3: HashMap para asociar ID de muestra con investigador
        HashMap<String, String> asignacionInvestigadores = new HashMap<>();
        asignacionInvestigadores.put("M-001", "Dra. López");
        asignacionInvestigadores.put("M-002", "Dr. Hernández");
        asignacionInvestigadores.put("M-003", "Biol. Vargas");
        asignacionInvestigadores.put("M-004", "Dra. López");
        asignacionInvestigadores.put("M-005", "Dr. Ramírez");

        System.out.println("🧑‍🔬 Relación ID de muestra → Investigador:");
        for (Map.Entry<String, String> entry : asignacionInvestigadores.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        System.out.println("\n--------------------------------------------------");

        // Paso 4: Búsqueda por ID de muestra
        String idBusqueda = "M-002";
        if (asignacionInvestigadores.containsKey(idBusqueda)) {
            String investigador = asignacionInvestigadores.get(idBusqueda);
            System.out.println("🔍 Búsqueda por ID de muestra \"" + idBusqueda + "\":");
            System.out.println("   ID: " + idBusqueda + " está a cargo de: " + investigador);
        } else {
            System.out.println("⚠️ No se encontró ninguna muestra con el ID: " + idBusqueda);
        }
    }
}
