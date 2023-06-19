package GUI;

import Comp_Decomp.Compressor;
import Comp_Decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton ;

    JButton decompressButton;

    AppFrame() {
        this.setSize(500, 400);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);


        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20 , 100, 200, 40);
        compressButton.addActionListener(this);
        this.add(compressButton);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 40);
        decompressButton.addActionListener(this);



        this.add(decompressButton);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressButton) {

            JFileChooser filechooser = new JFileChooser();

            int response = filechooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());

                System.out.print(file);

                try {

                    Compressor.method(file);

                } catch (Exception ee) {

                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

        if(e.getSource()==decompressButton) {

            JFileChooser filechooser = new JFileChooser();

            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(filechooser.getSelectedFile().getAbsolutePath());

                System.out.print(file);

                try {
                    Decompressor.method(file);
                } catch (Exception ee) {

                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }

    }
}
