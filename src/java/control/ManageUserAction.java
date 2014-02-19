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
    RoleBean roleBean;
    private List<UserBean> userlist;
    private List<RoleBean> rolelist;
    private int check;

    private String UserNameNew;
    private String PasswordNew;
    private int RoleIDNew;
    private String FullNameNew;
    private String GenderNew;
    private String YearOfBirthNew;
    private String EmailNew;
    private String PhoneNew;
    private String AddressNew;

    private int UserIDUpdate;
    private String UserNameUpdate;
    private String PasswordUpdate;
    private int RoleIDUpdate;
    private String FullNameUpdate;
    private String GenderUpdate;
    private String YearOfBirthUpdate;
    private String EmailUpdate;
    private String PhoneUpdate;
    private String AddressUpdate;
    
    private int UserIDChangeRole;
    private int RoleIDChangeRole;
    
    private int UserIDChangePassword;
    private String UserPassChangePassword;

    public String GetAllUserView() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        UserBean user123 = (UserBean) session.get("update_user");
        session.remove("all_user");
        session.remove("all_role");
        userBean = new UserBean();
        userlist = new ArrayList();
        userlist = userBean.getAllUsers();

        roleBean = new RoleBean();
        rolelist = new ArrayList();
        rolelist = roleBean.getAllRole();

        if (user123 == null) {
            session.remove("update_user");
            UserBean user12 = new UserBean();
            user12 = userBean.getUserID(1);
            session.put("update_user", user12);
        }

        session.put("all_user", userlist);
        session.put("all_role", rolelist);
        return "success";
    }

    public String AddNewUser() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        userBean = new UserBean();
        UserBean user = new UserBean();
        user.setUserID(UserID);
        user.setRoleID(this.RoleIDNew);
        user.setUserName(this.UserNameNew);
        user.setUserPass(this.PasswordNew);
        user.setFullName(this.FullNameNew);
        user.setGender(this.GenderNew);
        user.setYearOfBirth(this.YearOfBirthNew);
        user.setEmail(this.EmailNew);
        user.setPhone(this.PhoneNew);
        user.setUserAddress(this.AddressNew);

        userBean.addUser(user);
        return "success";
    }

    public String SaveUpdateUser() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        userBean = new UserBean();
        UserBean user = new UserBean();
        user.setUserID(this.UserIDUpdate);
        user.setRoleID(this.RoleIDUpdate);
        user.setUserName(this.UserNameUpdate);
        user.setUserPass(this.PasswordUpdate);
        user.setFullName(this.FullNameUpdate);
        user.setGender(this.GenderUpdate);
        user.setYearOfBirth(this.YearOfBirthUpdate);
        user.setEmail(this.EmailUpdate);
        user.setPhone(this.PhoneUpdate);
        user.setUserAddress(this.AddressUpdate);

        userBean.updateUser(user);
        return "success";
    }

    public String UpdateUser() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_user");
        userBean = new UserBean();
        UserBean userlist1 = new UserBean();
        userlist1 = userBean.getUserID(this.UserID);

        session.put("update_user", userlist1);
        return "success";
    }
    
    public String ChangeRoleUser() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_user");
        userBean = new UserBean();
        UserBean userlist1 = new UserBean();
        userlist1 = userBean.getUserID(this.UserID);

        session.put("update_user", userlist1);
        return "success";
    }
    
    public String SaveChangeRoleUser() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        userBean = new UserBean();
        userBean.changeRole(this.UserIDChangeRole, this.RoleIDChangeRole);
        
        return "success";
    }
    
    public String ChangePassUser() throws ClassNotFoundException, SQLException, ParseException {
        Map session = ActionContext.getContext().getSession();
        session.remove("update_user");
        userBean = new UserBean();
        UserBean userlist1 = new UserBean();
        userlist1 = userBean.getUserID(this.UserID);

        session.put("update_user", userlist1);
        return "success";
    }
    
    public String SaveChangePasswordUser() throws ClassNotFoundException, SQLException, ParseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        userBean = new UserBean();
        userBean.changePassword(this.UserIDChangePassword, this.UserPassChangePassword);
        
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

    public String getUserNameNew() {
        return UserNameNew;
    }

    public void setUserNameNew(String UserNameNew) {
        this.UserNameNew = UserNameNew;
    }

    public String getPasswordNew() {
        return PasswordNew;
    }

    public void setPasswordNew(String PasswordNew) {
        this.PasswordNew = PasswordNew;
    }

    public int getRoleIDNew() {
        return RoleIDNew;
    }

    public void setRoleIDNew(int RoleIDNew) {
        this.RoleIDNew = RoleIDNew;
    }

    public String getFullNameNew() {
        return FullNameNew;
    }

    public void setFullNameNew(String FullNameNew) {
        this.FullNameNew = FullNameNew;
    }

    public String getGenderNew() {
        return GenderNew;
    }

    public void setGenderNew(String GenderNew) {
        this.GenderNew = GenderNew;
    }

    public String getYearOfBirthNew() {
        return YearOfBirthNew;
    }

    public void setYearOfBirthNew(String YearOfBirthNew) {
        this.YearOfBirthNew = YearOfBirthNew;
    }

    public String getEmailNew() {
        return EmailNew;
    }

    public void setEmailNew(String EmailNew) {
        this.EmailNew = EmailNew;
    }

    public String getPhoneNew() {
        return PhoneNew;
    }

    public void setPhoneNew(String PhoneNew) {
        this.PhoneNew = PhoneNew;
    }

    public String getAddressNew() {
        return AddressNew;
    }

    public void setAddressNew(String AddressNew) {
        this.AddressNew = AddressNew;
    }

    public int getUserIDUpdate() {
        return UserIDUpdate;
    }

    public void setUserIDUpdate(int UserIDUpdate) {
        this.UserIDUpdate = UserIDUpdate;
    }

    public String getUserNameUpdate() {
        return UserNameUpdate;
    }

    public void setUserNameUpdate(String UserNameUpdate) {
        this.UserNameUpdate = UserNameUpdate;
    }

    public String getPasswordUpdate() {
        return PasswordUpdate;
    }

    public void setPasswordUpdate(String PasswordUpdate) {
        this.PasswordUpdate = PasswordUpdate;
    }

    public int getRoleIDUpdate() {
        return RoleIDUpdate;
    }

    public void setRoleIDUpdate(int RoleIDUpdate) {
        this.RoleIDUpdate = RoleIDUpdate;
    }

    public String getFullNameUpdate() {
        return FullNameUpdate;
    }

    public void setFullNameUpdate(String FullNameUpdate) {
        this.FullNameUpdate = FullNameUpdate;
    }

    public String getGenderUpdate() {
        return GenderUpdate;
    }

    public void setGenderUpdate(String GenderUpdate) {
        this.GenderUpdate = GenderUpdate;
    }

    public String getYearOfBirthUpdate() {
        return YearOfBirthUpdate;
    }

    public void setYearOfBirthUpdate(String YearOfBirthUpdate) {
        this.YearOfBirthUpdate = YearOfBirthUpdate;
    }

    public String getEmailUpdate() {
        return EmailUpdate;
    }

    public void setEmailUpdate(String EmailUpdate) {
        this.EmailUpdate = EmailUpdate;
    }

    public String getPhoneUpdate() {
        return PhoneUpdate;
    }

    public void setPhoneUpdate(String PhoneUpdate) {
        this.PhoneUpdate = PhoneUpdate;
    }

    public String getAddressUpdate() {
        return AddressUpdate;
    }

    public void setAddressUpdate(String AddressUpdate) {
        this.AddressUpdate = AddressUpdate;
    }

    public int getUserIDChangeRole() {
        return UserIDChangeRole;
    }

    public void setUserIDChangeRole(int UserIDChangeRole) {
        this.UserIDChangeRole = UserIDChangeRole;
    }

    public int getRoleIDChangeRole() {
        return RoleIDChangeRole;
    }

    public void setRoleIDChangeRole(int RoleIDChangeRole) {
        this.RoleIDChangeRole = RoleIDChangeRole;
    }

    public int getUserIDChangePassword() {
        return UserIDChangePassword;
    }

    public void setUserIDChangePassword(int UserIDChangePassword) {
        this.UserIDChangePassword = UserIDChangePassword;
    }

    public String getUserPassChangePassword() {
        return UserPassChangePassword;
    }

    public void setUserPassChangePassword(String UserPassChangePassword) {
        this.UserPassChangePassword = UserPassChangePassword;
    }

}
