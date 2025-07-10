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

   public boolean editarJugador(Jugador usado){
        int inf = 0;
        int sup = lista.size() - 1;
        int medio;

        while (inf <= sup) {
            medio = (inf + sup) / 2;
            int codigoActual = lista.get(medio).getCodigo();

            if (codigoActual == usado.getCodigo()) {
                lista.set(medio, usado);
                return true;
            } else if (usado.getCodigo() < codigoActual) {
                sup = medio - 1;
            } else {
                inf = medio + 1;
            }
        }

        return false;
    }

   public boolean eliminarJugador(int codigo){
        int inf = 0;
        int sup = lista.size() - 1;
        int medio;

        while (inf <= sup) {
            medio = (inf + sup) / 2;
            int codigoActual = lista.get(medio).getCodigo();

            if (codigoActual == codigo) {
                lista.remove(medio);
                return true;
            } else if (codigo < codigoActual) {
                sup = medio - 1;
            } else {
                inf = medio + 1;
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
