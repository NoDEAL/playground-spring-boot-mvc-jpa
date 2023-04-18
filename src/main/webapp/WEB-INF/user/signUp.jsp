<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>회원가입</title>
  <script type="text/javascript" defer="defer">
    function signUp() {
      document.detailForm.action = "<c:url value="/user/signUp.do" />";
      document.detailForm.submit();
    }
  </script>
</head>
<body>
<form:form modelAttribute="userVO" id="detailForm" name="detailForm">
  <div>
    <h2>회원가입</h2>
  </div>
  <table>
    <tr>
      <td><label for="email">이메일</label></td>
      <td><form:input path="email" cssClass="txt" /></td>
    </tr>
    <tr>
      <td><label for="password">비밀번호</label></td>
      <td><form:password path="password" /></td>
    </tr>
  </table>
  <div>
    <a href="javascript:signUp();">회원가입</a>
  </div>
</form:form>
</body>
</html>
