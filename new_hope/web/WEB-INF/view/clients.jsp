<%--
  Created by IntelliJ IDEA.
  User: Муся
  Date: 03.04.2020
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Clients</title>
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
            height: 225px;
            background: #B0E0E6;
            padding: 5px;
            padding-right: 20px;
            border: solid 1px black;
        }
    </style>
</head>
<body>
<h1>Clients</h1>
<table>
    <tr>
    <td>
        <div class = "block1">
        <c:url var="addAction" value="/clients"></c:url>
        <form:form action="${addAction}" commandName="client" form="">
            <table>
                <c:if test="${!empty client.clientName}">
                    <tr>
                        <td>
                            <form:label path="clientId">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="clientId" readonly="true" size="11" disabled="true"/>
                        <form:hidden path="clientId"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="clientName">
                            <spring:message text="Name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="clientName" required = "true" placeholder="Full name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="dateOfBirth">
                            <spring:message text="DateOfBirth"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="dateOfBirth" required = "true" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}"  placeholder="01.01.2020"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="education">
                            <spring:message text="Education"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="education" required = "true" placeholder="higher/secondary"/>
                    </td>
                </tr>
                <tr>
                    <td>
                     <form:label path="experience">
                         <spring:message text="Experience"/>
                     </form:label>
                 </td>
                    <td>
                      <form:input path="experience" required = "true"  placeholder="1 year"/>
                    </td>
             </tr>
                <tr>
                 <td>
                     <form:label path="areaOfWork">
                         <spring:message text="AreaOfWork"/>
                        </form:label>
                 </td>
                    <td>
                        <form:input path="areaOfWork" required = "true" pattern="^[a-zA-Z]+$" placeholder="Education/etc"/>
                    </td>
                </tr>
                <tr>
                    <td>
                     <form:label path="skills">
                          <spring:message text="Skills"/>
                     </form:label>
                    </td>
                    <td>
                        <form:input path="skills" required = "true" placeholder="Kindness/etc"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="phone">
                            <spring:message text="Phone"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="phone" required = "true" pattern="[0-9]{11}" placeholder="8**********"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                            <input type="submit"
                                value="<spring:message text="Add/Edit"/>"/>
                    </td>
                </tr>
            </table>
        </div>
        </form:form>
    </td>
    <td>
        <div class="block1">
            <h3><a href="http://localhost:8080/organizations">Organization List</a></h3>

            <h3><a href="http://localhost:8080/posts">Post List</a></h3>

            <h3><a href="http://localhost:8080/contracts">Contract List</a></h3>
        </div>
    </td>
    </tr>
</table>

<c:if test="${!empty list}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">Name</th>
            <th width="80">DateOfBirth</th>
            <th width="80">Education</th>
            <th width="80">Experience</th>
            <th width="80">AreaOfWork</th>
            <th width="80">Skills</th>
            <th width="80">Phone</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${list}" var="client">
            <tr>
                    <td>${client.clientId}</td>
                    <td>${client.clientName}</td>
                    <td>${client.dateOfBirth}</td>
                    <td>${client.education}</td>
                    <td>${client.experience}</td>
                    <td>${client.areaOfWork}</td>
                    <td>${client.skills}</td>
                    <td>${client.phone}</td>
                <td><a href="<c:url value='/edit/${client.clientId}' />">Edit</a></td>
                <td><a href="<c:url value='/delete/${client.clientId}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>