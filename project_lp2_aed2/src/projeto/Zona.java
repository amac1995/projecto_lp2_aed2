package projeto;

import projeto.recursos_alt.SeparateChainingHashST;

public class Zona {
    private static int ACTUAL_ID = 380;
    private int idZona;
    private String nome;
    private int zip;

    private SeparateChainingHashST<Integer, Linhas> listaLinhas = new SeparateChainingHashST<>();

    public Zona(String nome, int zip) {
        this.nome = nome;
        this.zip = zip;
        this.idZona=ACTUAL_ID++;
    }


    public void addLinha(Linhas linhas){

        this.getListaLinhas().put(linhas.getIdLinha(), linhas);    }

    public void printLinha(){
            for (int l: getListaLinhas().keys()) {
                System.out.println("Habitação " + l +" : " + getListaLinhas().get(l) + "\n");
            }
    }


    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return  "Zona: " + idZona +
                "\t|\t nome='" + nome + '\'' +
                "\t|\t zip=" + zip;
    }


    public SeparateChainingHashST<Integer, Linhas> getListaLinhas() {
        return listaLinhas;
    }

    public void setListaLinhas(SeparateChainingHashST<Integer, Linhas> listaLinhas) {
        this.listaLinhas = listaLinhas;
    }
}
