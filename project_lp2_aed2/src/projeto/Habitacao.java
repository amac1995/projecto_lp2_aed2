package projeto;

import java.util.ArrayList;

public class Habitacao extends Consumos{

    private static int ACTUAL_ID = 199;
    private int potenciaContratada;
    private String idHabS;
    private int idHab;
    private ArrayList<Equipamento> listaEquipamento = new ArrayList<>();


    //Construtores

    public Habitacao(Integer potenciaContratada) {
        this.setPotenciaContratada(potenciaContratada);
        this.setIdHabS("HAB"+(++ACTUAL_ID));
        this.setIdHab(ACTUAL_ID);
    }

    public Habitacao(Integer potenciaContratada, int idHab) {
        this.setPotenciaContratada(potenciaContratada);
        this.setIdHab(idHab);
        this.setIdHabS("Hab"+idHab);
    }


    //Metodos

    public ArrayList pesquisaEquip(String nome){
        ArrayList resultado=new ArrayList();
        for (Equipamento e: getListaEquipamento()) {

            if (e.getNome().contains(nome)) {
                resultado.add(e);
            }

        }
        return resultado;
    }

    public void  deleteEquip(Equipamento e){
        this.getListaEquipamento().remove(e);
    }

    public void editEquip(int idEqip, String nome, boolean consumidor, double wattH){
        for (Equipamento e: getListaEquipamento()) {
            if (e.getIdEquip()==idEqip){
                e.setNome(nome);
                e.setConsumoAtual(wattH);
                Date d = new Date();
                Consumos c = new Consumos(wattH, false);
                e.getEstado().put(d, c);
                break;
            }

        }
    }

   public void addestado(Equipamento e, boolean offOn){
        Date d = new Date();
        Consumos c = new Consumos(e.getConsumoAtual(), offOn);
        if (offOn==false) {
            e.getEstado().put(d, c);
            return;
        }
        /*try {
            if (overLoad(e.getConsumoAtual())==false) {
                e.getEstado().put(d, c);
            }
        } catch (ConsumoExcedido consumoExcedido) {
            consumoExcedido.printStackTrace();
        }*/
    }

    public void addestado(Equipamento e, boolean offOn, Date d){
        Consumos c = new Consumos(e.getConsumoAtual(), offOn);
        if (offOn==false) {
            e.getEstado().put(d, c);
            return;
        }
        /*try {
            if (overLoad(e.getConsumoAtual())==false) {
                e.getEstado().put(d, c);
            }
        } catch (ConsumoExcedido consumoExcedido) {
            consumoExcedido.printStackTrace();
        }*/
    }

    public void changeWattEquip(int idEqip, double wattH){
        for (Equipamento e: getListaEquipamento()) {
            if ((e.getIdEquip()==idEqip)){
                Date d = new Date();
                Consumos c = new Consumos(wattH, false);
                e.getEstado().put(d, c);
                break;
            }
        }
    }

    public void addEquip(Equipamento e) {
        this.getListaEquipamento().add(e);

       /* try {
            overLoad(e.getWattH());
        } catch (ConsumoExcedido consumoExcedido) {
            consumoExcedido.getMessage();
            e.addestado(false);
        }*/
    }

    /*public void drawConsumo(){
        for (int i:listaHabitacoes.keys()) {
            drawRedBlackTreeStringKeys(listaHabitacoes);
            while (!StdDraw.mousePressed());
            while (StdDraw.mousePressed());
        }
    }*/

    public void consumption(Equipamento e) {

        Date dateOld = new Date();
        while(!e.getConsumo().isEmpty()){
            for (Date d: e.getConsumo().keys()) {
                if(e.getConsumo().get(d).isEstado()==true){
                    dateOld = d;
                    System.out.println("\nOn : " + d);
                } else {
                    d.diferenceHour(d, dateOld);
                    System.out.println("\nOff : " + d + "Consumo: " + (d.diferenceHour(d, dateOld)*e.getConsumo().get(e.getConsumo().max()).getConsumoAtual()));
                }
            }
        }
    }

   /* public double consumption() {
        double consumption = 0;
        for (Equipamento e:listaEquipamento) {
            if (){
                consumption+=e.getConsumoAtual();
            }
        }
        return consumption;
    }*/

    /*public boolean overLoad() throws ConsumoExcedido {
        if(potenciaContratada<consumption()){
            throw new ConsumoExcedido("Consumo excedeu a potencia contratada");
        }
        return false;
    }

    public boolean overLoad(double cons) throws ConsumoExcedido {
        if(potenciaContratada<(consumption()+cons)){
            throw new ConsumoExcedido("Consumo excedeu a potencia contratada");
        }
        return false;
    }*/

    public void printEquip() {
        ArrayList resultado=new ArrayList();
        for (Equipamento e: getListaEquipamento()) {
            System.out.println(e);
        }
    }


    //Gets e Sets

    public int getPotenciaContratada() {
        return potenciaContratada;
    }

    public void setPotenciaContratada(Integer potenciaContratada) {
        this.potenciaContratada = potenciaContratada;
    }

    public String getIdHabS() {
        return idHabS;
    }

    public void setIdHabS(String idHabS) {
        this.idHabS = idHabS;
    }

    public int getIdHab() {
        return idHab;
    }

    public void setIdHab(int idHab) {
        this.idHab = idHab;
    }

    public ArrayList<Equipamento> getListaEquipamento() {
        return listaEquipamento;
    }

    public void setListaEquipamento(ArrayList<Equipamento> listaEquipamento) {
        this.listaEquipamento = listaEquipamento;
    }

    @Override
    public String toString() {
        return  "\n\tPotencia Contratada: " + potenciaContratada +
                "\n\tID Hab: " + getIdHab() +
                "\n\tListaEquipamento:\n\t" + getListaEquipamento();
    }


}