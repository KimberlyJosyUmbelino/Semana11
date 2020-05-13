import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelDeTexto extends JFrame implements ActionListener
{ 
   //Campo não editavel que mostram as coisas
   private JLabel jlbDigite ;
   //Campo editavel e objetos com parte visual e tambem conteudo que o usuario digita
   private JTextField txtDigite;
   //Declarando os botões
   private JButton limpar,mostrar,sair;
   public void actionPerformed (ActionEvent e)
   {
      if(e.getSource()==mostrar)
      {String texto=txtDigite.getText();
         JOptionPane.showMessageDialog(null,texto);
      }
      else if(e.getSource()==limpar)
      {
         JOptionPane.showMessageDialog (null, "Limpar");
         txtDigite.setText("");
      }
      else if(e.getSource()==sair)
      { 
         JOptionPane.showMessageDialog (null, "Sai");
         System.exit(0);
      }
   }
   //Construdor de inicializar
   public PainelDeTexto()
   {
      //titulo da pagina
      super ("Bloco de notas");
      JPanel painelPrincipal=new JPanel (new GridLayout(2,1));
      JPanel painelDigitacao=new JPanel(new FlowLayout());
      //Criando a etiqueta 
      //Ciando espaço e tamanho da parte de digitar
      txtDigite=new JTextField  ("TEXTO");
      //Adicionando os objetos na tela
      painelPrincipal.add(txtDigite);
      //Painel dos botões
      JPanel painelBotoes=new JPanel (new GridLayout(1,3));
      //Criando os botões
      mostrar=new JButton("Mostrar");
      limpar=new JButton("Limpar");
      sair=new JButton("Sair");  
      //Adicionando os botoes ao painel botões
      painelBotoes.add(mostrar);
      painelBotoes.add(limpar);
      painelBotoes.add(sair);
      //avisamos os botões de maneira a informar que queremos saber sobre os seguintes eventos dos seus botões
      //Também vamos partir para a logica do programa,ou seja,fazer com que os botões funcionem o que é corresponde
      //Atribuir observador aos botoes
      mostrar.addActionListener(this);
      limpar.addActionListener(this);
      sair.addActionListener(this);
      //Quem adiciona e diz onde quem vai ficar Border 
      Container retrato=getContentPane();
      retrato.setLayout(new BorderLayout());
      retrato.add(painelPrincipal,BorderLayout.CENTER);
      retrato.add(painelBotoes,BorderLayout.SOUTH);
      //Colocando tamanho na tela
      setSize(710,190);
      //para encerrar o programa apertando os botoes sair ou o X
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Centralizando a tela
      setLocationRelativeTo(null);
      //Tornando a tela visivel
      setVisible(true); 
   } 
   //Metodo principal
   public static void main (String [] args)
   {
      SwingUtilities.invokeLater(
         new Runnable ()
         {
            public void run ()
            {
               new PainelDeTexto();
            }
         });
   }   
}