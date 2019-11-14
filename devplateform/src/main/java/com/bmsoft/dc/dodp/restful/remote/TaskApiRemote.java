package com.bmsoft.dc.dodp.restful.remote;

import org.springframework.web.bind.annotation.GetMapping;

import javax.ws.rs.core.Response;

public interface TaskApiRemote {
    @GetMapping("/api/sekect")
    public Response select();

}
