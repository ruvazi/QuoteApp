package rest;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Quote;
import facades.QuoteFacade;
import utils.EMF_Creator;

public class QuoteResource {

	private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory("pu",
			"jdbc:mysql://localhost:3306/startcode?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&&useSSL=false",
			"root", "RVZeave_yabe_2", EMF_Creator.Strategy.CREATE);
	private static final QuoteFacade FACADE = QuoteFacade.getQuoteFacade(EMF);
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String demo() {
		return "{\"msg\":\"Hello World\"}";
	}

	@Path("count")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getQuoteFacadeCount() {
		long count = FACADE.getQuoteFacadeCount();
		// System.out.println("--------------->"+count);
		return "{\"count\":" + count + "}";
	}

	@Path("getQuote")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getQuote(Long Id) {
		Quote quote = FACADE.getQuote(Id);
		// System.out.println("--------------->" single quote by Id:
		return GSON.toJson(quote);
	}

	@Path("getAllQuotes")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getQuoteList() {
		;
		List<Quote> allQuotes = FACADE.getQuoteList();
		// System.out.println("--------------->" All quotes from db:
		return GSON.toJson(allQuotes);
	}
}
