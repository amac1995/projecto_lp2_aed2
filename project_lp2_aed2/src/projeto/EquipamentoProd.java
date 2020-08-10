package projeto;

public class EquipamentoProd extends Equipamento{

    private static int ACTUAL_ID = 300;

    public EquipamentoProd(String nome, double wattH) {
            super(++ACTUAL_ID, nome, wattH);
    }
}
