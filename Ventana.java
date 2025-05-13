import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtNombre;
    private JTextField txtRendimiento;
    private JComboBox cboPosicion;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JSpinner spCodigo;
    private JButton btnBuscar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private Equipo equipo1=new Equipo();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=txtNombre.getText();
                float r=Float.parseFloat(txtRendimiento.getText());
                String pos=cboPosicion.getSelectedItem().toString();
                equipo1.agregarJugador(new Jugador(-1,nombre,r,pos));
                txtListado.setText(equipo1.listarTodos());
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spCodigo.getValue().toString());
                try{
                    Jugador j=equipo1.buscarBinario(codigo);
                    txtListado.setText(j.toString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spCodigo.getValue().toString());
                String nombre = txtNombre.getText();
                float r = Float.parseFloat(txtRendimiento.getText());
                String pos = cboPosicion.getSelectedItem().toString();
                Jugador nuevo = new Jugador(codigo, nombre, r, pos);
                equipo1.editarJugador(nuevo);
                txtListado.setText(equipo1.listarTodos());
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spCodigo.getValue().toString());
                try{
                    equipo1.eliminarJugador(codigo);
                    txtListado.setText(equipo1.listarTodos());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
