package service;

import comptoirs.model.dao.CaDao;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("service/unitesVendues")
public class StatisticsService {
        
        @Inject
	CaDao cadao;
        
	
        
        @GET @Path("CAcategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List CAParCategorie(@QueryParam("from") Long timestampFrom,@QueryParam("to") Long timestampTo) {
		if(timestampFrom!=null && timestampTo!=null)
			return cadao.caParCategorie(new Date(timestampFrom), new Date(timestampTo));
		return cadao.caParCategorie();
	}
        
        @GET @Path("CAclient")
	@Produces(MediaType.APPLICATION_JSON)
	public List CAParClient(@QueryParam("from") Long timestampFrom,@QueryParam("to") Long timestampTo) {
		if(timestampFrom!=null && timestampTo!=null)
			return cadao.caParClient(new Date(timestampFrom), new Date(timestampTo));
		return cadao.caParClient();
	}
        
        @GET @Path("CApays")
	@Produces(MediaType.APPLICATION_JSON)
	public List CAParPays(@QueryParam("from") Long timestampFrom,@QueryParam("to") Long timestampTo) {
		if(timestampFrom!=null && timestampTo!=null)
			return cadao.caParPays(new Date(timestampFrom), new Date(timestampTo));
		return cadao.caParPays();
	}
       
}
