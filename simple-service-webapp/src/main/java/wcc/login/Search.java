package wcc.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.*;
import java.io.*;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("search")
public class Search {
    @GET
//    @Produces("text/plain")
    @Produces("application/json")
    public String get(@QueryParam("name") String name) throws IOException {
        System.out.println(name);
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
//           while((jsons=br.readLine())!=null){
//               User user = JSON.parseObject(jsons,User.class);
//               System.out.println(user.getUsername());
//               if(name.equals(user.getUsername())){
//                   return JSON.toJSONString(user);
//               }
//            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(br!=null) br.close();
        }
        return null;
    }

}
