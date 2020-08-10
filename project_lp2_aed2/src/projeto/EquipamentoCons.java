package projeto;

public class EquipamentoCons extends Equipamento{

    private static int ACTUAL_ID = 399;

    public EquipamentoCons(String nome, double wattH) {
        super(++ACTUAL_ID, nome, wattH);
    }
}
