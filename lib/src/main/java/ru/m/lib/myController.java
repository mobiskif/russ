package ru.m.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myController implements ActionListener {
	public myModel myModel;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Add thread")) {
			myModel.status= myModel.addThread();
		}
		if (e.getActionCommand().equalsIgnoreCase("Stop all")) {
			myModel.status= myModel.stopAll();
		}
	}
}
