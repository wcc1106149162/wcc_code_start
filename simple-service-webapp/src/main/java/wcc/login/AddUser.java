package wcc.login;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.*;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("adduser")
public class AddUser {
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String post(@FormParam("name") String name,@FormParam("pwd") String pwd) throws IOException {
        PrintWriter pw = null;
        String jsonString = null;
        try {
            File file = new File("D:/user.txt");
            pw = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(file,true)
                            ),"UTF-8"
                    ),true
            );
            User user = new User(name,pwd);
            jsonString = JSON.toJSONString(user);
            pw.println(jsonString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(pw!=null) pw.close();
        }
        return jsonString;
    }
}
