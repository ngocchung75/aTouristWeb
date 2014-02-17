/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.UserBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageUserAction extends ActionSupport implements SessionAware {

    private int UserID;
    private Map<String, Object> sessionMap;
    UserBean userBean;
    private List<UserBean> userlist;
    private int check;

    public String GetAllUserView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("all_user");
        userBean = new UserBean();
        userlist = new ArrayList();
        userlist = userBean.getAllUsersRole(2);

        session.put("all_user", userlist);
        return "success";
    }
    
    public String UpdateUser() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("list_user");
        userBean = new UserBean();
        UserBean userlist1 = new UserBean();
        userlist1 = userBean.getUserID(this.UserID);

        session.put("list_user", userlist1);
        return "success";
    }
    
    public String DeleteUser() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        
        userBean = new UserBean();
        int userid1 = Integer.valueOf(this.UserID);
        check = userBean.deleteUser(userid1);
        if (check > 0) {
            addActionError("Delete user successful");
            return "success";
        }
        addActionError("System error has occurred please try again later.");
        return "error";
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

}
