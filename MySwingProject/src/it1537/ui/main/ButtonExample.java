package it1537.ui.main;

import it1537.dao.MemberDAO;
import it1537.entities.Member;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class ButtonExample {

	public static void main(String[] args) {
		final ButtonExample example = new ButtonExample();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	example.createAndShowGUI();
            }
        });
	}
	
	private void createAndShowGUI() {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTable table = new JTable(new JTableModel()); 
        JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);	
		table.setCellSelectionEnabled(true);
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		//table.getColumn("Button1").setCellRenderer(buttonRenderer);
		table.getColumn("Button").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
        
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(500, 200));
        frame.pack();
        frame.setVisible(true);
	}
	
	class JTableModel extends AbstractTableModel {
		private final long serialVersionUID = 1L;
		private final String[] COLUMN_NAMES = new String[] {"MemberId", "Name", "Tel", "Button"};
		private final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class,  JButton.class};
		
		ArrayList<Member> memberList = MemberDAO.retrieveAll();
		int count = memberList.size();
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return count;
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0: return memberList.get(rowIndex).getMemberId();
				case 1: return memberList.get(rowIndex).getName();
				case 2: return memberList.get(rowIndex).getTel();
				case 3: final JButton button = new JButton("Click");
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
										"Button clicked for row "+rowIndex);
							}
						});
						return button;
				default: return "Error";
			}
		}	
	}

	private static class JTableButtonRenderer implements TableCellRenderer {		
		@Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JButton button = (JButton)value;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
		    } else {
		    	button.setForeground(table.getForeground());
		    	button.setBackground(UIManager.getColor("Button.background"));
		    }
			return button;	
		}
	}
	
	private static class JTableButtonMouseListener extends MouseAdapter {
		private final JTable table;
		
		public JTableButtonMouseListener(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int column = table.getColumnModel().getColumnIndexAtX(e.getX());
			int row    = e.getY()/table.getRowHeight(); 

			if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
			    Object value = table.getValueAt(row, column);
			    if (value instanceof JButton) {
			    	((JButton)value).doClick();
			    }
			}
		}
	}
}