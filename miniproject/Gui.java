import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BasicStroke;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Gui extends JPanel{

    private JFrame Start;
    private JButton easy,normal,hard;
    private JLabel label,label1,label2,text;
    private BufferedImage background,background1,background2;

    public Gui(){

        Start = new JFrame("Mine Sweaper");
        Start.setSize(900, 600);
        Start.setLocationRelativeTo(null);
        Start.setResizable(false);
        Start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try {
            background = ImageIO.read(new File("miniproject\\image\\2.png"));
            background1 = ImageIO.read(new File("miniproject\\image\\3.png"));
            background2 = ImageIO.read(new File("miniproject\\image\\4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

//----------------------------------------------------------------------------------------------------------------------

        label = new JLabel("9X9 10 ทุ่นระเบิด");
        label.setForeground(Color.WHITE);
        label.setBounds(120, 170, 300, 110);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            label.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        label1 = new JLabel("16X16 40 ทุ่นระเบิด");
        label1.setForeground(Color.WHITE);
        label1.setBounds(100, 320, 300, 110);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            label1.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        label2 = new JLabel("30X16 99 ทุ่นระเบิด");
        label2.setForeground(Color.WHITE);
        label2.setBounds(90, 470, 300, 110);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            label2.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        text = new JLabel("MINIPROJECT ค้าบอ้วน!!");
        text.setForeground(Color.WHITE);
        text.setBounds(70, 30, 300, 50);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            text.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


//----------------------------------------------------------------------------------------------------------------------

        easy = new JButton("ง่าย");
        easy.setBounds(70, 130, 280, 60);
        easy.setForeground(Color.WHITE);
        easy.setBackground(Color.decode("#4a4a4a"));
        easy.setContentAreaFilled(true);
        easy.setFocusPainted(false);
        easy.setBorder(new LineBorder(Color.white, 4));
        easy.setHorizontalAlignment(SwingConstants.CENTER); 
        easy.setVerticalAlignment(SwingConstants.CENTER);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            easy.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        easy.addActionListener(e -> startGame(9, 9, 10));

        normal = new JButton("ปานกลาง");
        normal.setBounds(70, 270, 280, 60);
        normal.setBackground(Color.decode("#4a4a4a"));
        normal.setForeground(Color.WHITE);
        normal.setContentAreaFilled(true);
        normal.setFocusPainted(false);
        normal.setBorder(new LineBorder(Color.white,4));
        normal.setVerticalAlignment(SwingConstants.CENTER);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            normal.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        normal.addActionListener(e -> startGame(16, 16, 40));
        

        hard = new JButton("ยาก");
        hard.setBounds(70, 420, 280, 60);
        hard.setBackground(Color.decode("#4a4a4a"));
        hard.setForeground(Color.WHITE);
        hard.setContentAreaFilled(true);
        hard.setFocusPainted(false);
        hard.setBorder(new LineBorder(Color.white, 4));
        hard.setVerticalAlignment(SwingConstants.CENTER);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("miniproject\\font\\ZFTERMIN__.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            hard.setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        hard.addActionListener(e -> startGame(30, 16, 99));

        

        this.setLayout(null); 
        this.setBackground(Color.decode("#161c26"));

        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(text);
        this.add(easy);
        this.add(normal);
        this.add(hard);

        Start.add(this);
        Start.setVisible(true);
    }
    

    

    @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

        /*Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.white);
        g2d.drawRect(430, 130, 400, 500);*/

        Graphics2D g3d = (Graphics2D) g;
        g3d.setStroke(new BasicStroke(4));
        g3d.setColor(Color.white);
        g3d.drawRoundRect(35, 110, 370, 450,20,20);
       

            if (background != null) {
                g.drawImage(background, 0, 0, this);
            }
            if (background1 != null) {
                g.drawImage(background1, 0, 0, this);
            }
            if (background2 != null) {
                g.drawImage(background2, 0, 0, this);
            }
        
        /*Graphics2D g1d = (Graphics2D) g;
        g1d.setStroke(new BasicStroke(4)); 
        g1d.setColor(Color.decode("#4a4a4a"));
        g1d.fillRoundRect(40, 20, 800, 70, 20, 20);
        g1d.setColor(Color.white);
        g1d.drawRoundRect(40, 20, 800, 70, 20, 20);*/

        }

        private void startGame(int rows, int cols, int numBombs) {
            JFrame gameFrame = new JFrame("Minesweeper");
            gameFrame.setSize(900, 600);
            gameFrame.setResizable(false);
            gameFrame.setLocationRelativeTo(null);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MinesweeperGame gamePanel = new MinesweeperGame(rows, cols, numBombs, gameFrame);
            gameFrame.add(gamePanel);
            gameFrame.setVisible(true);
            Start.setVisible(false);
        }

    public static void main(String[] args) {
        new Gui();
    }
}