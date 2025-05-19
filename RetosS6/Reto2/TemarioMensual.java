class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Tema{" +
               "titulo='" + titulo + '\'' +
               ", prioridad=" + prioridad +
               '}';
    }

    @Override
    public int compareTo(Tema otroTema) {
        return this.titulo.compareTo(otroTema.titulo);
    }
}

public class TemarioMensual {
    public static void main(String[] args) {
        // ✅ Gestionar los temas activos usando una lista concurrente
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();
        temasActivos.add(new Tema("Lectura comprensiva", 2));
        temasActivos.add(new Tema("Matemáticas básicas", 1));
        temasActivos.add(new Tema("Cuidado del medio ambiente", 3));
        temasActivos.add(new Tema("Expresión oral", 2));
        temasActivos.add(new Tema("Ciencias naturales", 1));

        System.out.println("📚 Temario activo (orden de adición):");
        temasActivos.forEach(System.out::println);

        System.out.println("\n--------------------------------------------------");

        // 📊 Ordenar los temas por nombre (alfabético)
        temasActivos.sort(Tema::compareTo);
        System.out.println("📊 Temario ordenado alfabéticamente:");
        temasActivos.forEach(System.out::println);

        System.out.println("\n--------------------------------------------------");

        // 📊 Ordenar los temas por prioridad (orden ascendente)
        temasActivos.sort(Comparator.comparingInt(Tema::getPrioridad));
        System.out.println("📊 Temario ordenado por prioridad (ascendente):");
        temasActivos.forEach(System.out::println);

        System.out.println("\n--------------------------------------------------");

        // 📚 Mantener un repositorio concurrente de materiales asociados a cada tema
        ConcurrentHashMap<String, String> repositorioRecursos = new ConcurrentHashMap<>();
        repositorioRecursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        repositorioRecursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        repositorioRecursos.put("Cuidado del medio ambiente", "https://recursos.edu/ambiente");
        repositorioRecursos.put("Expresión oral", "https://recursos.edu/oral");
        repositorioRecursos.put("Ciencias naturales", "https://recursos.edu/ciencias");

        System.out.println("📚 Repositorio de materiales por tema:");
        repositorioRecursos.forEach((tema, recurso) -> System.out.println("Tema: " + tema + " - Recurso: " + recurso));
    }
}
