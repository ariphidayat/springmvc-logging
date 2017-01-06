<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<body>
    <div>
        <h1>New/Edit</h1>
        <form:form action="save" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td>Id:</td>
                    <td><form:input path="id" /></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>