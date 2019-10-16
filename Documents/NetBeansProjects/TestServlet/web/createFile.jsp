<%-- 
    Document   : test
    Created on : 13.10.2019, 1:05:36
    Author     : User
--%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.http.HttpServletResponse"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Test</title>
</head>
<body>
        <%--<jsp:useBean id="filesList" scope="request" type="test.FileList"/>--%>
        Успешное создание!
       
        <form method="post" action="test?action=create" enctype="multipart/form-data" >
            <h3>Создание файла</h3>
            Имя файла:
            <input type="text" style="width:200px;" value="input.txt" name="fileName"/><br/>
            Директория:
            <input type="text" style="width:400px;" value="C:\\Users\\User\\Documents\\ServletDirectory" name="path"/>
            </br>
            <input type="submit" value="Создать файл" name="create" id="create" />
        </form>
        <br>
        <form method="post" action="test?action=createDir" enctype="multipart/form-data" >
            <h3>Создание директории</h3>
            Имя директории:
            <input type="text" style="width:200px;" value="Directory" name="directoryName"/><br/>
            Директория:
            <input type="text" style="width:400px;" value="C:\\Users\\User\\Documents\\ServletDirectory" name="pathDir"/>
            </br>
            <input type="submit" value="Создать директорию" name="createDir" id="createDir" />
        </form>
        <br>
        <form method="post" action="upload" enctype="multipart/form-data" >
            <h3>Загрузка файла на сервер</h3>
            Файл:
            <input type="file" name="file" id="file" /> <br/>
            Директория:
            <input type="text" style="width:400px;" value="C:\\Users\\User\\Documents\\ServletDirectory" name="destination"/>
            </br>
            <input type="submit" value="Загрузить" name="upload" id="upload" />
            
        </form>
    
</body>
</html>
