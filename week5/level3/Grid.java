import java.util.*;

public class Grid
{
       
   private ArrayList<ArrayList<String>> rows;
   
   public Grid(int dimension){
       rows = new ArrayList<ArrayList<String>>(dimension);
    
       for ( int i = 0; i<dimension; i++){
           rows.add(new ArrayList<String>(dimension));
           for ( int  j = 0 ; j<dimension; j++){
               rows.get(i).add("null");
            }
        }
    }
    
    public void setEntryValue(int row, int column, String value){
        rows.get(row-1).set((column-1), value);
        printGrid();
    }
    
    public String getValue(int row, int column){
        return rows.get(row-1).get(column-1);
    }
    
    public void printGrid(){
        for (int i = 0; i <rows.size(); i++){
            for (int j = 0; j<rows.get(i).size(); j++){
                System.out.print("[" + rows.get(i).get(j) + "] ");
            }
            System.out.println("");
        }
    }
}
