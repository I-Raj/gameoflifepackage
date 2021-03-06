package gameoflifepackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Grid extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Cell[][] grid = new Cell[100][100];
	private int numCols, numRows;
	private int cellSizeChange = 18;
	private Color cellColor=Color.YELLOW;
	private Color gridColor=Color.GRAY;

	public Grid() {
		// Can be changed later
		this.numCols = 80;
		this.numRows = 60;

		setBounds(100, 80, numCols * 10 + 1, numRows * 10 + 1);

		addMouseListener(this);
		addMouseMotionListener(this);
	
//		JButton next = new JButton("Next");
//		next.setBounds(130, 460, 60, 25);
//		add(next);
//		JButton start = new JButton("Start");
//		start.setBounds(208, 460, 60, 25);
//		add(start);
//		JSlider speed = new  JSlider(JSlider.HORIZONTAL,0,100,10);
//		speed.setBounds(280, 460, 110, 25);
//		add(speed);
//		JSlider resize = new  JSlider(JSlider.HORIZONTAL, 0, 100, 10);
//		resize.setBounds(410, 460, 110, 25);
//		add(resize);
//		resize.addComponentListener(new ComponentListener() {
//
//			public void componentHidden(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentMoved(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentResized(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentShown(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//		});
		setupGrid();
	}

	public void setupGrid() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				grid[row][col] = new Cell(false);
			}
		}
	}

	public int getNumCols() {
		return numCols;
	}

	public int getNumRows() {
		return numRows;
	}

	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
/*	public Color getcellColor() {
		return cellColor;
	}*/
	public void setcellColor(Color c) {
		cellColor = c;
	}
	public void setgridColor(Color col) {
		gridColor = col;
	}

	public void actionPerformed(ActionEvent event) {
		
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mouseReleased(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		int row = event.getY() / 18;
		int col = event.getX() / 18;
		grid[row][col].swapIsLiving();
//		System.out.print(row+" "+col);
		repaint();
	}

	public void mouseDragged(MouseEvent event) {
		mousePressed(event);
	}

	public void mouseMoved(MouseEvent event) {
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				g.setColor(Color.BLACK);
				g.drawRect(col * cellSizeChange, row * cellSizeChange, cellSizeChange, cellSizeChange);
//				if ((row + col) % 2 == 1) {
				if (grid[row][col].isLiving() == false) {
					g.setColor(gridColor);
				} else {
					g.setColor(cellColor);
				}
				g.fillRect(col * cellSizeChange + 1, row * cellSizeChange + 1, cellSizeChange - 1, cellSizeChange - 1);
			}
		}
	}

	public void setNewcellSize(int newSize) {
		cellSizeChange = (newSize >= 5 ? newSize : 18);
		repaint();
	}

	public void setInitailView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(false);
				cell.updateIsLiving();
			}
		}
	}

	public void exploreView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(true);
				cell.updateIsLiving();
			}
		}
	}
	public void SpaceshipView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(false);
				cell.updateIsLiving();
			     if((row==17&&(col==7||col==9)) || (row==18&&(col==8||col==9)) || (row==19)&&(col==8)||
				(row==15&&(col==14||col==15)) || (row==16&&(col==14||col==16)) || (row==17)&&(col==14)||
				(row==19&&(col==12)) || (row==20&&(col==12||col==13)) || ((row==21)&&(col==11 || col==13)) ||
				(row==17&&(col==31||col==32||col==33))|| (row==18 && (col==31 || col==34)) || (row==19 && (col==31))||
			        (row==20&&(col==31))||(row==21&&(col==32||col==34))
			       )
				cell.setWillLive(true);
				cell.updateIsLiving();
			}
		}
	}
	
	public void pulsarView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(false);
				cell.updateIsLiving();
			if((row == 6 &&(col == 16||col == 17 ||col == 18 ||col == 22||col == 23 ||col == 24 ))||
				   (row == 8 &&(col == 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 9 &&(col == 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 10 &&(col== 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 11 &&(col == 16||col == 17 ||col == 18 ||col == 22||col == 23 ||col == 24 ))||
				   (row == 13 &&(col == 16||col == 17 ||col == 18 ||col == 22||col == 23 ||col == 24 ))||
				   (row == 14 &&(col == 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 15 &&(col == 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 16 &&(col== 14||col == 19 ||col == 21 ||col == 26)) ||
				   (row == 18 &&(col == 16||col == 17 ||col == 18 ||col == 22||col == 23 ||col == 24 )))
				cell.setWillLive(true);
				cell.updateIsLiving();
			}
		}
	}
	public void gliderView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(false);
				cell.updateIsLiving();
				if ((row == 13 && (col == 29 ||col == 30 ||col == 40 ||col == 41)) ||
						(row == 14 && (col == 28 ||col == 30 ||col == 40 ||col == 41)) ||
						(row == 15 && (col == 6 ||col == 7 ||col == 15 ||col == 16||col == 28||col == 29)) ||
						(row == 16 && (col == 6 ||col == 7 ||col == 14 ||col == 16)) ||
						(row == 17 && (col == 14 ||col == 15 ||col == 22 ||col == 23)) ||
						(row == 18 && (col == 22 ||col == 24)) ||
						(row == 19 && (col == 22)) ||
						(row == 20 && (col == 41 ||col == 42)) ||
						(row == 21 && (col == 41 ||col == 43)) ||
						(row == 22 && (col == 41)) ||
						(row == 25 && (col == 30 ||col == 31 ||col == 32)) ||
						(row == 26 && (col == 30)) ||
						(row == 27 && (col == 31)))
					cell.setWillLive(true);
					cell.updateIsLiving();

			}

		}
	}
	
         public void blinkerView() {
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Cell cell = getCell(row, col);
				cell.setWillLive(false);
				cell.updateIsLiving();
				if((row==12&&(col==7||col==8||col==9)) ||
				    (row==13&&(col==6||col==8||col==9||col==10)) ||
				    (row==14&&(col==5||col==6||col==9||col==10||col==11)) ||
				    (row==15 && (col==6 || col==7||col==12))||
				    (row==16&&(col==6||col==7||col==9||col==10||col==11))||
				    (row==17 && (col==7||col==8||col==9||col==10))||
				    (row==18)&&(col==8)||
				    (row==15 && (col==14||col==15||col==16))||
				    (row==15 && (col==18||col==19||col==20))||
				    (row==15 && (col==22||col==23||col==24))||
				    (row==15 && (col==26||col==27||col==28)) ||
				    (row==15 && (col==30||col==31||col==32))||
				    (row==15 && (col==34||col==35||col==36)))
					 cell.setWillLive(true);
                                         cell.updateIsLiving();
			}
		}
	}
	public void coenView() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = getCell(row, col);
                cell.setWillLive(false);
                cell.updateIsLiving();
                if ((row == 6 && (col == 8 || col == 9 || col == 10 || col == 11 || col == 15 || col == 16 || col == 17 || col == 18 || col == 22 || col == 23 || col == 24 || col == 25 || col == 29 || col == 33)) ||
                        (row == 7 && (col == 8 || col == 15 || col == 18 || col == 22 || col == 29 || col == 30 || col == 33)) ||
                        (row == 8 && (col == 8 || col == 15 || col == 18 || col == 22 ||col == 23 ||col == 24 ||col == 25|| col == 29 || col == 31 || col == 33)) ||
                        (row == 9 && (col == 8 || col == 15 || col == 18 || col == 22 || col == 29 || col == 32 || col == 33)) ||
                        (row == 10 && (col == 8 || col == 9 || col == 10 || col == 11 || col == 15 || col == 16 || col == 17 || col == 18 || col == 22 || col == 23 || col == 24 || col == 25 || col == 29 || col == 33)) ||
                        (row == 14 && (col == 13 || col == 14 || col == 15 || col == 20 || col == 21 || col == 22 || col == 27 || col == 28 || col == 29)) ||
                        (row == 15 && (col == 15 || col == 22 || col == 27)) ||
                        (row == 16 && (col == 14 || col == 22 || col == 27|| col == 28|| col == 29)) ||
                        (row == 17 && (col == 13 || col == 22 || col == 29)) ||
                        (row == 18 && (col == 13 || col == 14 || col == 15 || col == 22 || col == 27 || col == 28 || col == 29)))
                    cell.setWillLive(true);
                cell.updateIsLiving();

            }
        }
    }

}



