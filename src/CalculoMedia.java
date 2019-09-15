import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculoMedia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JButton btnLimpar;
	private JTextField lblMdia; 
	private JTextField txtMedia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoMedia frame = new CalculoMedia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoMedia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalculoMedia.class.getResource("/icones/calculadora.png")));
		setTitle("Calculadora da M\u00E9dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNota = new JLabel("Nota1");
		lblNota.setBounds(10, 27, 48, 14);
		contentPane.add(lblNota);
		
		JLabel lblNota_1 = new JLabel("Nota2");
		lblNota_1.setBounds(10, 70, 48, 14);
		contentPane.add(lblNota_1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(59, 24, 96, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(59, 67, 96, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			//evento "clicar" no botão
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(CalculoMedia.class.getResource("/icones/calculadora1.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.setBounds(10, 114, 128, 128);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(CalculoMedia.class.getResource("/icones/limpar.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(160, 114, 128, 128);
		contentPane.add(btnLimpar);
		
		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setBounds(199, 42, 48, 14);
		contentPane.add(lblMdia);
		
		txtMedia = new JTextField();
		txtMedia.setBounds(189, 67, 58, 20);
		contentPane.add(txtMedia);
		txtMedia.setColumns(10);
	}
	//método para calcular a média
	private void calcular() {
		DecimalFormat formatador= new DecimalFormat("0.0");
		double nota1,nota2,media;
		//a linha abaixo captura o conteúdo da caixa de texto, converte para o tipo double e armazena na variavel
		//.replace troca um caractere por outro
		nota1 = Double.parseDouble(txtNota1.getText().replace(",","."));
		nota2 = Double.parseDouble(txtNota2.getText().replace(",","."));
		media = (nota1 + nota2)/2;
		txtMedia.setText(formatador.format(media)); 
		//showMessageDialog(CAIXA DE MENSAGEM)
		//null(tamanho padrão)
		//"Texto"
		//"Título"
		//ícone 
		if (media < 5) {
			JOptionPane.showMessageDialog(null, "REPROVADO","Status",JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "APROVADO","Status",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	//método para limpar
	private void limpar() {
		txtNota1.setText(null);
		txtNota2.setText(null);
		txtMedia.setText(null);
	}
}
