/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package com.cburch.logisim.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.cburch.logisim.gui.main.Frame;
import com.cburch.logisim.gui.opts.OptionsFrame;
import com.cburch.logisim.gui.prefs.PreferencesFrame;
import com.cburch.logisim.proj.Project;
import com.cburch.logisim.proj.ProjectActions;
import com.cburch.logisim.util.MacCompatibility;

class MenuFile extends Menu implements ActionListener {
	private LogisimMenuBar menubar;
	private JMenuItem quit = new JMenuItem();

	public MenuFile(LogisimMenuBar menubar) {
		this.menubar = menubar;

		int menuMask = getToolkit().getMenuShortcutKeyMask();


		quit.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_Q, menuMask));





			add(quit);


		quit.addActionListener(this);
	}

	public void localeChanged() {
		this.setText(Strings.get("fileMenu"));

		quit.setText(Strings.get("fileQuitItem"));
	}

	@Override
	void computeEnabled() {
		setEnabled(true);
		menubar.fireEnableChanged();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == quit) {
			ProjectActions.doQuit();
		}
	}
}
