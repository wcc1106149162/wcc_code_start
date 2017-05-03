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
    public String postadd(@FormParam("name") String name,@FormParam("pwd") String pwd) throws IOException {
        String jsonStr = add(name,pwd);
        return jsonStr;
    }
    public String add(String name,String pwd) {
        PrintWriter pw = null;
        String jsonString = null;
        try {
            File file = new File("D:/user.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            pw = new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(file, true)
                            ), "UTF-8"
                    ), true
            );
            User user = new User(name, pwd);
            jsonString = JSON.toJSONString(user);
            pw.println(jsonString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) pw.close();
        }
        return  jsonString;
    }
}
