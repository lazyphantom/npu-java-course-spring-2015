/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jie
 */
public class View extends JFrame implements Observer{

    private Calculator mCalculator;
    private JTextField mJTextField;
    private ArrayList<Button> mButtonList = new ArrayList<Button>();
    private int num;
    private String []sign =  {"MC", "MR", "M+", "M-", "MS", "√", "%", "1/x", "CE", "C", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".", "="};
    
    public View(Calculator c) {
        this.setTitle("Calcuator");
        initComponents();
        num = 0;
        mCalculator = c;
        mCalculator.Attach(this);
    }
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        //設定視窗預設關閉行為
        Container contentPane = this.getContentPane();                              //取得JFrame的容器
        contentPane.setLayout(new GridBagLayout());                                 //將JFrame的Layout設為GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        //gbc.fill = java.awt.GridBagConstraints.BOTH;
        mJTextField = new JTextField();
        mJTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mJTextField.setPreferredSize(new java.awt.Dimension(252, 21));
        mJTextField.setText("");
        contentPane.add(mJTextField, gbc);
        for(int y=1; y<8; y++) {
            for(int x=0; x<4; x++) {
                gbc.gridwidth = 1;
                gbc.gridx = x;
                gbc.gridy = y;
                mButtonList.add(new Button(this, num, sign[num]));
                contentPane.add(mButtonList.get(num), gbc);
                num++;
            }
        }
        this.pack();
    }
    void onClick(int index) {
        mCalculator.Convert(index);
    }
    
    @Override
    public void Update() {
        this.mJTextField.setText(mCalculator.getDisplay());
    }

}
