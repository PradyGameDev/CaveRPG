import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PradyGameDev ^ SiDJ January 2016
 */
public class IslandsAndCaves implements MouseListener, KeyListener {

    final static int HEIGHT = 800, WIDTH = 800;
    static int height = HEIGHT / 100, width = WIDTH / 100;
    static JFrame frame;
    static IslandsAndCaves game;
    static JPanel props, top;
    static JButton[][] tiles;
    static Random r;
    static JButton player;//The tile the player is on currently
    static boolean change = false;//Has there been any shifting of tiles -- if yes, update map
    static Color[] colours = {Color.green, Color.blue, Color.red};
    static Color pColor, originalColour;
    static int[] coor;

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        game = new IslandsAndCaves();
        frame = new JFrame("IslandsAndCaves!");
        props = new JPanel(new GridLayout(height, width));
        top = new JPanel();
        r = new Random();
        pColor = new Color(220, 0, 70);
        coor = new int[2];//Stores the players coordinates
        tiles = new JButton[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new JButton((i + 1) + " " + (j + 1));
                tiles[i][j].addMouseListener(game);
                tiles[i][j].addKeyListener(game);
                tiles[i][j].setVisible(true);
                tiles[i][j].setBackground(colours[r.nextInt(colours.length)]);
                props.add(tiles[i][j]);
            }
        }
        props.addKeyListener(game);
        coor[0] = r.nextInt(height);
        coor[1] = r.nextInt(width);

        originalColour = tiles[coor[0]][coor[1]].getBackground();
        player = tiles[coor[0]][coor[1]];
        player.setBackground(pColor);

        frame.add(props);
        frame.add(top);
        frame.setContentPane(props);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public void renderGraphics() {//Called every frame to draw over all the images if there has been a change
        if (change) {
            change = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("Key pressed: " + e.getKeyCode());
    //This moves the player
// next, there should be a method to slowly, bring down a new row of tiles with random colours    
    switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                player.setBackground(originalColour);
                coor[1]--;
                try {
                    player = tiles[coor[0]][coor[1]];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    coor[1]++;
                }
                originalColour = player.getBackground();
                player.setBackground(pColor);
                break;
            }

            case KeyEvent.VK_UP: {
                player.setBackground(originalColour);
                coor[0]--;
                try {
                    player = tiles[coor[0]][coor[1]];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    coor[0]++;
                }
                originalColour = player.getBackground();
                player.setBackground(pColor);
                break;
            }
            case KeyEvent.VK_DOWN: {
                player.setBackground(originalColour);
                coor[0]++;
                try {
                    player = tiles[coor[0]][coor[1]];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    coor[0]--;
                }
                originalColour = player.getBackground();
                player.setBackground(pColor);
                break;
            }
            case KeyEvent.VK_RIGHT: {
                player.setBackground(originalColour);
                coor[1]++;
                try {
                    player = tiles[coor[0]][coor[1]];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    coor[1]--;
                }
                originalColour = player.getBackground();
                player.setBackground(pColor);
                break;
            }
            default:
                break;
        }
        System.out.println((coor[0] + 1) + " , " + (coor[1] + 1));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
