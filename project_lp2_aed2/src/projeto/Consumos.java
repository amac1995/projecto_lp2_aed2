package projeto;

public  class Consumos {

    private double consumoAtual;
    private boolean estado;

    public Consumos(double consumoAtual, boolean estado) {
        this.consumoAtual = consumoAtual;
        this.estado = estado;
    }

    public Consumos() {
        this.consumoAtual = 0;
        this.estado = false;
    }

    public double getConsumoAtual() {
        return consumoAtual;
    }

    public void setConsumoAtual(double consumoAtual) {
        this.consumoAtual = consumoAtual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //private RedBlackBST<Estado, Double> consumoHist = new RedBlackBST<>();


    @Override
    public String toString() {
        return "Consumos{" +
                "consumoAtual=" + consumoAtual +
                ", estado=" + estado +
                '}';
    }
}