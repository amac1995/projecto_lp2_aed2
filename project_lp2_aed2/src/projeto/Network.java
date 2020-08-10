package projeto;

import projeto.recursos_alt.RedBlackBST;
import projeto.recursos_alt.SeparateChainingHashST;


public class Network {

    private static int ACTUAL_ID = 000;
    private SeparateChainingHashST<Integer, PostoDistribuicao> listaPd = new SeparateChainingHashST<>();
    private int id;
    private String name;

    Network(String name) {
        this.id = ACTUAL_ID++;
        this.setName(name);
    }


    public void translateNodes(RedBlackBST node) {
        for (int i1 = 0; i1 < node.size(); i1++) {
            for (int i = 0; i < listaPd.size(); i++) {
                for (int x = 0; i < listaPd.get(i).getListaZonas().size(); i++) {
                    for (Object s : node.keys()) {
                        if (listaPd.get(i).getListaZonas().get(x).equals(s)) {
                            System.out.println(s + " " + listaPd.get(i).getListaZonas().get(x));
                        }
                        //System.out.println((s + " " + node.get((Comparable) s)));
                    }
                }
            }
            /*for (Object s : node.keys()) {
                System.out.println((s + " " + node.get((Comparable) s)));
            }*/
        }
    }

    public void addPd(PostoDistribuicao pd) {
        listaPd.put(pd.getIdDP(), pd);
    }

    public void delPd(PostoDistribuicao pd) {
        listaPd.delete(pd.getIdDP());
    }

    public SeparateChainingHashST<Integer, PostoDistribuicao> getListaPd() {
        return listaPd;
    }

    public void setListaPd(SeparateChainingHashST<Integer, PostoDistribuicao> listaLinha) {
        this.listaPd = listaLinha;
    }

    public void printPd() {
        String zonas= new String();
        for (int h: getListaPd().keys()) {
            zonas = zonas + getListaPd().get(h);
            System.out.println(getListaPd().get(h));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Network{" +
                "listaPd=" + listaPd +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
