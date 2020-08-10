package projeto;

import projeto.recursos_alt.*;

public class PostoDistribuicao{

    private double wattPedido;
    private double wattAtual;
    private String idDPS;
    private int idDP;
    private static int ACTUAL_ID = 005;

    //Mais rapido aceder aos valores do array
    private SeparateChainingHashST<Integer, FonteEnergia> listaFonte = new SeparateChainingHashST<>();
    private SeparateChainingHashST<Integer, Zona> listaZonas = new SeparateChainingHashST<>();



    public PostoDistribuicao(double wattAtual) {
        this.wattPedido = 0;
        this.wattAtual = wattAtual;
        this.setIdDPS(("PD" + ++ACTUAL_ID));
        this.setIdDP(ACTUAL_ID);
    }

    public PostoDistribuicao(double wattAtual, int idDP) {
        this.wattPedido = 0;
        this.wattAtual = wattAtual;
        this.setIdDPS(("PD" +idDP));
        this.setIdDP(idDP);
    }

    public void saveZones(){
        Out out = new Out("data/zonas.txt");
        for (int h: getListaZonas().keys()) {
            out.print(getListaZonas().get(h)+"\n");
        }
        out.close();
    }

    public void savePSU(){
        Out out = new Out("data/psu.txt");
        for (int h: getListaFonte().keys()) {
            out.print(getListaFonte().get(h)+"\n");
        }
        out.close();
    }

    //Métodos
    public void printZona() {
        String zonas= new String();
        for (int h: getListaZonas().keys()) {
            zonas = zonas + getListaZonas().get(h);
            System.out.println(getListaZonas().get(h));
        }
    }

    public void printZona(int id) {
            System.out.println(getListaZonas().get(id));
    }

    public double consumptionHab(Habitacao habitacao) {
        return 0.0;
    }



    public void addPS(FonteEnergia fonte) {

        this.getListaFonte().put(fonte.getIdPS(), fonte);
    }

    public void addZona(Zona zona) {

        this.getListaZonas().put(zona.getIdZona(), zona);
    }


    public void  printPS() {
        for (int h: getListaFonte().keys()) {
            System.out.println(getListaFonte().get(h));
        }
    }

    /*public void delLinha(Linhas linhas) {
        listaZonas.delete(linhas.get.getIdZona());
    }*/

    public void delZona(Zona zona) {
        getListaZonas().delete(zona.getIdZona());
    }

    public void delPS(FonteEnergia fonte) {
        getListaFonte().delete(fonte.getIdPS());
    }

    public double consumptionHab() {
        return 0.0;
    }

    //Gets e Sets

    public double getWattPedido() {
        return wattPedido;
    }

    public void setWattPedido(double wattPedido) {
        this.wattPedido = wattPedido;
    }

    public double getWattAtual() {
        return wattAtual;
    }

    public void setWattAtual(double wattAtual) {
        this.wattAtual = wattAtual;
    }


    public String getIdDPS() {
        return idDPS;
    }

    public void setIdDPS(String idDPS) {
        this.idDPS = idDPS;
    }

    public int getIdDP() {
        return idDP;
    }

    public void setIdDP(int idDP) {
        this.idDP = idDP;
    }

    public SeparateChainingHashST<Integer, FonteEnergia> getListaFonte() {
        return listaFonte;
    }

    public void setListaFonte(SeparateChainingHashST<Integer, FonteEnergia> listaFonte) {
        this.listaFonte = listaFonte;
    }

    public SeparateChainingHashST<Integer, Zona> getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(SeparateChainingHashST<Integer, Zona> listaZonas) {
        this.listaZonas = listaZonas;
    }

    @Override
    public String toString() {
        return "PostoDistribuicao{" +
                "wattPedido=" + wattPedido +
                ", wattAtual=" + wattAtual +
                ", idDPS='" + idDPS + '\'' +
                ", idDP=" + idDP +
                ", listaFonte=" + listaFonte +
                ", listaZonas=" + listaZonas +
                '}';
    }
}