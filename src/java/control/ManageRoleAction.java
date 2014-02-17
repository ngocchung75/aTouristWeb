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
import model.RoleBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageRoleAction extends ActionSupport implements SessionAware {
    
    private int RoleID;
    private String RoleNameNew;
    private int RoleIDUpdate;
    private String RoleNameUpdate;
    private Map<String, Object> sessionMap;
    RoleBean roleBean;
    private List<RoleBean> roleList;
    private int check;

    public String GetAllRoleView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        RoleBean role123 = (RoleBean) session.get("update_role");
        session.remove("all_role");

        roleBean = new RoleBean();
        roleList = new ArrayList();
        roleList = roleBean.getAllRole();

        if (role123 == null) {
            session.remove("update_role");
            RoleBean roleList1 = new RoleBean();
            roleList1 = roleBean.getRoleWithID(1);
            session.put("update_role", roleList1);
        }

        session.put("all_role", roleList);
        return "success";
    }

    public String AddNewRole() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        roleBean = new RoleBean();
        roleBean.addRole(this.RoleNameNew);

        return "success";
    }
    
    public String SaveUpdateRole() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        roleBean = new RoleBean();
        roleBean.updateRole(this.RoleIDUpdate, this.RoleNameUpdate);

        return "success";
    }

    public String UpdateRole() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_role");
        roleBean = new RoleBean();
        RoleBean roleList1 = new RoleBean();
        roleList1 = roleBean.getRoleWithID(this.RoleID);

        session.put("update_role", roleList1);
        return "success";
    }

    public String DeleteRole() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {

        roleBean = new RoleBean();
        int roleID = Integer.valueOf(this.RoleID);
        check = roleBean.deleteRole(roleID);
        if (check > 0) {
            addActionError("Delete Role successful");
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

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getRoleNameNew() {
        return RoleNameNew;
    }

    public void setRoleNameNew(String RoleNameNew) {
        this.RoleNameNew = RoleNameNew;
    }

    public int getRoleIDUpdate() {
        return RoleIDUpdate;
    }

    public void setRoleIDUpdate(int RoleIDUpdate) {
        this.RoleIDUpdate = RoleIDUpdate;
    }

    public String getRoleNameUpdate() {
        return RoleNameUpdate;
    }

    public void setRoleNameUpdate(String RoleNameUpdate) {
        this.RoleNameUpdate = RoleNameUpdate;
    }
    
}
