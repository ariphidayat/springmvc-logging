<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <div>
            <h3><a href="/new">New Contact</a></h3>
            <table>
                <th>No.</th>
                <th>Id</th>
                <th>Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Address</th>

                <c:forEach var="user" items="${users}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.address}</td>
                        <td>
                            <a href="/edit?id=${user.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="/delete?id=${user.id}">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>