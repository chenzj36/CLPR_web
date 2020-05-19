# CLPR_web  后台展示部分设计 
## 待完善，后续更新

# 1. 前端
## 1.1. Bootstrap(v3.3)
### 1.1.1. 介绍
&emsp;&emsp;Bootstrap是Twitter推出的一个用于前端开发的开源工具包。它由Twitter的设计师Mark Otto和Jacob Thornton合作开发，是一个CSS/HTML框架。目前，Bootstrap最新版本为3.0 。Bootstrap中文网致力于为广大国内开发者提供详尽的中文文档、代码实例等，助力开发者掌握并使用这一框架。
&emsp;&emsp;[Bootstrap3中文手册](https://v3.bootcss.com/)
### 1.1.2. 学习笔记
- 下载好的Bootstrap包含三个目录：/css、/fonts、/js，文件均以bootstrap开头
- .js为未压缩版本，包含完整的注释，形参名完整
- .min.js为压缩版本，体积小，便于网络上传输
- head中`<link href="../static/css/bootstrap.min.css" th:href="@{/css/bootstrap.min.css}" rel="stylesheet"/>`为导入外部样式表，在html中就可以使用他的css
- 

## 1.2. jQuery
### 1.2.1. 介绍
&emsp;&emsp;jQuery是一套跨浏览器的JavaScript库，简化HTML与JavaScript之间的操作。由约翰·雷西格（John Resig）在2006年1月的BarCamp NYC上发布第一个版本。当前是由Dave Methvin领导的开发团队进行开发。全球前10,000个访问最高的网站中，有65%使用了jQuery，是当前最受欢迎的JavaScript库。
&emsp;&emsp;The Write Less, Do More, JavaScript Library.
&emsp;&emsp;[jQuery中文教程W3school](https://www.w3school.com.cn/jquery/index.asp)
### 1.2.2. 学习笔记
- 绑定
	- `$("div")` 绑定TagName
	- `$(".box")` 绑定ClassName
	- `$("#idName")` 绑定Id
	- `$(function(){})`为`$(document).ready(function(){})`的简写模式
## 1.3. Layui
### 1.3.1. 介绍
&emsp;&emsp;layui 是一款采用自身模块规范编写的前端 UI 框架，遵循原生 HTML/CSS/JS 的书写与组织形式，门槛极低，拿来即用。其外在极简，却又不失饱满的内在，体积轻盈，组件丰盈，从核心代码到 API 的每一处细节都经过精心雕琢，非常适合界面的快速开发。
### 1.3.2. 学习笔记
# 2. 前后端交互
## 2.1. Ajax
### 2.1.1 介绍
&emsp;&emsp;Ajax 即“Asynchronous Javascript And XML”（异步 JavaScript 和 XML），是指一种创建交互式、快速动态网页应用的网页开发技术，无需重新加载整个网页的情况下，能够更新部分网页的技术。
&emsp;&emsp;通过在后台与服务器进行少量数据交换，Ajax 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。
&emsp;&emsp;[Ajax中文教程W3school](https://www.w3school.com.cn/ajax/index.asp)
### 2.1.2 学习笔记
- 使用Ajax的五个步骤
	1. 创建一个异步对象
	2. 设置请求方式和请求地址
	3. 发送请求
	4. 监听状态的变化
	5. 处理返回的结果
## 2.2. Thymeleaf(v3.0)
### 2.2.1. 介绍
&emsp;&emsp;Thymeleaf 是一个跟 Velocity、FreeMarker 类似的模板引擎，它可以完全替代 JSP 。相较与其他的模板引擎，它有如下三个极吸引人的特点:
- Thymeleaf 在有网络和无网络的环境下皆可运行，即它可以让美工在浏览器查看页面的静态效果，也可以让程序员在服务器查看带数据的动态页面效果。这是由于它支持 html 原型，然后在 html 标签里增加额外的属性来达到模板 + 数据的展示方式。浏览器解释 html 时会忽略未定义的标签属性，所以 thymeleaf 的模板可以静态地运行；当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。
- Thymeleaf 开箱即用的特性。它提供标准和 Spring 标准两种方言，可以直接套用模板实现 JSTL、 OGNL 表达式效果，避免每天套模板、改 JSTL、改标签的困扰。同时开发人员也可以扩展和创建自定义的方言。
- Thymeleaf 提供 Spring 标准方言和一个与 SpringMVC 完美集成的可选模块，可以快速的实现表单绑定、属性编辑器、国际化等功能。

&emsp;&emsp;[Thymeleaf教程](https://tutorial.e-learn.cn/read/thymeleaf/index)
### 2.2.2. 学习笔记
# 3. 后端
## 3.1. Shiro安全控制(v1.4)
### 3.1.1. 介绍
&emsp;&emsp;Apache Shiro是Java的一个安全框架。Shiro可以帮助我们完成：认证、授权、加密、会话管理、与Web集成、缓存等。其不仅可以用在 JavaSE环境，也可以用在 JavaEE 环境。

# 4. 项目剖析
## 4.1. 单模块
1. SQL

| menu_name | parent_id  | type                   | perms      | url |
| --------- | ---------- | ---------------------- | ---------- | --- |
| 菜单名    | 上级目录id | 类型：目录、菜单、按钮 | 要求的权限 | 点击此菜单请求的链接  |

建表语句

2. Java
	- controller：控制层，处理url请求，根据url返回html或调用service层的服务
	- domain：定义实体类、多表关联或一些常量
	- service：业务层，实现具体的业务，负责调用mapper，一般写法为接口+实现
	- mapper：数据层，负责操作数据库，接口形式，与resources/mybatis/下的xml对应
3. Web
&emsp;&emsp;templates/下的html页面对应controller，使用到了Thymeleaf、Bootstrap、jQuery、Layui等框架
4. 定时任务
操作步骤：
    1. 在`task`目录下，新建一个类，添加@Component('任务名')注解
    2. 新建的类下，可添加方法，方法名任意，可带参数
    3. 在网页端新建定时任务，将需要添加的定时任务加入到列表
    4. 新建的时候注意，任务名称与@Component注解内对应，方法名不加括号。
    ![enter description here](https://aliyunosschenzj.oss-cn-beijing.aliyuncs.com/aliyunoss/1587123046104.png)    
    ![enter description here](https://aliyunosschenzj.oss-cn-beijing.aliyuncs.com/aliyunoss/1587123121618.png)
    5. cron表达式：http://qqe2.com/cron
## 4.2. 文件结构
com.ruoyi
|--common==>工具类
&emsp;&emsp;&emsp;|--constant==>通用常量
&emsp;&emsp;&emsp;|--exception==>通用异常
&emsp;&emsp;&emsp;|--utils==>通用类处理
&emsp;&emsp;&emsp;|--xss==>xss过滤处理
|--framework==>框架核心
&emsp;&emsp;&emsp;|--aspectj==>注解实现
&emsp;&emsp;&emsp;|--config==>系统配置
&emsp;&emsp;&emsp;|--datasource==>数据权限
&emsp;&emsp;&emsp;|--manager==>异步处理
&emsp;&emsp;&emsp;|--shiro==>权限控制
&emsp;&emsp;&emsp;|--web==>前端控制


