package facades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Quote;

public class QuoteFacade {

	private static QuoteFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private QuoteFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static QuoteFacade getQuoteFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new QuoteFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getQuoteFacadeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long QuoteFacadeCount = (long)em.createQuery("SELECT COUNT(r) FROM Quote r").getSingleResult();
            return QuoteFacadeCount;
        }finally{  
            em.close();
        }
        
    }
    
    // getQuote: get a quote on id
    public Quote getQuote(Long id){
        EntityManager em = emf.createEntityManager();
        try{
        	Quote quote = (Quote)em.createQuery("SELECT c FROM quote c WHERE c.id=:id")
                    .setParameter("id", id).getSingleResult();
            return quote;
        }finally{  
            em.close();
        }
        
    }
    
    // quoteList: get all quotes from db in quote table
    public List<Quote> getQuoteList(){
    	EntityManager em = emf.createEntityManager();
        try{
        	List<Quote> quoteList = (List<Quote>)em.createQuery("SELECT c FROM quote c").getResultList();
            return quoteList;
        }finally{  
        	em.close();
        }
	
    }
    
    
}
