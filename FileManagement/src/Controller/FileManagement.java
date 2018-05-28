package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

public class FileManagement {

	private String path;

	public FileManagement() {
		this.path = System.getProperty("user.dir") 
				+ File.separator + "src" 
				+ File.separator + "Files" 
				+ File.separator;
	}

	public void createFile(String name, String content) {		
		File file = new File(this.path + name + ".txt");
		if (file.exists())
			editFile(name, content);

		else {
			try {

				FileWriter out = new FileWriter(file);

				out.write(content);
				out.close();

				JOptionPane.showMessageDialog(null, "Archivo creado.");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	public void deleteFile(String name) {
		File file = new File(this.path  + name + ".txt");
		if (file.exists()) {
			file.delete();
			JOptionPane.showMessageDialog(null, "Archivo eliminado.");
		}

		else
			JOptionPane.showMessageDialog(null, "El archivo no existe.");
	}
	public void editFile(String name, String content) {
		File file = new File(this.path  + name + ".txt");
		if (file.exists()) {
			ArrayList<String> lines = new ArrayList<String>();
			String line = null;

			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				while ((line = br.readLine()) != null)
					lines.add(line);

				lines.add(content);
				fr.close();
				br.close();

				FileWriter fw = new FileWriter(file);
				BufferedWriter out = new BufferedWriter(fw);

				for (String l : lines) {
					out.write(l);
				}

				out.flush();
				out.close();

				JOptionPane.showMessageDialog(null, "Archivo editado.");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		else
			JOptionPane.showMessageDialog(null, "El archivo no existe.");
	}
	public String showFile(String name) {
		File file = new File(this.path  + name + ".txt");
		if (file.exists()) {
			String content = "";

			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				String line;
				while ((line = br.readLine()) != null)
					content += line + '\n';

				fr.close();
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return content;
		}

		else {
			JOptionPane.showMessageDialog(null, "El archivo no existe.");
			return "";
		}
	}
	public String showAllFiles() {
		File file = new File(path);
		String[] files = file.list();

		String list = "";
		for (String f : files) {
			list += f + '\n';
		}

		return list;
	}
	public void createProperty(String name, String content) {
		File file = new File(this.path + name + ".properties");		
		Properties properties = new Properties();
		
		String[] data1 = content.split("\n");
		String data2 = "";
		
		for (int i = 0; i < data1.length; i++) {
			data2 += data1[i];
			if (i < data1.length - 1)
				data2 += "=";
		}
		
		String[] data3 = data2.split("=");
		
		for (int i = 0; i < data3.length; i+=2)
			properties.put(data3[i], data3[i + 1]);
		
		try {
			FileOutputStream fr = new FileOutputStream(file);
			properties.store(fr, "Prueba");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String showProperties(String name) {
		File file = new File(this.path + name + ".properties");
		if (file.exists()) {
			Properties properties = new Properties();
			String data = "";
			
			try {
				  properties.load(new FileInputStream(file));
				  for(String key : properties.stringPropertyNames()) {
					  String value = properties.getProperty(key);
					  data += key + " => " + value + '\n';
					}
				} catch (IOException e) {}
			return data;
		}
		
		else {
			JOptionPane.showMessageDialog(null, "El archivo no existe.");
			return "";
		}
	}
}