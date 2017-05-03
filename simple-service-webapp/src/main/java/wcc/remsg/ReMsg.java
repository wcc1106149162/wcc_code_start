package wcc.remsg;

import com.alibaba.fastjson.JSON;
import wcc.login.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by soft01 on 2017/5/3.
 */
@Path("remsg")
public class ReMsg {
    @GET
    @Produces("application/json")
    public String get(@QueryParam("name") String name,@QueryParam("pwd") String pwd){
        Group group = new Group();
        group.setState("成功");
        User user = new User(name,pwd);
        group.addUser(user);
        String jsonStr = JSON.toJSONString(group);
        return jsonStr;
    }
}
