package projeto;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;


public class GuiNetwork {

    public Button addFonteEnergia;
    public TextArea textAreaPSU;
    public TextArea textAreaZone;
    public TextArea textAreaGraph;
    public Button loadGraphButton;
    public Button loadZoneButton;
    public Button loadPSUButton;
    public ComboBox comboBoxTipoEnergia;
    public ChoiceBox<String> choiceBoxTipoEnergia;



    public void pressedLoadGraphButton(ActionEvent event){
        String filename = "data/graphBackup.bin";
        File f = new File(filename);
        NetworkGraph graph2=null;
        try {
            textAreaGraph.setText("");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            graph2 = (NetworkGraph) ois.readObject();
            ois.close();
        } catch (Exception e) {
            //e.printStackTrace();
            //textAreaGraph.setText("Ficheiro não existe");
        }

        //textAreaGraph.setText(textAreaGraph.getText() + "Graph: " + graph2 /*+ "Vertices: "+ graph2.V() + "\nEdges: "*/);
        textAreaGraph.setText(textAreaGraph.getText() + "Origem\t|\tDestino\t|\tCapacidade");
        for (FlowEdge de : graph2.edges()) {
            textAreaGraph.setText(textAreaGraph.getText() + "\n" + de.from() + "\t\t|\t" + de.to() + "\t\t|\t" + de.capacity());
        }
        textAreaGraph.setText(textAreaGraph.getText()+"\n0xx -> Posto distribuição\n1xx -> Fontes de energia\n2xx -> Habitações\n38x -> Zonas");
    }

    public void pressedLoadZoneButton(ActionEvent event){

        //InputStream is = null;
        try {
            textAreaZone.setText("");
            File fileDir = new File("data/zonas.txt");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));

            String str;

            while ((str = in.readLine()) != null) {
                textAreaZone.setText(textAreaZone.getText() + str + "\n");
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pressedLoadPSUButton(ActionEvent event){
        try {
            textAreaPSU.setText("");
            File fileDir = new File("data/psu.txt");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));
            String str;
            while ((str = in.readLine()) != null) {
                textAreaPSU.setText(textAreaPSU.getText() + str + "\n");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pressedAddPsu(ActionEvent event){
    }

    public void pressedClearButton(ActionEvent event){
        textAreaGraph.setText("");
    }


    public static void main(String[] args) {




    }
    public void textAreaPSU(ActionEvent event) {
        ComboBox<FonteEnergia> comboPSU = new ComboBox<>();
    }


    public void pressedComboBoxTipoEnergia() {
        choiceBoxTipoEnergia = new ChoiceBox<>();
        choiceBoxTipoEnergia.getItems().addAll(
                "Solar",
                "Eolica"
        );
    }
}
