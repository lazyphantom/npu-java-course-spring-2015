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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jie
 */
public class Frame extends JFrame{
    public Frame() {
        this.setTitle("Calcuator");
        initComponents();
    }
    private JTextField jtf = new JTextField();
    private void initComponents() 
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);        //設定視窗預設關閉行為
        Container contentPane = this.getContentPane();                              //取得JFrame的容器
        contentPane.setLayout(new GridBagLayout());                                 //將JFrame的Layout設為GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        jtf.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        contentPane.add(jtf, gbc);
        
        
        int num = 0;
        for(int x=1; x<5; x++)
        {
            for(int o=1; o<5; o++)
                gbc.gridx = x;
                gbc.gridy = y;
                contentPane.add(new JButton(""+num++), gbc);
            }
        }/*
        gbc.gridx=0;
        gbc.gridy=5;
        //jtf.setPreferredSize(new java.awt.Dimension(90, 21));
        //contentPane.add(jtf, gbc);*/
        this.pack();
    }
    
}
