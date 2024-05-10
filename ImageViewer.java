import com.sun.jdi.ClassNotLoadedException;
import javax.imageio.ImageIO ;
import java.awt.color.ColorSpace;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.File ;
import java.io.FilePermission;
import java.io.IOException ;
import java.awt.image.BufferedImage ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.Buffer;
import java.util.concurrent.ExecutionException;
import java.lang.Object ;

public class ImageViewer extends JFrame implements ActionListener {

    JButton chooseImage ;
    JButton showImage ;
    JButton brightness ;
    JButton grayScale ;
    JButton reSize ;
    JButton exit ;
    JButton showBrightnessChanges ;
    JButton showResizeChanges ;
    JButton backButton ;
    JTextField brightnessLevel ;
    JTextField width ;
    JTextField height ;
   private final String filePath = "Images";
   File file ;
   BufferedImage bufferedImage ;
   float brightnessLevelNumber = 1 ;
   int h = 900 ;
   int w = 1200 ;
    JFileChooser fileChooser = new JFileChooser(filePath) ;

    ImageViewer(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(1200 , 900);
        this.setVisible(true) ;
        this.setResizable(true) ;

        mainPanel();
    }


    public void mainPanel(){
        JPanel mainPanel = new JPanel() ;
        mainPanel.setLayout(null) ;
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setSize(1200 , 900) ;

        JPanel buttonsPanel = new JPanel() ;
        buttonsPanel.setBounds(400 , 250  , 400 , 200);
        buttonsPanel.setLayout(new GridLayout(3 , 2 , 0 , 0 ));

        buttonsPanel.add(mainPanel) ;
        this.add(mainPanel) ;


        JLabel label1 = new JLabel("Image Viewer") ;
        label1.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        label1.setBounds(520 , 100 ,  250 , 150);
        mainPanel.add(label1) ;


        chooseImage = new JButton("Choose Image") ;
        this.chooseImage.addActionListener(this);
        this.chooseImage.setSize(130 , 100);
        this.chooseImage.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.chooseImage.setForeground(Color.BLACK);
        this.chooseImage.addActionListener(this);
        this.chooseImage.setFocusable(false);
        this.chooseImage.setVisible(true);

        buttonsPanel.add(this.chooseImage) ;
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        showImage = new JButton("Show Image") ;
        this.showImage.setSize(130 , 100);
        this.showImage.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.showImage.setForeground(Color.BLACK);
        this.showImage.addActionListener(this);
        this.showImage.setFocusable(false);
        this.showImage.setVisible(true);

        buttonsPanel.add(this.showImage) ;
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        brightness = new JButton("Brightness") ;
        this.brightness.setSize(130 , 100);
        this.brightness.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.brightness.setForeground(Color.BLACK);
        this.brightness.addActionListener(this);
        this.brightness.setFocusable(false);
        this.brightness.setVisible(true);

        buttonsPanel.add(this.brightness );
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        grayScale = new JButton("Gray scale") ;
        this.grayScale.setSize(130 , 100);
        this.grayScale.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.grayScale.setForeground(Color.BLACK);
        this.grayScale.addActionListener(this);
        this.grayScale.setFocusable(false);
        this.grayScale.setVisible(true);

        buttonsPanel.add(this.grayScale) ;
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        reSize = new JButton("Resize") ;
        this.reSize.setSize(130 , 100);
        this.reSize.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.reSize.setForeground(Color.BLACK);
        //addActionListener for resizing !
        this.reSize.addActionListener(this);
        this.reSize.setFocusable(false);
        this.reSize.setVisible(true);

        buttonsPanel.add(this.reSize) ;
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        exit = new JButton("Exit") ;
        this.exit.setSize(130 , 100);
        this.exit.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
        this.exit.setForeground(Color.BLACK);
        this.exit.addActionListener(this);
        this.exit.setFocusable(false);
        this.exit.setVisible(true);

        //add hand-cursor to make our main panel more beautiful
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR) ;
        chooseImage.setCursor(cursor);
        showImage.setCursor(cursor);
        brightness.setCursor(cursor);
        grayScale.setCursor(cursor);
        reSize.setCursor(cursor);
        exit.setCursor(cursor);



        buttonsPanel.add(this.exit) ;
        buttonsPanel.setVisible(true);
        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);
        this.add(mainPanel) ;
        this.setVisible(true);

        buttonsPanel.setVisible(true);

        mainPanel.add(buttonsPanel) ;
        mainPanel.setVisible(true);

        this.add(mainPanel) ;
        this.setVisible(true);
    }

    //if we select resize
    public void resizePanel(){

        //welcoming text for resize section
        JPanel resizePanel = new JPanel() ;
        resizePanel.setLayout(null);
        resizePanel.setBackground(Color.GRAY);
        resizePanel.setBounds(0 , 0 , 1200 , 900);
        resizePanel.setVisible(true);
        this.add(resizePanel) ;
        this.setVisible(true);

        JLabel resizeSection = new JLabel("Resize Section") ;
        resizeSection.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        resizeSection.setBounds(500 , 200 , 250 , 150);
        resizeSection.setVisible(true);

        resizePanel.add(resizeSection) ;
        this.add(resizePanel) ;

        //text fields and texts for resizing
        JLabel widthResize = new JLabel("Width") ;
        JLabel heightResize = new JLabel("Height") ;
        widthResize.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        heightResize.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        widthResize.setBounds(250 , 390 , 200 , 100);
        heightResize.setBounds(250 , 510 , 200 , 100);
        widthResize.setVisible(true);
        heightResize.setVisible(true);

        resizePanel.add(widthResize) ;
        resizePanel.add(heightResize) ;
        this.add(resizePanel) ;

        width  = new JTextField() ;
        height = new JTextField() ;
        width.setEditable(true) ;
        height.setEditable(true) ;
        this.width.setBounds(500 , 420 , 150 , 40);
        this.height.setBounds(500 , 540 , 150 , 40);
        this.width.setPreferredSize(new Dimension(100 , 50));
        this.height.setPreferredSize(new Dimension(100 , 50));
        this.width.setVisible(true);
        this.height.setVisible(true);

        resizePanel.add(width) ;
        resizePanel.add(height) ;
        this.add(resizePanel) ;

        this.backButton = new JButton("Back") ;
        this.backButton.addActionListener(this);
        Cursor cursor =  new Cursor(Cursor.HAND_CURSOR );
        this.backButton.setCursor(cursor);
        this.backButton.setBounds(100  , 750 , 200 , 100);
        this.backButton.setFocusable(false);
        this.backButton.setVisible(true);

        resizePanel.add(backButton) ;
        this.add(resizePanel) ;

        this.showResizeChanges = new JButton("Show Result") ;
        this.showResizeChanges.addActionListener(this);
        this.showResizeChanges.setBounds( 800 , 750 , 200 , 100);
        this.showResizeChanges.setCursor(cursor);
        this.showResizeChanges.setFocusable(false);
        this.showResizeChanges.setVisible(true);


        resizePanel.add(showResizeChanges) ;
        this.add(resizePanel) ;


        //read our new width and height from user
        // w =  Integer.parseInt(width.getText()) ;
        // h =  Integer.parseInt(height.getText()) ;


    }

    public void showResizeImage( int widthScale , int heightScale ){

        try{

            JFrame tempFrame = new JFrame() ;
            JPanel tempPanel = new JPanel() ;

            tempFrame.setSize(1800, 1000);
            tempPanel.setSize(1800 ,1000);
            tempFrame.setTitle("Image viewer");
            tempFrame.setVisible(true);
            tempPanel.setVisible(true);

            file = fileChooser.getSelectedFile() ;
            bufferedImage = ImageIO.read(file) ;

            BufferedImage bridgeImage = new BufferedImage(1500 , 1000 , bufferedImage.getType()) ;
            Graphics graphics1 = bridgeImage.createGraphics() ;
            graphics1.drawImage(bufferedImage , 0 , 0 , 1500 , 1000 , null) ;
            graphics1.dispose();

            BufferedImage outputImage = new BufferedImage(widthScale , heightScale , bridgeImage.getType()) ;

            Graphics graphics = outputImage.createGraphics() ;
            graphics.drawImage(bridgeImage , 0 , 0 , widthScale , heightScale , null) ;
            graphics.dispose() ;


            JLabel label = new JLabel() ;
            ImageIcon imageIcon = new ImageIcon(outputImage) ;
            label.setIcon(imageIcon);
            tempPanel.add(label) ;
            tempPanel.setVisible(true) ;
            tempFrame.add(tempPanel) ;
            tempFrame.setVisible(true);

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    //if we select brightness
    public void brightnessPanel(){

        JPanel brightnessPanel = new JPanel() ;
        brightnessPanel.setLayout(null) ;
        brightnessPanel.setSize(1200 , 900);
        brightnessPanel.setBackground(Color.GRAY);
        brightnessPanel.setVisible(true);
        this.add(brightnessPanel) ;

        JLabel enter = new JLabel("Enter f") ;
        enter.setBounds(260 , 350 , 250 , 100);
        enter.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        enter.setVisible(true);

        brightnessPanel.add(enter) ;
        this.add(brightnessPanel) ;

        JLabel parentheses = new JLabel("(must be between 0 and 1)") ;
        parentheses.setBounds(150 , 400 , 300 , 150);
        parentheses.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
        parentheses.setVisible(true);


        brightnessPanel.add(parentheses) ;
        this.add(brightnessPanel) ;

        brightnessLevel = new JTextField() ;
        brightnessLevel.setBounds(500 , 380 , 150 , 40);
        brightnessLevel.setPreferredSize(new Dimension(100 ,50));
        brightnessLevel.setVisible(true);

        brightnessPanel.add(brightnessLevel) ;
        this.add(brightnessPanel) ;

        backButton = new JButton("Back") ;
        backButton.addActionListener(this);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setBounds(150  , 750 , 200 , 100);
        backButton.setVisible(true);
        backButton.setFocusable(false);

        brightnessPanel.add(backButton) ;
        this.add(brightnessPanel) ;

        showBrightnessChanges = new JButton("Result") ;
        showBrightnessChanges.addActionListener(this);
        showBrightnessChanges.setFocusable(false);
        showBrightnessChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showBrightnessChanges.setBounds(800 , 750 , 200 , 100);
        showBrightnessChanges.setVisible(true);

        brightnessPanel.add(showBrightnessChanges) ;
        this.add(brightnessPanel) ;
    }

    public void showBrightnessImage(float f){

        try{
            JFrame tempFrame = new JFrame() ;
            JPanel tempPanel = new JPanel() ;

            tempFrame.setSize(1800 ,  1000);
            tempPanel.setSize(1800 , 1000);
            tempFrame.setTitle("Image Viewer");

            file = fileChooser.getSelectedFile() ;
            bufferedImage = ImageIO.read(file) ;

            RescaleOp rescaleOp = new RescaleOp( f , 0 , null) ;

            BufferedImage output = new BufferedImage(1500  , 1000 , bufferedImage.getType()) ;
            Graphics graphics = output.createGraphics() ;
            graphics.drawImage(bufferedImage , 0 , 0 , 1500 ,  1000 , null) ;
            graphics.dispose() ;


            JLabel label = new JLabel() ;
            ImageIcon imageIcon = new ImageIcon(rescaleOp.filter(output , null)) ;
            label.setIcon(imageIcon) ;
            tempPanel.add(label) ;
            tempPanel.setVisible(true) ;
            tempFrame.add(tempPanel) ;
            tempFrame.setVisible(true) ;

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //if we select grayScale
    public void grayScaleImage(){


        try{

            JFrame tempFrame = new JFrame() ;
            tempFrame.setSize(1800 , 1000);
            tempFrame.setTitle("Image Viewer");

            JPanel tempPanel = new JPanel() ;
            tempPanel.setSize(1800 , 1000);

            file = fileChooser.getSelectedFile() ;
            bufferedImage = ImageIO.read(file) ;

            for (int x = 0; x < bufferedImage.getWidth(); ++x)
                for (int y = 0; y < bufferedImage.getHeight(); ++y)
                {
                    int rgb = bufferedImage.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = (rgb & 0xFF);

                    // Normalize and gamma correct:
                    float rr = (float) Math.pow(r / 255.0, 2.2);
                    float gg = (float)Math.pow(g / 255.0, 2.2);
                    float bb = (float) Math.pow(b / 255.0, 2.2);

                    // Calculate luminance:
                    float sum = (float) (0.2126 * rr) + (float)(0.7152 * gg) + (float)(0.0722 * bb) ;

                    // Gamma compound and rescale to byte range:
                    int grayLevel = (int) (255.0 * Math.pow(sum, 1.0 / 2.2));
                    int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                    bufferedImage.setRGB(x, y, gray);
                }

            BufferedImage output = new BufferedImage(1500 , 1000 , bufferedImage.getType()) ;
            Graphics graphics = output.createGraphics() ;
            graphics.drawImage(bufferedImage , 0 , 0 , 1500 , 1000 , null, null ) ;
            graphics.dispose();


            ImageIcon imageIcon = new ImageIcon(output) ;
            JLabel label = new JLabel() ;
            label.setIcon(imageIcon) ;
            tempPanel.add(label) ;
            tempPanel.setVisible(true);
            tempFrame.add(tempPanel) ;
            tempFrame.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //if we select ChooseImage
    public void ChooseFileImage(){

        fileChooser.showSaveDialog(null) ;
        fileChooser.setAcceptAllFileFilterUsed(false);
        file = fileChooser.getSelectedFile() ;
        fileChooser.setApproveButtonText("Are you sure ?") ;

    }

    //if we select ShowImage
    public void showOriginalImage(){

        try {
            file = fileChooser.getSelectedFile() ; //I made an object from the File Class at the first of the code
             bufferedImage = ImageIO.read(file); //new syntax for me !!!
            BufferedImage output = new BufferedImage(1500 , 1000 , bufferedImage.getType()) ;


            Graphics graphics = output.createGraphics() ;
            graphics.drawImage(bufferedImage , 0 , 0 , 1500 , 1000 , null, null ) ;
            graphics.dispose();

            JFrame tempFrame = new JFrame();
            ImageIcon imageIcon = new ImageIcon(output);

            tempFrame.setLayout(new FlowLayout());
            tempFrame.setTitle("Image Viewer");
            tempFrame.setSize(1800 , 1000);
            tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tempFrame.setVisible(true);
            tempFrame.setResizable(true);

            JPanel tempPanel = new JPanel() ;
            tempPanel.setBackground(Color.DARK_GRAY);
            tempPanel.setLayout(new FlowLayout());
            tempPanel.setSize(1800 , 1000);
            tempPanel.setVisible(true);

            JLabel label = new JLabel() ;
            label.setIcon(imageIcon);
            tempPanel.add(label) ;
            tempFrame.add(tempPanel);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==reSize){
            this.getContentPane().removeAll();
            this.resizePanel();
            this.revalidate();
            this.repaint() ;
        }

        if(e.getSource()==showResizeChanges){
            this.showResizeImage(Integer.parseInt(width.getText()) , Integer.parseInt(height.getText()) ) ;
            this.revalidate() ;
            this.repaint() ;
        }

        if(e.getSource()==brightness){
            this.getContentPane().removeAll();
            this.brightnessPanel();
            this.revalidate();
            this.repaint();
        }

        if(e.getSource()==showBrightnessChanges){
            this.showBrightnessImage(Float.parseFloat(brightnessLevel.getText()));
            this.revalidate();
            this.repaint();
        }
        if(e.getSource()==grayScale){
            this.grayScaleImage();
            this.revalidate();
            this.repaint();
        }

        if(e.getSource()==chooseImage){
            this.ChooseFileImage();
            this.revalidate();
            this.repaint();
        }

        if(e.getSource()==showImage){
            this.showOriginalImage();
            this.revalidate();
            this.repaint();
        }

        if(e.getSource()==exit){
            this.dispatchEvent(new WindowEvent(this , WindowEvent.WINDOW_CLOSING));
        }

        if(e.getSource()==backButton){
            this.getContentPane().removeAll();
            this.mainPanel();
            this.revalidate();
            this.repaint();
        }
    }
}
