
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.KhohangDAO;
import model.Khohang;
import view.GUI;

public class QLKController implements ActionListener{
	private KhohangDAO tkDAO = new KhohangDAO();
	private GUI gui;
	
	public GUI view;
	
	
	public QLKController(GUI view) {
		this.view = view;
	}

	public QLKController() {
	}

	public void TonkhoController(KhohangDAO tkDAO, GUI gui) {
		this.tkDAO = tkDAO;
		this.gui = gui;
	}


	public ArrayList<Khohang> getListKhohangConTroller(){
		return tkDAO.getListTonkho();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(gui, "Bạn vừa nhấn vào"+cm);
		if(cm.equals("Tìm")) {
			this.view.xoaForm();
			this.view.Model.setLuachon("Thêm");
		}
	}
	public ArrayList<Khohang> getListKhohang(){
		return KhohangDAO.getListTonkho();
	}
	public static void main(String[] args) {
	    // Simulate creating a GUI instance (modify based on your GUI class)
	    GUI mockGUI = new GUI();

	    // Create a QLKController instance and associate it with the mock GUI
	    QLKController controller = new QLKController(mockGUI);

	    // Simulate a button click with "Tìm" action command
	    ActionEvent mockEvent = new ActionEvent(mockGUI, 0, "Tìm");
	    controller.actionPerformed(mockEvent);
	  }
	}
