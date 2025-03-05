package org.example;

public class CuentaBancaria {
    private String titular;
    private final String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío.");
        }
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = Math.max(saldoInicial, 0);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println(titular + " sea depositado $" + String.format("%.2f", cantidad) + ". Nuevo saldo: $" + String.format("%.2f", saldo));
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Sin  insuficientes para " + titular + ".");
        } else {
            saldo -= cantidad;
            System.out.println(titular + " ha retirado $" + String.format("%.2f", cantidad) + ". Nuevo saldo: $" + String.format("%.2f", saldo));
        }
    }

    public void mostrarInformacion() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + String.format("%.2f", saldo));

    }
}

