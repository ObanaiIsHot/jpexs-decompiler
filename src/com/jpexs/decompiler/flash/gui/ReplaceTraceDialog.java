/*
 * Copyright (C) 2014 JPEXS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpexs.decompiler.flash.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author JPEXS
 */
public class ReplaceTraceDialog extends AppDialog {
    
    private JRadioButton debugAlertRadio;
    private JRadioButton debugConsoleRadio;
    private JRadioButton debugProxyRadio;

    private String result = null;

    public String getResult() {
        return result;
    }
    
    public ReplaceTraceDialog(Window owner) {
        super(owner);
        setTitle(translate("dialog.title"));
        Container cnt=getContentPane();
        cnt.setLayout(new BoxLayout(cnt, BoxLayout.Y_AXIS));
        debugAlertRadio = new JRadioButton(translate("function.debugAlert"));
        debugAlertRadio.setAlignmentX(0);
        debugConsoleRadio = new JRadioButton(translate("function.debugConsole"));
        debugConsoleRadio.setAlignmentX(0);
        debugProxyRadio = new JRadioButton(translate("function.debugSocket"));
        debugProxyRadio.setAlignmentX(0);
        
        debugAlertRadio.setSelected(true);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(debugAlertRadio);
        bg.add(debugConsoleRadio);
        bg.add(debugProxyRadio);
        
        
        
        cnt.add(debugAlertRadio);
        cnt.add(debugConsoleRadio);
        cnt.add(debugProxyRadio);
        
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton okButton=new JButton(AppStrings.translate("button.ok"));
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(debugAlertRadio.isSelected()){
                    result = "debugAlert";
                }
                if(debugConsoleRadio.isSelected()){
                    result = "debugConsole";
                }
                if(debugProxyRadio.isSelected()){
                    result = "debugSocket";
                }
                setVisible(false);
            }
        });
        JButton cancelButton=new JButton(AppStrings.translate("button.cancel"));
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                result = null;
                setVisible(false);
            }
        });
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);      
        buttonsPanel.setAlignmentX(0);
        add(buttonsPanel);
        setModalityType(DEFAULT_MODALITY_TYPE);
        pack();
        View.setWindowIcon(this);
        View.centerScreen(this);
    }
    
}