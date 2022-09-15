

package MODEL;
import java.util.Date;


public class PROJECTS {
    
    private int ID;
    private String NAME;
    private String DESCRIPTION;
    private Date CREATED_AT;
    private Date UPDATED_AT;

    public PROJECTS(int ID, String NAME, String DESCRIPTION, Date CREATED_AT, Date UPDATE_AT) {
        this.ID = ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.CREATED_AT = CREATED_AT;
        this.UPDATED_AT = UPDATE_AT;
    
        
       
            
        }

   
     public PROJECTS(){
        this.CREATED_AT = new Date();
        this.UPDATED_AT = new Date();
     }
     
       //public Project(){
        //throw new UnsupportedOperationException("not suported");   
     
     public void Projects(){
     throw new UnsupportedOperationException("not suported");
     }
     
    public int getID() {
        return ID;
        
    }

    public String getNAME() {
        return NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public Date getUPDATE_AT() {
       
        return UPDATED_AT;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public void setUPDATE_AT(Date UPDATE_AT) {
        this.UPDATED_AT = UPDATE_AT;
    }

    @Override
    public String toString() {
    return this.NAME;
    }
    
    
    
}
