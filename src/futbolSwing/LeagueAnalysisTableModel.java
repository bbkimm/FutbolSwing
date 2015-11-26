package futbolSwing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LeagueAnalysisTableModel extends AbstractTableModel{
	private static final long serialVersionUID = -2458050882626441238L;
	private static final int COLUMN_NO = 0;
    private static final int COLUMN_NAME = 1;
    private static final int COLUMN_POINTS = 2;
    private static final int COLUMN_GOALS = 3;
    private static final int COLUMN_PENALTIES = 4;
    
    private String[] columnNames = {"No #", "Team Name", "Points", "Goals","Penalties"};
    private List<Team> listTeams;
    
    public LeagueAnalysisTableModel(List<Team> listTeams) {
        this.listTeams = listTeams;
    int indexCount = 1;
    
    for (Team team : listTeams) {
        team.setIndex(indexCount);
        indexCount++;
    }
	}
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount() {
        return listTeams.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
     
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listTeams.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Team team = listTeams.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case COLUMN_NO:
            returnValue = team.getIndex();
            break;
        case COLUMN_NAME:
            returnValue = team.getName();
            break;
        case COLUMN_POINTS:
            returnValue = team.getNumPoints();
            break;
        case COLUMN_GOALS:
            returnValue = team.getNumGoals();
            break;
        case COLUMN_PENALTIES:
            returnValue = team.getNumPenalties();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
         
        return returnValue;
    }
}
