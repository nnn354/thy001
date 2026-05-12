由哔哩哔哩看视频后所得的视频笔记，不是我写的笔记

# SpringBoot 整合 Thymeleaf 学习笔记
0.1界面勾选四个依赖
---1Lombok
2Spring Web
3Thymeleaf
4Spring Boot DevTools

## 1. Thymeleaf 是什么
### 1.1 模板引擎
- 是一种用于生成动态内容的工具，主要在 Web 开发中使用。
- 核心功能：将静态的模板文件和动态数据结合起来（例如 JSP）。

### 1.2 Thymeleaf 介绍
- 采用 Java 语言开发的模板引擎。
- 既可以用于 Web 环境，也可以用于非 Web 环境。

### 1.3 SpringBoot 官方支持
- SpringBoot 官方推荐的模板引擎技术是 **Thymeleaf**。
- 其他支持的模板引擎：FreeMarker。

---

## 2. SpringBoot 整合 Thymeleaf
### 2.1 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### 2.2 配置选项（application.yml）
```yaml
spring:
  thymeleaf:
    cache: false          # 关闭页面缓存（开发环境使用，避免修改模板后重启服务器），默认 true
    prefix: classpath:/views/  # 模板文件访问的根路径，默认 classpath:/templates/
    suffix: .html         # 模板文件的后缀，默认 .html
    mode: HTML            # 模板类型，默认 HTML
    encoding: UTF-8       # 字符集编码，默认 UTF-8
```


---

## 3. Thymeleaf 基础语法
### 3.1 引入命名空间
在 HTML 标签中添加 Thymeleaf 命名空间，以启用语法提示：
```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```

### 3.2 访问静态资源
在resource目录下设static(静态资源)   views/templates（模板HTML文件）
static下设js  css目录 设img目录放图片 
访问 image、css、js 等静态资源：
```html
<!-- CSS 放head标签里面-->
<link type="text/css" rel="stylesheet" th:href="@{/css/index.css}" />

<!-- JS 放head标签里面-->
<link type="text/css" rel="stylesheet" th:href="@{/css/index.css}" />

<!-- 图片放body标签里面 -->
<img th:src="@{/img/desktop.jpg}">
```

### 3.3 读取变量
```html
<!-- 转义文本输出 -->
<span th:text="${变量}"></span>

<!-- 不转义文本输出（可解析 HTML） -->
<span th:utext="${变量}"></span>
```

### 3.4 读取对象属性
```html
<!-- 标准写法 -->
<div th:text="${对象.属性}"></div>

<!-- 选择变量写法 -->
<div th:text="*{对象.属性}"></div>

<!-- th:object 简化写法 -->
<div th:object="${对象}">
    <p th:text="*{属性1}"></p>
    <p th:text="*{属性2}"></p>
</div>
```

### 3.5 条件判断
```html
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
```

### 3.6 循环遍历
```html
<!-- 遍历集合，变量名:集合 -->
<tr th:each="item : ${集合}">
    <td th:text="${item.id}"></td>
    <td th:text="${item.name}"></td>
</tr>
```

### 3.7 超链接传参
```html
<!-- 静态参数 -->
<a th:href="@{/product(pid=P001)}">查看详情（静态）</a>

<!-- 动态参数 -->
<a th:href="@{/product(pid=${proId})}">查看详情（动态）</a>

<!-- 无参数跳转 -->
<a th:href="@{/toIndex}">返回首页</a>
```

---

## 4. 补充说明
- 本笔记仅包含 Thymeleaf 最基础、最常用的用法。
- 未覆盖的高级用法：
  - 内联用法（`th:inline`）
  - 模板布局（`th:fragment`、`th:replace`）
  - 国际化设置
  - 内置对象（`#request`、`#session` 等）的使用

---


