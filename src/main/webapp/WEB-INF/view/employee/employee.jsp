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
</s:form>
</body>
</html>
