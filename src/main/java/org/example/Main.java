package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CuentaBancaria> cuentas = new ArrayList<>();

        // Crear cuentas
        cuentas.add(new CuentaBancaria("Wilson Gomez", "12356343", 100000));
        cuentas.add(new CuentaBancaria("Paula Gómez", "12464546", 34000));
        cuentas.add(new CuentaBancaria("Cristian Cano", "13247578", 1000));


        System.out.println("\n Cuentas");
        mostrarCuentas(cuentas);

        while (true) {
            System.out.print("\nIngrese el número de cuenta");
            String numeroCuentaIngresado = scanner.nextLine();

            if (numeroCuentaIngresado.equalsIgnoreCase("salir")) {
                System.out.println("Salio");
                break;
            }

            CuentaBancaria cuentaSeleccionada = null;
            for (CuentaBancaria cuenta : cuentas) {
                if (cuenta.getNumeroCuenta().equals(numeroCuentaIngresado)) {
                    cuentaSeleccionada = cuenta;
                    break;
                }
            }


            if (cuentaSeleccionada != null) {
                cuentaSeleccionada.mostrarInformacion();


                int opcion = 0;
                while (opcion != 1 && opcion != 2) {
                    System.out.print("\nSeleccione una opción 1 Depositar, 2 Retirar ");
                    if (scanner.hasNextInt()) {
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        if (opcion != 1 && opcion != 2) {
                            System.out.println("Eror Intente de Nuevo");
                        }
                    } else {
                        System.out.println("Ingrese un número válido.");
                        scanner.nextLine();
                    }
                }


                System.out.print("Ingrese cantidad: ");
                if (scanner.hasNextDouble()) {
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine();

                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor a 0");
                    } else {
                        if (opcion == 1) {
                            cuentaSeleccionada.depositar(cantidad);
                        } else {
                            cuentaSeleccionada.retirar(cantidad);
                        }
                        cuentaSeleccionada.mostrarInformacion();
                    }
                } else {
                    System.out.println("Debe ingresar un número válido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Número de cuenta no encontrado");
            }
        }

        scanner.close();
    }

    public static void mostrarCuentas(List<CuentaBancaria> cuentas) {
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.mostrarInformacion();
        }
    }
}






