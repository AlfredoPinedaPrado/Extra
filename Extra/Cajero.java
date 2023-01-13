package Extra;

import java.util.Scanner;

public class Cajero {

    private static Cuenta cuenta = new Cuenta("Alfredo Pineda Prado", "1515", 1000, "12345678", true);
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int operacion = 0;

        while (operacion != 100) {
            System.out.println("| -- -- -- -- -- -- -- -- |");
            System.out.println("| ***CAJERO AUTOMATICO*** |");
            System.out.println("|  Alfredo Pineda Prado   |");
            System.out.println("| -- -- -- -- -- -- -- -- |\n");
            System.out.println("[1] Retirar saldo");
            System.out.println("[2] Depositar saldo");
            System.out.println("[3] Consultar saldo");
            System.out.println("[4] Baja");
            System.out.println("[5] Alta");
            System.out.println("[6] SALIR");
            System.out.print("Elija opcion: ");
            operacion = Integer.parseInt(keyboard.nextLine());
            switch (operacion) {
                case 1:
                    retirar();
                    break;
                case 2:
                    ingresar();
                    break;
                case 3:
                    consultarSaldo();
                    break;
                case 4:
                    baja();
                    break;
                case 5:
                    alta();
                    break;
                case 6:
                    System.out.println("PROGRAMA FINALIZADO");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPERACION INVALIDA");
            }
        }
    }

    // Realizamos los codigos para retirar,depositar y autenticar la cuneta

    private static void retirar() {
        System.out.println();
        System.out.println("Ingrese los digitos de la targeta");
        String numCuenta = keyboard.nextLine();
        System.out.println("Ingrese el nip");
        String PIN = keyboard.nextLine();
        if (!cuenta.getNumCuenta().equals(numCuenta) || !cuenta.getPIN().equals(PIN) || !cuenta.inEstado() == true) {
            System.out.println();
            System.out.println("No exixte cuenta registrada, datos incorrectos");
        } else {
            if (cuenta.getSaldo() <= 0) {
                System.out.println("La cuenta no tiene fondos su saldo actual es de: " + cuenta.getSaldo());
            } else {
                System.out.println("Ingrese la cantidad deseada a retirar su saldo es de:" + cuenta.getSaldo());
                double cantidad = Double.parseDouble(keyboard.nextLine());
                cuenta.retirar(cantidad);
                System.out.println("Saldo actual:" + cuenta.getSaldo());
                System.out.println("***RETIRO EXITOSO***");
            }
        }
    }

    private static void ingresar() {
        System.out.println();
        System.out.println("Ingrese los digitos de la targeta");
        String numCuenta = keyboard.nextLine();
        if (!cuenta.getNumCuenta().equals(numCuenta) || !cuenta.inEstado() == true) {
            System.out.println();
            System.out.println("No exixte cuenta registrada, datos incorrectos");
        } else {
            System.out.println();
            System.out.println("Titular:" + cuenta.getTitular());
            System.out.print("\nCantidad a ingresar: ");
            double cantidad = Double.parseDouble(keyboard.nextLine());
            cuenta.ingresar(cantidad);
            System.out.println("***DEPOSITO EXITOSO***");
        }
    }

    private static void consultarSaldo() {
        System.out.println();
        System.out.println("Ingrese los digitos de la targeta");
        String numCuenta = keyboard.nextLine();
        System.out.println("Ingrese el nip");
        String PIN = keyboard.nextLine();
        if (!cuenta.getNumCuenta().equals(numCuenta) || !cuenta.getPIN().equals(PIN) || !cuenta.inEstado() == true) {
            System.out.println();
            System.out.println("No exixte cuenta registrada, datos incorrectos");
        } else {
            System.out.println("\nEl saldo actual es: " + cuenta.getSaldo());
        }
    }

    private static void baja() {
        System.out.println();
        System.out.println("Ingrese los digitos de la targeta");
        String numCuenta = keyboard.nextLine();
        System.out.println("Ingrese el nip");
        String PIN = keyboard.nextLine();
        if (!cuenta.getNumCuenta().equals(numCuenta) || !cuenta.getPIN().equals(PIN) || !cuenta.inEstado() == true) {
            System.out.println();
            System.out.println("No exixte cuenta registrada, datos incorrectos");
        } else {
            if (cuenta.getSaldo() > 0) {
                System.out.println("La cuenta con fondos su saldo actual es de: " + cuenta.getSaldo());
            } else {
                cuenta.setEstado(false);
                System.out.println("Cuenta temporalmente inactiva");
            }
        }
    }

    private static void alta() {
        System.out.println();
        System.out.println("Ingrese los digitos de la targeta");
        String numCuenta = keyboard.nextLine();
        System.out.println("Ingrese el nip");
        String PIN = keyboard.nextLine();
        if (!cuenta.getNumCuenta().equals(numCuenta) || !cuenta.getPIN().equals(PIN) || !cuenta.inEstado() == false) {
            System.out.println();
            System.out.println("No exixte cuenta registrada, datos incorrectos");
        } else {
            cuenta.setEstado(true);
            System.out.println("Cuenta activa");

        }
    }
}