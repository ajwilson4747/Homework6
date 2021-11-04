import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewLayout {
	public JTable myOutputTable; // table that will hold this info with
	public DefaultTableModel model;
	public Object[] columns;
	public Object[] row;

	public ViewLayout() {
		// create a frame
		JFrame myFrame = new JFrame();
		myFrame.setBounds(500, 100, 589, 439);
		myFrame.setBackground(Color.gray);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// build table using arrays for storing certain info in certain places
		columns = new Object[] { "Method and/or KeyWord:", "Number of Lines or Apperances:",
				"Total Sum for the entire code sample: " };
		
		// create row array
		row = new Object[2];

		// instantiate the table
		myOutputTable = new JTable();
		myOutputTable.setBounds(50, 150, 50, 150);
		myOutputTable.setBackground(Color.gray);
		myOutputTable.setForeground(Color.black);
		myOutputTable.setGridColor(Color.black);
		myOutputTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		myOutputTable.setRowHeight(25);
		myOutputTable.setAutoCreateRowSorter(true);

		// set up default table
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		myOutputTable.setModel(model);

		// create a scroll feature
		JScrollPane pane = new JScrollPane(myOutputTable);
		pane.setForeground(Color.white);
		pane.setBounds(10, 10, 10, 10);
		myFrame.getContentPane().add(pane);

		// myFrame.add(myOutputTable);

		// make app window visible
		myFrame.pack();
		myFrame.setVisible(true);

	}
}
