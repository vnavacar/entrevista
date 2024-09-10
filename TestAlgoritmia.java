import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

class Persona {
    char sexo;  // 'M' para masculino, 'F' para femenino
    int edad;

    public Persona(char sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
    }
}

public class TestAlgoritmia {

    public static void ParOInpar(){
        Scanner scanner = new Scanner(System.in);
        int NUMERO = 0;
        System.out.print("LEER NUMERO: ");



        /*
        NUMERO = scanner.nextInt();
    
        if ((NUMERO & 1) == 0) { // Si el último bit es 0, es par
            System.out.println("El número es par. Números pares descendientes:");
            for (int i = NUMERO; i >= 0; i -= 2) {
                System.out.println(i);
            }
        } else { // Si el último bit es 1, es impar
            System.out.println("El número es impar. Números impares descendientes:");
            for (int i = NUMERO; i >= 1; i -= 2) {
                System.out.println(i);
            }
        }
        */

        while (true) {
            try {
                System.out.print("LEER NUMERO: ");
                NUMERO = scanner.nextInt(); 
                break;  
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                scanner.next();  // Limpiar el buffer del scanner
            }
        }

        // Verificar si el número es par o impar
        if ((NUMERO & 1) == 0) {  // Si el último bit es 0, es par
            System.out.println("El número es par. Números pares descendientes:");
            for (int i = NUMERO; i >= 0; i -= 2) {
                System.out.println(i);
            }
        } else {  // Si el último bit es 1, es impar
            System.out.println("El número es impar. Números impares descendientes:");
            for (int i = NUMERO; i >= 1; i -= 2) {
                System.out.println(i);
            }
        }

    }


    

    

    public static void leerPersonas(Persona[] personas) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        

        // Preguntar al usuario si desea introducir personas manualmente o generarlas automáticamente
        while (true) {
            try {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Introducir personas manualmente");
                System.out.println("2. Generar personas automáticamente");
                System.out.print("Opción: ");
                opcion = scanner.nextInt();

                if (opcion == 1) {
                    leerPersonasManual(personas, scanner);
                    break;
                } else if (opcion == 2) {
                    generarPersonasAleatorias(personas);
                    break;
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();  // Limpiar buffer
            }
        }
    }

    public static void leerPersonasManual(Persona[] personas, Scanner scanner) {
        System.out.println("Ingrese los datos de las personas:");

        for (int i = 0; i < 50; i++) {
            char sexo = ' ';
            int edad = 0;

            while (true) {
                try {
                    System.out.print("Sexo de la persona " + (i + 1) + " (M/F): ");
                    sexo = scanner.next().toUpperCase().charAt(0);
                    if (sexo == 'M' || sexo == 'F') {
                        break;
                    } else {
                        System.out.println("Error: Debe ingresar 'M' o 'F'.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Entrada inválida.");
                    scanner.next();  // Limpiar buffer
                }
            }

            while (true) {
                try {
                    System.out.print("Edad de la persona " + (i + 1) + ": ");
                    edad = scanner.nextInt();
                    if (edad >= 0 && edad <= 120) {
                        break;
                    } else {
                        System.out.println("Error: La edad debe estar entre 0 y 120.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    scanner.next();  // Limpiar buffer
                }
            }

            personas[i] = new Persona(sexo, edad);
        }
    }


    public static void generarPersonasAleatorias(Persona[] personas) {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            char sexo = random.nextBoolean() ? 'M' : 'F';  // Aleatorio entre 'M' y 'F'
            int edad = random.nextInt(100);  // Edad aleatoria entre 0 y 99
            personas[i] = new Persona(sexo, edad);
        }
    }


    public static void ClasificacionPersonas(){


        System.out.println("Clasificacion de personas");




        Persona[] personas = new Persona[50];


        leerPersonas(personas);
        /* 
        // Leer los datos de las 50 personas, introduciendolos manualmente, mucho trabajo

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 50; i++) {
            System.out.println("LEER PERSONA " + (i + 1) + ":");
            System.out.print("Sexo (M/F): ");
            char sexo = scanner.next().toUpperCase().charAt(0);
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            personas[i] = new Persona(sexo, edad);
        }

        scanner.close();

        */

        /*
        // Rellenar los datos de las 50 personas aleatoriamente, mucho mas rapido
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            char sexo = random.nextBoolean() ? 'M' : 'F';  // Aleatorio entre 'M' y 'F'
            int edad = random.nextInt(100);  // Edad aleatoria entre 0 y 99
            personas[i] = new Persona(sexo, edad);
        } */

        int mayoresDeEdad = 0;
        int menoresDeEdad = 0;
        int masculinosMayores = 0;
        int femeninasMenores = 0;
        int totalMujeres = 0;

        for (Persona persona : personas) {
            if (persona.edad >= 18) {
                mayoresDeEdad++;
                if (persona.sexo == 'M') {
                    masculinosMayores++;
                }
            } else {
                menoresDeEdad++;
                if (persona.sexo == 'F') {
                    femeninasMenores++;
                }
            }

            if (persona.sexo == 'F') {
                totalMujeres++;
            }
        }

        // Cálculos porcentuales
        double porcentajeMayores = (mayoresDeEdad / 50.0) * 100;
        double porcentajeMujeres = (totalMujeres / 50.0) * 100;

        // Mostrar resultados
        System.out.println("Resultados:");
        System.out.println("a. Cantidad de personas mayores de edad: " + mayoresDeEdad);
        System.out.println("b. Cantidad de personas menores de edad: " + menoresDeEdad);
        System.out.println("c. Cantidad de personas masculinas mayores de edad: " + masculinosMayores);
        System.out.println("d. Cantidad de personas femeninas menores de edad: " + femeninasMenores);
        System.out.println("e. Porcentaje de personas mayores de edad: " + String.format("%.2f", porcentajeMayores) + "%");
        System.out.println("f. Porcentaje de mujeres respecto al total de personas: " + String.format("%.2f", porcentajeMujeres) + "%");



    }

    public static void CalculoSalario(){

        Scanner scanner = new Scanner(System.in);
        int horasTrabajadas = 0;
        double tarifa = 0.0;
        
        while (true) {
            try {
                System.out.print("LEER HORASTRABAJADAS: ");
                horasTrabajadas = scanner.nextInt();
                
                if (horasTrabajadas < 0) {
                    System.out.println("Las horas trabajadas no pueden ser negativas. Intente de nuevo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido para las horas trabajadas.");
                scanner.next(); // Limpiar el buffer para evitar bucle infinito
            }
        }

        while (true) {
            try {
                System.out.print("LEER TARIFA: ");
                tarifa = scanner.nextDouble();
                
                if (tarifa < 0) {
                    System.out.println("La tarifa no puede ser negativa. Intente de nuevo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido para la tarifa.");
                scanner.next(); // Limpiar el buffer para evitar bucle infinito
            }
        }
        double sueldo = 0;

        // Calcular el salario dependiendo de las horas trabajadas
        if (horasTrabajadas <= 40) {
            sueldo = horasTrabajadas * tarifa;
        } else {
            int horasExtras = horasTrabajadas - 40;
            sueldo = (40 * tarifa) + (horasExtras * tarifa * 1.5); // 50% más por horas extras
        }

        // Mostrar el sueldo
        System.out.println("El sueldo recibido es: " + sueldo);

        scanner.close();

    }

    public static void main(String[] args) {
        
        ParOInpar();
        ClasificacionPersonas();
        CalculoSalario();


}



}