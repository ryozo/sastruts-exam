<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Sample</title>
</head>
<body>
<html:errors/>
<s:form >
社員番号：<html:text property="employeeNo" /><br />
社員名：<html:text property="employeeName" /><br />
<s:submit property="join" value="入社"/>
<s:submit property="retire" value="退社"/>
<br />
<table border="1px">
  <thead>
    <tr>
      <td>社員番号</td>
      <td>社員名</td>
      <td>入社年月日</td>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="employee" items="${employees }">
      <tr>
        <td>${f:h(employee.employeeNo)}</td>
        <td>${f:h(employee.employeeName)}</td>
        <td>${f:h(employee.entranceDay )}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</s:form>
</body>
</html>
