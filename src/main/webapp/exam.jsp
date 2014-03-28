<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script src="http://cdn.bootcss.com/jquery/2.0.3/jquery.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.js"></script>
    <link href="http://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap-theme.css" rel="stylesheet">
    <style>
        .blank{
            border-width: 0;
            border-bottom: 1 solid black;
            width: 60px;
        }
        .incorrect{
            font-color:red;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <form action="check" method="post">
                <input type="hidden" name="paperId" value="<%=request.getAttribute("paperId")%>"/>
                <%=request.getAttribute("paper")%>
                <fieldset>
                    <button class="btn" type="submit">检查</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>