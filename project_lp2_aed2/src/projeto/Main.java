package projeto;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import projeto.recursos_alt.*;

public class Main extends Application {

    private static int GRAPH_ID = 000;

    public static void translateGraphNode(RedBlackBST node, Network rede) {
        SeparateChainingHashST<Integer, Zona> listaZonas = rede.getListaPd().get(rede.getId()).getListaZonas();
        SeparateChainingHashST<Integer, FonteEnergia> listaFonte = rede.getListaPd().get(rede.getId()).getListaFonte();

        while (!listaFonte.isEmpty()) {
            for (int i = 0; i < node.size(); i++) {
                System.out.println(listaFonte.get(i));
            }
        }
    }

    public static void main(String[] args) {

        RedBlackBST<Integer, Integer> redBlackNode = new RedBlackBST<>();
        NetworkGraph graph = new NetworkGraph(13);
        StartUp startUp = new StartUp();

        //Rede Nova
        Network rede = new Network("Aveiro");

        //Postos de distribuição
        PostoDistribuicao pd = new PostoDistribuicao(20000000);

        //Fontes de energia
        //FonteEnergia ps = new FonteEnergia(125000, "Solar");
        //FonteEnergia ps1 = new FonteEnergia(200000, "Nuclear");
        //FonteEnergia ps2 = new FonteEnergia(225000, "Eolica");

        //Equipamento
        //EquipamentoCons a1 = new EquipamentoCons("Maquina de cafe",150);
        //EquipamentoCons a2 = new EquipamentoCons("Frigorifico",1000);
        //EquipamentoCons a3 = new EquipamentoCons("Micro-ondas",1750);
        //EquipamentoCons a4 = new EquipamentoCons("Maquina de cafe",175);
        //EquipamentoCons a5 = new EquipamentoCons("Frigorifico",1150);
        //EquipamentoGer a6 = new EquipamentoGer("Painel Solar",5000);
        //EquipamentoCons a7 = new EquipamentoCons("Maquina de cafe",150);
        //EquipamentoCons a8 = new EquipamentoCons("Frigorifico",1250);
        //EquipamentoGer a9 = new EquipamentoGer("Painel Solar",5000);

        //Zona
        //Zona z1 = new Zona("Ovar",3880);
        //Zona z2 = new Zona("Cucujães",3980);

        //Habitação
        //Habitacao h1 = new Habitacao(25000);
        //Habitacao h2 = new Habitacao(25000);
        //Habitacao h3 = new Habitacao(25000);
        //Habitacao h4 = new Habitacao(25000);
        //Habitacao h5 = new Habitacao(25000);
        //Habitacao h6 = new Habitacao(25000);


        //loadFromFilePostosDistribuicao("data/postosDistribuicao.txt");

        //Posto de distribuição
        rede.addPd(new PostoDistribuicao(200000));
        rede.printPd();
        //Zonas
        rede.getListaPd().get(7).addZona(new Zona("Ovar", 3880));
        rede.getListaPd().get(7).addZona(new Zona("Cucujães", 3980));

        rede.getListaPd().get(7).printZona();
        //Linhas
        rede.getListaPd().get(7).getListaZonas().get(380).addLinha(new Linhas(20000));
        rede.getListaPd().get(7).getListaZonas().get(380).addLinha(new Linhas(28000));
        rede.getListaPd().get(7).getListaZonas().get(380).addLinha(new Linhas(23000));
        rede.getListaPd().get(7).getListaZonas().get(381).addLinha(new Linhas(20000));
        rede.getListaPd().get(7).getListaZonas().get(381).addLinha(new Linhas(22000));
        rede.getListaPd().get(7).getListaZonas().get(381).addLinha(new Linhas(20000));

        //Habitações
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).addHabit(new Habitacao(17000));
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(251).addHabit(new Habitacao(25000));
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(252).addHabit(new Habitacao(21000));
        rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(253).addHabit(new Habitacao(19500));
        rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(254).addHabit(new Habitacao(20050));
        rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(255).addHabit(new Habitacao(18650));

        //Fontes de energia
        rede.getListaPd().get(7).addPS(new FonteEnergia(125000, "Solar"));
        rede.getListaPd().get(7).addPS(new FonteEnergia(200000, "Nuclear"));
        rede.getListaPd().get(7).addPS(new FonteEnergia(225000, "Eolica"));

        //Equipamentos
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).addEquip(new EquipamentoCons("Maquina de cafe", 150));
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).addEquip(new EquipamentoCons("Frigorifico", 1000));
        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(251).getListaHabitacoes().get(201).addEquip(new EquipamentoCons("Micro-ondas", 1750));


        /*System.out.println("\nHabitações na zona 1");
        z1.printHabit();
        System.out.println("\nHabitações na zona 2");
        z2.printHabit();*/

        //-----------------------------------------------------------------
        /*//Diferenca de datas
        System.out.println("Diferenca de Anos Meses e Dias: ");
        LocalDateTime d2=LocalDateTime.now();
        LocalDateTime d1=LocalDateTime.of(2000,12,12,17,00,00);*/

        //-----------------------------------------------------------------

        //Graphs

        //Nós Postos de Zonas
        NetworkNode zip01 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(zip01.getId(), rede.getListaPd().get(7).getListaZonas().get(380).getIdZona());
        NetworkNode zip02 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(zip02.getId(), rede.getListaPd().get(7).getListaZonas().get(381).getIdZona());
        //NetworkNode zip03 = new NetworkNode(2);
        graph.addNode(zip01);
        graph.addNode(zip02);
        //graph.addNode(zip03);


        //Nós Postos de Postos de distribuição
        NetworkNode psu01 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(psu01.getId(), rede.getListaPd().get(7).getIdDP());
        //NetworkNode psu02 = new NetworkNode();
        //NetworkNode psu03 = new NetworkNode();
        graph.addNode(psu01);
        //graph.addNode(psu02);
        //graph.addNode(psu03);

        //Nós Postos de Fontes de enegia
        NetworkNode ps01 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(ps01.getId(), rede.getListaPd().get(7).getListaFonte().get(100).getIdPS());
        NetworkNode ps02 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(ps02.getId(), rede.getListaPd().get(7).getListaFonte().get(101).getIdPS());
        NetworkNode ps03 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(ps03.getId(), rede.getListaPd().get(7).getListaFonte().get(102).getIdPS());
        graph.addNode(ps01);
        graph.addNode(ps02);
        graph.addNode(ps03);



        //Nós Habitações
        NetworkNode hab01 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab01.getId(), rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).getIdHab());
        NetworkNode hab02 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab02.getId(), rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(251).getListaHabitacoes().get(201).getIdHab());
        NetworkNode hab03 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab03.getId(), rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(252).getListaHabitacoes().get(202).getIdHab());
        NetworkNode hab04 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab04.getId(), rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(253).getListaHabitacoes().get(203).getIdHab());
        NetworkNode hab05 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab05.getId(), rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(254).getListaHabitacoes().get(204).getIdHab());
        NetworkNode hab06 = new NetworkNode(GRAPH_ID++);
        redBlackNode.put(hab06.getId(), rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(255).getListaHabitacoes().get(205).getIdHab());
        graph.addNode(hab01);
        graph.addNode(hab02);
        graph.addNode(hab03);
        graph.addNode(hab04);
        graph.addNode(hab05);
        graph.addNode(hab06);

        rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).printEquip();

        //Equipamentos
        NetworkNode equi01 = new NetworkNode(GRAPH_ID++);
        graph.addNode(equi01);

        //redBlackNode.put(equi01.getId(), rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).getListaEquipamento().get(400).getIdEquip());


        graph.addEdge(ps01, psu01, rede.getListaPd().get(7).getListaFonte().get(100).getPotenciaProduzida());
        graph.addEdge(ps02, psu01, rede.getListaPd().get(7).getListaFonte().get(101).getPotenciaProduzida());
        graph.addEdge(ps03, psu01, rede.getListaPd().get(7).getListaFonte().get(102).getPotenciaProduzida());


        graph.addEdge(zip01, hab01, rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).getPotenciaContratada());
        graph.addEdge(zip01, hab02, rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(251).getListaHabitacoes().get(201).getPotenciaContratada());
        graph.addEdge(zip01, hab03, rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(252).getListaHabitacoes().get(202).getPotenciaContratada());
        graph.addEdge(zip02, hab04, rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(253).getListaHabitacoes().get(203).getPotenciaContratada());
        graph.addEdge(zip02, hab05, rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(254).getListaHabitacoes().get(204).getPotenciaContratada());
        graph.addEdge(zip02, hab06, rede.getListaPd().get(7).getListaZonas().get(381).getListaLinhas().get(255).getListaHabitacoes().get(205).getPotenciaContratada());

        graph.addEdge(psu01, zip01, 000000);
        graph.addEdge(psu01, zip02, 000000);

        //graph.addEdge(equi01, hab01, rede.getListaPd().get(7).getListaZonas().get(380).getListaLinhas().get(250).getListaHabitacoes().get(200).getListaEquipamento().get(400).getConsumoAtual());
        System.out.println("Graph: " + graph);
        System.out.println("Graph -> V: " + graph.V());
        System.out.println("Graph -> edges: ");
        for (FlowEdge de : graph.edges()) {
            System.out.println(de.from() + "\t" + de.to() + "\t" + de.capacity());
        }


        //EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(graph);
        // cálculo do caminho mais curto entre dois nós do grafo

        for (int i = 0; i < graph.V(); i++) {
            DijkstraSP dijkstraSP = new DijkstraSP(graph, i);
            for (int j = 0; j < graph.V(); j++) {
                System.out.println("O vertice " + redBlackNode.get(i) + " tem uma distancia de " + dijkstraSP.distTo(j) + " ao vertice " + redBlackNode.get(j));
            }
        }
//Um vertice sink: As arestas, neste caso, especificam o valor da carga. (potência condumida)
//tens de dizer de que tipo sao
        /*FordFulkerson maxflow = new FordFulkerson(graph, source ,target);
        StdOut.println("Max flow from " + source + " to " + target);
        for (int v = 0; v < graph.V(); v++) {
            for (FlowEdge e : graph.adj(v)) {
                if ((v == e.from()) && e.flow() > 0) {
                    StdOut.println("   " + e);
                }
            }
        }*/

        //Selecionar um subgrafo e aplicar-lhe os mesmos algoritmos ou funcionalidades descritas;

        /*

        Deverá associar-se a cada nó uma ou mais árvores para armazenamento de
        dados dos aparelhos e posteriormente permitir a manipulação conjunta de forma
        a facilitar as pesquisas e as ações de gestão de informação; Poderá usar-se, por
        exemplo, uma árvore Red-Black (RB) para guardar a lista de logs dos aparelhos
        assim como toda a informação associada de forma a facilitar a pesquisa bem
        como a manipulação da informação acerca do perfil desses nós;

        */



/*
        //pd.printHabit();
        h1.printEquip();
        //h1.changeWattEquip(0, "cafe", 200);
        //h1.printEquip();
        a1.lastState();
        //pd.printPS();
        h1.consumption(a1);
       /* System.out.println("Maquina de café: " + h1.pesquisaEquip("ca"));
        h1.deleteEquip(a1);
        System.out.println("Maquina de café: " + h1.pesquisaEquip("ca"));*/
        //CopiarFicheiro copy = new CopiarFicheiro();

        //rede.translateNodes(redBlackNode);
        rede.getListaPd().get(7).savePSU();
        rede.getListaPd().get(7).saveZones();
        startUp.backupGraph(graph);
        //translateGraphNode(redBlackNode, rede);
        launch(args);

    }


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GuiNetwork.fxml"));
        primaryStage.setTitle("Rede Eletrica");
        primaryStage.setScene(new Scene(root, 774, 479));
        primaryStage.show();

    }

}
