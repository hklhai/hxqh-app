package com.hxqh.eam.service;

import com.hxqh.eam.common.hxqh.Account;
import com.hxqh.eam.common.util.GroupListUtil;
import com.hxqh.eam.common.util.ListSortUtil;
import com.hxqh.eam.common.util.MailUtils;
import com.hxqh.eam.dao.*;
import com.hxqh.eam.model.*;
import com.hxqh.eam.model.dto.*;
import com.hxqh.eam.model.dto.action.LoginDto;
import com.hxqh.webService.model.RoleSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    static Logger logger = Logger.getLogger(SystemServiceImpl.class);

    @Value("${hxqh.email.name}")
    private String serverName;
    @Value("${hxqh.email.username}")
    private String username;
    @Value("${hxqh.email.password}")
    private String password;
    @Value("${hxqh.email.path.name}")
    private String pathName;

    @Autowired
    private SfOrganizationAccountDao organizationAccountDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SfOrganizationDepartmentDao sfOrganizationDepartmentDao;
    @Autowired
    private TbIocCustTop7Dao tbIocCustTop7Dao;
    @Autowired
    private TbIoccustomeruserDao ioccustomeruserDao;
    @Autowired
    private TbModelDao modelDao;
    @Autowired
    private TbRoleDao roleDao;
    @Autowired
    private TbRolemodelDao rolemodelDao;
    @Autowired
    private TbUserroleDao userroleDao;
    @Autowired
    private UserDao userDao;
    @Resource
    protected SessionFactory sessionFactory;

    @Override
    public List<SfOrganizationAccount> getLoginUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", loginDto.getName());
        String where = "name=:name ";
        List<SfOrganizationAccount> accountList = organizationAccountDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public List<Menu> getMenuListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        //        params.put("name", "");
        //        String where = "name=:name ";
        //        List<Menu> menuList = menuDao.findAll(where, params, null);
        List<Menu> menuList = menuDao.findAll();
        return menuList;
    }

    @Override
    public void editMenu(Menu menu) throws Exception {
        menuDao.update(menu);
    }

    @Override
    public void addMenu(Menu menu) throws Exception {
        menuDao.save(menu);
    }

    @Override
    public void delMenu(String menuid) throws Exception {
        menuDao.delete(menuid);
    }

    @Override
    public UserDto getUserListData() {
        String sql = "select distinct (t1.userid) as id, t1.loginname as name, t3.rolename,t3.roleid,t1.userstatus as userstatus\n" +
                "  from TB_USER t1\n" +
                "  left join tb_userrole t2\n" +
                "    on t1.userid = t2.userid\n" +
                "  left join tb_role t3\n" +
                "    on t2.roleid = t3.roleid";
        List<UserRoleDto> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(UserRoleDto.class).list();
        return new UserDto(list);
    }

    @Override
    public List<TbRole> getRoleListData() {
        return roleDao.findAll();
    }

    @Override
    public List<TbIocCustTop7> custtop7ListData() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("custtype", "DWS");
        String where = "custtype<>:custtype";
        return tbIocCustTop7Dao.findAll(where, params, null);
    }

    @Override
    public List<TbIoccustomeruser> customeruserListData(String name, String div) {
        Map<String, Object> params = new HashMap<>();

        List<TbIoccustomeruser> ioccustomeruserList = new ArrayList<>();
        if (name.equals("") && div.equals("")) {
            ioccustomeruserList = ioccustomeruserDao.findAll();
        } else if (name.equals("")) {
            params.put("div", div);
            String where = "div=:div";
            ioccustomeruserList = ioccustomeruserDao.findAll(where, params, null);
        } else if (div.equals("")) {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        } else {
            params.put("custName", name.trim());
            StringBuilder sb = new StringBuilder("");
            sb.append(" custName like '%'||").append(":custName").append("||'%' ").append(" or div=:div ");
            ioccustomeruserList = ioccustomeruserDao.findAll(sb.toString(), params, null);
        }
        return ioccustomeruserList;
    }

    @Transactional
    @Override
    public void updateRank(Long ioccustomeruserid, String custid, String name) {
        TbIocCustTop7 iocCustTop7 = tbIocCustTop7Dao.find(custid);
        TbIoccustomeruser ioccustomeruser = ioccustomeruserDao.find(ioccustomeruserid);

        iocCustTop7.setCustid(String.valueOf(ioccustomeruser.getIoccustomeruserid()));
        iocCustTop7.setCustname(ioccustomeruser.getCustName());
        iocCustTop7.setName(name);

        tbIocCustTop7Dao.update(iocCustTop7);
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
    }


    @Transactional
    @Override
    public void callProcedure() {
        sessionFactory.getCurrentSession().createSQLQuery("{call p_custom_rank.pro_custom_rank()}");
    }

    @Override
    public TestDto testData() {
        return new TestDto();
    }

    @Override
    public void userRole(String id, BigDecimal roleid) {

//        TbUserrole userrole = new TbUserrole(id, roleid);
//        userroleDao.save(userrole);
    }

    @Override
    public UserObj findUserbyId(Long id) {
        return userDao.find(id);
    }

    @Override
    public ModelDto getModelListData() {
        //分别返回一级节点和二级节点
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("sortnum", "asc");
        List<TbModel> modelList = modelDao.findAll(null, null, orderby);
        for (TbModel model : modelList) {
            model.setTbRolemodels(null);
        }

        //对modelList分组
        Map<Integer, List<TbModel>> listMap = GroupListUtil.group(modelList, new GroupListUtil.GroupBy<Integer>() {
            @Override
            public Integer groupby(Object obj) {
                TbModel d = (TbModel) obj;
                return d.getIsmdeol();    // 分组依据为mdeol
            }
        });

        return new ModelDto(listMap);
    }

    @Override
    public void editrole(TbRole account) {
        roleDao.update(account);
    }

    /**
     * 批量编辑角色 add Ocean_hy
     *
     * @param tbRoleList
     * @return
     */
    @Override
    public String editrole(List<TbRole> tbRoleList) {
        for (TbRole tbRole : tbRoleList) {
            Map<String, Object> params = new HashMap<>();
            params.put("sourceId", tbRole.getSourceid());
            String where = "sourceid=:sourceId";
            List<TbRole> roleObjs = roleDao.findAll(where, params, null);
            if (roleObjs.size() == 1) {
                List<UserObj> userObjList = new ArrayList<>();
                tbRole.setRoleid(roleObjs.get(0).getRoleid());
                roleDao.update(tbRole, null, null, null);
            } else {
                roleDao.delete(roleObjs.get(0).getRoleid());
                roleDao.save(tbRole);
            }
        }

        return null;
    }

    @Override
    public int addrole(TbRole account) {
        //如果loginname重复不添加
        Map<String, Object> params = new HashMap<>();
        params.put("rolename", account.getRolename());
        String where = "rolename=:rolename ";
        List<TbRole> roleList = roleDao.findAll(where, params, null);
        if (roleList.size() > 0) {
            return 0;
        }
        // 写TB_Role表
        account.setSortnum(new BigDecimal(1));
        roleDao.save(account);
        return 1;
    }

    /**
     * 批量新增角色 Add Ocean
     *
     * @param tbRoleList
     * @return
     */
    @Override
    public String addrole(List<TbRole> tbRoleList) {
        int error_Num = 0;
        int success_Num = 0;
        for (TbRole tb : tbRoleList) {
            Map<String, Object> params = new HashMap<>();
            params.put("rolename", tb.getRolename());
            String where = "rolename=:rolename ";
            List<TbRole> roleList = roleDao.findAll(where, params, null);
            if (roleList.size() > 0) {
                error_Num++;
            } else {
                tb.setSortnum(new BigDecimal(1));
                roleDao.save(tb);
                success_Num++;
            }
        }
        return "成功数量：" + success_Num + "    异常数量：" + error_Num;
    }

    @Override
    public String addRoleSource(List<RoleSource> tbRoleList) {
        for (RoleSource roleSource : tbRoleList) {
            int type = roleSource.getOptionType();
            //查找角色信息
            TbRole tbRole = roleDao.find(roleSource.getRoleId());
            if (type == 1) {
                //查找用户信息
                UserObj userObj = userDao.find(roleSource.getSourceId());
                TbUserrole tbUserrole = new TbUserrole();
                tbUserrole.setTbUser(userObj);
                tbUserrole.setTbRole(tbRole);
                userroleDao.save(tbUserrole);
            } else if (type == 2) {
                //查找资源信息
                TbModel tbModel = modelDao.find(roleSource.getSourceId());
                TbRolemodel tbRolemodel = new TbRolemodel();
                tbRolemodel.setTbModel(tbModel);
                rolemodelDao.save(tbRolemodel);
            }
        }


        return null;
    }

    @Override
    public String editRoleSource(List<RoleSource> tbRoleList) {

        return null;
    }

    @Override
    public String delRoleSource(List<RoleSource> tbRoleList) {
        for (RoleSource roleSource : tbRoleList) {
            int type = roleSource.getOptionType();
            //查找角色信息
            if (type == 1) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("userid", roleSource.getSourceId());
                params.put("roleid", roleSource.getRoleId());
                String where = "userid:userid   and roleid=:roleid";
                List<TbUserrole> userroleList = userroleDao.findAll(where, params, null);
                for (TbUserrole t : userroleList) {
                    userroleDao.delete(t.getUserroleid());
                }
            } else if (type == 2) {
                //查找资源信息
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("modelid", roleSource.getSourceId());
                params.put("roleid", roleSource.getRoleId());
                String where = "userid:userid   and modelid=:modelid";
                List<TbRolemodel> rolemodelList = rolemodelDao.findAll(where, params, null);
                for (TbRolemodel t : rolemodelList) {
                    rolemodelDao.delete(t.getRolemodelid());
                }
            }
        }
        return null;
    }

    @Override
    public void delrole(Long id) {
        if (!(id == 1l)) {
            TbRole role = roleDao.find(id);
            List<TbRolemodel> rolemodelList = role.getTbRolemodels();
            for (TbRolemodel e : rolemodelList) {
                rolemodelDao.delete(e.getRolemodelid());
            }
            roleDao.delete(id);
        }
    }

    /**
     * 批量删除角色
     * add Ocean
     *
     * @param tbRoleList
     * @return
     */
    @Override
    public String delrole(List<TbRole> tbRoleList) {
        int delNum = 0;
        for (TbRole tr : tbRoleList) {
            TbRole role = roleDao.find(tr.getRoleid());
            List<TbRolemodel> rolemodelList = role.getTbRolemodels();
            for (TbRolemodel e : rolemodelList) {
                rolemodelDao.delete(e.getRolemodelid());
            }
            List<TbUserrole> tbUserroleList = role.getTbUserroles();
            for (TbUserrole e : tbUserroleList) {
                userroleDao.delete(e.getUserroleid());
            }
            delNum++;
            roleDao.delete(tr.getRoleid());
        }


        return "与角色相关的信息已删除,共计删除角色：" + delNum;
    }

    @Override
    public void editmodel(TbModel account) {
        modelDao.update(account);
    }

    @Override
    public void addmodel(TbModel account) {
        modelDao.save(account);
    }

    @Override
    public void delmodel(String id) {
        modelDao.delete(id);
    }

    @Override
    public void roleModel(String models, Long roleid) {
        TbRole role = roleDao.find(roleid);
        String[] split = models.split(",");
        List<TbModel> modelList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            modelList.add(modelDao.find(Long.valueOf(split[i])));
        }

        for (TbModel e : modelList) {
            TbRolemodel rolemodel = new TbRolemodel(e, role);
            rolemodelDao.save(rolemodel);
        }
    }

    @Override
    public ModelRoleDto getModelRoleData(Long roleid) {
        TbRole role = roleDao.find(roleid);
        List<TbModel> modelHaveList = new ArrayList<>();
        for (TbRolemodel rolemodel : role.getTbRolemodels()) {
            modelHaveList.add(modelDao.find(rolemodel.getTbModel().getModelid()));
        }
        Map<String, Object> params = new HashMap<>();
        params.put("ismdeol", 1);
        String where = "ismdeol=:ismdeol ";

        List<TbModel> modelNoList = modelDao.findAll(where, params, null);
        modelNoList.removeAll(modelHaveList);

        for (TbModel e : modelNoList) {
            e.setTbRolemodels(null);
        }
        for (TbModel e : modelHaveList) {
            e.setTbRolemodels(null);
        }

        return new ModelRoleDto(modelNoList, modelHaveList);
    }

    @Override
    public List<TbRole> findRoleList() {
        return roleDao.findAll();
    }

    @Override
    public List<UserObj> getUserList(LoginDto loginDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginDto.getName());
        String where = "loginname=:loginname ";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        return accountList;
    }

    @Override
    public int forgetPassword(String loginname, String email) {
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            UserObj userObj = accountList.get(0);
            userObj.setUserstatus(0);
            userDao.save(userObj);
            return 1;
        }
        return 0;
    }

    @Override
    public int resetPassword(Long userid) {
        UserObj userObj = userDao.find(userid);
        //重置密码 初始密码123456
        String password = Account.encrypt("123456");
        userObj.setLoginpassword(password);
        userObj.setUserstatus(1);
        userDao.save(userObj);
        //发送邮件
        if (userObj.getLoginname() != null && userObj.getEmail() != null) {
            sendEmail(userObj.getLoginname(), userObj.getEmail());
        }
        return 0;
    }

    @Override
    public int sendEmail(String loginname, String email) {
        MailUtils cn = new MailUtils();

        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        params.put("email", email);
        String where = "loginname=:loginname and email=:email";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() == 1) {
            // 设置发件人地址、收件人地址和邮件标题
            cn.setAddress(username, accountList.get(0).getEmail(), "The password has been reset");
            // 设置要发送附件的位置和标题
            cn.setAffix(pathName, "attach.txt");

            /**
             * 设置smtp服务器以及邮箱的帐号和密码
             * 用QQ 邮箱作为发生者不好使 （原因不明）
             * 163 邮箱可以，但是必须开启  POP3/SMTP服务 和 IMAP/SMTP服务
             * 因为程序属于第三方登录，所以登录密码必须使用163的授权码
             */
            // 注意： [授权码和你平时登录的密码是不一样的]
            cn.send(serverName, username, password, "重置密码为123456");
            return 1;
        }
        return 0;
    }

    @Override
    public ModelIndexDto getModelIndex(String loginname) {
//        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
//        orderby.put("modelid", "asc");

        Map<String, Object> params = new HashMap<>();
        params.put("loginname", loginname);
        String where = "loginname=:loginname ";
        List<UserObj> userObjList = userDao.findAll(where, params, null);
        Set<TbModel> modelList = new LinkedHashSet<>();

        if (userObjList.size() == 1) {
            UserObj userObj = userObjList.get(0);
            List<TbUserrole> tbUserroles = userObj.getTbUserroles();

            List<TbRolemodel> tbRolemodels = new ArrayList<>();
            for (TbUserrole e : tbUserroles) {
                tbRolemodels.addAll(e.getTbRole().getTbRolemodels());
            }
            for (TbRolemodel e : tbRolemodels) {
                modelList.add(e.getTbModel());
            }
            for (TbModel e : modelList) {
                //#修改为&
                e.setTbRolemodels(null);
            }
        }

        //返回子节点信息, 并打包到父节点下
        for (TbModel e : modelList) {
            Map<String, Object> p = new HashMap<>();
            p.put("parentid", e.getModelid());
            String w = "parentid=:parentid ";

            List<TbModel> childlList = modelDao.findAll(w, p, null);
            for (TbModel ele : childlList) {
                if (ele.getMurl() != null) {
                    String s = ele.getMurl().replaceAll("#", "&");
                    ele.setMurl(s);
                }
            }
            e.setChildList(childlList);
        }
        List<TbModel> mList = new LinkedList<>();
        for (TbModel e : modelList) {
            mList.add(e);
        }
        //modelList排序
        ListSortUtil<TbModel> sortList = new ListSortUtil<TbModel>();
        sortList.sort(mList, "sortnum", "asc");


        return new ModelIndexDto(mList);
    }


    @Override
    public TbIocCustTop7 getrankDetail(String ioccustomerusertop7id) {
        return tbIocCustTop7Dao.find(ioccustomerusertop7id);
    }

    @Override
    public void editUser(UserObj account) {
        //查询TB_USERROLE  userid
        Map<String, Object> params = new HashMap<>();
        params.put("userid", account.getUserid());
//        params.put("roleid", account.getRoleid());
        String where = "userid=:userid";
        List<TbUserrole> userroleList = userroleDao.findAll(where, params, null);

        if (userroleList.size() == 1) {
            TbUserrole userrole = userroleList.get(0);
            TbRole role = roleDao.find(Long.valueOf(account.getRoleid()));
            userrole.setTbRole(role);
            userroleDao.update(userrole);
        }
        userDao.update(userroleList.get(0).getTbUser());
    }

    @Override
    public String editUser(List<UserObj> objList) {
        String msg = "";
        int updateSuccessNum = 0;
        if (objList.size() < 0) {
            msg = "不存在修改的用户";
        } else {
            for (UserObj u : objList) {
                Map<String, Object> params = new HashMap<>();
                params.put("sourceuserId", u.getSourceuserid());
                String where = "sourceuserid=:sourceuserId";
                List<UserObj> userObjs = userDao.findAll(where, params, null);
                if (userObjs.size() > 0) {
                    u.setUserid(Long.valueOf(userObjs.get(0).getUserid()));
                    if (null != u.getLoginpassword().trim() && !"".equals(u.getLoginpassword().trim())) {
                        String newPwd = Account.encrypt(u.getLoginpassword());
                        u.setLoginpassword(newPwd);
                    }
                    userDao.update(u, null, null, null);


                    String whereRole = "userid=:userid";
                    Map<String, Object> paramsrole = new HashMap<>();
                    paramsrole.put("userid", userObjs.get(0).getUserid());
                    List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                    TbUserrole userrole = userroleList.get(0);
                    TbRole role = roleDao.find(Long.valueOf(u.getRoleid()));
                    userrole.setTbRole(role);
                    userroleDao.update(userrole, null, null, null);
                    msg = "用户信息修改成功！";


                }
            }
            updateSuccessNum++;
        }
        return msg + updateSuccessNum;
    }

    /**
     * add hy
     *
     * @param objList
     * @return
     */
    @Override
    public String addUser(List<UserObj> objList) {
        int addSuccessNum = 0;
        int addErrorNum = 0;
        String msg = "";
        if (objList.size() < 0) {
            msg = "推送的用户数据为空";
        } else {
            for (UserObj u : objList) {
                Map<String, Object> params = new HashMap<>();
                params.put("loginname", u.getLoginname().toLowerCase());
                String where = "loginname=:loginname ";
                List<UserObj> accountList = userDao.findAll(where, params, null);
                boolean isAdd = accountList.size() == 0 ? true : false;
                if (isAdd) {
                    String newPwd = Account.encrypt(u.getLoginpassword() == null ? u.getLoginpassword() : "123456");
                    u.setLoginpassword(newPwd);
                    u.setLoginname(u.getLoginname().toLowerCase());
                    userDao.save(u);
                    TbUserrole urobj = new TbUserrole();
                    urobj.setTbRole(roleDao.find(Long.valueOf(u.getRoleid())));
                    urobj.setTbUser(u);
                    userroleDao.save(urobj);
                    addSuccessNum++;
                } else {
                    addErrorNum++;
                    msg += u.getLoginname().toLowerCase() + ",";
                }
            }
            if (addErrorNum > 0)
                msg = "SUCCESS:" + addSuccessNum + "ERRORS:" + addErrorNum + "账户名" + msg + "已存在！";
            else {
                msg = "SUCCESS:" + addSuccessNum + "ERRORS:" + addErrorNum;
            }
        }
        return msg;
    }


    @Override
    public int addUser(UserObj account, Long roleid) {
        //如果loginname重复不添加
        Map<String, Object> params = new HashMap<>();
        params.put("loginname", account.getLoginname().toLowerCase());
        String where = "loginname=:loginname ";
        List<UserObj> accountList = userDao.findAll(where, params, null);
        if (accountList.size() > 0) {
            return 0;
        }
        // 写TB_USER表
        //设置密码 初始密码123456
        String password = Account.encrypt("123456");
        account.setLoginpassword(password);
        account.setLoginname(account.getLoginname().toLowerCase());
        account.setUserstatus(1);

        userDao.save(account);
        // 写TB_USERROLE表
        TbUserrole urobj = new TbUserrole();
        urobj.setTbRole(roleDao.find(roleid));
        urobj.setTbUser(account);
        userroleDao.save(urobj);
        return 1;
    }

    @Override
    public void delUser(Long id) {
        if (!(id == 1)) {
            userDao.delete(id);
        }
    }

    /**
     * 接口删除用户 add Ocean_hy
     *
     * @param userObjList
     */
    @Override
    public String delUser(List<UserObj> userObjList) {
        String msg = "";
        for (UserObj u : userObjList) {
            //查找用户
            Map<String, Object> params = new HashMap<>();
            params.put("sourceuserId", u.getSourceuserid());
            String where = "sourceuserid=:sourceuserId";
            List<UserObj> userObjs = userDao.findAll(where, params, null);

            //查找用户拥有的角色

            Long userId = userObjs.get(0).getUserid();
            if (userId == 1) {
                msg = "内置管理员账户禁止删除";
            } else {
                String whereRole = "userid=:userid";
                Map<String, Object> paramsrole = new HashMap<>();
                paramsrole.put("userid", userId);
                List<TbUserrole> userroleList = userroleDao.findAll(whereRole, paramsrole, null);
                for (TbUserrole tbu : userroleList) {
                    userroleDao.delete(tbu.getUserroleid());
                }
                userDao.delete(userId);
                msg = "用户删除成功！";
            }
        }
        return msg;
    }


    @Override
    public List<SfOrganizationAccount> findOnlineUserList() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", new BigDecimal(1));
        String where = "login=:login ";
        List<SfOrganizationAccount> organizationAccountList = organizationAccountDao.findAll(where, params, null);
        return organizationAccountList;
    }

    @Override
    public List<SfOrganizationDepartment> getDepartmentList() {
        return sfOrganizationDepartmentDao.findAll();
    }


}
