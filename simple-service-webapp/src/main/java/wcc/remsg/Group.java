package wcc.remsg;

import wcc.login.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft01 on 2017/5/3.
 */
public class Group {
    private String status;
    private List<User> result = new ArrayList<User>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public void addUser(User user){
        result.add(user);
    }

}
