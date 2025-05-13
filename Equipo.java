import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> lista;
    private int codigo=1;

    public Equipo() {
        lista=new ArrayList<>();
    }

    public void agregarJugador(Jugador nuevo){
        nuevo.setCodigo(codigo);
        codigo++;
        lista.add(nuevo);
    }

    public Jugador buscarBinario(int codigo) throws Exception {
        if(codigo<1 || codigo>lista.getLast().getCodigo())
            throw new Exception("No existe el jugador");
        int inf=0;
        int sup=lista.size()-1;
        int c;

        while(inf<=sup){
            c=(inf+sup)/2;
            if(lista.get(c).getCodigo()==codigo)
                return lista.get(c);
            else if(codigo<lista.get(c).getCodigo()){
                sup=c-1;
            }else{
                inf=c+1;
            }
        }
        throw new Exception("No se encontró el código");
    }

    public void editarJugador(Jugador usado){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo() == usado.getCodigo()) {
                lista.set(i, usado);
                return;
            }
        }
    }

    public boolean eliminarJugador(int codigo){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCodigo() == codigo){
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    public String listarTodos(){
        StringBuilder sb=new StringBuilder();
        for(Jugador j:lista){
            sb.append(j.toString());
        }
        return sb.toString();
    }
}
