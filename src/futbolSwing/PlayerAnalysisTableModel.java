package futbolSwing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PlayerAnalysisTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2458050882626441238L;
	private static final int COLUMN_NO = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_SHOTS = 2;
    private static final int COLUMN_GOALS = 3;
    private static final int COLUMN_PENALTIES = 4;
    
    private String[] columnNames = {"No #", "Player Name", "Shots", "Goals","Penalties"};
    private List<Player> listPlayers;
    
    public PlayerAnalysisTableModel(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    int indexCount = 1;
    
    for (Player player : listPlayers) {
        player.setIndex(indexCount);
        indexCount++;
    }
	}
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount() {
        return listPlayers.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
     
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listPlayers.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Player player = listPlayers.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case COLUMN_NO:
            returnValue = player.getIndex();
            break;
        case COLUMN_NAME:
            returnValue = player.getName();
            break;
        case COLUMN_SHOTS:
            returnValue = player.getShots();
            break;
        case COLUMN_GOALS:
            returnValue = player.getNumGoals();
            break;
        case COLUMN_PENALTIES:
            returnValue = player.getInfractions();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
         
        return returnValue;
    }
}
