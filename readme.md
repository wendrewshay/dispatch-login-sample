# shiro分发登录示例

### 场景说明
* 一个后台系统和一个前台系统做在一个单体应用中，共用shiro框架；
* 后台系统所有请求路径以/admin开头，前台系统所有请求路径以/user开头；
* 一个后台角色用户admin，拥有管理员角色，一个前台用户user，拥有普通用户角色；
* 需要满足条件：
    1. admin用户只能登录后台系统的登录页，并访问后台的功能；user用户只能登录前台系统的登录页，并访问前台的功能;
    2. admin用户登录进入后台后，无访问前台功能的权限；user用户登录进入前台后，无访问后台功能的权限；

### 代码要点说明
* 自定义LoginAuthenticationFilter，根据请求访问路径预处理设置loginUrl和successUrl;
* 在ShiroConfiguration中配置LoginAuthenticationFilter为authc过滤器，配置/admin和/user开头的路径请求（除登录请求和登出请求）都由authc过滤器处理，且分别设置管理员权限和用户权限（"authc,roles[admin]", "authc,roles[user]"）;
* 启动应用后，访问http://localhost:8080/admin/login ， 输入用户名密码admin/123456，进入adminIndex.html页面，尝试访问http://localhost:8080/user/index ，显示无权限；
* 同理，访问http://localhost:8080/user/login ，输入用户名密码user/123456，进入userIndex.html页面，尝试访问http://localhost:8080/admin/index ，显示无权限；

