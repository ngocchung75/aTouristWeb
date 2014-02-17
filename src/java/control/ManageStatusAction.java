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
import model.StatusBean;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author CHUNG TOOC
 */
public class ManageStatusAction extends ActionSupport implements SessionAware {

    private int StatusID;
    private String StatusNameNew;
    private int StatusIDUpdate;
    private String StatusNameUpdate;
    private Map<String, Object> sessionMap;
    StatusBean statusBean;
    private List<StatusBean> statusList;
    private int check;

    public String GetAllStatusView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        StatusBean status123 = (StatusBean) session.get("update_status");
        session.remove("all_status");

        statusBean = new StatusBean();
        statusList = new ArrayList();
        statusList = statusBean.getAllStatus();

        if (status123 == null) {
            session.remove("update_status");
            StatusBean statusList1 = new StatusBean();
            statusList1 = statusBean.getStatusWithID(1);
            session.put("update_status", statusList1);
        }

        session.put("all_status", statusList);
        return "success";
    }

    public String AddNewStatus() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        statusBean = new StatusBean();
        statusBean.addStatus(this.StatusNameNew);

        return "success";
    }
    
    public String SaveUpdateStatus() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        statusBean = new StatusBean();
        statusBean.updateStatus(this.StatusIDUpdate, this.StatusNameUpdate);

        return "success";
    }

    public String UpdateStatus() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_status");
        statusBean = new StatusBean();
        StatusBean statusList1 = new StatusBean();
        statusList1 = statusBean.getStatusWithID(this.StatusID);

        session.put("update_status", statusList1);
        return "success";
    }

    public String DeleteStatus() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {

        statusBean = new StatusBean();
        int statusID = Integer.valueOf(this.StatusID);
        check = statusBean.deleteStatus(statusID);
        if (check > 0) {
            addActionError("Delete Status successful");
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

    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

    public String getStatusNameNew() {
        return StatusNameNew;
    }

    public void setStatusNameNew(String StatusNameNew) {
        this.StatusNameNew = StatusNameNew;
    }

    public int getStatusIDUpdate() {
        return StatusIDUpdate;
    }

    public void setStatusIDUpdate(int StatusIDUpdate) {
        this.StatusIDUpdate = StatusIDUpdate;
    }

    public String getStatusNameUpdate() {
        return StatusNameUpdate;
    }

    public void setStatusNameUpdate(String StatusNameUpdate) {
        this.StatusNameUpdate = StatusNameUpdate;
    }

}
