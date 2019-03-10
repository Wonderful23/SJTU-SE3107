# 课程第一次作业 
## 作业进度安排
- 3月6日：学习Junit
- 3月7日-3月8日：学习maven+改写wordladder
- 3月9日：搭建maven项目+完成Junit 单元测试
- 3月10日：反思+完成项目的markdown文件
## 学习笔记
### Junit单元测试
- 单元测试的目的
> 测试代码的执行结果是否与程序员的期望相同
- 如何进行测试
> 测试应该考虑的几个方面
> 1. Right-BICEP
> - Right --正确
> - B -- 所有的边界条件都是正确的
> - I -- 是否能反向关联
> - C -- 交叉检查
> - E -- 强制错误条件发生
> - P -- 性能要求<br/>
> 2. 边界条件 CORRECT
> - 一致性
> - 有序性
> - 区间性
> - 引用性
> - 基数性（0-1-n原则）
> - 时间性<br/>
> 3. Junit 实现单元测试<br/>
> a. 断言
> - assertEquals([String message],expected,actual) 
> - assertNull([String message],expected,actual)
> - assertSame([String message],expected,actual)
> - assertTrue([String message],expected,actual)
> - fail([String message])
> - 等等<br/>
> b. Junit框架
>  ```java 
> //引入必要的Junit类 
>import junit.framework.*; 
>//从基类TestCase中继承单元测试功能
> public class Test*** extends TestCase{
> // 相关的构造函数
>    public Test***(String name){
>        super(name);
>    }
> // test...()这个方法Junit 会调用
>    public void test***(){
>        //ToDo
>    }
>}
### maven 安装与学习
- maven 安装
> 1. 从![http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi)下载maven 3.6.0,并解压
> 2. 在系统环境变量里，添加MAVEN_HOME(或M2_HOME)，然后PATH环境变量最后附加上";%MAVEN_HOME%\bin"
> 3. 输入 mvn -v，正常情况下会显示maven及jdk的版本号
- 搭建 maven 项目（eclipse）
> 1. 配置 pom.xml文件
> > a. 添加Junit 相关依赖
> > ```html
> > <dependencies>
> >    <dependency>
>  >       <groupId>junit</groupId>
>   >      <version>4.7</version>
>   >      <scope>test</scope>
>  >     </dependency>
> > </dependencies>
> >
> b. 配置相关测试
> >```html
>  > <build>
>  ><plugins>
>  >   <plugin>
>  >     <groupId>org.apache.maven.plugins</groupId>
>  >     <artifactId>maven-surefire-plugin</artifactId>
>  >     <configuration>
>  >       <includes>
>  >         <include>**/*Test.java</include>
>  >       </includes>
>  >     </configuration>
>  >   </plugin>
> >   </plugins>
>> </build>
> c. 在相关的package完成class 和testclass
- maven 相关指令
> mvn clean 将根目录下生成的target文件移除 <br/>
> mvn install 对相关的依赖包进行安装<br/>
> mvn test 进行单元测试<br/>
> mvn exec:java -Dexec.mainClass="...class" 运行特定的class<br/>
> mvn compile 完成相关的编译<br/>
> 
### 作业说明
- App.java
> 该Java处于com.wzy.ladder中有一下几种方法
> - public static ArrayList<Node> bfs(String begin,String end,Set<String>wordDict)
> - public static String printpath(ArrayList<Node> temp1,String begin,String end)
> - public static Set<String> Read(String filename)
> - public static void run()
> - public static void main()
> bfs()主要主要运用广度优先搜索，<br/>
> printpath获得最终结果 <br/>
> Read()从文件中读取dictionary<br/>
> run()运行程序
- AppTest.java
> 该Java主要完成测试
> - testRead() 使用5组正确的输入2组错误的输入进行验证<br/>
> - testUnRead() 测试在Read()未读到文件时是否正常抛出错误<br/>
> - testprintpath() 使用4组其中两组正确两组错误用例测试printpath()是否正常工作<br/>
> - testBfs() 使用4组测试用例测试bfs()是否正确<br/>
- 程序运行
- 在ladder 项目下在命令行中输入 mvn test 运行测试
- mvn exec:java -Dexec.mainClass="com.wzy.ladder.App" 运行主程序