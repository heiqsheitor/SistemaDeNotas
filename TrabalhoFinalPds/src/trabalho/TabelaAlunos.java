package trabalho;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import trabalho.CadastroAluno.Sistema;
import java.awt.*;

public class TabelaAlunos extends JFrame {

    public TabelaAlunos() {

        setTitle("Tabela de Alunos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"Nome", "Período", "Nota 1", "Nota 2", "Nota 3", "Média", "Situação"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modelo);

        for (AlunoNotas a : Sistema.alunos) {
            modelo.addRow(new Object[]{
                a.getNome(),
                a.getPeriodo(),
                a.getN1(),
                a.getN2(),
                a.getN3(),
                a.calcularMedia(),
                a.verificarSituacao()
            });
        }

        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnVoltar = new JButton("Fechar");
        btnVoltar.addActionListener(e -> dispose());

        JPanel painel = new JPanel();
        painel.add(btnVoltar);

        add(scroll, BorderLayout.CENTER);
        add(painel, BorderLayout.SOUTH);
    }
}