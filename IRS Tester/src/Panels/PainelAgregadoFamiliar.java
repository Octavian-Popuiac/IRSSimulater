package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PainelAgregadoFamiliar extends JPanel {
    private final ArrayList<JPanel> listMembros = new ArrayList<>();
    private final JPanel panelLista;
    private final JFrame frameAgregado;

    public PainelAgregadoFamiliar(JFrame frameAgregado){
        this.frameAgregado = frameAgregado;
        setLayout(new BorderLayout());

        panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.setBorder(BorderFactory.createTitledBorder("Membros do Agregado Familiar |   " + this.listMembros.size()));

        var panelBotoes = getPanel(frameAgregado);

        add(panelLista, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
    }

    private JPanel getPanel(JFrame frameAgregado) {
        JButton btnAdicionarDependente = new JButton("Adicionar Depedente");
        btnAdicionarDependente.addActionListener(e -> adicionarDependente());

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarDados());

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {});

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnAdicionarDependente);
        panelBotoes.add(btnGuardar);
        panelBotoes.add(btnVoltar);
        return panelBotoes;
    }

    private void adicionarDependente(){
        JPanel panelMembro = new JPanel(new FlowLayout());

        JTextField txtNIFDependente = new JTextField(20);
        JTextField txtGrauDeficiencia = new JTextField(20);
        JButton btnEliminar = new JButton("Eliminar");

        panelMembro.add(new JLabel("NIF: "));
        panelMembro.add(txtNIFDependente);
        panelMembro.add(new JLabel("Grau Deficiência: "));
        panelMembro.add(txtGrauDeficiencia);
        panelMembro.add(btnEliminar);

        btnEliminar.addActionListener(e -> removerDependente(panelMembro));

        listMembros.add(panelMembro);
        panelLista.add(panelMembro);

        revalidate();
        repaint();
    }

    private void removerDependente(JPanel panelMembro){
        listMembros.remove(panelMembro);
        panelLista.remove(panelMembro);
        revalidate();
        repaint();
    }

    private void guardarDados(){
        JOptionPane.showMessageDialog(frameAgregado, "Dados do agregado familiar guardados!");
        frameAgregado.dispose();
    }
}
