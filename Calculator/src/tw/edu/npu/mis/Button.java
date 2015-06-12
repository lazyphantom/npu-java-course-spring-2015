/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import javax.swing.JButton;

/**
 *
 * @author jie
 */
public class Button extends JButton {
    
    private View mView;
    private int index;
    public Button(View v, int index, String text) {
        this.mView = v;
        this.index = index;
        setPreferredSize(new java.awt.Dimension(60, 21));
        setText(text);
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mView.onClick(index);
            }
       });
    }
}
