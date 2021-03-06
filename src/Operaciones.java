import java.math.BigInteger;

public class Operaciones {

    public int num;

    public Operaciones(int valor) {
        this.num = valor;
    }

    public long toBase128() {
        String cadena = Integer.toString(num);
        int aux = cadena.length() - 1;
        long suma = 0;
        for (int i = 0; i < cadena.length(); i++) {
            suma = suma + (int) ((int) cadena.charAt(i) * Math.pow(128, aux));
            aux--;
        }
        return suma;
    }

    public int trunk() {
        BigInteger val = BigInteger.valueOf(toBase128() * toBase128());
        String aux = "";
        for (int i = 0; i < 2; i++) {
            aux = aux + val.toString().charAt(i);
        }
        return Integer.parseInt(aux);
    }

    public int pleg() {
        long valor = toBase128();
        long resultado = 0;
        while (valor > 0) {
            resultado = resultado + valor % 10;
            valor = valor / 10;
        }
        return (int) resultado;
    }
}
