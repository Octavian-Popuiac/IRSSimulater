import Panels.PainelAgregadoFamiliar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Programa{
    private JPanel mainPanel, agregadoPanel, estadoCivilPanel;
    private JFrame frame;
    private Sujeito sujeitoA;
    private ArrayList<Sujeito> agregadoFamiliar = new ArrayList<>();
    private JComboBox<String> comboAno;
    private JPanel panelAgregado, panelCasado;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void criarJanela(){
        //Criar Janela
        this.frame = new MyFrame();
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setMainPanel(gbc);

        //Tornar a janela visivel
        frame.setVisible(true);
    }

    private void abrirJanelaAgregado(){
        this.mainPanel.setVisible(false);
        this.agregadoPanel = new PainelAgregadoFamiliar(this.frame);
        this.frame.add(agregadoPanel);
    }

    private void seguinte(){
        this.mainPanel.setVisible(false);
    }

    private void setMainPanel(GridBagConstraints gbc){
        JTextField txtCodigoFinancas, txtNomeA, txtNIFA;
        JTextField txtNomeB, txtNIFB;

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.mainPanel.add(new JLabel("Ano do IRS: "), gbc);

        //comboAno = new JComboBox<>(new String[]{"2022","2023","2024"});
        this.comboAno = new JComboBox<>(new String[]{"2024"});
        gbc.gridx = 1;
        this.mainPanel.add(comboAno, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.mainPanel.add(new JLabel("Código Serviço Finanças: "), gbc);

        txtCodigoFinancas = new JTextField(6);
        gbc.gridx = 1;
        this.mainPanel.add(txtCodigoFinancas, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.mainPanel.add(new JLabel("Nome do Sujeito A: "), gbc);

        txtNomeA = new JTextField(20);
        gbc.gridx = 1;
        this.mainPanel.add(txtNomeA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.mainPanel.add(new JLabel("NIF do Sujeito A: "), gbc);

        txtNIFA = new JTextField(10);
        gbc.gridx = 1;
        this.mainPanel.add(txtNIFA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.mainPanel.add(new JLabel("Estado Civil"), gbc);

        gbc.gridx = 1;
        estadoCivilPanel = new JPanel();
        JRadioButton radioCasado = new JRadioButton("Casado");
        JRadioButton radioSolteiro = new JRadioButton("Solteiro", true);
        ButtonGroup grupoEstadoCivil = new ButtonGroup();
        grupoEstadoCivil.add(radioCasado);
        grupoEstadoCivil.add(radioSolteiro);
        estadoCivilPanel.add(radioCasado);
        estadoCivilPanel.add(radioSolteiro);
        this.mainPanel.add(estadoCivilPanel , gbc);

        panelCasado = new JPanel(new GridLayout(2, 2));
        panelCasado.setBorder(BorderFactory.createEmptyBorder());
        panelCasado.add(new JLabel("Nome do Sujeito B"));
        txtNomeB = new JTextField(20);
        panelCasado.add(txtNomeB);
        panelCasado.add(new JLabel("NIF do Sujeito B"));
        txtNIFB = new JTextField(20);
        panelCasado.add(txtNIFB);
        panelCasado.setVisible(false);

        radioCasado.addActionListener( e -> {
            System.out.println("Casado");
            panelCasado.setVisible(true);
        });
        radioSolteiro.addActionListener(e -> {
            System.out.println("Solteiro");
            panelCasado.setVisible(false);
        });

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        this.mainPanel.add(panelCasado, gbc);

        /*
        JButton btnAgregado = new JButton("Agregado Familiar");
        btnAgregado.addActionListener(e -> abrirJanelaAgregado());
        gbc.gridy = 6;
        this.mainPanel.add(btnAgregado, gbc);
         */

        JButton btnSeguinte = new JButton("Seguinte");
        btnSeguinte.addActionListener(e -> {
            try {
                this.sujeitoA = new Sujeito(txtNomeA.getText(), Integer.parseInt(txtNIFA.getText()));
                agregadoFamiliar.add(sujeitoA);
                if(txtNomeB.isValid() && txtNIFB.isValid()){
                    agregadoFamiliar.add(new Sujeito(txtNomeB.getText(), Integer.parseInt(txtNIFB.getText())));
                }
                System.out.println("\nFamilia Info (" + agregadoFamiliar.size() + ")\n");
                for (Sujeito sujeito : agregadoFamiliar) {
                    System.out.println(sujeito.getNome() + " | " + sujeito.getNif());
                }
                seguinte();
            }catch (Exception e1){
                agregadoFamiliar.removeFirst();
                throw new InputMismatchException("Erro no entrada de dados. (Painel Principal)");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 6;
        this.mainPanel.add(btnSeguinte);

        frame.add(this.mainPanel);
    }
}
