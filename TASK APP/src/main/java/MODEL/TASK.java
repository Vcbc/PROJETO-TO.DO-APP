
package MODEL;

import java.util.Date;


public class TASK {
    
    private int ID;
    private int ID_PROJECT;
    private String NAME;
    private String DESCRIPTION;
    private String NOTES;
    private boolean IS_COMPLETED;
    private Date DEADLINE;
    private Date CREATED_AT;
    private Date UPDATED_AT;
    
    public TASK(int ID, int PROJECT_ID, String NAME, String DESCRIPTION, String NOTES, boolean IS_COMPLETED, Date DEADLINE, Date CREATED_AT, Date UPDATED_AT ){
    this.ID = ID;
    this.NAME = NAME;
    this.DESCRIPTION = DESCRIPTION;
    this.NOTES = NOTES;
    this.IS_COMPLETED = IS_COMPLETED;
    this.DEADLINE = DEADLINE;
    this.CREATED_AT = CREATED_AT;
    this.UPDATED_AT = UPDATED_AT;
    }
    
    public TASK(){
        this.CREATED_AT = new Date();
        this.UPDATED_AT = new Date();
        this.DEADLINE = new Date();
        
        
    }
    

    public int getID() {
        return ID;
    }

    public int getID_PROJECT() {
        return ID_PROJECT;
    }

    public String getNAME() {
        return NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getNOTES() {
        return NOTES;
    }

    public boolean isIS_COMPLETED() {
        return IS_COMPLETED;
    }

    public Date getDEADLINE() {
        return DEADLINE;
    }

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setID_PROJECT(int ID_PROJECT) {
        this.ID_PROJECT = ID_PROJECT;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setNOTES(String NOTES) {
        this.NOTES = NOTES;
    }

    public void setIS_COMPLETED(boolean IS_COMPLETED) {
        this.IS_COMPLETED = IS_COMPLETED;
    }

    public void setDEADLINE(Date DEADLINE) {
        this.DEADLINE = DEADLINE;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public void setUPDATED_AT(Date UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }

    @Override
    public String toString() {
        return "TASK{" + "ID=" + ID + ", PROJECT_ID=" + ID_PROJECT + ", NAME=" + NAME + ", DESCRIPTION=" + DESCRIPTION + ", NOTES=" + NOTES + ", IS_COMPLETED=" + IS_COMPLETED + ", DEADLINE=" + DEADLINE + ", CREATED_AT=" + CREATED_AT + ", UPDATED_AT=" + UPDATED_AT + '}';
    }
    
    
}
