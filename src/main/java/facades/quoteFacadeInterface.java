package facades;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import entities.Quote;


//not implemented...

public interface quoteFacadeInterface {

	
	public long getQuoteFacadeCount();
	
	public List<Quote> getQuoteList();
	
	public Quote getQuote(Long id);
	
	public Quote getRandomOne();
	
	public Quote positiveQuoteScore(Long id);
	
	public Quote negativeQuoteScore(Long id);
	
	
}
