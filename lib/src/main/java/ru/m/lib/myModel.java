package ru.m.lib;

import comp.myJButton;

import java.awt.*;

public class myModel implements Runnable {
	public myView myView;
	public myController myController;
	public String status;

	public myModel(myController myController) {
		myController.myModel = this;
		this.myController = myController;
	}

	public String addThread() {
		try {
			myJButton calc = new myJButton();
			new Thread(calc).start();
			myView.panel.add(calc);
		} catch (Exception e) {return "Error: addThread()  ";}
		return "Success: addThread() ";
	}

	public String stopAll() {
		try {
			for (Component comp : myView.panel.getComponents()) {
				comp.setVisible(false);
			}
		} catch (Exception e) {return "Error: stopAll() ";}
		return "Success: stopAll() ";
	}

	@Override
	public void run() {
		String load="";
		while (true) {
			double f = 0.0;
			int i = 0;
			for (Component comp : myView.panel.getComponents()) {
				i = comp.isVisible() ? i+1 : i;
				f = comp.getClass().getName().endsWith("myJButton") ? f + ((myJButton)comp).value : f;
			}
			String vsum = String.format("%.2f", f);
			myView.label.setText(i+ " threads    " + vsum + " MFlops   " + load);
			myView.status.setText(this.status);
			
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {}
		}
	}

}
