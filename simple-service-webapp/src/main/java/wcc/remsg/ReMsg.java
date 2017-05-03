package wcc.remsg;

import com.alibaba.fastjson.JSON;
import wcc.login.AddUser;
import wcc.login.Search;
import wcc.login.User;

import javax.ws.rs.*;
import java.io.*;
import java.util.Collections;


/**
 * Created by soft01 on 2017/5/3.
 */
@Path("remsg")
public class ReMsg {
    Group group = new Group();
    @GET
    @Produces("application/json")
    public String get(@QueryParam("name") String name,@QueryParam("pwd") String pwd) throws IOException {
        group.setStatus("成功");
        AddUser a = new AddUser();
        a.add(name,pwd);
        read();
        String jsonStr = JSON.toJSONString(group);
        return jsonStr;
    }
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String post(@FormParam("name") String name,@FormParam("pwd") String pwd) throws IOException {
        group.setStatus("成功");
        AddUser a = new AddUser();
        a.add(name,pwd);
        read();
        String jsonStr = JSON.toJSONString(group);
        return jsonStr;
    }
    public void read() throws IOException {
        BufferedReader br = null;
        String jsons = null;
        try {
            File file = new File("D:/user.txt");
            br = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(file)
                            ),"UTF-8"
                    )
            );
            String b;
            while((b=br.readLine())!=null){
                User user = JSON.parseObject(b,User.class);
                group.addUser(user);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (br != null) br.close();
        };
    }
}
