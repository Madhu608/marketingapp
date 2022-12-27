<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
<h2>Lead | Create</h2>
<form action="SaveLead" name="post">
<pre>
	First Name <input type="text" name="firstName"/>
	Last Name <input type="text" name="lastName"/>
	Email <input type="text" name="email"/>
	mobile <input type="text" name="mobile"/>
	<input type="submit" value="Save"/>
	
</pre>
</form>
${msg}
</body>
</html>