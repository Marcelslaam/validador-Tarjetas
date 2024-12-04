public class Tarjeta {
    public String numeroTarjeta;
    public String numImpar;
    public boolean validador;
    public String tipoTarjeta;

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumImpar() {
        return numImpar;
    }

    public void setNumImpar(String numImpar) {
        this.numImpar = numImpar;
    }

    public boolean isValidador() {
        return validador;
    }

    public void setValidador(boolean validador) {
        this.validador = validador;
    }

}
