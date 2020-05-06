<%--
  Created by IntelliJ IDEA.
  User: Муся
  Date: 14.04.2020
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Organizations</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

        .block1 {
                    width: 250px;
                    height: 190px;
                    background: #B0E0E6;
                    padding: 5px;
                    padding-right: 20px;
                    border: solid 1px black;
                }
    </style>
</head>
<body>
<h1>Organizations</h1>
<table>
    <tr>
    <td>
        <div class="block1">
            <c:url var="addAction" value="/organizations"></c:url>
            <form:form action="${addAction}" commandName="organization" form="">
                <table>
                    <c:if test="${!empty organization.orgName}">
                        <tr>
                            <td>
                                <form:label path="orgId">
                                    <spring:message text="IdOrg"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="orgId" readonly="true" size="11" disabled="true"/>
                            <form:hidden path="orgId"/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="orgName">
                                <spring:message text="OrgName"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="orgName" required = "true" placeholder="Organization name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="orgAdress">
                                <spring:message text="Adress"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="orgAdress" required = "true" placeholder="Adress"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="orgPhone">
                                <spring:message text="Phone"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="orgPhone" required = "true" pattern="[0-9]{11}" placeholder="8**********"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                                <input type="submit"
                                    value="<spring:message text="Add/Edit"/>"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </td>

    <td>
        <div class="block1">
            <h3><a href="http://localhost:8080/clients">Client List</a></h3>

            <h3><a href="http://localhost:8080/posts">Post List</a></h3>

            <h3><a href="http://localhost:8080/contracts">Contract List</a></h3>
        </div>
    </td>
    </tr>
</table>
<c:if test="${!empty listOrg}">
    <table class="tg">
        <tr>
            <th width="80">IdOrg</th>
            <th width="80">OrgName</th>
            <th width="80">Adress</th>
            <th width="80">Phone</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${listOrg}" var="organization">
            <tr>
                    <td>${organization.orgId}</td>
                    <td>${organization.orgName}</td>
                    <td>${organization.orgAdress}</td>
                    <td>${organization.orgPhone}</td>
                <td><a href="<c:url value='/editO/${organization.orgId}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteO/${organization.orgId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>