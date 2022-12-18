

package MODEL;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table (name = "projects")
public class PROJECTS {
    
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /** Criação das variáveis com os mesmos nomes que foram usados na tabela do banco de dados
     * com excessão das variáveis UPDATED_AT e CREATED_AT
     */
    
    private int ID;
    private String NAME;
    private String DESCRIPTION;
    private Date CREATED_AT;
    private Date UPDATED_AT;
    
    
 /**Gerar construtor com as variáveis criadas
  * 
  * @param ID
  * @param NAME
  * @param DESCRIPTION
  * @param CREATED_AT
  * @param UPDATE_AT 
  */
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
     
 
     /**Gerar os GETTERS e SETTERS para cada atributo criado
      * esses métodos existem para no caso do GET, pegar a informação e 
      * no caso do SET, setar a informação
      * @return 
      */
     
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
    
    /** Aqui geramos o método ToString, nesse método quando os projetos forem 
     * carregados no projectsModel, ira aparecer somente o nome do projeto
     * pois é a única informação que precisamos exibir.
     * 
     * @return retorna o nome do projeto
     */

    @Override
    public String toString() {
    return this.NAME;
    }
    
    
    
}
