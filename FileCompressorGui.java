import java.io.*;
import java.util.zip.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileCompressorGui extends JFrame{
    private JPanel mainPanel;
    private JTextField fileTextField;
    private JLabel fileLabel;
    private JButton compressButton;

    public void compress( File source, File destination) throws IOException{
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        GZIPOutputStream gos = new GZIPOutputStream(fos);
        int read;
        while((read = fis.read(buffer)) != -1){
            gos.write(buffer, read, 0);
        }
        gos.finish();
        gos.close();
        fos.close();
        fis.close();
    }
    public FileCompressorGui(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        compressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File source = new File(fileTextField.getText());
                File destination = new File("C:\\Users\\gshuk\\Desktop\\zipFiles\\compressed.rar");
                try{
                    compress(source,
                            destination);
                }
                catch(IOException f){
                    System.out.println("f");
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new FileCompressorGui( "My FIle Compressor.");
        frame.setVisible(true);
    }
}
