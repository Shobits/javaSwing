# ch01-springMVC：springmvc注解式开发

## 需求：用户发起一个请求，springmvc接收请求， 显示请求的处理结果

### `servlet`的实现方式：
`jsp`发起---`servlet`--`jsp`显示结果

### 步骤：
1. 新建web应用
2. 加入web依赖
    spring-webmvc依赖（springmvc框架依赖），`servlet`依赖
3. 声明springmvc核心对象`DispatcherServlet`。
   1) `DispatcherServlet` 是一个`servlet`对象。
   2) `DispatcherServlet` 叫做前端控制器（front controller）
   3) `DispatcherServlet` 作用
      1. `在servlet`的`init`()方法中，创建springmvc中的容器对象
      2. 作为`servlet`，接受请求
4. 创建一个`jsp`，发起请求
5. 创建一个普通的类，作为控制器使用（代替之前的`servlet`）
   1) 在类的上面加入`@Controller`注解
   2) 在类中定义方法，方法的上面加入`@RequestMapping`注解
      方法处理请求的，相当于`servlet`的`doGet`,`doPost`
6. 创建作为结果的`jsp`页面
7. 创建springmvc的配置文件（spring的配置文件一样）
   1) 声明组件扫描器，指定`@Contro11er`注解所在的包名
   2) 声明视图解析器对象
8. 使用逻辑视图名称