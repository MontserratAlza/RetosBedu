public class Cajero {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 
        var saldo = 1000.0; // Saldo inicial
        int opcion;
        do {
            // Mostrar menú de opciones
            System.out.println("\nBienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt(); // Leer la opción elegida por el usuario

            switch (opcion) {
                case 1 -> {
                    System.out.println("Tu saldo actual es: $" + saldo);
                }
                case 2 -> {
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("El monto debe ser mayor a 0.");
                        continue; // Volver al menú sin modificar el saldo
                    }

                    saldo += deposito; 
                    System.out.println("Depósito realizado. Tu Saldo actualizado: $" + saldo);
                }
                case 3 -> {
                    // Retirar dinero
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();

                    if (retiro <= 0) {
                        System.out.println("El monto debe ser mayor a 0.");
                        continue; // Volver al menú sin hacer nada
                    }

                    if (retiro > saldo) {
                        System.out.println("Saldo insuficiente. Tu saldo es: $" + saldo);
                    } else {
                        saldo -= retiro; // Restar el monto del saldo
                        System.out.println("Retiro exitoso. Saldo restante: $" + saldo);
                    }
                }
                case 4 -> {
                    // Salir del programa
                    System.out.println("Gracias por usar el cajero. ¡Hasta pronto!");
                }
                default -> {
                    // Opción no válida
                    System.out.println("Opción inválida. Intenta nuevamente.");
                }
            }

        } while (opcion != 4); 

        scanner.close(); 
    }
