package com.bmsoft.datadev.restful;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/datadev1")
@Component
public class HelloRestful {


    @GET
    @Path("/select")
    public String test(){
        return "niubi";
    }

}
