<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/2
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/css/peformance/persevice.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="layout">
    <div class="box">
        <h4>Monthly SLA Report</h4>
        <div id="echart1"></div>
        <table>
            <thead>
            <tr>
                <td width="3%" class="no-bg"></td>
                <td width="3%" class="no-bg"></td>
                <td width="7%">JAN</td>
                <td width="7%">FEB</td>
                <td width="7%">MAR</td>
                <td width="7%">APR</td>
                <td width="7%">MAY</td>
                <td width="7%">JUN</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            <tr>
                <td>
                    <span></span>
                </td>
                <td>DSO</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
                <td>11</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/peformance/perService.js"></script>
</html>
