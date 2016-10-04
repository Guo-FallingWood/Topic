<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" rtexprvalue="true" %>

<tr>
    <td>${label}</td>
    <td>
        <input name="${name}" v-model="${name}" type="text" class="form-control">
    </td>
</tr>
