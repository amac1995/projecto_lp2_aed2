package projeto;

import projeto.recursos_alt.SeparateChainingHashST;

public class Linhas {

    private static int ACTUAL_ID = 249;
    private int idLinha;
    private double capacidade;

    private SeparateChainingHashST<Integer, Habitacao> listaHabitacoes = new SeparateChainingHashST<>();

    public Linhas(double capacidade) {
        this.setIdLinha(++ACTUAL_ID);
        this.setCapacidade(capacidade);
    }


    public void addHabit(Habitacao habitacao) {
        this.getListaHabitacoes().put(habitacao.getIdHab(), habitacao);
    }


    public void printHabit() {
        for (int h: getListaHabitacoes().keys()) {
            System.out.println("Habitação " + h +" : " + getListaHabitacoes().get(h) + "\n");
        }
    }


    public static int getActualId() {
        return ACTUAL_ID;
    }

    public static void setActualId(int actualId) {
        ACTUAL_ID = actualId;
    }
    public SeparateChainingHashST<Integer, Habitacao> getListaHabitacoes() {
        return listaHabitacoes;
    }

    public void setListaHabitacoes(SeparateChainingHashST<Integer, Habitacao> listaHabitacoes) {
        this.listaHabitacoes = listaHabitacoes;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }
}
