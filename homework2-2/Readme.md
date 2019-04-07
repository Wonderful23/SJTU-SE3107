# 第二次作业说明
## 使用方法
- 在springboot中启动 Chapter1Main。java
- 在浏览器中输入localhost:8080,可以看到Welcome to Wordladder
- 在Begin和End的输入框中输入相应的单词，之后点击查找按钮
- 跳转后的页面显示结果，点击返回链接返回首页。

## 作业相关细节的介绍
- 在使用react编写前端网页，通过npm run build，进行build操作，之后将相应的文件放在resources/static下面
- 使用thymeleaf对restful响应进行回应。templates/demo.html能根据结果进行渲染
- restful应用使用springboot的框架中的@RequestMapping("/templates")进行回应
- @RequestMapping("/templates") 的返回值为ModelAndView,设置setViewName("templates/demo.html"）跳转
- 在原本基础上新增加mockTestA()的测试用例对controller进行测试。具体是使用mockMvc进行测试。

## 相关链接
- [gitflow](https://github.com/Wonderful23/SJTU-SE3107/commits/master)
- [Junit中测试Controller](https://www.cnblogs.com/jiangbei/p/8432985.html)
- [npm run build进行打包](https://www.cnblogs.com/qiu-Ann/p/7477593.html)