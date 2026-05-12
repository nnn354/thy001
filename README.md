# thy001
thymeleaf整合springboot的小练习，001
实现了   1  访问静态资源css  js  img   <link type="text/css" rel="stylesheet" th:href="@{/css/index.css}" />
<link type="text/css" rel="stylesheet" th:href="@{/css/index.css}" />
<img th:src="@{/img/desktop.jpg}">
2 读取对象属性
<div th:text="${对象.属性}"></div>

<div th:text="*{对象.属性}"></div>

<!-- th:object 简化写法 -->
<div th:object="${对象}">
    <p th:text="*{属性1}"></p>
    <p th:text="*{属性2}"></p>
</div>

3 条件判断
<!-- if 条件为 true 时显示 -->
<div th:if="${条件表达式}">条件成立时显示</div>

<!-- unless 条件为 false 时显示 -->
<div th:unless="${条件表达式}">条件不成立时显示</div>

<!-- switch-case 多分支判断 -->
<div th:switch="${用户角色}">
    <p th:case="'admin'">管理员</p>
    <p th:case="'user'">普通用户</p>
    <p th:case="*">访客</p>
</div>

4 循环遍历
<!-- 遍历集合，变量名:集合 -->
<tr th:each="item : ${集合}">
    <td th:text="${item.id}"></td>
    <td th:text="${item.name}"></td>
</tr>
