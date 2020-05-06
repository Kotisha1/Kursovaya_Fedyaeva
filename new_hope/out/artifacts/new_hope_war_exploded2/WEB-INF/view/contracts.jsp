<%--
  Created by IntelliJ IDEA.
  User: Муся
  Date: 14.04.2020
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <title>Contracts</title>
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
            width: 290px;
            height: 190px;
            background: #B0E0E6;
            padding: 5px;
            padding-right: 20px;
            border: solid 1px black;
        }
    </style>
</head>
<body>
<h1>Contracts</h1>
<table>
    <tr>
    <td>
        <div class="block1">
            <c:url var="addAction" value="/contracts"></c:url>
            <form:form action="${addAction}" commandName="contract" form="">
                <table>
                <c:if test="${!empty contract.idOfCont}">
                      <tr>
                          <td>
                              <form:label path="idOfCont">
                                  <spring:message text="ID"/>
                              </form:label>
                           </td>
                           <td>
                               <form:input path="idOfCont" readonly="true" size="11" disabled="true"/>
                                   <form:hidden path="idOfCont"/>
                           </td>
                      </tr>
                </c:if>

                        <td>
                         <form:label path="organizationName">
                              <spring:message text="OrgName"/>
                         </form:label>
                        </td>
                        <td>
                            <form:select path="organizationName">
                                <c:forEach items="${listOrg}" var="org">
                                     <form:option value="${org.orgName}"/>
                                </c:forEach>
                            </form:select>
                         </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="idOfClient">
                                <spring:message text="ClientID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:select path="idOfClient">
                                <c:forEach items="${listClient}" var="client">
                                    <form:option value="${client.clientId}"/>
                                 </c:forEach>
                              </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <form:label path="idOfPost">
                                <spring:message text="PostID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:select path="idOfPost">
                                <c:forEach items="${listPost}" var="post">
                                    <form:option value="${post.idOfPos}"/>
                                </c:forEach>
                             </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="dateOfConclusion">
                                <spring:message text="dateOfConclusion"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="dateOfConclusion" required = "true" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}"  placeholder="01.01.2020"/>
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

            <h3><a href="http://localhost:8080/posts">Post List</a></h3>
        </div>
    </td>
    </tr>
</table>

<c:if test="${!empty list}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="80">OrgName</th>
            <th width="80">ClientID</th>
            <th width="80">PostID</th>
            <th width="80">DateOfConclusion</th>
            <th width="80">Edit</th>
            <th width="80">Delete</th>
        </tr>
        <c:forEach items="${list}" var="contract">
            <tr>
                    <td>${contract.idOfCont}</td>
                    <td>${contract.organizationName}</td>
                    <td>${contract.idOfClient}</td>
                    <td>${contract.idOfPost}</td>
                    <td>${contract.dateOfConclusion}</td>
                <td><a href="<c:url value='/editC/${contract.idOfCont}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteC/${contract.idOfCont}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
