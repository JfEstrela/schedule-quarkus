package br.com.jfestrela;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.jfestrela.service.ScheduleService;

@Path("/schedule")
public class ScheduleResource {
	
	@Inject
	private ScheduleService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/time")
    public String get() {
        return "Schedule Count Time : ".concat(service.getScheduleCountTime().toString());
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cron")
    public String helloApresentation() {
      return "Schedule Count Cron :".concat(service.getScheduleCountCron().toString());
    }
  
}