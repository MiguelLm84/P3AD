package vista;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.vo.AlumnoVO;
import modelo.vo.CursaVO;

public abstract class AlumnosUI {

	private JFrame frame;
	private JTextField TextField_nombre;
	private JTextField textField_ap1;
	private JTextField textField_ap2;
	private JTextField textField_dni;
	private JLabel lblTelfono;
	private JTextField textField_telefono;
	private JLabel lblFechaNacimiento;
	private JTextField textField_fnaci;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	private String dni;
	private int idModulo;
	private JTextField textField_nota;
	private JTextField textField_anho;

	/**
	 * Create the application.
	 */
	public AlumnosUI(int idModulo) {
		this.idModulo=idModulo;
		initialize();
	}

	/**
	 * Muestra el formulario
	 */
	public void show() {
		frame.setVisible(true);
	}

	/**
	 * Agregar un modulo en funcion de los valores de los campos: nombre, ciclo,
	 * curso y horas
	 * 
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 * @param string
	 * @param string2
	 */
	protected abstract void agregarAlumno(String dni, String nombre, String ap1, String ap2, int telefono,
			Date fechaNaci);

	/**
	 * Edita un modulo seleccionado en funcion de los valores de los campos:
	 * dni,nombre, ap1, ap2, telefono, fechaNaci
	 * 
	 * @param dni
	 * @param nombre
	 * @param ap1
	 * @param ap2
	 * @param telefono
	 * @param fechaNaci
	 */
	protected abstract void editarAlumno(String dni, String nombre, String ap1, String ap2, int telefono,
			Date fechaNaci);

	/**
	 * Elimina un modulo seleccionado
	 */
	protected abstract void eliminarAlumno(String dni);

	/**
	 * En este método deben implementarse las funcionalidades necesarias para
	 * transformar una lista de VO en una lista de arrays de String (String[]) donde
	 * cada elemento sea un array con
	 * {"Dni",Nombre",Apellido1","Apellido2","Telefono","fechaNaci"}
	 * 
	 * @return
	 */
	protected abstract List<AlumnoVO> transformarListaVO();

	
	 protected abstract void agregarCursa(String anho, int nota, String dni, int
	 idModulo);
	  
	 protected abstract void editarCursa(String anho, int nota, String dni, int
	 idModulo);
	 
	 protected abstract void eliminarCursa(int IdModulo, String dni);
	 

	protected abstract List<CursaVO> listarCursa();

	protected String getDni() {
		return this.dni;
	}

	protected String getNombre() {
		return this.TextField_nombre.getText();
	}

	protected String getAp1() {
		return this.textField_ap1.getText();
	}

	protected String getAp2() {
		return this.textField_ap2.getText();
	}

	protected String getTelefono() {
		return this.textField_telefono.getText();
	}

	protected String getFechaNaci() {
		return this.textField_fnaci.getText();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dni = null;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(300, 300, 876, 678);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 13, 46, 14);
		frame.getContentPane().add(lblNombre);

		TextField_nombre = new JTextField();
		TextField_nombre.setBounds(10, 29, 270, 20);
		frame.getContentPane().add(TextField_nombre);
		TextField_nombre.setColumns(10);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(292, 13, 250, 14);
		frame.getContentPane().add(lblDni);

		textField_dni = new JTextField();
		textField_dni.setBounds(292, 28, 200, 22);
		frame.getContentPane().add(textField_dni);
		textField_dni.setColumns(10);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(10, 62, 94, 18);
		frame.getContentPane().add(lblPrimerApellido);

		textField_ap1 = new JTextField();
		textField_ap1.setBounds(10, 79, 270, 22);
		frame.getContentPane().add(textField_ap1);
		textField_ap1.setColumns(10);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(12, 110, 110, 16);
		frame.getContentPane().add(lblSegundoApellido);

		textField_ap2 = new JTextField();
		textField_ap2.setColumns(10);
		textField_ap2.setBounds(10, 128, 270, 22);
		frame.getContentPane().add(textField_ap2);

		lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(292, 63, 56, 16);
		frame.getContentPane().add(lblTelfono);

		textField_telefono = new JTextField();
		textField_telefono.setBounds(292, 79, 200, 22);
		frame.getContentPane().add(textField_telefono);
		textField_telefono.setColumns(10);

		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(292, 110, 110, 16);
		frame.getContentPane().add(lblFechaNacimiento);

		textField_fnaci = new JTextField();
		textField_fnaci.setBounds(292, 128, 200, 22);
		frame.getContentPane().add(textField_fnaci);
		textField_fnaci.setColumns(10);

		btnGuardar = new JButton("Añadir");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (dni == null) {  //TODO: El problema está aquí. El dni es siempre null o no es auto generado y da error. 

					try {
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNaci = format.parse(textField_fnaci.getText());
						
						agregarAlumno(textField_dni.getText(), TextField_nombre.getText(), textField_ap1.getText(),
								textField_ap2.getText(), Integer.parseInt(textField_telefono.getText()), fechaNaci);
						agregarCursa(textField_anho.getText(),Integer.parseInt(textField_nota.getText()),textField_dni.getText(),idModulo);
						
					} catch (NumberFormatException e) {
						System.out.println("Error, el valor introducido no es un digito.");
						
					} catch (Exception f) {
						System.out.println("Error, el valor introducido no es valido.");
						
					}

				} else {

					try {
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaNaci = format.parse(textField_fnaci.getText());
						
						editarAlumno(textField_dni.getText(), TextField_nombre.getText(), textField_ap1.getText(),
								textField_ap2.getText(), Integer.parseInt(textField_telefono.getText()), fechaNaci);
						editarCursa(textField_anho.getText(), Integer.parseInt(textField_nota.getText()),textField_dni.getText(),idModulo);
						
					} catch (NumberFormatException e) {
						System.out.println("Error, el valor introducido no es un digito.");
						
					}catch (Exception f) {
						System.out.println("Error, el valor introducido no es valido.");
						
					}
				}
				clearFields();
				recargarTabla();
			}
		});
		btnGuardar.setBounds(769, 26, 89, 23);
		frame.getContentPane().add(btnGuardar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearFields();
			}

		});
		btnLimpiar.setBounds(769, 78, 89, 23);
		frame.getContentPane().add(btnLimpiar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(769, 127, 89, 23);
		btnEliminar.setEnabled(false);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField_dni.getText() != null) { //TODO: cambié dni por textField_dni.getText().
					int res = JOptionPane.showConfirmDialog(null,
							"El alumno " + getNombre() + " se eliminará de forma permanente", "Eliminar",
							JOptionPane.OK_CANCEL_OPTION);
					if (res == JOptionPane.OK_OPTION) {
						eliminarAlumno(dni);
						eliminarCursa(idModulo, textField_dni.getText());
						clearFields();
						recargarTabla();
					}
				}
			}
		});
		frame.getContentPane().add(btnEliminar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 163, 848, 2);
		frame.getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 848, 384);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEliminar.setEnabled(true);
				btnGuardar.setText("Guardar");
				textField_dni.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
				TextField_nombre.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
				textField_ap1.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 2));
				textField_ap2.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 3));
				textField_telefono.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 4));
				textField_fnaci.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 5));
				textField_nota.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 6));
				textField_anho.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 7));
				
			}
		});
		scrollPane.setViewportView(table);

		recargarTabla();

	}

	private void recargarTabla() {
		DefaultTableModel tm = new DefaultTableModel();
		tm.addColumn("Dni");
		tm.addColumn("Nombre");
		tm.addColumn("1º Apellido");
		tm.addColumn("2º Apellido");
		tm.addColumn("Teléfono");
		tm.addColumn("Fecha Nacimiento");
		
		for (AlumnoVO alumno : transformarListaVO()) {
			for (CursaVO cursa : listarCursa()) {
				if (alumno.getDni().equals(cursa.getDni()) && idModulo == cursa.getIdModulo()) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					String fechaNaci = sdf.format(alumno.getFechaNaci());
					tm.addRow(new String[] { alumno.getDni(), alumno.getNombre(), alumno.getApellido1(),
							alumno.getApellido2(), String.valueOf(alumno.getTelefono()), fechaNaci});
				}
			}

		}

		table.setModel(tm);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	private void clearFields() {
		btnEliminar.setEnabled(false);
		btnGuardar.setText("Añadir");
		textField_dni.setText("");
		TextField_nombre.setText("");
		textField_ap1.setText("");
		textField_ap2.setText("");
		textField_telefono.setText("");
		textField_fnaci.setText("");
		table.clearSelection();
	}
}
