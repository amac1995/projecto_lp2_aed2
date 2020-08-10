package projeto;

import projeto.recursos_alt.RedBlackBST;

public class Equipamento extends Consumos {

    private int idEquip;

    private String nome;

    private Boolean consumidor;

    private RedBlackBST<Date, Consumos> consumo = new RedBlackBST<>();

    public Equipamento(int idEquip, String nome, double wattH) {
        super(wattH, false);
        this.setIdEquip(idEquip);
        this.setNome(nome);
        Date date = new Date();
        this.getConsumo().put(date, this.getConsumo().get(date));
        this.consumidor= consumidor;
    }

    //Métodos
    public void lastConsumption(){
        if(this.getConsumo().get(this.getConsumo().max()).isEstado()==false){
            //this.consumo.max().
        }
        this.getConsumo().get(this.getConsumo().max());
        System.out.println("\n\nlistEstado: " + this.getConsumo().get(this.getConsumo().max()) + "\n\n");
    }




    public void lastState(){
        System.out.println("\n\nlistEstado: " + this.getConsumo().get(this.getConsumo().max()) + "\n\n");
    }

    //Gets e Sets
    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  "\n\tID do Equipamento: " + idEquip +
                "\n\tNome: " + nome  +
                "\n\tConsumo por hora: " + this.getConsumoAtual() + "watts" +
                "\n";
    }

    public RedBlackBST<Date, Consumos> getConsumo() {
        return consumo;
    }

    public void setConsumo(RedBlackBST<Date, Consumos> consumo)  {
        this.consumo = consumo;
    }

    public RedBlackBST<Date, Consumos> getEstado() {
        return this.consumo;
    }

    public void setEstado(RedBlackBST<Date, Consumos> consumo) {
        this.consumo = consumo;
    }
}