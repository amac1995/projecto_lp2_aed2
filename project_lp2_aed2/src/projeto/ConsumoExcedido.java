package projeto;

public class ConsumoExcedido extends Exception{
    public ConsumoExcedido(String msg){
        super(msg);
    }
    public ConsumoExcedido(){
        super();
    }
}
