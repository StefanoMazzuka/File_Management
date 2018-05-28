package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.FileManagement;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newFileNameTextField;
	private JTextField deleteTextField;
	private JTextField showTextField;
	private JTextField newProTextField;
	private JTextField showProTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		FileManagement fm = new FileManagement();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "newFilePanel");
			}
		});

		mnArchivo.add(mntmNuevo);

		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "deletePanel");
			}
		});
		
		mnArchivo.add(mntmBorrar);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "showPanel");
			}
		});
		mnArchivo.add(mntmMostrar);
		
		JMenuItem mntmMostrarTodo = new JMenuItem("Mostrar todo");
		mntmMostrarTodo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "showAllPanel");
			}
		});
		mnArchivo.add(mntmMostrarTodo);
		
		JMenu mnProperties = new JMenu("Properties");
		menuBar.add(mnProperties);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mntmNuevo_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "newProPanel");
			}
		});
		mnProperties.add(mntmNuevo_1);
		
		JMenuItem mntmMostrar_1 = new JMenuItem("Mostrar");
		mntmMostrar_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "showProPanel");
			}
		});
		mnProperties.add(mntmMostrar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel newFilePanel = new JPanel();
		contentPane.add(newFilePanel, "newFilePanel");
		GridBagLayout gbl_newFilePanel = new GridBagLayout();
		gbl_newFilePanel.columnWidths = new int[]{0, 0, 0};
		gbl_newFilePanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_newFilePanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_newFilePanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		newFilePanel.setLayout(gbl_newFilePanel);

		JLabel newFileNameLabel = new JLabel("Nombre del archivo:");
		GridBagConstraints gbc_newFileNameLabel = new GridBagConstraints();
		gbc_newFileNameLabel.anchor = GridBagConstraints.EAST;
		gbc_newFileNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newFileNameLabel.gridx = 0;
		gbc_newFileNameLabel.gridy = 0;
		newFilePanel.add(newFileNameLabel, gbc_newFileNameLabel);

		newFileNameTextField = new JTextField();
		GridBagConstraints gbc_newFileNameTextField = new GridBagConstraints();
		gbc_newFileNameTextField.anchor = GridBagConstraints.WEST;
		gbc_newFileNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_newFileNameTextField.gridx = 1;
		gbc_newFileNameTextField.gridy = 0;
		newFilePanel.add(newFileNameTextField, gbc_newFileNameTextField);
		newFileNameTextField.setColumns(10);

		JScrollPane newFileScrollPane = new JScrollPane();
		GridBagConstraints gbc_newFileScrollPane = new GridBagConstraints();
		gbc_newFileScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_newFileScrollPane.gridwidth = 2;
		gbc_newFileScrollPane.fill = GridBagConstraints.BOTH;
		gbc_newFileScrollPane.gridx = 0;
		gbc_newFileScrollPane.gridy = 1;
		newFilePanel.add(newFileScrollPane, gbc_newFileScrollPane);

		JTextArea newFileTextArea = new JTextArea();
		newFileScrollPane.setViewportView(newFileTextArea);

		JButton newFileSaveButton = new JButton("Guardar");
		GridBagConstraints gbc_newFileSaveButton = new GridBagConstraints();
		gbc_newFileSaveButton.gridx = 1;
		gbc_newFileSaveButton.gridy = 2;
		newFilePanel.add(newFileSaveButton, gbc_newFileSaveButton);

		JPanel deletePanel = new JPanel();
		contentPane.add(deletePanel, "deletePanel");
		GridBagLayout gbl_deletePanel = new GridBagLayout();
		gbl_deletePanel.columnWidths = new int[]{0, 0, 0};
		gbl_deletePanel.rowHeights = new int[]{0, 0, 0};
		gbl_deletePanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_deletePanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		deletePanel.setLayout(gbl_deletePanel);

		JLabel lblNewLabel = new JLabel("Nombre del archivo:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		deletePanel.add(lblNewLabel, gbc_lblNewLabel);

		deleteTextField = new JTextField();
		GridBagConstraints gbc_deleteTextField = new GridBagConstraints();
		gbc_deleteTextField.insets = new Insets(0, 0, 5, 0);
		gbc_deleteTextField.anchor = GridBagConstraints.WEST;
		gbc_deleteTextField.gridx = 1;
		gbc_deleteTextField.gridy = 0;
		deletePanel.add(deleteTextField, gbc_deleteTextField);
		deleteTextField.setColumns(10);

		JButton deleteButton = new JButton("Borrar");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = deleteTextField.getText();
				fm.deleteFile(fileName);
			}
		});
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.gridx = 1;
		gbc_deleteButton.gridy = 1;
		deletePanel.add(deleteButton, gbc_deleteButton);
		
		JPanel editPanel = new JPanel();
		contentPane.add(editPanel, "editPanel");
		
		JPanel showPanel = new JPanel();
		contentPane.add(showPanel, "showPanel");
		GridBagLayout gbl_showPanel = new GridBagLayout();
		gbl_showPanel.columnWidths = new int[]{0, 0, 0};
		gbl_showPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_showPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_showPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		showPanel.setLayout(gbl_showPanel);
		
		JLabel showLabel = new JLabel("Nombre del archivo:");
		GridBagConstraints gbc_showLabel = new GridBagConstraints();
		gbc_showLabel.anchor = GridBagConstraints.EAST;
		gbc_showLabel.insets = new Insets(0, 0, 5, 5);
		gbc_showLabel.gridx = 0;
		gbc_showLabel.gridy = 0;
		showPanel.add(showLabel, gbc_showLabel);
		
		showTextField = new JTextField();
		GridBagConstraints gbc_showTextField = new GridBagConstraints();
		gbc_showTextField.anchor = GridBagConstraints.WEST;
		gbc_showTextField.insets = new Insets(0, 0, 5, 0);
		gbc_showTextField.gridx = 1;
		gbc_showTextField.gridy = 0;
		showPanel.add(showTextField, gbc_showTextField);
		showTextField.setColumns(10);
		
		JScrollPane showScrollPane = new JScrollPane();
		GridBagConstraints gbc_showScrollPane = new GridBagConstraints();
		gbc_showScrollPane.gridwidth = 2;
		gbc_showScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_showScrollPane.fill = GridBagConstraints.BOTH;
		gbc_showScrollPane.gridx = 0;
		gbc_showScrollPane.gridy = 1;
		showPanel.add(showScrollPane, gbc_showScrollPane);
		
		JTextArea showTextArea = new JTextArea();
		showScrollPane.setViewportView(showTextArea);
		
		JButton showButton = new JButton("Mostrar");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = showTextField.getText();
				String content = fm.showFile(fileName);
				showTextArea.setText(content);
			}
		});
		GridBagConstraints gbc_showButton = new GridBagConstraints();
		gbc_showButton.gridx = 1;
		gbc_showButton.gridy = 2;
		showPanel.add(showButton, gbc_showButton);
		
		JPanel showAllPanel = new JPanel();
		contentPane.add(showAllPanel, "showAllPanel");
		GridBagLayout gbl_showAllPanel = new GridBagLayout();
		gbl_showAllPanel.columnWidths = new int[]{0, 0, 0};
		gbl_showAllPanel.rowHeights = new int[]{97, 0, 0};
		gbl_showAllPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_showAllPanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		showAllPanel.setLayout(gbl_showAllPanel);
		
		JScrollPane showAllScrollPane = new JScrollPane();
		GridBagConstraints gbc_showAllScrollPane = new GridBagConstraints();
		gbc_showAllScrollPane.gridwidth = 2;
		gbc_showAllScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_showAllScrollPane.fill = GridBagConstraints.BOTH;
		gbc_showAllScrollPane.gridx = 0;
		gbc_showAllScrollPane.gridy = 0;
		showAllPanel.add(showAllScrollPane, gbc_showAllScrollPane);
		
		JTextArea showAllTextArea = new JTextArea();
		showAllScrollPane.setViewportView(showAllTextArea);
		
		JButton showAllButton = new JButton("Mostrar todo");
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String allFiles = fm.showAllFiles();	
				showAllTextArea.setText(allFiles);
			}
		});
		GridBagConstraints gbc_showAllButton = new GridBagConstraints();
		gbc_showAllButton.gridx = 1;
		gbc_showAllButton.gridy = 1;
		showAllPanel.add(showAllButton, gbc_showAllButton);
		
		JPanel newProPanel = new JPanel();
		contentPane.add(newProPanel, "newProPanel");
		GridBagLayout gbl_newProPanel = new GridBagLayout();
		gbl_newProPanel.columnWidths = new int[]{0, 0, 0};
		gbl_newProPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_newProPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_newProPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		newProPanel.setLayout(gbl_newProPanel);
		
		JLabel newProLabel = new JLabel("Nombre del Propertie:");
		GridBagConstraints gbc_newProLabel = new GridBagConstraints();
		gbc_newProLabel.anchor = GridBagConstraints.EAST;
		gbc_newProLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newProLabel.gridx = 0;
		gbc_newProLabel.gridy = 0;
		newProPanel.add(newProLabel, gbc_newProLabel);
		
		newProTextField = new JTextField();
		GridBagConstraints gbc_newProTextField = new GridBagConstraints();
		gbc_newProTextField.anchor = GridBagConstraints.WEST;
		gbc_newProTextField.insets = new Insets(0, 0, 5, 0);
		gbc_newProTextField.gridx = 1;
		gbc_newProTextField.gridy = 0;
		newProPanel.add(newProTextField, gbc_newProTextField);
		newProTextField.setColumns(10);
		
		JScrollPane newProScrollPane = new JScrollPane();
		GridBagConstraints gbc_newProScrollPane = new GridBagConstraints();
		gbc_newProScrollPane.gridwidth = 2;
		gbc_newProScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_newProScrollPane.fill = GridBagConstraints.BOTH;
		gbc_newProScrollPane.gridx = 0;
		gbc_newProScrollPane.gridy = 1;
		newProPanel.add(newProScrollPane, gbc_newProScrollPane);
		
		JTextArea newProTextArea = new JTextArea();
		newProScrollPane.setViewportView(newProTextArea);
		
		JButton newProButton = new JButton("Guardar");
		newProButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = newProTextField.getText();
				String content = newProTextArea.getText();
				fm.createProperty(fileName, content);
			}
		});
		GridBagConstraints gbc_newProButton = new GridBagConstraints();
		gbc_newProButton.gridx = 1;
		gbc_newProButton.gridy = 2;
		newProPanel.add(newProButton, gbc_newProButton);
		
		JPanel showProPanel = new JPanel();
		contentPane.add(showProPanel, "showProPanel");
		GridBagLayout gbl_showProPanel = new GridBagLayout();
		gbl_showProPanel.columnWidths = new int[]{0, 0, 0};
		gbl_showProPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_showProPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_showProPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		showProPanel.setLayout(gbl_showProPanel);
		
		JLabel showProLabel = new JLabel("Nombre del Propertie:");
		GridBagConstraints gbc_showProLabel = new GridBagConstraints();
		gbc_showProLabel.anchor = GridBagConstraints.EAST;
		gbc_showProLabel.insets = new Insets(0, 0, 5, 5);
		gbc_showProLabel.gridx = 0;
		gbc_showProLabel.gridy = 0;
		showProPanel.add(showProLabel, gbc_showProLabel);
		
		showProTextField = new JTextField();
		GridBagConstraints gbc_showProTextField = new GridBagConstraints();
		gbc_showProTextField.anchor = GridBagConstraints.WEST;
		gbc_showProTextField.insets = new Insets(0, 0, 5, 0);
		gbc_showProTextField.gridx = 1;
		gbc_showProTextField.gridy = 0;
		showProPanel.add(showProTextField, gbc_showProTextField);
		showProTextField.setColumns(10);
		
		JScrollPane showProScrollPane = new JScrollPane();
		GridBagConstraints gbc_showProScrollPane = new GridBagConstraints();
		gbc_showProScrollPane.gridwidth = 2;
		gbc_showProScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_showProScrollPane.fill = GridBagConstraints.BOTH;
		gbc_showProScrollPane.gridx = 0;
		gbc_showProScrollPane.gridy = 1;
		showProPanel.add(showProScrollPane, gbc_showProScrollPane);
		
		JTextArea showProTextArea = new JTextArea();
		showProScrollPane.setViewportView(showProTextArea);
		
		JButton showProButton = new JButton("Mostrar");
		showProButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = showProTextField.getText();
				String content = fm.showProperties(fileName);
				showProTextArea.setText(content);
			}
		});
		GridBagConstraints gbc_showProButton = new GridBagConstraints();
		gbc_showProButton.gridx = 1;
		gbc_showProButton.gridy = 2;
		showProPanel.add(showProButton, gbc_showProButton);

		newFileSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = newFileNameTextField.getText();
				String content = newFileTextArea.getText();
				fm.createProperty(fileName, content);
			}
		});
	}
}