package Aplicaciones;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpinnerListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GUI_Proyecto2 extends javax.swing.JFrame {
	
	private JLabel PadreLabel;
	private JLabel NuevoNodoLabel;
	private JLabel jLabel2; 
	private JLabel AlturaLabel;
	private JLabel jLabel1;
	private JLabel ProfLabel;
	private JLabel Paso2Label;
	private JLabel Paso3Label;
	private JLabel Paso1;
	private JLabel ProfundidadLabel;
	private JLabel IngRaizLabel;
	private JPanel jPanel1;
	
	private JTextField RaizTextField;
	private JTextField PadreTextField;
	private JTextField NuevoNodoText;
	private JTextField P2TextField;
	
	private JSeparator jSeparator3;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	
	private JButton RaizOk;
	private JButton NuevoOk;
	private JButton CrearNuevoBoton;
	private JButton Paso1Boton;
	private JButton P2Ok;

	private JPanel CargarArbolPanel;
	
	private JTextArea NivelesLabel;
	private JTextArea jTextArea1;
	private JTextArea CargarLabel;
	
	private JScrollPane Altura;
	private JScrollPane Niveles;
	private JScrollPane Profundidades;
	private Ejercicio4 ej;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI_Proyecto2 inst = new GUI_Proyecto2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GUI_Proyecto2() {
		
		super();
		ej=new Ejercicio4();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setForeground(new java.awt.Color(0,128,0));
			this.setTitle("Proyecto 2 - Virkel Federico / Kestel Guido");
			getContentPane().setBackground(new java.awt.Color(140,190,65));
			{
				NivelesLabel = new JTextArea();
				getContentPane().add(NivelesLabel);
				NivelesLabel.setText("Representación \r\n    por niveles");
				NivelesLabel.setBounds(6, 237, 129, 44);
				NivelesLabel.setOpaque(false);
				NivelesLabel.setFont(new java.awt.Font("Arial",0,16));
			}
			{
				Niveles = new JScrollPane();
				getContentPane().add(Niveles);
				Niveles.setBounds(148, 226, 319, 51);
				Niveles.setSize(320, 65);
				{
					jLabel1 = new JLabel();
					Niveles.setViewportView(jLabel1);
					jLabel1.setFont(new java.awt.Font("Segoe UI",0,28));
					jLabel1.setText("");
					jLabel1.setOpaque(true);
				}
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setText(" Nodos segun \r\n    su altura \r\n(mayor a menor)");
				jTextArea1.setBounds(15, 317, 121, 70);
				jTextArea1.setFont(new java.awt.Font("Arial",0,16));
				jTextArea1.setOpaque(false);
			}
			{
				Altura = new JScrollPane();
				getContentPane().add(Altura);
				Altura.setBounds(148, 317, 320, 64);
				{
					AlturaLabel = new JLabel();
					Altura.setViewportView(AlturaLabel);
					AlturaLabel.setFont(new java.awt.Font("Segoe UI",0,28));
					AlturaLabel.setText("");
				}
			}
			{
				CargarArbolPanel = new JPanel();
				getContentPane().add(CargarArbolPanel);
				CargarArbolPanel.setBounds(19, 12, 449, 208);
				CargarArbolPanel.setLayout(null);
				CargarArbolPanel.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				CargarArbolPanel.setBackground(new java.awt.Color(0,128,64));
				{
					CargarLabel = new JTextArea();
					CargarArbolPanel.add(CargarLabel);
					CargarLabel.setText("Cargar un arbol");
					CargarLabel.setBounds(157, 2, 138, 20);
					CargarLabel.setOpaque(false);
					CargarLabel.setFont(new java.awt.Font("Arial",3,16));
					CargarLabel.setEditable(false);
				}
				{
					IngRaizLabel = new JLabel();
					CargarArbolPanel.add(IngRaizLabel);
					IngRaizLabel.setText("Ingrese raiz:");
					IngRaizLabel.setBounds(98, 44, 87, 25);
					IngRaizLabel.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					RaizTextField = new JTextField();
					CargarArbolPanel.add(RaizTextField);
					RaizTextField.setText("");
					RaizTextField.setBounds(203, 46, 62, 23);
				}
				{
					RaizOk = new JButton();
					CargarArbolPanel.add(RaizOk);
					RaizOk.setText("Crear");
					RaizOk.setBounds(277, 46, 137, 23);
					OyenteBoton ejer1 = new OyenteBoton();
					RaizOk.addActionListener(ejer1);
				}
				{
					NuevoNodoLabel = new JLabel();
					CargarArbolPanel.add(NuevoNodoLabel);
					NuevoNodoLabel.setText("Nuevo nodo:");
					NuevoNodoLabel.setBounds(97, 148, 94, 16);
					NuevoNodoLabel.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					NuevoNodoText = new JTextField();
					CargarArbolPanel.add(NuevoNodoText);
					NuevoNodoText.setText("");
					NuevoNodoText.setBounds(203, 146, 62, 23);
				}
				{
					NuevoOk = new JButton();
					CargarArbolPanel.add(NuevoOk);
					NuevoOk.setText("Agregar");
					NuevoOk.setBounds(277, 126, 137, 22);
					OyenteBoton ejer1 = new OyenteBoton();
					NuevoOk.addActionListener(ejer1);
				}
				{
					PadreLabel = new JLabel();
					CargarArbolPanel.add(PadreLabel);
					PadreLabel.setText("Padre:");
					PadreLabel.setBounds(98, 111, 59, 16);
					PadreLabel.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					jSeparator1 = new JSeparator();
					CargarArbolPanel.add(jSeparator1);
					jSeparator1.setBounds(0, 88, 447, 3);
					jSeparator1.setEnabled(false);
					jSeparator1.setBorder(BorderFactory.createCompoundBorder(
							null, 
							null));
					jSeparator1.setBackground(new java.awt.Color(140,190,65));
				}
				{
					PadreTextField = new JTextField();
					CargarArbolPanel.add(PadreTextField);
					PadreTextField.setText("");
					PadreTextField.setBounds(203, 103, 62, 23);
				}
				{
					CrearNuevoBoton = new JButton();
					CargarArbolPanel.add(CrearNuevoBoton);
					CrearNuevoBoton.setText("Crear un nuevo arbol");
					CrearNuevoBoton.setBounds(2, 181, 445, 23);
					OyenteBoton ejer1 = new OyenteBoton();
					CrearNuevoBoton.addActionListener(ejer1);
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(486, 12, 370, 346);
				jPanel1.setBackground(new java.awt.Color(0,128,64));
				jPanel1.setLayout(null);
				{
					ProfundidadLabel = new JLabel();
					jPanel1.add(ProfundidadLabel);
					ProfundidadLabel.setText("Profundidad de nodos");
					ProfundidadLabel.setBounds(89, 12, 182, 16);
					ProfundidadLabel.setFont(new java.awt.Font("Arial",3,16));
				}
				{
					Paso1 = new JLabel();
					jPanel1.add(Paso1);
					Paso1.setText("1- Crear Diccionario");
					Paso1.setBounds(12, 81, 152, 16);
					Paso1.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					Paso1Boton = new JButton();
					jPanel1.add(Paso1Boton);
					Paso1Boton.setText("Crear");
					Paso1Boton.setBounds(191, 79, 134, 23);
					OyenteBoton ejer1 = new OyenteBoton();
					Paso1Boton.addActionListener(ejer1);
				}
				{
					jSeparator2 = new JSeparator();
					jPanel1.add(jSeparator2);
					jSeparator2.setBounds(43, 121, 262, 10);
				}
				{
					Paso2Label = new JLabel();
					jPanel1.add(Paso2Label);
					Paso2Label.setText("2- Ingrese una profundidad");
					Paso2Label.setBounds(12, 143, 199, 21);
					Paso2Label.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					P2TextField = new JTextField();
					jPanel1.add(P2TextField);
					P2TextField.setBounds(210, 143, 37, 23);
				}
				{
					P2Ok = new JButton();
					jPanel1.add(P2Ok);
					P2Ok.setText("OK");
					P2Ok.setBounds(266, 143, 53, 23);
					OyenteBoton ejer1 = new OyenteBoton();
					P2Ok.addActionListener(ejer1);
				}
				{
					jSeparator3 = new JSeparator();
					jPanel1.add(jSeparator3);
					jSeparator3.setBounds(43, 187, 262, 10);
				}
				{
					Paso3Label = new JLabel();
					jPanel1.add(Paso3Label);
					Paso3Label.setText("3- Nodos con profundidad");
					Paso3Label.setBounds(12, 217, 192, 16);
					Paso3Label.setFont(new java.awt.Font("Arial",0,16));
				}
				{
					ProfLabel = new JLabel();
					jPanel1.add(ProfLabel);
					ProfLabel.setBounds(204, 209, 36, 24);
					ProfLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					ProfLabel.setBackground(new java.awt.Color(192,192,192));
					ProfLabel.setOpaque(true);
				}
				{
					Profundidades = new JScrollPane();
					jPanel1.add(Profundidades);
					Profundidades.setBounds(12, 254, 339, 78);
					Profundidades.setSize(340, 75);
					{
						jLabel2 = new JLabel();
						Profundidades.setViewportView(jLabel2);
						jLabel2.setFont(new java.awt.Font("Arial",0,36));
						jLabel2.setText("");
						jLabel2.setSize(336, 70);
					}
					
					NuevoOk.setEnabled(false);
					CrearNuevoBoton.setEnabled(false);
					Paso1Boton.setEnabled(false);
					P2Ok.setEnabled(false);
					
				}
				
			pack();
			this.setSize(884, 437);
			}}
			catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		}
		public class OyenteBoton implements ActionListener
		{
			public void actionPerformed(ActionEvent e){
				
				if (e.getSource() == RaizOk){
					String s=RaizTextField.getText();
					ej.crearRaiz(Integer.parseInt(s));
					NuevoOk.setEnabled(true);
					CrearNuevoBoton.setEnabled(true);
					Paso1Boton.setEnabled(true);
					RaizOk.setEnabled(false);
					jLabel1.setText(ej.mostrarNiveles());
					AlturaLabel.setText(ej.ordenPorAltura());
				}	
				if(e.getSource() == NuevoOk){
					String padre= PadreTextField.getText();
					String nodo= NuevoNodoText.getText();
					
					
					try {
						ej.agregarNodo(Integer.parseInt(nodo), Integer.parseInt(padre));
						jLabel1.setText(ej.mostrarNiveles());
						AlturaLabel.setText(ej.ordenPorAltura());	
					} catch (Ejercicio4Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						
				}
				}
				if(e.getSource() == CrearNuevoBoton){
					ej=new Ejercicio4();
					RaizOk.setEnabled(true);
					NuevoOk.setEnabled(false);
					CrearNuevoBoton.setEnabled(false);
					Paso1Boton.setEnabled(false);
					P2Ok.setEnabled(false);
					jLabel1.setText("");
					AlturaLabel.setText("");
				}
				if(e.getSource()==Paso1Boton){
					ej.crearDiccionario();
					P2Ok.setEnabled(true);
				}
				if(e.getSource()==P2Ok){
					String s=P2TextField.getText();
					int i=Integer.parseInt(s);
					String s2 = ej.mostrarNodosConProfundidad(i);
					ProfLabel.setText(s);
					jLabel2.setText(s2);
				}
				
			}
		}
		
}
	

