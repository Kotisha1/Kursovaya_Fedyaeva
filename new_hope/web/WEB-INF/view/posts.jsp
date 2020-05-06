<%--
  Created by IntelliJ IDEA.
  User: Муся
  Date: 14.04.2020
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Posts</title>
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
                    width: 270px;
                    height: 250px;
                    background: #B0E0E6;
                    padding: 5px;
                    padding-right: 20px;
                    border: solid 1px black;
                }
    </style>
</head>
<body>
<h1>Posts</h1>
<table>
    <tr>
    <td>
        <div class="block1">
            <c:url var="addAction" value="/posts"></c:url>
            <form:form action="${addAction}" commandName="post" form="">
                <table>
                <c:if test="${!empty post.postName}">
                        <tr>
                            <td>
                                <form:label path="idOfPos">
                                     <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="idOfPos" readonly="true" size="11" disabled="true"/>
                                <form:hidden path="idOfPos"/>
                             </td>
                        </tr>
                </c:if>
                    <tr>
                        <td>
                        <form:label path="idOfOrg">
                            <spring:message text="OrgID"/>
                        </form:label>
                        </td>
                        <td>
                            <form:select path="idOfOrg">
                                <c:forEach items="${listOrg}" var="org">
                                     <form:option value="${org.orgId}"/>
                                </c:forEach>
                             </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="postName">
                                <spring:message text="PostName"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="postName" required = "true" placeholder="Tracher/etc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="performedWork">
                                <spring:message text="PerformedWork"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="performedWork" required = "true" placeholder="Clean the cabinet/etc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="postSalary">
                                <spring:message text="Salary"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="postSalary" required = "true" pattern="^[ 0-9]+$" placeholder="15000"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="workShedule">
                                <spring:message text="WorkShedule"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="workShedule" required = "true" placeholder="5/2"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="require">
                                <spring:message text="Requirements"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="require" required = "true" placeholder="Decency/etc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="postAreaOfWork">
                                <spring:message text="AreaOfWorks"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="postAreaOfWork" required = "true" placeholder="IT/etc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="postActuality">
                                <spring:message text="Actuality"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="postActuality" required = "true" placeholder="yes/no"/>
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

            <h3><a href="http://localhost:8080/organizations">Organization List</a></h3>

            <h3><a href="http://localhost:8080/contracts">Contract List</a></h3>
        </div>
    </td>
    </tr>
</table>

<c:if test="${!empty list}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">idOfOrg</th>
            <th width="80">PostName</th>
            <th width="80">PerformedWork</th>
            <th width="80">Salary</th>
            <th width="80">WorkShedule</th>
            <th width="80">Requirements</th>
            <th width="80">AreaOfWorks</th>
            <th width="80">Actuality</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${list}" var="post">
            <tr>
                    <td>${post.idOfPos}</td>
                    <td>${post.idOfOrg}</td>
                    <td>${post.postName}</td>
                    <td>${post.performedWork}</td>
                    <td>${post.postSalary}</td>
                    <td>${post.workShedule}</td>
                    <td>${post.require}</td>
                    <td>${post.postAreaOfWork}</td>
                    <td>${post.postActuality}</td>
                <td><a href="<c:url value='/editP/${post.idOfPos}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteP/${post.idOfPos}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>