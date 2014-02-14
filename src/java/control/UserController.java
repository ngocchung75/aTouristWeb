/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBean;

/**
 *
 * @author CHUNG TOOC
 */
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserBean userBean;

    protected void doGetUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            List<UserBean> lstUser = new ArrayList<UserBean>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            if (action.equals("list")) {
                try {
                    //Fetch Data from User Table
                    lstUser = userBean.getAllUsers();
                    //Convert Java Object to Json				
                    JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<UserBean>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();
                    //Return Json in the format required by jTable plugin
                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.getWriter().print(listData);
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
                    response.getWriter().print(error);
                    ex.printStackTrace();
                }
            } else if (action.equals("create") || action.equals("update")) {
                UserBean user = new UserBean();
                if (request.getParameter("userid") != null) {
                    int userid = Integer.parseInt(request.getParameter("userid"));
                    user.setUserID(userid);
                }
                if (request.getParameter("roleid") != null) {
                    int roleid = Integer.parseInt(request.getParameter("roleid"));
                    user.setRoleID(roleid);
                }
                if (request.getParameter("userName") != null) {
                    String userName = (String) request.getParameter("userName");
                    user.setUserName(userName);
                }
                if (request.getParameter("userPass") != null) {
                    String userPass = (String) request.getParameter("userPass");
                    user.setUserPass(userPass);
                }
                if (request.getParameter("fullName") != null) {
                    String fullName = (String) request.getParameter("fullName");
                    user.setFullName(fullName);
                }

                if (request.getParameter("gender") != null) {
                    String gender = (String) request.getParameter("gender");
                    user.setGender(gender);
                }
                if (request.getParameter("yearOfBirth") != null) {
                    String yearOfBirth = (String) request.getParameter("yearOfBirth");
                    user.setYearOfBirth(yearOfBirth);
                }
                if (request.getParameter("email") != null) {
                    String email = (String) request.getParameter("email");
                    user.setEmail(email);
                }
                if (request.getParameter("phone") != null) {
                    String phone = (String) request.getParameter("phone");
                    user.setPhone(phone);
                }
                if (request.getParameter("userAddress") != null) {
                    String userAddress = (String) request.getParameter("userAddress");
                    user.setUserAddress(userAddress);
                }

                try {
                    if (action.equals("create")) {//Create new record
                        userBean.addUser(user);
                        lstUser.add(user);
                        //Convert Java Object to Json				
                        String json = gson.toJson(user);
                        //Return Json in the format required by jTable plugin
                        String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                        response.getWriter().print(listData);
                    } else if (action.equals("update")) {//Update existing record
                        userBean.updateUser(user);
                        String listData = "{\"Result\":\"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
                    response.getWriter().print(error);
                }
            } else if (action.equals("delete")) {//Delete record
                try {
                    if (request.getParameter("userid") != null) {
                        String userid = (String) request.getParameter("userid");
                        userBean.deleteUser(Integer.parseInt(userid));
                        String listData = "{\"Result\":\"OK\"}";
                        response.getWriter().print(listData);
                    }
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace().toString() + "}";
                    response.getWriter().print(error);
                }
            }
        }
    }
}
