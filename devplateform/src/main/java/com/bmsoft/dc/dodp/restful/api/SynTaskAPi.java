package com.bmsoft.dc.dodp.restful.api;

import com.bmsoft.dc.dodp.restful.remote.TaskApiRemote;
import com.webank.wedatasphere.linkis.server.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("devplateform")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component
public class SynTaskAPi implements TaskApiRemote {


    @GET
    @Path("/select")
    @Override
    public Response select() {
        // List<SynTask> list = synTaskService.list();
        return Message.messageToResponse(Message.ok("Query successful(查询成功)").data("columns", new String("testsssssss")));
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    @ResponseBody
    public String test() {
        // List<SynTask> list = synTaskService.list();
        return "恭喜你测试通过";
    }
}
