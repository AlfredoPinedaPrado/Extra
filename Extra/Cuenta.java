package Extra;

public class Cuenta {
    private String titular;
    private String PIN;
    private double saldo;
    private String numCuenta;
    private boolean estado;

    public Cuenta(String titular, String pin, double saldo, String numCuenta, boolean estado) {
        this.titular = titular;
        PIN = pin;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.estado = estado;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String pIN) {
        PIN = pIN;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public boolean inEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Operancion completada con exito");
        } else {
            System.out.println("La cantidad a ingresar debe de ser mayor a 0");
        }
    }

    public void retirar(double cantidad) {
        if (saldo - cantidad < 0) {
            System.out.println("No hay saldo suficiete para retirar");
        } else {
            saldo -= cantidad;
            System.out.println("La operacion se ha completado con exito");
        }
    }

}
